package net.gray.connect.mapper.test.mapstruct.entity;

public class BlackEntity {
	private WhiteEntity white;
	private String germanName;
	
	public WhiteEntity getWhite() {
		return white;
	}
	
	public void setWhite(WhiteEntity white) {
		this.white = white;
	}
	
	public String getGermanName() {
		return germanName;
	}
	
	public void setGermanName(String germanName) {
		this.germanName = germanName;
	}
}
