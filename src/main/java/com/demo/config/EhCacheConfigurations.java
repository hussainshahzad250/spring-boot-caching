package com.demo.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@EnableCaching
@Configuration
public class EhCacheConfigurations {

	@Bean
	public CacheManager cachemanager() {

		EhCacheCacheManager cacheManager = new EhCacheCacheManager();
		cacheManager.setCacheManager(cacaheManagerFactoryBean().getObject());
		cacheManager.setTransactionAware(true);
		return cacheManager;

	}

	@Bean
	EhCacheManagerFactoryBean cacaheManagerFactoryBean() {
		EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
		bean.setConfigLocation(new ClassPathResource("ehCache.xml"));
		bean.setShared(true);
		return bean;
	}
}
