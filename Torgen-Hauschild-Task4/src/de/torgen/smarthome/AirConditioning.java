package de.torgen.smarthome;

public interface AirConditioning {
	public int getDesiredTemp();
	public void setDesiredTemp(Integer desiredTemp);
	public Integer getMeasuredTemp();
	public void setMeasuredTemp(Integer measuredTemp);
	public Integer getCoolingPercentage();
	public void calculateCooling();
}
