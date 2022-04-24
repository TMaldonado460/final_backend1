package com.ctd.finalbackend1.config.auth;

import com.ctd.finalbackend1.config.auth.filters.PacienteFilter;
import com.ctd.finalbackend1.security.UserDetailsServiceImpl;
import com.ctd.finalbackend1.config.auth.filters.JwtRequestFilter;
import com.ctd.finalbackend1.security.entity.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

import javax.servlet.Filter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private PacienteFilter pacienteFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
            .authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/users/signin").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/turnos*").hasAnyAuthority(UserRoles.ROLE_USER.name(), UserRoles.ROLE_ADMIN.name())
                // /turnos, /turnos/{id}
                .anyRequest().hasAuthority(UserRoles.ROLE_ADMIN.name())
            .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        /*
        // intente añadir filtros customizados, no supe como hacerlo, cuando tenga tiempo veo como hacerlo correctamente
        // TODO
        http.antMatcher("/pacientes/*").addFilterAfter(pacienteFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .anyRequest().authenticated();

         */
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public DaoAuthenticationProvider dao(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

}
