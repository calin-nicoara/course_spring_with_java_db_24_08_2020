package ro.esolacad.springcourse.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .httpBasic()
                    .and()
                .cors()
                    .and()
                .csrf()
                    .disable()
                .authorizeRequests()
                    .antMatchers("api/**")
                    .hasAnyRole("API")
                    .and()
                .authorizeRequests()
                    .antMatchers("/dummy/open/**")
                    .permitAll()
//                    .and()
//                .authorizeRequests()
                    .anyRequest()
                    .authenticated()
                    .and()
                .formLogin()
                    .permitAll();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails firstUser = User.withDefaultPasswordEncoder()
                .username("api")
                .password("api")
                .roles("API")
                .build();

        UserDetails secondUser = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();

        UserDetails thirdUser = User.withDefaultPasswordEncoder()
                .username("writer")
                .password("writer")
                .roles("API", "WRITER")
                .build();

        return new InMemoryUserDetailsManager(firstUser, secondUser, thirdUser);
    }
}
