package com.xll.aop;

import com.xll.annotation.SystemLog;
import com.xll.model.OperateLogInfo;
import com.xll.model.User;
import com.xll.service.OperateLogInfoService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 系统日志切面，针对使用了SystemLog注释的方法进行拦截
 * 之后将日志数据写入数据库
 */
@Component
@Aspect
public class SystemLogAspect {

    private static final Logger LOG = LoggerFactory.getLogger(SystemLogAspect.class);

    /** 记录每个用户刚开始访问方法的时间 */
    private static final ThreadLocal<Date> BEGIN_TIME_THREAD_LOCAL =
            new NamedThreadLocal<Date>("ThreadLocal beginTime");

    private static final ThreadLocal<OperateLogInfo> LOG_THREAD_LOCAL =
            new NamedThreadLocal<OperateLogInfo>("ThreadLocal log");


    @Autowired(required=false)
    private HttpServletRequest request;

    /** spring框架自带的线程池 */
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;


    @Resource
    private OperateLogInfoService operateLogInfoService;

    public SystemLogAspect() {}

    /**
     * 对使用SystemLog注释的方法进行拦截
     */
    @Pointcut("@annotation(com.xll.annotation.SystemLog)")
    public void systemLogAspectCtrl(){}


    /**
     * 前置通知 用于拦截记录用户的操作的开始时间
     *
     * @param joinPoint 切点
     * @throws InterruptedException
     */
    @Before("systemLogAspectCtrl()")
    public void doBefore(JoinPoint joinPoint) throws InterruptedException {

        Date beginTime = new Date();

        BEGIN_TIME_THREAD_LOCAL.set(beginTime);

        if (LOG.isDebugEnabled()){
            LOG.debug("开始计时: {}，URI: {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                    .format(beginTime), request.getRequestURI());
        }
    }

    /**
     * 后置通知 用于拦截用户操作
     *
     * @param joinPoint 切点
     */
    @After("systemLogAspectCtrl()")
    public void doAfter(JoinPoint joinPoint) {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            OperateLogInfo operateLogInfo = new OperateLogInfo();

            operateLogInfo.setUid(user.getId());
            operateLogInfo.setUname(user.getName());
            operateLogInfo.setStatus(true);
            operateLogInfo.setFromIp(request.getRemoteAddr());
            operateLogInfo.setMethod(request.getMethod());
            operateLogInfo.setUri(request.getRequestURI());
            operateLogInfo.setLogType("info");
            operateLogInfo.setOperateFunc(getMethodDescription(joinPoint));
            operateLogInfo.setVisitMethod(getMethod(joinPoint));
            operateLogInfo.setMethodCostTime(new Date().getTime() - BEGIN_TIME_THREAD_LOCAL.get().getTime() + "");

            // 开启新线程进行日志记录
            taskExecutor.execute(new SaveLogThread(operateLogInfo , operateLogInfoService));

            LOG_THREAD_LOCAL.set(operateLogInfo);

        }

    }


    /**
     * 获取注解中对方法的描述信息
     *
     * @param joinPoint 切点
     * @return description
     */
    private String getMethodDescription(JoinPoint joinPoint) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        Method method = signature.getMethod();

        SystemLog systemLog = method.getAnnotation(SystemLog.class);

        String description = systemLog.description();

        return description;
    }

    private String getMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        Method method = signature.getMethod();

        return method.getName();
    }


    /**
     * 异常通知 记录操作报错日志
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "systemLogAspectCtrl()" , throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint , Throwable e) {

        OperateLogInfo operateLogInfo = LOG_THREAD_LOCAL.get();

        operateLogInfo.setLogType("error");
        operateLogInfo.setVisitMethodErrorInfo(e.getMessage());

        taskExecutor.execute(new UpdateLogThread(operateLogInfo , operateLogInfoService));
    }

    /**
     * 保存日志线程
     */
    private static class SaveLogThread implements Runnable {

        private OperateLogInfo operateLogInfo;
        private OperateLogInfoService operateLogInfoService;


        public SaveLogThread(OperateLogInfo operateLogInfo, OperateLogInfoService operateLogInfoService) {
            this.operateLogInfo = operateLogInfo;
            this.operateLogInfoService = operateLogInfoService;
        }

        @Override
        public void run() {
            operateLogInfoService.insert(operateLogInfo);
        }
    }

    /**
     * 日志更新线程
     */
    private static class UpdateLogThread extends Thread {

        private OperateLogInfo operateLogInfo;
        private OperateLogInfoService operateLogInfoService;

        public UpdateLogThread(OperateLogInfo operateLogInfo, OperateLogInfoService operateLogInfoService) {
            super(UpdateLogThread.class.getSimpleName());
            this.operateLogInfo = operateLogInfo;
            this.operateLogInfoService = operateLogInfoService;
        }

        @Override
        public void run() {
            operateLogInfoService.update(operateLogInfo);
        }
    }
}
