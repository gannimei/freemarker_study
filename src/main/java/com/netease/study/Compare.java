package com.netease.study;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ TYPE })
@Constraint(validatedBy = { CompareValidator.class })
public @interface Compare {
	
	String message() default "数据不一致";
	
	String field() default "";
	
	String verifyField() default "";

	Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
	
}
