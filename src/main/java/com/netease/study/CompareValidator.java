package com.netease.study;

import java.lang.reflect.Field;

public class CompareValidator implements CustomConstraintValidator<Compare> {
	
	private String verifyField;
	
	/* (non-Javadoc)
	 * @see com.netease.study.CustomConstraintValidator#initialize(java.lang.annotation.Annotation)
	 */
	public void initialize(Compare constraintAnnotation) {
		// TODO Auto-generated method stub
		verifyField = constraintAnnotation.verifyField();
	}

	/* (non-Javadoc)
	 * @see com.netease.study.CustomConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
	 */
	public boolean isValid(Object value, Object model) {
		// TODO Auto-generated method stub
		try {
			Field field = model.getClass().getDeclaredField(verifyField);
			field.setAccessible(true);
			Object verifyFieldValue = field.get(model);
			if(value.equals(verifyFieldValue)) {
				return true;
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
	
	public String getErrorMessage(Compare constraintAnnotation) {
		return constraintAnnotation.message();
	}

}
