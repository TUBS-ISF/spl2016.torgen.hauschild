package de.torgen.smarthome;

public interface Shutter {
	public void setSun(Integer sun);
	public Integer getShutterPercentage();
	public void setShutterPercentage(Integer shutterPercentage);
	public void calculateShutter();
}
