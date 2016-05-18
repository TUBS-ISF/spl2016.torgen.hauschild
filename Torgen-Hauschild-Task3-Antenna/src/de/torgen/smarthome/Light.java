package de.torgen.smarthome;

public class Light {
	private final int MOTION_TIMER = 20; // timer in milli seconds
	
	enum State{ON,OFF};
	private State state;
	private Thread thread;
	private int timer;
	
	public Light(final State state) {
		super();
		this.state = state;
		this.timer = 0;
		this.thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					if(timer == 0){
						Light.this.state = State.OFF;
					}
					else{
						Light.this.state = State.ON;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(timer>0){
						timer--;
					}
				}
			}
		});
		this.thread.start();
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public void onMotionDetected(){
		timer = MOTION_TIMER;
	}
}
