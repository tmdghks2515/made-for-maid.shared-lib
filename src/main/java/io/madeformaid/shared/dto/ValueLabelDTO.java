package io.madeformaid.shared.dto;

import io.madeformaid.shared.vo.enums.DescribableEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ValueLabelDTO {
    private String value;
    private String label;

    public static <T extends Enum<T> & DescribableEnum> ValueLabelDTO from(T enumValue) {
        return new ValueLabelDTO(enumValue.name(), enumValue.getDisplayName());
    }
}
