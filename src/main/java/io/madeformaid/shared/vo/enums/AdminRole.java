package io.madeformaid.shared.vo.enums;

public enum AdminRole implements DescribableEnum {
    MAID_CAFE_ADMIN("메이드카페 관리자"),
    MAID("메이드"),
    SYSTEM_ADMIN("시스템 관리자"),
    ;

    private final String displayName;

    AdminRole(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
