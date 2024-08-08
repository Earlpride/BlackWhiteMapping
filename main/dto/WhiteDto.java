package net.gray.connect.mapper.test.mapstruct.dto;

public class WhiteDto {
	private BlackDto black;
	private String germanName;
	
	public BlackDto getBlack() {
		return black;
	}
	
	public void setBlack(BlackDto black) {
		this.black = black;
	}
	
	public String getGermanName() {
		return germanName;
	}
	
	public void setGermanName(String germanName) {
		this.germanName = germanName;
	}
}
