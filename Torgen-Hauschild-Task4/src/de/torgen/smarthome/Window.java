package de.torgen.smarthome;

public interface Window {
	public void setDesiredTempIn(Integer desiredTempIn);
	public Boolean getWindowOpened();
	public void setTempIn(Integer tempIn);
	public void setTempOut(Integer tempOut);
	public void setRain(Boolean rain);
	public void calculateWindow();
}
