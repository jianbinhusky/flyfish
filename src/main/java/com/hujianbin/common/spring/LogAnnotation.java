package com.hujianbin.common.spring;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})   
@Retention(RetentionPolicy.RUNTIME)   
@Documented
public @interface LogAnnotation {

	public String module() default "";
	
	public String action() default "";
	
	public String remark() default "";
}
