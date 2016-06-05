package de.torgen.smarthome;

public interface Heating {
	public int getDesiredTemp();
	public void setDesiredTemp(Integer desiredTemp);
	public Integer getMeasuredTemp();
	public void setMeasuredTemp(Integer measuredTemp);
	public Integer getHeatingPercentage();
	public void calculateHeating();
}
