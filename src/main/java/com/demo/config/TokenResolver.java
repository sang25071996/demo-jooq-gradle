package com.demo.config;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.flywaydb.core.internal.util.StringUtils;
import org.springframework.security.oauth2.server.resource.web.BearerTokenResolver;

@Log4j2
public class TokenResolver implements BearerTokenResolver {

    private static final String AUTHORIZATION_HEADER_KEY = "authorization";
    private static final String BEARER_TOKEN_PREFIX = "bearer ";

    public String resolve(HttpServletRequest request) {
        String headerToken = this.getTokenFromHeader(request);
        if (!StringUtils.hasText(headerToken)) {
            log.warn("security - token is not found in cookie or header!");
        }
        return headerToken;
    }

    private String getTokenFromHeader(HttpServletRequest request) {
        String authHeader = request.getHeader(AUTHORIZATION_HEADER_KEY);
        if (StringUtils.hasText(authHeader)) {
            int tokenStartIndex = authHeader.toLowerCase().startsWith(BEARER_TOKEN_PREFIX) ? BEARER_TOKEN_PREFIX.length() : 0;
            return authHeader.substring(tokenStartIndex);
        } else {
            return null;
        }
    }
}
