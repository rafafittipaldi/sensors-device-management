package com.sensors.device.management.api.config.jpa;

import io.hypersistence.tsid.TSID;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TSIDToLongJPAAttibuteConverter implements AttributeConverter<TSID, Long> {

    @Override
    public Long convertToDatabaseColumn(io.hypersistence.tsid.TSID attribute) {
        return attribute.toLong();
    }

    @Override
    public io.hypersistence.tsid.TSID convertToEntityAttribute(Long dbData) {
        return TSID.from(dbData);
    }
}
