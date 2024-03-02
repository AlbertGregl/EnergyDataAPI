package gregl.energydataapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/api/public").permitAll()
                .requestMatchers("/api/private").authenticated()
                .requestMatchers("/api/index").authenticated()
                .requestMatchers("/api/**").authenticated()
                .requestMatchers("/api/save").authenticated()
                .requestMatchers("/api/update/**").authenticated()
                .requestMatchers("/api/delete/**").authenticated()
                .and().cors()
                .and().oauth2ResourceServer().jwt();
        return http.build();
    }
}
