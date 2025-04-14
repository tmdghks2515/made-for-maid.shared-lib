package io.madeformaid.shared.vo.enums;

import lombok.Getter;

@Getter
public enum OauthProvider implements DescribableEnum {
    GOOGLE("구글"),
    KAKAO("카카오"),
    NAVER("네이버"),
    NONE("none"),
    ;

    private final String displayName;

    OauthProvider(String displayName) {
        this.displayName = displayName;
    }


    @Override
    public String getDisplayName() {
        return displayName;
    }
}
