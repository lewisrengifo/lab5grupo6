package sw2.lab5.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception  {

        http.formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/processlogin")
                .defaultSuccessUrl("/redirectByRol", true);

        http.logout().logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true);

        http.authorizeRequests().antMatchers("/user","user/**","/user/list").hasAuthority("admin");
        http.authorizeRequests().antMatchers("/post/delete").hasAuthority("admin");
        http.authorizeRequests().antMatchers("/user","/user/edit").hasAnyAuthority("user","admin");
        http.authorizeRequests().antMatchers("/post/create","/post/edit").hasAnyAuthority("user","admin");
        http.authorizeRequests().anyRequest().permitAll();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery("SELECT email, password,active from user where email =?")
                .authoritiesByUsernameQuery("select u.email, r.role_name from user u" +
                                            "inner join role r on u.id_role=r.id_role" +
                                            "where u.email = ? and u.active =1");
                        }
}