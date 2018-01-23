package com.netease.study;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkerMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
		cfg.setSharedVariable("valid", new ValidDirective());
		cfg.setDirectoryForTemplateLoading(
				new File("E:/eclipse/freemarker_study/src/main/resources"));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

		Template ftl = cfg.getTemplate("user.ftl");

		Map<String, Object> root = new HashMap<String, Object>();
		root.put("name", "lilei");
		root.put("password", "12345");

		Writer out = new OutputStreamWriter(System.out);
		ftl.process(root, out);
	}

}
