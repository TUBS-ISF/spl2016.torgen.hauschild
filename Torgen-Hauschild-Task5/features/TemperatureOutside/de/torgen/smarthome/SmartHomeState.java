package de.torgen.smarthome;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmartHomeState {
	private Integer tempOut;
	
	public void buildFeatures(){
		original();
		this.aktiveFeatures.add("tempOut");
	}
	
	public void setTempOutside(Integer temp){
		original(temp);
		tempOut = temp;
	}
	
	public Integer getTempOut() {
		return tempOut;
	}

	public void setTempOut(Integer tempOut) {
		this.tempOut = tempOut;
	}
}
