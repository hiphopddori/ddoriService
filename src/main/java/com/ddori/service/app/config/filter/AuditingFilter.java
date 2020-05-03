package com.ddori.service.app.config.filter;


import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

public class AuditingFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        long start = new Date().getTime();
        chain.doFilter(request, response);
        long elapsed = new Date().getTime() - start;
        logger.info("Request[uri=" + httpServletRequest.getRequestURI() + ", method=" +
                httpServletRequest.getMethod() + "] completed in " + elapsed + " ms");
    }
}
