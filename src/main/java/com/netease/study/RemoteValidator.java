/**
 * 
 */
package com.netease.study;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author gz
 *
 */
public class RemoteValidator implements CustomConstraintValidator<Remote> {

	private Class<?> verifyClass;
	private String verifyMethod;
	private String[] additionalField;
	
	/* (non-Javadoc)
	 * @see com.netease.study.CustomConstraintValidator#initialize(java.lang.annotation.Annotation)
	 */
	public void initialize(Remote constraintAnnotation) {
		// TODO Auto-generated method stub
		this.verifyClass = constraintAnnotation.verifyClass();
		this.verifyMethod = constraintAnnotation.verifyMethod();
		this.additionalField = constraintAnnotation.additionalField();
	}

	/* (non-Javadoc)
	 * @see com.netease.study.CustomConstraintValidator#isValid(java.lang.Object, java.lang.Object)
	 */
	public boolean isValid(Object value, Object model) {
		// TODO Auto-generated method stub
		Class[] paramsClass = new Class[additionalField.length + 1];
		Object[] paramsValue = new Object[additionalField.length + 1];
		paramsClass[0] = value.getClass();
		paramsValue[0] = value;
		for(int i = 0; i < additionalField.length; i++) {
			try {
				Field additional = model.getClass().getDeclaredField(additionalField[i]);
				additional.setAccessible(true);
				paramsClass[i + 1] = additional.getType();
				paramsValue[i + 1] = additional.get(model);
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Method verify = verifyClass.getDeclaredMethod(verifyMethod, paramsClass);
			boolean result = (Boolean)verify.invoke(verifyClass.newInstance(), paramsValue);
			return result;
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.netease.study.CustomConstraintValidator#getErrorMessage(java.lang.annotation.Annotation)
	 */
	public String getErrorMessage(Remote constraintAnnotation) {
		// TODO Auto-generated method stub
		return constraintAnnotation.message();
	}

}
