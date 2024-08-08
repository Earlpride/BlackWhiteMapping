package net.gray.connect.mapper.test.mapstruct.entity;

public class WhiteEntity {
	private BlackEntity black;
	private String germanName;
	
	public BlackEntity getBlack() {
		return black;
	}
	
	public void setBlack(BlackEntity black) {
		this.black = black;
	}
	
	public String getGermanName() {
		return germanName;
	}
	
	public void setGermanName(String germanName) {
		this.germanName = germanName;
	}
}
