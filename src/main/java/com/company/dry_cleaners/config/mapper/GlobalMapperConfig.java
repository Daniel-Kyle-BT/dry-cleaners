package com.company.dry_cleaners.config.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.NullValuePropertyMappingStrategy; 

@MapperConfig(
		componentModel = "spring", 
		unmappedTargetPolicy = ReportingPolicy.IGNORE, 
		nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
		nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface GlobalMapperConfig {
}