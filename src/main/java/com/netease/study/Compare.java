package com.netease.study;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, METHOD, FIELD })
@CustomConstraint(validatedBy = CompareValidator.class)
public @interface Compare {
	
	String message() default "数据不一致";
	
	String verifyField() default "";
	
}
