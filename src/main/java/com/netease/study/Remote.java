/**
 * 
 */
package com.netease.study;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@CustomConstraint(validatedBy = RemoteValidator.class)
/**
 * @author gz
 *
 */
public @interface Remote {

	String message() default "账号已注册";
	
	Class<?> verifyClass();
	
	String verifyMethod() default "";
	
	String[] additionalField() default {};
	
}
