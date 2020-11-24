package com.loblaw.falcon.GeoExtractor.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AppRes {
	
	public String postal;
	
	public String longt;
	
	public String latt;
	
	public Standard standard;
	
	@JsonProperty("Dissemination_Area")
	public DisseminationArea dissemination_Area;
	
	@JsonProperty("TimeZone")
	public String timeZone;
	
	@JsonProperty("AreaCode")
	public String areaCode;
}
