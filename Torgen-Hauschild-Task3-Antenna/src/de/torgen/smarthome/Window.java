package de.torgen.smarthome;

public class Window {
	private Integer desiredTempIn;
	//#if TemperatureOutside
//@	private Integer tempOut;
	//#endif
	//#if TemperaturInside
//@	private Integer tempIn;
	//#endif
	private Boolean windowOpened;
	//#if Rain
//@	private Boolean rain;
	//#endif
	public Window() {
		super();
		windowOpened = false;
	}
	public void setDesiredTempIn(Integer desiredTempIn) {
		this.desiredTempIn = desiredTempIn;
	}

	public Boolean getWindowOpened() {
		return windowOpened;
	}
	
	//#if TemperaturInside
//@	public void setTempIn(Integer tempIn) {
//@		this.tempIn = tempIn;
//@	}
	//#endif
	//#if TemperatureOutside
//@	public void setTempOut(Integer tempOut) {
//@		this.tempOut = tempOut;
//@		calculateWindow();
//@	}
	//#endif
	//#if Rain
//@	public void setRain(Boolean rain) {
//@		this.rain = rain;
//@		calculateWindow();
//@	}
	//#endif
	private void calculateWindow(){
		//#if Rain
//@		if(rain != null){
//@			if(rain){
//@				windowOpened = false;
//@			}
//@			else{
				//#if TemperaturInside
				//#if TemperatureOutside
//@				if(desiredTempIn != null && tempIn != null && tempOut != null){
//@					Integer diff = desiredTempIn - tempIn;
//@					if((diff > 0 && tempOut > tempIn) || (diff < 0 && tempOut < tempIn)){
//@						windowOpened = true;
//@					}
//@					else{
//@						windowOpened = false;
//@					}
//@				}
				//#endif
				//#endif
//@			}
//@		}
		//#endif
	}
	
}
