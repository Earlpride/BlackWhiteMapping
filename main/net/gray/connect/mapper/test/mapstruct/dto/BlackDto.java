package net.gray.connect.mapper.test.mapstruct.dto;

public class BlackDto {
	private WhiteDto white;
	private String germanName;
	
	public WhiteDto getWhite() {
		return white;
	}
	
	public void setWhite(WhiteDto white) {
		this.white = white;
	}
	
	public String getGermanName() {
		return germanName;
	}
	
	public void setGermanName(String germanName) {
		this.germanName = germanName;
	}
}
