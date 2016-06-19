package de.torgen.smarthome;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmartHomeState {
	private Heating heating;
	
	public void buildFeatures(){
		original();
		this.heating = new Heating();
		this.aktiveFeatures.add("heating");
	}
	
	public void setDesiredTempInside(Integer temp){
		original(temp);
		heating.setDesiredTemp(temp);
	}
	
	public void setTempInside(Integer temp){
		original(temp);
		heating.setMeasuredTemp(temp);
	}
	
	public Heating getHeating() {
		return heating;
	}

	public void setHeating(Heating heating) {
		this.heating = heating;
	}
}
