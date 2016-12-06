package com.friendtrest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Zac Leids.
 */
public class LoggerMe implements Filter{
    public void destroy() {
    }
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    private static final Logger LOG = LogManager.getLogger(LoggerMe.class);
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        LOG.info("Request Logged: IP:"+ servletRequest.getRemoteAddr().toString() + " URL:"+request.getRequestURL()+" Parameters:"+ servletRequest.getParameterMap().toString() );
        chain.doFilter(servletRequest, servletResponse);
    }
    public static Logger getLOG(){
        return LOG;
    }
}
