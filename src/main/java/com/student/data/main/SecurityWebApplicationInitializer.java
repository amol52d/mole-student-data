package com.student.data.main;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @author amoldhekane
 * @since 10/12/15 10:59 AM
 * @version 1.1
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebApplicationInitializer() {
        super(SecurityConfig.class);
    }
}
