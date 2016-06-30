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
	
	
	public SmartHomeSimulation() {
		super();
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
		
	    final SmartHomeRessource resource = new SmartHomeRessource(new SmartHomeState());
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
