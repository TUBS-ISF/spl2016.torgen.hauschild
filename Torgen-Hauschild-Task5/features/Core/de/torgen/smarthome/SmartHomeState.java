package de.torgen.smarthome;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmartHomeState {
	
	private List<String> aktiveFeatures;

	public SmartHomeState() {
		super();
		buildFeatures();
	}
	
	public void buildFeatures(){
		this.aktiveFeatures = new ArrayList<String>();
	}
	
	public void setDesiredTempInside(Integer temp){
		
	}
	
	public void setTempInside(Integer temp){
		
	}
	
	public void setTempOutside(Integer temp){
		
	}
	
	public void onMotionInside(){
		
	}
	
	public void onMotionOutside(){
		
	}
	
	public void onSetRain(boolean raining){
		
	}
	
	public void onSetSun(Integer sun){
		
	}

	public List<String> getAktiveFeatures() {
		return aktiveFeatures;
	}

	public void setAktiveFeatures(List<String> aktiveFeatures) {
		this.aktiveFeatures = aktiveFeatures;
	}
}
