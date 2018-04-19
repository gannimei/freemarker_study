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
		boolean result = true;
		Class<?> modelType = value.getClass();
		Field[] modelFields = modelType.getDeclaredFields();
		for (Field modelField : modelFields) {
			modelField.setAccessible(true);
			Annotation[] validAnnotations = modelField.getDeclaredAnnotations();
			for (Annotation validAnnotation : validAnnotations) {
				CustomConstraint constraint = validAnnotation.annotationType().getDeclaredAnnotation(CustomConstraint.class);
				if(constraint != null) {
					for (Class<CustomConstraintValidator<?>> validatorClass : (Class<CustomConstraintValidator<?>>[])constraint.validatedBy()) {
						CustomConstraintValidator validator = CustomConstraintValidatorBuilder.INSTANCE.GetValidator(validatorClass);
						validator.initialize(validAnnotation);
						try {
							if(validator.isValid(modelField.get(value), value) == false) {
								String message = validator.getErrorMessage(validAnnotation);
								context.buildConstraintViolationWithTemplate(message).addPropertyNode(modelField.getName()).addConstraintViolation();
								result = false;
							}
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		if(result == false) {
			context.disableDefaultConstraintViolation();
		}
		return result;
	}

}
