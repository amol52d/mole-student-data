package com.student.data.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * @author amoldhekane
 * @since 10/12/15 10:58 AM
 * @version 1.1
 */
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    RequestMatcher requestMatcher = new RequestMatcher() {
        private RegexRequestMatcher regexRequestMatcher = new RegexRequestMatcher("/dlr/add", null);
        private Pattern allowedMethod = Pattern.compile("^$GET|PUT|TRACE$");
        @Override
        public boolean matches(HttpServletRequest request) {
            return regexRequestMatcher.matches(request) ||
                    allowedMethod.matcher(request.getMethod()).matches();
        }
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().csrfTokenRepository(csrfTokenRepository())
        .ignoringAntMatchers("/dlr/**")
                .ignoringAntMatchers("/notify/**");
                //http.csrf().requireCsrfProtectionMatcher(requestMatcher);
//        http
//                .headers()
//                .cacheControl().disable();
//                http.headers().httpStrictTransportSecurity().and().xssProtection();

        http
                .headers()
                .defaultsDisabled()
                .cacheControl();
        http.headers().httpStrictTransportSecurity().and().xssProtection();

        /*http
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/LogOutServlet"))
                .logoutSuccessUrl("/Login.jsp");*/
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
    // ...

    private CsrfTokenRepository csrfTokenRepository()
    {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setSessionAttributeName("_csrf");
        return repository;
    }

}
