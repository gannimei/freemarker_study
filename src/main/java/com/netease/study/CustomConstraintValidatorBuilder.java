/**
 * 
 */
package com.netease.study;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gz
 *
 */
public enum CustomConstraintValidatorBuilder {

	INSTANCE;
	
	private Map<Class<CustomConstraintValidator<?>>, CustomConstraintValidator<?>> validators;
	
	CustomConstraintValidatorBuilder(){
		validators = new HashMap<Class<CustomConstraintValidator<?>>, CustomConstraintValidator<?>>();
	}
	
	public CustomConstraintValidator<?> GetValidator(Class<CustomConstraintValidator<?>> c){
		CustomConstraintValidator<?> result = validators.get(c);
		if(result == null) {
			try {
				result = c.newInstance();
				validators.put(c, result);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
