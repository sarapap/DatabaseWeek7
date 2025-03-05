package dao;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RankConverter implements AttributeConverter<String, Integer> {
    @Override
    public Integer convertToDatabaseColumn(String rank) {
        switch (rank) {
            case "Beginner":
                return 1;
            case "Intermediate":
                return 2;
            case "Advanced":
                return 3;
            default:
                return 0;
        }
    }

    @Override
    public String convertToEntityAttribute(Integer rank) {
        switch (rank) {
            case 1:
                return "Beginner";
            case 2:
                return "Intermediate";
            case 3:
                return "Advanced";
            default:
                return "Unknown";
        }
    }
}
