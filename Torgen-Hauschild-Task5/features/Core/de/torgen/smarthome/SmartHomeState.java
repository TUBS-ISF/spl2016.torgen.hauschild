package de.torgen.smarthome;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmartHomeState {
	/*
	//#if Sun
	private Integer sun;
	//#endif
	//#if RollerShutter
	private Shutter shutter;
	//#endif
	//#if WindowOpener
//@	private Window window;
	//#endif*/
	
	private List<String> aktiveFeatures;

	public SmartHomeState() {
		super();
		buildFeatures();
	}
	
	public void buildFeatures(){
		this.aktiveFeatures = new ArrayList<String>();
/*	
		this.shutter = new Shutter();
		//#if Sun
		this.aktiveFeatures.add("sun");
		//#endif
		//#if RollerShutter
		this.aktiveFeatures.add("shutter");
		//#endif
		*/
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
	
/*	

	//#endif
	//#if Sun
	public Integer getSun() {
		return sun;
	}

	public void setSun(Integer sun) {
		this.sun = sun;
	}
	//#endif
	//#if RollerShutter
	public Shutter getShutter() {
		return shutter;
	}

	public void setShutter(Shutter shutter) {
		this.shutter = shutter;
	}
	//#endif
*/

	public List<String> getAktiveFeatures() {
		return aktiveFeatures;
	}

	public void setAktiveFeatures(List<String> aktiveFeatures) {
		this.aktiveFeatures = aktiveFeatures;
	}
}
