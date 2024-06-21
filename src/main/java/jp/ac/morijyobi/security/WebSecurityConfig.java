package jp.ac.morijyobi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/book/list").authenticated()
                .requestMatchers("/", "/common/**").permitAll()   // "/", "/common/**" というリクエストに対してはログイン不要
                .requestMatchers("/tag/**", "/book/**").hasRole("ADMIN")       // "/tag/**" に対しては ADMIN 権限が必要
                .anyRequest().authenticated()         // それ以外のリクエストに対してはログインが必要
            ).formLogin(login -> login
                .loginProcessingUrl("/login")        // ログイン処理を行うURL (POST)
                .loginPage("/login")                 // ログイン画面のURL  (GET)]
                .defaultSuccessUrl("/")              // ログイン成功時のリダイレクト先
                .failureUrl("/login?error")  // ログイン失敗時のリダイレクト先
                .permitAll()                         // ログイン画面にはログイン不要
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
