package com.netease.study;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

public class ValidDirective implements TemplateDirectiveModel {

	public void execute(Environment env, Map params, TemplateModel[] model, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		// TODO Auto-generated method stub
		String className = params.get("className").toString();
		try {
			Class c = Class.forName(className);
			System.out.println(className);
			
			Field[] fields = c.getDeclaredFields();
			System.out.println(fields.length);
			for(Field field : fields) {
				System.out.println(field.getName());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
