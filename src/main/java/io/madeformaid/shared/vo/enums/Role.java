package io.madeformaid.shared.vo.enums;

public enum Role implements DescribableEnum {
    SUPER_ADMIN("슈퍼 관리자"),
    SYSTEM_ADMIN("시스템 관리자"),
    SHOP_OWNER("사장님"),
    SHOP_MANAGER("매니저"),
    SHOP_STAFF("메이드/집사"),
    USER("사용자"),
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
