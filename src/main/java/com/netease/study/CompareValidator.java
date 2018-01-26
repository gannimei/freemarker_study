package com.netease.study;

import java.lang.reflect.Field;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CompareValidator implements ConstraintValidator<Compare, Object> {

	private String field;
	private String verifyField;
	
	public void initialize(Compare constraintAnnotation) {
		// TODO Auto-generated method stub
		this.field = constraintAnnotation.field();
		this.verifyField = constraintAnnotation.verifyField();
	}

	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		try {
			Class<?> modelType = value.getClass();
			Field fieldValue = modelType.getDeclaredField(field);
			fieldValue.setAccessible(true);
			Field verifyFieldValue = modelType.getDeclaredField(verifyField);
			verifyFieldValue.setAccessible(true);
			if(fieldValue.get(value).equals(verifyFieldValue.get(value))) {
				return true;
			}
			String messageTemplate = context.getDefaultConstraintMessageTemplate();
			context.buildConstraintViolationWithTemplate(messageTemplate).addPropertyNode(verifyField).addConstraintViolation();
			context.disableDefaultConstraintViolation();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
