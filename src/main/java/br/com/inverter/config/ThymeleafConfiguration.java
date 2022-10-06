package br.com.inverter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ThymeleafConfiguration {
	
	@Bean
	@Description("Thymeleaf template resolver serving HTML 5 emails")
	public ClassLoaderTemplateResolver emailTemplateResolver() {
	    ClassLoaderTemplateResolver emailTemplateResolver = new ClassLoaderTemplateResolver();
	    emailTemplateResolver.setPrefix("admin/");
	    emailTemplateResolver.setPrefix("imp/");
	    emailTemplateResolver.setSuffix(".html");
	    emailTemplateResolver.setTemplateMode("HTML5");
	    emailTemplateResolver.setCharacterEncoding("UTF-8");
	    emailTemplateResolver.setOrder(1);
	    return emailTemplateResolver;
	}
}
