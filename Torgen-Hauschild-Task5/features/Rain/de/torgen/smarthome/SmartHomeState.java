package de.torgen.smarthome;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmartHomeState {
	private Boolean rain;
	
	public void buildFeatures(){
		original();
		this.aktiveFeatures.add("rain");
	}
	
	public void onSetRain(boolean raining){
		original(raining);
		rain = raining;
	}
	
	public Boolean getRain() {
		return rain;
	}
	
	public void setRain(Boolean rain) {
		this.rain = rain;
	}
}
