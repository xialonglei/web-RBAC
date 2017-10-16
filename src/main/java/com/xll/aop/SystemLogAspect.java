package com.xll.aop;

import com.xll.model.OperateLogInfo;
import com.xll.model.User;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by lonely.xia on 2017/10/15.
 */
@Component
@Aspect
public class SystemLogAspect {

    private static final Logger LOG = LoggerFactory.getLogger(SystemLogAspect.class);

    private static final ThreadLocal<Date> beginTimeThreadLocal =
            new NamedThreadLocal<Date>("ThreadLocal beginTime");

    private static final ThreadLocal<OperateLogInfo> logThreadLocal =
            new NamedThreadLocal<OperateLogInfo>("ThreadLocal log");

    private static final ThreadLocal<User> currentUser=new NamedThreadLocal<>("ThreadLocal user");

    public SystemLogAspect() {}

    /**
     * 对使用SystemLog注释的方法进行拦截
     */
    @Pointcut("@annotation(com.xll.annotation.SystemLog)")
    public void systemLogAspectCtrl(){}
}
