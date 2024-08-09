package net.gray.connect.mapper.test.mapstruct;

import net.gray.connect.mapper.test.mapstruct.dto.BlackDto;
import net.gray.connect.mapper.test.mapstruct.dto.WhiteDto;
import net.gray.connect.mapper.test.mapstruct.entity.BlackEntity;
import net.gray.connect.mapper.test.mapstruct.mapper.IBlackMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class _MainTest {
	
	static IBlackMapper blackMapper = IBlackMapper.INSTANCE;
	static ObjectMapper om = new JsonMapper().enable(SerializationFeature.INDENT_OUTPUT);
	
	public static void main(String[] args) {
		System.out.println("##############################################################");
		
		//Creating DTOs - Reference chain: blackDto1 -> whiteDto1 -> null
		WhiteDto whiteDto1 = new WhiteDto();
		whiteDto1.setGermanName("weiss_1");
		
		BlackDto blackDto1 = new BlackDto();
		blackDto1.setGermanName("schwarz_1");
		blackDto1.setWhite(whiteDto1);
		
		//Printing DTOs as JSON to console
		System.out.println("X --> DTO");
		printObjectToConsole("whiteDto1", whiteDto1);
		printObjectToConsole("blackDto1", blackDto1);
		System.out.println("##############################################################");
		
		//DTO -> Entity
		BlackEntity blackEntity1 = blackMapper.toEntity(blackDto1);
		
		//Printing entities as JSON to console
		System.out.println("DTO --> Entity");
		printObjectToConsole("blackEntity1", blackEntity1);
		System.out.println("##############################################################");
		
		//Entity -> DTO
		blackDto1 = blackMapper.toDto(blackEntity1);
		
		//Print results
		System.out.println("Entity --> DTO");
		printObjectToConsole("blackDto1", blackDto1);
		System.out.println("##############################################################");
	}
	
	private static void printObjectToConsole(String name, Object obj) {
		try {
			String jsonString = om.writeValueAsString(obj);
			System.out.println(name + ":\n" + jsonString + "\n");
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
