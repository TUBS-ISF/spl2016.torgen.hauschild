package de.torgen.smarthome;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.torgen.smarthome.SmartHomeState;

@Path("/home")
@Produces(MediaType.APPLICATION_JSON)
public class SmartHomeRessource {
	private final AtomicLong counter;
	private SmartHomeState e;

	public SmartHomeRessource(SmartHomeState e) {
		this.counter = new AtomicLong();
		this.e = e;
	}

	@GET
	@Timed
	public SmartHomeState getSmartHomeState() {
		System.out.println("getSnart ");
		return e;
	}

	static class Job {
		@JsonProperty
		String floor;
	}
	
	@POST
	@Timed
	@Path("motionIn")
	@Produces(MediaType.APPLICATION_JSON)
	public void motionIndoorDetected() {
		e.onMotionInside();
		//#if LightOutside
//@		e.getLightIndoor().onMotionDetected();
		//#endif
	}
	
	@POST
	@Timed
	@Path("motionOut")
	@Produces(MediaType.APPLICATION_JSON)
	public void motionOutdoorDetected() {
		e.onMotionOutside();
		//#if LightOutside
//@		e.getLightOutdoor().onMotionDetected();
		//#endif
	}
	
	@POST
	@Timed
	@Path("tempIn")
	@Produces(MediaType.APPLICATION_JSON)
	public void tmpInMeasured(Integer measuredTemp) {
		e.setTempInside(measuredTemp);
		//#if Heater
//@		e.getHeating().setMeasuredTemp(measuredTemp);
		//#endif
		//#if TemperaturInside
//@		e.setTempIn(measuredTemp);
		//#endif
		//#if AirConditioning
//@		e.getAirConditioning().setMeasuredTemp(measuredTemp);
		//#endif
		//#if WindowOpener
		//#if TemperaturInside
//@		e.getWindow().setTempIn(measuredTemp);
		//#endif
		//#endif
	}
	
	@POST
	@Timed
	@Path("tempOut")
	@Produces(MediaType.APPLICATION_JSON)
	public void tmpOutMeasured(Integer measuredTemp) {
		e.setTempOutside(measuredTemp);
		//#if TemperatureOutside
//@		e.setTempOut(measuredTemp);
		//#endif
		//#if WindowOpener
		//#if TemperatureOutside
//@		e.getWindow().setTempOut(measuredTemp);
		//#endif
		//#endif
	}
	
	@POST
	@Timed
	@Path("desiredTempIn")
	@Produces(MediaType.APPLICATION_JSON)
	public void desiredTempInChanged(Integer desiredTemp) {
		System.out.println("desired tmp: " + desiredTemp);
		e.setDesiredTempInside(desiredTemp);
		//#if Heater
//@		e.getHeating().setDesiredTemp(desiredTemp);
		//#endif
		//#if AirConditioning
//@		e.getAirConditioning().setDesiredTemp(desiredTemp);
		//#endif
		//#if WindowOpener
//@		e.getWindow().setDesiredTempIn(desiredTemp);
		//#endif
	}
	
	@POST
	@Timed
	@Path("rain")
	@Produces(MediaType.APPLICATION_JSON)
	public void rain(String status) {
		e.onSetRain(Boolean.valueOf(status));
	}
	
	@POST
	@Timed
	@Path("sun")
	@Produces(MediaType.APPLICATION_JSON)
	public void sun(Integer sun) {
		/*//#if Sun
		e.setSun(sun);
		//#endif
		//#if RollerShutter
		e.getShutter().setSun(sun);
		//#endif*/
	}
}
