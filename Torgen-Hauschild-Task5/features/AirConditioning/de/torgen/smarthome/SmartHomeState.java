package de.torgen.smarthome;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.torgen.smarthome.AirConditioning;

public class SmartHomeState {
	private AirConditioning airConditioning;
	
	public void buildFeatures(){
		original();
		this.airConditioning = new AirConditioning();
		this.aktiveFeatures.add("airConditioning");
	}
	
	public void setDesiredTempInside(Integer temp){
		original(temp);
		airConditioning.setDesiredTemp(temp);
	}
	
	public void setTempInside(Integer temp){
		original(temp);
		airConditioning.setMeasuredTemp(temp);
	}
	
	
	public AirConditioning getAirConditioning() {
		return airConditioning;
	}
	
	public void setAirConditioning(AirConditioning airConditioning) {
		this.airConditioning = airConditioning;
	}
}
