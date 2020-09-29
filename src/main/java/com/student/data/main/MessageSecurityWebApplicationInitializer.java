package com.student.data.main;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @author professional-nibba
 * @since 13/12/15 10:58 AM
 * @version 1.1
 */
public class MessageSecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {


    public  MessageSecurityWebApplicationInitializer()
    {
        super(RootConfiguration.class);
    }


}