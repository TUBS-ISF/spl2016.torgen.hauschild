package de.torgen.smarthome;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;

import de.torgen.smarthome.Light.State;
import properties.PropertyManager;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class SmartHomeSimulation extends Application<SmartHomeConfiguration>{
	private static String HTML_PATH = "SmartHome.html";
	private Light lightIndoor, lightOutdoor;
	private Heating heating;
	private AirConditioning airConditioning;
	private Shutter shutter;
	private Window window;
	private List<String> aktiveFeatures;
	
	
	public SmartHomeSimulation() {
		super();
		this.lightIndoor = new Light(Light.State.OFF);
		this.lightOutdoor = new Light(Light.State.OFF);
		this.heating = new Heating();
		this.airConditioning = new AirConditioning();
		this.shutter = new Shutter();
		this.window = new Window();
		this.aktiveFeatures = new ArrayList<String>();
		if(PropertyManager.getProperty("Rain")){
			this.aktiveFeatures.add("rain");
		}
		if(PropertyManager.getProperty("Sun")){
			this.aktiveFeatures.add("sun");
		}
		if(PropertyManager.getProperty("TemperaturInside")){
			this.aktiveFeatures.add("tempIn");
		}
		if(PropertyManager.getProperty("TemperatureOutside")){
			this.aktiveFeatures.add("tempOut");
		}
		if(PropertyManager.getProperty("MotionInside")){
			this.aktiveFeatures.add("motionIn");
		}
		if(PropertyManager.getProperty("MotionOutside")){
			this.aktiveFeatures.add("motionOut");
		}
		if(PropertyManager.getProperty("LightInside")){
			this.aktiveFeatures.add("lightIn");
		}
		if(PropertyManager.getProperty("LightOutside")){
			this.aktiveFeatures.add("lightOut");
		}
		if(PropertyManager.getProperty("RollerShutter")){
			this.aktiveFeatures.add("shutter");
		}
		if(PropertyManager.getProperty("WindowOpener")){
			this.aktiveFeatures.add("window");
		}
		if(PropertyManager.getProperty("Heater")){
			this.aktiveFeatures.add("heating");
		}
		if(PropertyManager.getProperty("AirConditioning")){
			this.aktiveFeatures.add("airConditioning");
		}
	}

	public static void main(String[] args) throws Exception {
		SmartHomeSimulation eSim = new SmartHomeSimulation();
		eSim.run(args[0]);
		while(true){
			//clearScreen();
			//printElevatorPosition(elevator);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run(SmartHomeConfiguration smartHomeConfiguration, Environment environment)
			throws Exception {
		// Enable CORS headers
	    final FilterRegistration.Dynamic cors =
	        environment.servlets().addFilter("CORS", CrossOriginFilter.class);

	    // Configure CORS parameters
	    cors.setInitParameter("allowedOrigins", "*");
	    cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
	    cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

	    // Add URL mapping
	    cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
		
	    final SmartHomeRessource resource = new SmartHomeRessource(new SmartHomeState(aktiveFeatures, lightIndoor, lightOutdoor, heating, 0, 0, airConditioning, false, 0, shutter, window));
	        environment.jersey().register(resource);
		Thread openHtml = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File htmlFile = new File(HTML_PATH);
		        try {
					Desktop.getDesktop().browse(htmlFile.toURI());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		openHtml.start();
	}

}
