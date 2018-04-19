/**
 * 
 */
package com.netease.study;

import java.lang.annotation.Annotation;

/**
 * @author gz
 *
 */
public interface CustomConstraintValidator<A extends Annotation> {

	public void initialize(A constraintAnnotation);
	
	public boolean isValid(Object value);
	
}
