package converter;

import entity.AttendanceStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AttendanceStatusConverter implements AttributeConverter<AttendanceStatus, String> {
    @Override
    public String convertToDatabaseColumn(AttendanceStatus status) {
        return status.name();
    }

    @Override
    public AttendanceStatus convertToEntityAttribute(String status) {
        return AttendanceStatus.valueOf(status);
    }
}
