package io.madeformaid.shared.jpa.converter;

import io.madeformaid.shared.vo.enums.DescribableEnum;
import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class EnumSetConverter<T extends Enum<T> & DescribableEnum> implements AttributeConverter<Set<T>, String> {

    private final Class<T> enumClass;

    protected EnumSetConverter(Class<T> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    public String convertToDatabaseColumn(Set<T> attribute) {
        if (attribute == null || attribute.isEmpty()) return "";
        return attribute.stream()
                .map(Enum::name)
                .collect(Collectors.joining(","));
    }

    @Override
    public Set<T> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.trim().isEmpty()) return Set.of();
        return Arrays.stream(dbData.split(","))
                .map(String::trim)
                .map(value -> Enum.valueOf(enumClass, value))
                .collect(Collectors.toSet());
    }
}
