package com.netease.study;

public class CompareValidator implements CustomConstraintValidator<Compare> {

	/* (non-Javadoc)
	 * @see com.netease.study.CustomConstraintValidator#initialize(java.lang.annotation.Annotation)
	 */
	public void initialize(Compare constraintAnnotation) {
		// TODO Auto-generated method stub
		System.out.println("aaa");
		System.out.println(constraintAnnotation.message());
		System.out.println(constraintAnnotation.verifyField());
	}

	/* (non-Javadoc)
	 * @see com.netease.study.CustomConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
	 */
	public boolean isValid(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

}
