package de.torgen.smarthome;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmartHomeState {
	private Shutter shutter;
	
	public void buildFeatures(){
		original();
		this.shutter = new Shutter();
		this.aktiveFeatures.add("shutter");
	}
	
	public void onSetSun(Integer sun){
		original(sun);
		shutter.setSun(sun);
	}
	
	public Shutter getShutter() {
		return shutter;
	}

	public void setShutter(Shutter shutter) {
		this.shutter = shutter;
	}
}
