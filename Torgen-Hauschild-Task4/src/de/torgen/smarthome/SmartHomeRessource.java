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
		e.getLightIndoor().onMotionDetected();
	}
	
	@POST
	@Timed
	@Path("motionOut")
	@Produces(MediaType.APPLICATION_JSON)
	public void motionOutdoorDetected() {
		e.getLightOutdoor().onMotionDetected();
	}
	
	@POST
	@Timed
	@Path("tempIn")
	@Produces(MediaType.APPLICATION_JSON)
	public void tmpInMeasured(Integer measuredTemp) {
		e.getHeating().setMeasuredTemp(measuredTemp);
		e.setTempIn(measuredTemp);
		e.getAirConditioning().setMeasuredTemp(measuredTemp);
		e.getWindow().setTempIn(measuredTemp);
	}
	
	@POST
	@Timed
	@Path("tempOut")
	@Produces(MediaType.APPLICATION_JSON)
	public void tmpOutMeasured(Integer measuredTemp) {
		e.setTempOut(measuredTemp);
		e.getWindow().setTempOut(measuredTemp);
	}
	
	@POST
	@Timed
	@Path("desiredTempIn")
	@Produces(MediaType.APPLICATION_JSON)
	public void desiredTempInChanged(Integer desiredTemp) {
		e.getHeating().setDesiredTemp(desiredTemp);
		e.getAirConditioning().setDesiredTemp(desiredTemp);
		e.getWindow().setDesiredTempIn(desiredTemp);
	}
	
	@POST
	@Timed
	@Path("rain")
	@Produces(MediaType.APPLICATION_JSON)
	public void rain(String status) {
		e.setRain(Boolean.valueOf(status));
		e.getWindow().setRain(e.getRain());
	}
	
	@POST
	@Timed
	@Path("sun")
	@Produces(MediaType.APPLICATION_JSON)
	public void sun(Integer sun) {
		e.setSun(sun);
		e.getShutter().setSun(sun);
	}
}
