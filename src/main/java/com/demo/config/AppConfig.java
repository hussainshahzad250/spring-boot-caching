/**
 * 
 */
package com.demo.config;

/**
 * @author shahzad.hussain
 *
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AppConfig implements ApplicationContextAware {

	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

	public <T> T getBean(Class<T> beanClass) {
		return context.getBean(beanClass);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}