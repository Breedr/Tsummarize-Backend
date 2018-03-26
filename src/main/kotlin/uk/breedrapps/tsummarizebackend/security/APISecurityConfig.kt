package uk.breedrapps.tsummarizebackend.security

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy


@Configuration
@EnableWebSecurity
@Order(1)
class APISecurityConfig: WebSecurityConfigurerAdapter() {

    @Value("\${tsummarize.http.auth-token-header}")
    lateinit var principalRequestHeader: String

    @Value("\${tsummarize.http.auth-token}")
    lateinit var principalRequestValue: String

    override fun configure(httpSecurity: HttpSecurity?) {
        val filter = ApiKeyAuthFilter(principalRequestHeader)
        filter.setAuthenticationManager { authentication ->
            val principal = authentication.principal as String
            if (principalRequestValue != principal) {
                throw BadCredentialsException("The API key was not found or not the expected value.")
            }
            authentication.isAuthenticated = true
            authentication
        }

        httpSecurity?.let {
            it.antMatcher("/api/**")
                    .csrf()
                    .disable()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .addFilter(filter)
                    .authorizeRequests()
                    .anyRequest()
                    .authenticated()
        }

    }

}