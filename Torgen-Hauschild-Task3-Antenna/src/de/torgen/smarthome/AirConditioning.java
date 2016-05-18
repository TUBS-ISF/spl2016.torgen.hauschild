package de.torgen.smarthome;

public class AirConditioning {
	//#if TemperaturInside
//@	private Integer measuredTemp;
	//#endif
	private Integer desiredTemp,coolingPercentage;

	public AirConditioning() {
		super();
		coolingPercentage = 0;
	}

	public int getDesiredTemp() {
		return desiredTemp;
	}

	public void setDesiredTemp(Integer desiredTemp) {
		this.desiredTemp = desiredTemp;
		calculateCooling();
	}

	//#if TemperaturInside
//@	public Integer getMeasuredTemp() {
//@		return measuredTemp;
//@	}
//@
//@	
//@	public void setMeasuredTemp(Integer measuredTemp) {
//@		this.measuredTemp = measuredTemp;
//@		calculateCooling();
//@	}
	//#endif

	public Integer getCoolingPercentage() {
		return coolingPercentage;
	}
	
	private void calculateCooling(){
		//#if TemperaturInside
//@		if(desiredTemp != null){
//@			int diff = measuredTemp - desiredTemp;
//@			if(diff > 0){
//@				diff = diff*10;
//@				if(diff > 100){
//@					diff = 100;
//@				}
//@				coolingPercentage = diff;
//@			}
//@			else{
//@				coolingPercentage = 0;
//@			}
//@			return;
//@		}
		//#endif
		coolingPercentage = desiredTemp;
		
	}
}
