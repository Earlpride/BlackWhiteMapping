package net.gray.connect.mapper.test.mapstruct;

import net.gray.connect.mapper.test.mapstruct.dto.BlackDto;
import net.gray.connect.mapper.test.mapstruct.dto.WhiteDto;
import net.gray.connect.mapper.test.mapstruct.entity.BlackEntity;
import net.gray.connect.mapper.test.mapstruct.entity.WhiteEntity;
import net.gray.connect.mapper.test.mapstruct.mapper.IBlackMapper;
import net.gray.connect.mapper.test.mapstruct.mapper.IWhiteMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class BlackWhite {
	
	static IBlackMapper blackMapper = IBlackMapper.INSTANCE;
	static IWhiteMapper whiteMapper = IWhiteMapper.INSTANCE;
	static ObjectMapper om = new JsonMapper().enable(SerializationFeature.INDENT_OUTPUT);
	
	public static void main(String[] args) {
		System.out.println("##############################################################");
		/* Creating DTOs
		Reference chain: 0 -> 1 -> 2 -> 3 -> null
		(i.e. objects of blackDto3 and whiteDto3 are null) */
		BlackDto blackDto3 = new BlackDto();
		WhiteDto whiteDto3 = new WhiteDto();
		blackDto3.setGermanName("schwarz");
		whiteDto3.setGermanName("weiss");
		
		BlackDto blackDto2 = new BlackDto();
		WhiteDto whiteDto2 = new WhiteDto();
		blackDto2.setGermanName("schwarz");
		whiteDto2.setGermanName("weiss");
		blackDto2.setWhite(whiteDto3);
		whiteDto2.setBlack(blackDto3);
		
		BlackDto blackDto1 = new BlackDto();
		WhiteDto whiteDto1 = new WhiteDto();
		blackDto1.setGermanName("schwarz");
		whiteDto1.setGermanName("weiss");
		blackDto1.setWhite(whiteDto2);
		whiteDto1.setBlack(blackDto2);
		
		BlackDto blackDto0 = new BlackDto();
		WhiteDto whiteDto0 = new WhiteDto();
		blackDto0.setGermanName("schwarz");
		whiteDto0.setGermanName("weiss");
		blackDto0.setWhite(whiteDto1);
		whiteDto0.setBlack(blackDto1);
		
		//Printing DTOs as JSON to console
		System.out.println("X --> DTO");
		printObjectToConsole("blackDtoM0", blackDto0);
		printObjectToConsole("whiteDtoM0", whiteDto0);
		printObjectToConsole("blackDtoM1", blackDto1);
		printObjectToConsole("whiteDtoM1", whiteDto1);
		printObjectToConsole("blackDtoM2", blackDto2);
		printObjectToConsole("whiteDtoM2", whiteDto2);
		printObjectToConsole("blackDtoM3", blackDto3);
		printObjectToConsole("whiteDtoM3", whiteDto3);
		System.out.println("##############################################################");
		
		//DTO -> Entity
		BlackEntity blackEntity3 = blackMapper.toEntity(blackDto3);
		WhiteEntity whiteEntity3 = whiteMapper.toEntity(whiteDto3);
		BlackEntity blackEntity2 = blackMapper.toEntity(blackDto2);
		WhiteEntity whiteEntity2 = whiteMapper.toEntity(whiteDto2);
		BlackEntity blackEntity1 = blackMapper.toEntity(blackDto1);
		WhiteEntity whiteEntity1 = whiteMapper.toEntity(whiteDto1);
		BlackEntity blackEntity0 = blackMapper.toEntity(blackDto0);
		WhiteEntity whiteEntity0 = whiteMapper.toEntity(whiteDto0);
		
		
		//Printing entities as JSON to console
		System.out.println("DTO --> Entity");
		printObjectToConsole("blackEntity0", blackEntity0);
		printObjectToConsole("whiteEntity0", whiteEntity0);
		printObjectToConsole("blackEntity1", blackEntity1);
		printObjectToConsole("whiteEntity1", whiteEntity1);
		printObjectToConsole("blackEntity2", blackEntity2);
		printObjectToConsole("whiteEntity2", whiteEntity2);
		printObjectToConsole("blackEntity3", blackEntity3);
		printObjectToConsole("whiteEntity3", whiteEntity3);
		System.out.println("##############################################################");
		
		//Entity -> DTO
		//M = mapped
		BlackDto blackDtoM3 = blackMapper.toDto(blackEntity3);
		WhiteDto whiteDtoM3 = whiteMapper.toDto(whiteEntity3);
		BlackDto blackDtoM2 = blackMapper.toDto(blackEntity2);
		WhiteDto whiteDtoM2 = whiteMapper.toDto(whiteEntity2);
		BlackDto blackDtoM1 = blackMapper.toDto(blackEntity1);
		WhiteDto whiteDtoM1 = whiteMapper.toDto(whiteEntity1);
		BlackDto blackDtoM0 = blackMapper.toDto(blackEntity0);
		WhiteDto whiteDtoM0 = whiteMapper.toDto(whiteEntity0);
		
		//Print results
		System.out.println("Entity --> DTO");
		printObjectToConsole("blackDtoM0", blackDtoM0);
		printObjectToConsole("whiteDtoM0", whiteDtoM0);
		printObjectToConsole("blackDtoM1", blackDtoM1);
		printObjectToConsole("whiteDtoM1", whiteDtoM1);
		printObjectToConsole("blackDtoM2", blackDtoM2);
		printObjectToConsole("whiteDtoM2", whiteDtoM2);
		printObjectToConsole("blackDtoM3", blackDtoM3);
		printObjectToConsole("whiteDtoM3", whiteDtoM3);
		System.out.println("##############################################################");
		
	}
	
	private static void printObjectToConsole(String name, Object obj) {
		try {
			String jsonString = om.writeValueAsString(obj);
			System.out.println(name + ":\n" + jsonString + "\n");
		} catch(JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
