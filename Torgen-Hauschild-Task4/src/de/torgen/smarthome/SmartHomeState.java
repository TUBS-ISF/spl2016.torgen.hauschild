package de.torgen.smarthome;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmartHomeState {
	private Light lightIndoor;
	private Light lightOutdoor;
	private Heating heating;
	private Integer tempIn;
	private Integer tempOut;
	private AirConditioning airConditioning;
	private Boolean rain;
	private Integer sun;
	private Shutter shutter;
	private Window window;
	
	private List<String> aktiveFeatures;

	public SmartHomeState(
			Light lightIndoor
			, Light lightOutdoor
			, Heating heating
			, Integer tempIn
			, Integer tempOut
			, AirConditioning airConditioning
			, Boolean rain
			, Integer sun
			, Shutter shutter
			, Window window
			, List<String> aktiveFeatures
			) {
		super();
		this.lightIndoor = lightIndoor;
		this.lightOutdoor = lightOutdoor;
		this.heating = heating;
		this.tempIn = tempIn;
		this.tempOut = tempOut;
		this.airConditioning = airConditioning;
		this.rain = rain;
		this.sun = sun;
		this.shutter = shutter;
		this.window = window;
		this.aktiveFeatures = aktiveFeatures;
	}
	
	public Light getLightIndoor() {
		return lightIndoor;
	}

	public void setLightIndoor(LightTimerClockFast lightIndoor) {
		this.lightIndoor = lightIndoor;
	}
	public Light getLightOutdoor() {
		return lightOutdoor;
	}

	public void setLightOutdoor(LightTimerClockFast lightOutdoor) {
		this.lightOutdoor = lightOutdoor;
	}

	public Heating getHeating() {
		return heating;
	}

	public void setHeating(Heating heating) {
		this.heating = heating;
	}

	public Integer getTempIn() {
		return tempIn;
	}

	public void setTempIn(Integer tempIn) {
		this.tempIn = tempIn;
	}

	public Integer getTempOut() {
		return tempOut;
	}

	public void setTempOut(Integer tempOut) {
		this.tempOut = tempOut;
	}

	public AirConditioning getAirConditioning() {
		return airConditioning;
	}

	public void setAirConditioning(AirConditioning airConditioning) {
		this.airConditioning = airConditioning;
	}

	public Boolean getRain() {
		return rain;
	}

	public void setRain(Boolean rain) {
		this.rain = rain;
	}

	public Integer getSun() {
		return sun;
	}

	public void setSun(Integer sun) {
		this.sun = sun;
	}

	public Shutter getShutter() {
		return shutter;
	}

	public void setShutter(Shutter shutter) {
		this.shutter = shutter;
	}

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}
	
	public List<String> getAktiveFeatures() {
		return aktiveFeatures;
	}

	public void setAktiveFeatures(List<String> aktiveFeatures) {
		this.aktiveFeatures = aktiveFeatures;
	}
	
}
