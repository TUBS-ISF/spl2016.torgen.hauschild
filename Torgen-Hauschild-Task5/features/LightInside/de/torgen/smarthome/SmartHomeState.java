package de.torgen.smarthome;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.torgen.smarthome.Light;

public class SmartHomeState {
	private Light lightIndoor;
	
	public void buildFeatures(){
		original();
		this.lightIndoor = new Light(Light.State.OFF);
		this.aktiveFeatures.add("lightIn");
	}
	
	public void onMotionInside(){
		original();
		lightIndoor.onMotionDetected();
	}
	
	public Light getLightIndoor() {
		return lightIndoor;
	}

	public void setLightIndoor(Light lightIndoor) {
		this.lightIndoor = lightIndoor;
	}
}
