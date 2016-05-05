package de.torgen.smarthome;

public class AirConditioning {
	private Integer desiredTemp,measuredTemp,coolingPercentage;

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

	public Integer getMeasuredTemp() {
		return measuredTemp;
	}

	public void setMeasuredTemp(Integer measuredTemp) {
		this.measuredTemp = measuredTemp;
		calculateCooling();
	}

	public Integer getCoolingPercentage() {
		return coolingPercentage;
	}
	
	private void calculateCooling(){
		if(measuredTemp != null && desiredTemp != null){
			int diff = measuredTemp - desiredTemp;
			if(diff > 0){
				diff = diff*10;
				if(diff > 100){
					diff = 100;
				}
				coolingPercentage = diff;
			}
			else{
				coolingPercentage = 0;
			}
		}
		else if(desiredTemp != null){
			coolingPercentage = desiredTemp;
		}
	}
}
