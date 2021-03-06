package com.laptrinhjavawebshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavawebshop.service.impl.UserDetailsServiceIml;


@Configuration
@EnableWebSecurity /*(debug = true)*/
@Transactional
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceIml userDetailsService;

    @Autowired
    private AppConfig appConfig;

	@Autowired
	@Qualifier ("authenticationSuccessHandler")
	private AuthenticationSuccessHandler successHandler;
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    
        auth.userDetailsService(userDetailsService).passwordEncoder(appConfig.passwordEncoder());
    }

    @Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
    

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        // C??c trang kh??ng y??u c???u login
        http.authorizeRequests().antMatchers("/trang-chu", "/dang-ky", "/dang-nhap","/" ).permitAll();
      
        // Trang ch??? d??nh cho ADMIN
        http.authorizeRequests().antMatchers("/admin/home").authenticated();  
        http.authorizeRequests().antMatchers("/admin/product/*").authenticated();
        http.authorizeRequests().antMatchers("/admin/user/*").authenticated();
       
        //trang bat ph???i ????ng nh???p quy???n.
//        http.authorizeRequests().antMatchers("/contact").access("hasRole('USER')");
        
       //N???u c???n v?? nh???ng trang y??u c???u quy???n m?? ch??a ????ng nh???p th?? s??? v??o th??ng "/accessDenied"
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/accessDenied");

        // C???u h??nh cho Login Form.
        http.authorizeRequests().and().formLogin()//
                // Submit URL c???a trang login
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/dang-nhap")//
//                .defaultSuccessUrl("/customSuccessHandler",true)
                .successHandler(successHandler)
                .failureUrl("/dang-nhap?incorrectAccount")//nhap sai thi phai nhap lai
                .usernameParameter("j_username")//
                .passwordParameter("j_password")
                
                // C???u h??nh cho Logout Page.
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
               
        // C???u h??nh Remember Me.
        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h

    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }
}
