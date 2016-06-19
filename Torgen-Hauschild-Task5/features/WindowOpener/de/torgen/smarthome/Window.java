package de.torgen.smarthome;

public class Window {
	private Integer desiredTempIn;
	private Integer tempOut;
	private Integer tempIn;
	private Boolean windowOpened;
	private Boolean rain;
	
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
		System.out.println("window: rain: " + rain +  " desiredTempIn: " + desiredTempIn + " tempIn: " + tempIn + " tempOut: " + tempOut);
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
		System.out.println("window: result: " +windowOpened );
	}
	
}
