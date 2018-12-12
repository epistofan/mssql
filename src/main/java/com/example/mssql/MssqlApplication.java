package com.example.mssql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
//import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;


@SpringBootApplication
@ServletComponentScan
public class MssqlApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MssqlApplication.class, args);




	}

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	private static Class<MssqlApplication> applicationClass = MssqlApplication.class;*/


}
