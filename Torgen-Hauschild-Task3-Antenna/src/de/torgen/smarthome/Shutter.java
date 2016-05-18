package de.torgen.smarthome;

public class Shutter {
	//#if Sun
	private final Integer SUN_THRESHOLD = 50;
	private Integer sun;
	//#endif
	private Integer shutterPercentage;

	public Shutter() {
		super();
		shutterPercentage = 0;
	}

	//#if Sun
	public void setSun(Integer sun) {
		this.sun = sun;
		calculateShutter();
	}
	//#endif

	public Integer getShutterPercentage() {
		return shutterPercentage;
	}

	public void setShutterPercentage(Integer shutterPercentage) {
		this.shutterPercentage = shutterPercentage;
	}

	private void calculateShutter(){
		//#if Sun
		if(sun != null){
			Integer diff = sun - SUN_THRESHOLD;
			if(diff > 0){
				shutterPercentage = diff * 2;
			}
			else{
				shutterPercentage = 0;
			}
		}
		//#endif
	}
}
