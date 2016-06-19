package de.torgen.smarthome;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmartHomeState {
	public void buildFeatures(){
		original();
		this.aktiveFeatures.add("motionOut");
	}
}
