package io.madeformaid.shared.vo.enums;

public enum AdminRole implements DescribableEnum {
    MAID_CAFE_OWNER("메이드카페 사장님"),
    MAID_CAFE_MANAGER("메이드카페 매니저"),
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
