package com.fm.recommender.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializr extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }
    @Override
    protected Class<?>[] getServletConfigClasses() { return new Class[]{RecommenderConfig.class };
    }
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
