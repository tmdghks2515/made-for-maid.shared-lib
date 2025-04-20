package io.madeformaid.shared.vo.enums;

public enum Role implements DescribableEnum {
    USER("사용자"),
    CAFE_OWNER("사장님"),
    CAFE_MANAGER("매니저"),
    CAFE_STAFF("메이드/집사"),
    SYSTEM_ADMIN("시스템 관리자"),
    SUPER_ADMIN("슈퍼 관리자"),
    ;

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
