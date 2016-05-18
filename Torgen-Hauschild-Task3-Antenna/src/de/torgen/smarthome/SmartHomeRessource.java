package de.torgen.smarthome;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.annotation.JsonProperty;

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
		System.out.println("getSnart");
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
		//#if LightOutside
//@		e.getLightIndoor().onMotionDetected();
		//#endif
	}
	
	@POST
	@Timed
	@Path("motionOut")
	@Produces(MediaType.APPLICATION_JSON)
	public void motionOutdoorDetected() {
		//#if LightOutside
//@		e.getLightOutdoor().onMotionDetected();
		//#endif
	}
	
	@POST
	@Timed
	@Path("tempIn")
	@Produces(MediaType.APPLICATION_JSON)
	public void tmpInMeasured(Integer measuredTemp) {
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
		e.getWindow().setTempIn(measuredTemp);
		//#endif
	}
	
	@POST
	@Timed
	@Path("tempOut")
	@Produces(MediaType.APPLICATION_JSON)
	public void tmpOutMeasured(Integer measuredTemp) {
		//#if TemperatureOutside
//@		e.setTempOut(measuredTemp);
		//#endif
		//#if WindowOpener
		e.getWindow().setTempOut(measuredTemp);
		//#endif
	}
	
	@POST
	@Timed
	@Path("desiredTempIn")
	@Produces(MediaType.APPLICATION_JSON)
	public void desiredTempInChanged(Integer desiredTemp) {
		//#if Heater
//@		e.getHeating().setDesiredTemp(desiredTemp);
		//#endif
		//#if AirConditioning
//@		e.getAirConditioning().setDesiredTemp(desiredTemp);
		//#endif
		//#if WindowOpener
		e.getWindow().setDesiredTempIn(desiredTemp);
		//#endif
	}
	
	@POST
	@Timed
	@Path("rain")
	@Produces(MediaType.APPLICATION_JSON)
	public void rain(String status) {
		//#if Rain
		e.setRain(Boolean.valueOf(status));
		//#endif
		//#if WindowOpener
		e.getWindow().setRain(e.getRain());
		//#endif
	}
	
	@POST
	@Timed
	@Path("sun")
	@Produces(MediaType.APPLICATION_JSON)
	public void sun(Integer sun) {
		//#if Sun
//@		e.setSun(sun);
		//#endif
		//#if RollerShutter
//@		e.getShutter().setSun(sun);
		//#endif
	}
}
