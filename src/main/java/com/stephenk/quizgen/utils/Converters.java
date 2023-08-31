package com.stephenk.quizgen.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class Converters {
    @Converter
    public static class StringListConverter implements AttributeConverter<List<String>, String> {
        private static final String SPLIT_CHAR = ";";

        @Override
        public String convertToDatabaseColumn(List<String> strings) {
            return strings != null && !strings.isEmpty() ? String.join(SPLIT_CHAR, strings) : "";
        }

        @Override
        public List<String> convertToEntityAttribute(String s) {
            return s != null ? Arrays.asList(s.split(SPLIT_CHAR)) : Collections.emptyList();
        }
    }
}
