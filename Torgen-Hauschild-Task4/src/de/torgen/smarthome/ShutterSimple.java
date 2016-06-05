package de.torgen.smarthome;

public class ShutterSimple implements Shutter{

	private final Integer SUN_THRESHOLD = 50;
	private Integer sun;

	private Integer shutterPercentage;

	public ShutterSimple() {
		super();
		shutterPercentage = 0;
	}

	public void setSun(Integer sun) {
		this.sun = sun;
		calculateShutter();
	}

	public Integer getShutterPercentage() {
		return shutterPercentage;
	}

	public void setShutterPercentage(Integer shutterPercentage) {
		this.shutterPercentage = shutterPercentage;
	}

	public void calculateShutter(){
		if(sun != null){
			Integer diff = sun - SUN_THRESHOLD;
			if(diff > 0){
				shutterPercentage = diff * 2;
			}
			else{
				shutterPercentage = 0;
			}
		}
	}
}
