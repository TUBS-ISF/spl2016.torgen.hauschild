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

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class SmartHomeSimulation extends Application<SmartHomeConfiguration>{
	private static String HTML_PATH = "SmartHome.html";
	private List<String> aktiveFeatures;
	
	
	public SmartHomeSimulation() {
		super();
		this.aktiveFeatures = new ArrayList<String>();
		//#if Rain
		this.aktiveFeatures.add("rain");
		//#endif
		//#if Sun
		this.aktiveFeatures.add("sun");
		//#endif
		//#if TemperaturInside
		this.aktiveFeatures.add("tempIn");
		//#endif
		//#if TemperatureOutside
		this.aktiveFeatures.add("tempOut");
		//#endif
		//#if MotionInside
		this.aktiveFeatures.add("motionIn");
		//#endif
		//#if MotionOutside
		this.aktiveFeatures.add("motionOut");
		//#endif
		//#if LightInsideFast
//@		this.aktiveFeatures.add("lightIn");
		//#endif
		//#if LightInsideSlow
		this.aktiveFeatures.add("lightIn");
		//#endif
		//#if LightOutsideFast
		this.aktiveFeatures.add("lightOut");
		//#endif
		//#if LightOutsideSlow
//@		this.aktiveFeatures.add("lightOut");
		//#endif
		//#if RollerShutter
		this.aktiveFeatures.add("shutter");
		//#endif
		//#if WindowOpener
		this.aktiveFeatures.add("window");
		//#endif
		//#if Heater
		this.aktiveFeatures.add("heating");
		//#endif
		//#if AirConditioning
		this.aktiveFeatures.add("airConditioning");
		//#endif
	}

	public static void main(String[] args) throws Exception {
		SmartHomeSimulation eSim = new SmartHomeSimulation();
		eSim.run(args[0]);
		while(true){
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
		
	    final SmartHomeRessource resource = new SmartHomeRessource(new SmartHomeState(
	    		//#if LightInsideFast
//@	    		new LightTimerClockFast(LightTimerClockFast.State.OFF)
	    		//#else
	    		//#if LightInsideSlow
	    		new LightTimerClockSlow(LightTimerClockSlow.State.OFF)
	    		//#else
//@	    		null
	    		//#endif
	    		//#endif
	    		//#if LightOutsideFast
	    		,new LightTimerClockFast(LightTimerClockFast.State.OFF)
	    		//#else
	    		//#if LightOutsideSlow
//@	    		,new LightTimerClockSlow(LightTimerClockSlow.State.OFF)
	    		//#else
//@	    		,null
	    		//#endif
	    		//#endif
	    		//#if Heater
	    		,new HeatingSimple()
	    		//#else
//@	    		,null
	    		//#endif
	    		//#if TemperaturInside
	    		,0
	    		//#else
//@	    		,null
	    		//#endif
	    		//#if TemperatureOutside
	    		,0
	    		//#else
//@	    		,null
	    		//#endif
	    		//#if AirConditioning
	    		,new AirConditioningSimple()
	    		//#else
//@	    		,null
	    		//#endif
	    		//#if Rain
	    		,false
	    		//#else
//@	    		,null
	    		//#endif
	    		//#if Sun
	    		,0
	    		//#else
//@	    		,null
	    		//#endif
	    		//#if RollerShutter
	    		,new ShutterSimple()
	    		//#else
//@	    		,null
	    		//#endif
	    		//#if WindowOpener
	    		,new WindowSimple()
	    		//#else
//@	    		,null
	    		//#endif
	    		,aktiveFeatures
	    		));
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
