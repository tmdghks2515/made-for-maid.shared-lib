package io.madeformaid.shared.dto;

import io.madeformaid.shared.vo.enums.DescribableEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EnumDTO {
    private String name;
    private String displayName;

    public static <T extends Enum<T> & DescribableEnum> EnumDTO from(T enumValue) {
        return new EnumDTO(enumValue.name(), enumValue.getDisplayName());
    }
}
