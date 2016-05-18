package de.torgen.smarthome;

public class Heating {
	//#if TemperaturInside
//@	private Integer measuredTemp;
	//#endif
	private Integer desiredTemp,heatingPercentage;

	public Heating() {
		super();
		heatingPercentage = 0;
	}

	public int getDesiredTemp() {
		return desiredTemp;
	}

	public void setDesiredTemp(Integer desiredTemp) {
		this.desiredTemp = desiredTemp;
		calculateHeating();
	}

	//#if TemperaturInside
//@	public Integer getMeasuredTemp() {
//@		return measuredTemp;
//@	}
//@
//@	public void setMeasuredTemp(Integer measuredTemp) {
//@		this.measuredTemp = measuredTemp;
//@		calculateHeating();
//@	}
	//#endif

	public Integer getHeatingPercentage() {
		return heatingPercentage;
	}
	
	private void calculateHeating(){
		//#if TemperaturInside
//@		if(measuredTemp != null && desiredTemp != null){
//@			int diff = measuredTemp - desiredTemp;
//@			if(diff < 0){
//@				diff = -diff*10;
//@				if(diff > 100){
//@					diff = 100;
//@				}
//@				heatingPercentage = diff;
//@			}
//@			else{
//@				heatingPercentage = 0;
//@			}
//@			return;
//@		}
		//#endif
		heatingPercentage = desiredTemp;
		
	}
}
