package com.xll.annotation;

/**
 * 进行系统日志控制的注释，如果Controller里面方法加上了该注解，
 * 则表示该方法需要进行操作日志记录，该注释只作用在方法上
 *
 * @author lonely.xia
 * @date 2017/10/15
 */
public @interface SystemLog {

    /**
     * 描述业务操作功能 例:登录、查看用户等等
     * @return
     */
    String description() default "";
}
