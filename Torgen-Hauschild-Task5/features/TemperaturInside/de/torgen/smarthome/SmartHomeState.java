package de.torgen.smarthome;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmartHomeState {
	private Integer tempIn;
	
	public void buildFeatures(){
		original();
		this.aktiveFeatures.add("tempIn");
	}
	
	public void setTempInside(Integer temp){
		original(temp);
		tempIn = temp;
	}
	
	public Integer getTempIn() {
		return tempIn;
	}

	public void setTempIn(Integer tempIn) {
		this.tempIn = tempIn;
	}
}
