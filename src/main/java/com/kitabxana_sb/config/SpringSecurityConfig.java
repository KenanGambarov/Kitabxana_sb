package com.kitabxana_sb.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/main")
                .hasAnyRole("ROLE_USER")
                .and().formLogin().
                loginPage("/login")
                .and().logout()
                .permitAll()
                .and().exceptionHandling()
                .accessDeniedPage("/403")
                .and().csrf();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(this.dataSource)
                .usersByUsernameQuery("select email, password, enabled from kitabxana.user_info where email=? ")
                .authoritiesByUsernameQuery("select email, authority from kitabxana.authorities where email=? ");
    }
}
