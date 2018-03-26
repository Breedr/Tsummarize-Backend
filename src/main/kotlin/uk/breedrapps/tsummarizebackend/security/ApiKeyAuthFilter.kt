package uk.breedrapps.tsummarizebackend.security

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter
import javax.servlet.http.HttpServletRequest

class ApiKeyAuthFilter(private val principalRequestHeader: String): AbstractPreAuthenticatedProcessingFilter() {

    override fun getPreAuthenticatedCredentials(request: HttpServletRequest?): Any {
        return request?.getHeader(principalRequestHeader) ?: ""
    }

    override fun getPreAuthenticatedPrincipal(request: HttpServletRequest?): Any {
        return request?.getHeader(principalRequestHeader) ?: ""
    }
}