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
	}
	
	@POST
	@Timed
	@Path("motionOut")
	@Produces(MediaType.APPLICATION_JSON)
	public void motionOutdoorDetected() {
		e.onMotionOutside();
	}
	
	@POST
	@Timed
	@Path("tempIn")
	@Produces(MediaType.APPLICATION_JSON)
	public void tmpInMeasured(Integer measuredTemp) {
		e.setTempInside(measuredTemp);
	}
	
	@POST
	@Timed
	@Path("tempOut")
	@Produces(MediaType.APPLICATION_JSON)
	public void tmpOutMeasured(Integer measuredTemp) {
		e.setTempOutside(measuredTemp);
	}
	
	@POST
	@Timed
	@Path("desiredTempIn")
	@Produces(MediaType.APPLICATION_JSON)
	public void desiredTempInChanged(Integer desiredTemp) {
		e.setDesiredTempInside(desiredTemp);
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
		e.onSetSun(sun);
	}
}
