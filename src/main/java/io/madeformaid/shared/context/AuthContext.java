package io.madeformaid.shared.context;

import java.util.List;
import java.util.Optional;

public class AuthContext {

    private static final ThreadLocal<AuthInfo> authHolder = new ThreadLocal<>();

    public static void set(String userId, List<String> roles) {
        authHolder.set(new AuthInfo(userId, roles));
    }

    public static String getUserId() {
        return Optional.ofNullable(authHolder.get())
                .map(AuthInfo::getUserId)
                .orElse(null);
    }

    public static List<String> getRoles() {
        return Optional.ofNullable(authHolder.get())
                .map(AuthInfo::getRoles)
                .orElse(List.of());
    }

    public static boolean hasRole(String role) {
        return getRoles().contains(role);
    }

    public static void clear() {
        authHolder.remove();
    }

    public static class AuthInfo {
        private final String userId;
        private final List<String> roles;

        public AuthInfo(String userId, List<String> roles) {
            this.userId = userId;
            this.roles = roles != null ? roles : List.of();
        }

        public String getUserId() {
            return userId;
        }

        public List<String> getRoles() {
            return roles;
        }
    }
}
