package babysitting.nannyservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;
  private final LogoutHandler logoutHandler;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable().cors().and()
            .authorizeHttpRequests()
            .requestMatchers("/api/v1/auth/**")
            .permitAll()
            .requestMatchers("/**")
            .permitAll()
            .requestMatchers("/**.png","/**.jpg","images/**")
            .permitAll()
            .requestMatchers("/home/**")
            .permitAll()
            .requestMatchers("/swagger-ui/**","/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs", "/v3/api-docs/**", "/swagger-resources/**", "/webjars/**","/searchNannies","/submitContactForm","/createBooking","/success")
            .permitAll()
            .requestMatchers(HttpMethod.GET,"/welcome")
            .authenticated()
            .requestMatchers(HttpMethod.GET,"/showAllNannies")
            .authenticated()
            .requestMatchers(HttpMethod.GET,"/api/v1/demo-controller")
            .authenticated()
            .requestMatchers(HttpMethod.GET,"/showBookingsForUser")
            .authenticated()
            .requestMatchers(HttpMethod.POST,"/showBookingsForUser")
            .authenticated()

        .anyRequest()
          .authenticated()
        .and()
          .sessionManagement()
          .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        .logout()
        .logoutUrl("/api/v1/auth/logout")
        .addLogoutHandler(logoutHandler)
        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
    ;

    return http.build();
  }
}
