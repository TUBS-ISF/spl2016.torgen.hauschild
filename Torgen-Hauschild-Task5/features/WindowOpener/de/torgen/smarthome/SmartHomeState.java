package de.torgen.smarthome;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.torgen.smarthome.Window;

public class SmartHomeState {
	private Window window;
	
	public void buildFeatures(){
		original();
		this.window = new Window();
		this.aktiveFeatures.add("window");
	}
	
	public void onSetRain(boolean raining){
		original(raining);
		window.setRain(raining);
	}
	
	public void setDesiredTempInside(Integer temp){
		original(temp);
		window.setDesiredTempIn(temp);
	}
	
	public void setTempInside(Integer temp){
		original(temp);
		window.setTempIn(temp);
	}
	
	public void setTempOutside(Integer temp){
		original(temp);
		window.setTempOut(temp);
	}
	
	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}
}
