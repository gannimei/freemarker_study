package com.netease.study;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.internal.metadata.facets.Validatable;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkerMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
		cfg.setSharedVariable("valid", new ValidDirective());
		cfg.setDirectoryForTemplateLoading(
				new File("D:/java/freemarker_study/src/main/resources"));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

		Template ftl = cfg.getTemplate("user.ftl");

		Map<String, Object> root = new HashMap<String, Object>();
		root.put("name", "lilei");
		root.put("password", "12345");

		Writer out = new OutputStreamWriter(System.out);
		ftl.process(root, out);*/
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		UserEditModel model = new UserEditModel();
		model.setPassword("123456");
		model.setUserName("guanzhen");
		model.setConfirmPassword("654321");
		Set<ConstraintViolation<UserEditModel>> constraintViolations = validator.validate(model);
		for (ConstraintViolation<UserEditModel> constraintViolation : constraintViolations) {  
            System.out.println("对象属性:"+constraintViolation.getPropertyPath());  
            System.out.println("国际化key:"+constraintViolation.getMessageTemplate());  
            System.out.println("错误信息:"+constraintViolation.getMessage());  
        } 
		
	}

}
