package de.torgen.smarthome;

import de.torgen.smarthome.Light.State;

public interface Light {
	enum State{ON,OFF};
	public void setState(State state);
	public State getState();
	public void onMotionDetected();
}
