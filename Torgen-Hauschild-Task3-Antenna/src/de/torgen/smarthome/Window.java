package de.torgen.smarthome;

public class Window {
	private Integer tempOut,  tempIn, desiredTempIn;
	private Boolean rain, windowOpened;
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
	public void setTempIn(Integer tempIn) {
		this.tempIn = tempIn;
	}

	public void setTempOut(Integer tempOut) {
		this.tempOut = tempOut;
		calculateWindow();
	}
	public void setRain(Boolean rain) {
		this.rain = rain;
		calculateWindow();
	}
	private void calculateWindow(){
		if(rain != null){
			if(rain){
				windowOpened = false;
			}
			else{
				if(desiredTempIn != null && tempIn != null && tempOut != null){
					Integer diff = desiredTempIn - tempIn;
					if((diff > 0 && tempOut > tempIn) || (diff < 0 && tempOut < tempIn)){
						windowOpened = true;
					}
					else{
						windowOpened = false;
					}
				}
			}
		}
	}
	
}
