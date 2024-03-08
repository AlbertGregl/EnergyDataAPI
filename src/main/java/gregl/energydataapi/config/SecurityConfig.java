package gregl.energydataapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/api/**").authenticated()
                        .requestMatchers("/api/save").authenticated()
                        .requestMatchers("/api/update/**").authenticated()
                        .requestMatchers("/api/delete/**").authenticated()
                        .requestMatchers("/api/uploadEnergyData").authenticated()
                        .requestMatchers("/api/data/**/**").authenticated()
                        .requestMatchers("/soap/").authenticated()
                        .requestMatchers("/soap/data.wsdl").permitAll()
                        )
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

        http.cors();
        return http.build();
    }
}
