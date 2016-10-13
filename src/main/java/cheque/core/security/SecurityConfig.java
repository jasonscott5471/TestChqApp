package cheque.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by finwebmailer on 8/9/2016.
 */

@Configuration
@EnableWebSecurity
//sets up forced form based login authentication mechanism
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  //inject our custom packages
  @Autowired
  private AuthFailure authFailure;

  @Autowired
  private  AuthSuccess authSuccess;

@Autowired
private EntryPointUnauthorizedHandler unauthorizedHandler;


//inject our own classes which utilize our custom accounts database
  //eventually should look at wire things up to ldap
  @Autowired
  private UserDetailServiceImpl userDetailService;

  @Autowired
    public void configAuthBuilder(AuthenticationManagerBuilder builder) throws Exception {

      //for possible ldap solution see the following articles
      //https://github.com/jvmvik/gs-securing-war/blob/master/src/main/java/sample/ui/secure/SecurityConfig.java
      //http://stackoverflow.com/questions/23344787/spring-ldap-security-without-xml

      builder
              /* useful for testing
             .inMemoryAuthentication()
              .withUser("username").password("password").roles("USER"); */
              .userDetailsService(userDetailService);


  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http
            .csrf().disable()
            .exceptionHandling()
              .authenticationEntryPoint(unauthorizedHandler)
              .and()
            .formLogin()
              .successHandler(authSuccess)
              .failureHandler(authFailure)
            .and()
           /*
            .authorizeRequests()
              .antMatchers("/**")
              .permitAll();
            */
            .authorizeRequests()
           //blocks all urls even login .antMatchers("/**").authenticated()
            //.antMatchers("/rest/**").authenticated()
            .antMatchers("/rest/mvc/F**").authenticated()
            .anyRequest().permitAll();


  }
}
