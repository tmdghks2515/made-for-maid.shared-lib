package io.madeformaid.shared.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "auth")
public class AuthProperties {

    private List<String> whitelist;
    private String systemSecret;
    private Jwt jwt = new Jwt();

    @Getter
    @Setter
    public static class Jwt {
        private String secret;
        private String refreshTokenName;
        private Long accessTokenExpireTime;
        private Long refreshTokenExpireTime;
    }
}
