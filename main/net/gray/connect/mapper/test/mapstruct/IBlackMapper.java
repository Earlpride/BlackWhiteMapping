package net.gray.connect.mapper.test.mapstruct.mapper;

import net.gray.connect.mapper.test.mapstruct.dto.BlackDto;
import net.gray.connect.mapper.test.mapstruct.entity.BlackEntity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = IWhiteMapper.class)
public interface IBlackMapper {
	IBlackMapper INSTANCE = Mappers.getMapper(IBlackMapper.class);
	
	BlackEntity toEntity(BlackDto dto);
	
	BlackDto toDto(BlackEntity entity);
}
