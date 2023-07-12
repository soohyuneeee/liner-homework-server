package homework.aurumplanet.liner.global.security

import com.fasterxml.jackson.databind.ObjectMapper

import homework.aurumplanet.liner.global.security.auth.AuthDetailsService
import homework.aurumplanet.liner.global.security.jwt.JwtTokenProvider
import homework.aurumplanet.liner.global.security.jwt.filter.JwtAuthenticationFilter
import homework.aurumplanet.liner.global.security.jwt.filter.JwtExceptionFilter

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration

@EnableWebSecurity
@Configuration
class SecurityConfig(
    private val authDetailsService: AuthDetailsService,
    private val jwtTokenProvider: JwtTokenProvider,
    private val mapper: ObjectMapper,
) {

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder();
    }

    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
        return WebSecurityCustomizer { web: WebSecurity ->
            web
                .ignoring()
                .requestMatchers(
                    HttpMethod.GET,
                    "/",
                    "/favicon.ico",
                    "/error",
                    "/actuator/**",
                    "/h2-console/**",
                    "/api-docs/**",
                    "/swagger-ui/**",
                    "/configuration/**",
                    "/swagger-resources/**",
                    "/v3/api-docs",
                    "/webjars/**",
                    "/webjars/springfox-swagger-ui/*.{js,css}"
                )
        }
    }

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain? {
        http
            .cors().configurationSource { request ->
                val cors = CorsConfiguration()
                cors.allowedOrigins = listOf("http://localhost:3000")
                cors.allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "OPTIONS")
                cors.allowedHeaders = listOf("*")
                cors
            }
            .and()
            .httpBasic().disable()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .requestMatchers(HttpMethod.POST, "/login").permitAll()
            .requestMatchers(HttpMethod.POST, "/user").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin().disable()

        http
            .addFilterBefore(
                JwtAuthenticationFilter(authDetailsService, jwtTokenProvider),
                UsernamePasswordAuthenticationFilter::class.java
            )
            .addFilterBefore(JwtExceptionFilter(mapper), JwtAuthenticationFilter::class.java)

        return http.build()
    }
}