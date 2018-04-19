/**
 * 
 */
package com.netease.study;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author gz
 *
 */
public class CustomValidatorBuilder implements ConstraintValidator<CustomValidator, Object> {

	/* (non-Javadoc)
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
	 */
	public void initialize(CustomValidator constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
	 */
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		System.out.println("aaaa");
		Class<?> modelType = value.getClass();
		Field[] modelFields = modelType.getDeclaredFields();
		for (Field modelField : modelFields) {
			Annotation[] validAnnotations = modelField.getDeclaredAnnotations();
			for (Annotation validAnnotation : validAnnotations) {
				CustomConstraint constraint = validAnnotation.annotationType().getDeclaredAnnotation(CustomConstraint.class);
				if(constraint != null) {
					for (Class<CustomConstraintValidator<?>> validatorClass : (Class<CustomConstraintValidator<?>>[])constraint.validatedBy()) {
						CustomConstraintValidator validator = CustomConstraintValidatorBuilder.INSTANCE.GetValidator(validatorClass);
						validator.initialize(validAnnotation);
					}
				}
			}
		}
		return false;
	}

}
