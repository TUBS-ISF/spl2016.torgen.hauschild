package de.torgen.smarthome;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.torgen.smarthome.Light;

public class SmartHomeState {
	private Light lightOutdoor;
	
	public void buildFeatures(){
		original();
		this.lightOutdoor = new Light(Light.State.OFF);
		this.aktiveFeatures.add("lightOut");
	}
	
	public void onMotionOutside(){
		original();
		lightOutdoor.onMotionDetected();
	}

	public Light getLightOutdoor() {
		return lightOutdoor;
	}
	
	public void setLightOutdoor(Light lightOutdoor) {
		this.lightOutdoor = lightOutdoor;
	}
}
