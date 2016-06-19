package de.torgen.smarthome;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmartHomeState {
	private Integer sun;
	
	public void buildFeatures(){
		original();
		this.aktiveFeatures.add("sun");
	}
	
	public void onSetSun(Integer sun){
		original(sun);
		this.sun = sun;
	}
	
	public Integer getSun() {
		return sun;
	}

	public void setSun(Integer sun) {
		this.sun = sun;
	}
}
