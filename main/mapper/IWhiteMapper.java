package net.gray.connect.mapper.test.mapstruct.mapper;

import net.gray.connect.mapper.test.mapstruct.dto.WhiteDto;
import net.gray.connect.mapper.test.mapstruct.entity.WhiteEntity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = IBlackMapper.class)
public interface IWhiteMapper {
	IWhiteMapper INSTANCE = Mappers.getMapper(IWhiteMapper.class);
	
	WhiteEntity toEntity(WhiteDto dto);
	
	WhiteDto toDto(WhiteEntity entity);
}
