package de.torgen.smarthome;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmartHomeState {
	//#if LightInside
//@	private Light lightIndoor;
	//#endif
	//#if LightOutside
//@	private Light lightOutdoor;
	//#endif
	//#if Heater
//@	private Heating heating;
	//#endif
	//#if TemperaturInside
//@	private Integer tempIn;
	//#endif
	//#if TemperatureOutside
//@	private Integer tempOut;
	//#endif
	//#if AirConditioning
//@	private AirConditioning airConditioning;
	//#endif
	//#if Rain
	private Boolean rain;
	//#endif
	//#if Sun
//@	private Integer sun;
	//#endif
	//#if RollerShutter
//@	private Shutter shutter;
	//#endif
	//#if WindowOpener
	private Window window;
	//#endif
	
	private List<String> aktiveFeatures;

	public SmartHomeState(List<String> aktiveFeatures
			//#if LightInside
//@			, Light lightIndoor
			//#endif
			//#if LightOutside
//@			, Light lightOutdoor
			//#endif
			//#if Heater
//@			, Heating heating
			//#endif
			//#if TemperaturInside
//@			, Integer tempIn
			//#endif
			//#if TemperatureOutside
//@			, Integer tempOut
			//#endif
			//#if AirConditioning
//@			, AirConditioning airConditioning
			//#endif
			//#if Rain
			, Boolean rain
			//#endif
			//#if Sun
//@			, Integer sun
			//#endif
			//#if RollerShutter
//@			, Shutter shutter
			//#endif
			//#if WindowOpener
			, Window window
			//#endif
			) {
		super();
		this.aktiveFeatures = aktiveFeatures;
		//#if LightInside
//@		this.lightIndoor = lightIndoor;
		//#endif
		//#if LightOutside
//@		this.lightOutdoor = lightOutdoor;
		//#endif
		//#if Heater
//@		this.heating = heating;
		//#endif
		//#if TemperaturInside
//@		this.tempIn = tempIn;
		//#endif
		//#if TemperatureOutside
//@		this.tempOut = tempOut;
		//#endif
		//#if AirConditioning
//@		this.airConditioning = airConditioning;
		//#endif
		//#if Rain
		this.rain = rain;
		//#endif
		//#if Sun
//@		this.sun = sun;
		//#endif
		//#if RollerShutter
//@		this.shutter = shutter;
		//#endif
		//#if WindowOpener
		this.window = window;
		//#endif	
	}
	
	
	
	//#if LightInside
//@	public Light getLightIndoor() {
//@		return lightIndoor;
//@	}
//@
//@	public void setLightIndoor(Light lightIndoor) {
//@		this.lightIndoor = lightIndoor;
//@	}
	//#endif
	//#if LightOutside
//@	public Light getLightOutdoor() {
//@		return lightOutdoor;
//@	}
//@
//@	public void setLightOutdoor(Light lightOutdoor) {
//@		this.lightOutdoor = lightOutdoor;
//@	}
	//#endif
	//#if Heater
//@	public Heating getHeating() {
//@		return heating;
//@	}
//@
//@	public void setHeating(Heating heating) {
//@		this.heating = heating;
//@	}
	//#endif
	//#if TemperaturInside
//@	public Integer getTempIn() {
//@		return tempIn;
//@	}
//@
//@	public void setTempIn(Integer tempIn) {
//@		this.tempIn = tempIn;
//@	}
	//#endif
	//#if TemperatureOutside
//@	public Integer getTempOut() {
//@		return tempOut;
//@	}
//@
//@	public void setTempOut(Integer tempOut) {
//@		this.tempOut = tempOut;
//@	}
	//#endif
	//#if AirConditioning
//@	public AirConditioning getAirConditioning() {
//@		return airConditioning;
//@	}
//@
//@	public void setAirConditioning(AirConditioning airConditioning) {
//@		this.airConditioning = airConditioning;
//@	}
	//#endif
	//#if Rain
	public Boolean getRain() {
		return rain;
	}

	public void setRain(Boolean rain) {
		this.rain = rain;
	}
	//#endif
	//#if Sun
//@	public Integer getSun() {
//@		return sun;
//@	}
//@
//@	public void setSun(Integer sun) {
//@		this.sun = sun;
//@	}
	//#endif
	//#if RollerShutter
//@	public Shutter getShutter() {
//@		return shutter;
//@	}
//@
//@	public void setShutter(Shutter shutter) {
//@		this.shutter = shutter;
//@	}
	//#endif
	//#if WindowOpener
	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}
	//#endif


	public List<String> getAktiveFeatures() {
		return aktiveFeatures;
	}

	public void setAktiveFeatures(List<String> aktiveFeatures) {
		this.aktiveFeatures = aktiveFeatures;
	}
	
}
