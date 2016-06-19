package de.torgen.smarthome;

public class Heating {
	private Integer measuredTemp;

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

	public Integer getMeasuredTemp() {
		return measuredTemp;
	}

	public void setMeasuredTemp(Integer measuredTemp) {
		this.measuredTemp = measuredTemp;
		calculateHeating();
	}

	public Integer getHeatingPercentage() {
		return heatingPercentage;
	}
	
	private void calculateHeating(){
		if(measuredTemp != null && desiredTemp != null){
			int diff = measuredTemp - desiredTemp;
			if(diff < 0){
				diff = -diff*10;
				if(diff > 100){
					diff = 100;
				}
				heatingPercentage = diff;
			}
			else{
				heatingPercentage = 0;
			}
			return;
		}
		heatingPercentage = desiredTemp;
	}
}
