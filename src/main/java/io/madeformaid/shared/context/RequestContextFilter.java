package io.madeformaid.shared.context;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RequestContextFilter implements Filter {

    private static final String USER_ID_HEADER = "X-User-Id";
    private static final String ROLES_HEADER = "X-User-Roles";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;

            String userId = httpRequest.getHeader(USER_ID_HEADER);
            String rolesHeader = httpRequest.getHeader(ROLES_HEADER);

            List<String> roles = Optional.ofNullable(rolesHeader)
                    .map(r -> Arrays.stream(r.split(","))
                            .map(String::trim)
                            .toList())
                    .orElse(List.of());

            if (userId != null && !userId.isBlank()) {
                AuthContext.set(userId, roles);
            }

            chain.doFilter(request, response);
        } finally {
            AuthContext.clear(); // 반드시 clear 해줘야 함! (메모리 누수 방지)
        }
    }
}
