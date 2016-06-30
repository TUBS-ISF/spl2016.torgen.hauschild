public aspect AirConditioningF {
	public de.torgen.smarthome.SmartHomeState.AirConditioning SmartHomeState.airConditioning;
	public static class de.torgen.smarthome.SmartHomeState.AirConditioning{
		public Integer measuredTemp;
		public Integer desiredTemp,coolingPercentage = 0;
 
		public int getDesiredTemp()  {
			return desiredTemp;
		}

		public void setDesiredTemp(Integer desiredTemp) {
			this.desiredTemp = desiredTemp;
			calculateCooling(); 
		}

		public Integer getMeasuredTemp() {
			return measuredTemp;
		}

		public void setMeasuredTemp(Integer measuredTemp) {
			this.measuredTemp = measuredTemp;
			calculateCooling();
		}


		public Integer getCoolingPercentage() {
			return coolingPercentage;
		}
		
		private void calculateCooling(){
			if(desiredTemp != null){
				int diff = measuredTemp - desiredTemp;
				if(diff > 0){
					diff = diff*10;
					if(diff > 100){
						diff = 100;
					}
					coolingPercentage = diff;
				}
				else{
					coolingPercentage = 0;
				}
				return; 
			}
			coolingPercentage = desiredTemp;
		}
	}
	after(de.torgen.smarthome.SmartHomeState s): target(s) && call(void de.torgen.smarthome.SmartHomeState.buildFeatures()) {
		s.airConditioning = new SmartHomeState.AirConditioning();
		s.aktiveFeatures.add("airConditioning");
		System.out.println("airConditioning");
	}
	
	after(de.torgen.smarthome.SmartHomeState s, int value): target(s) && call(void de.torgen.smarthome.SmartHomeState.setDesiredTempInside(int)) && args(value) {
		System.out.println("setDesiredTempInside");
		s.airConditioning.setDesiredTemp(value);
	}
	
	after(de.torgen.smarthome.SmartHomeState s, int value): target(s) && call(void de.torgen.smarthome.SmartHomeState.setTempInside(int)) && args(value){
		System.out.println("setTempInside");
		s.airConditioning.setMeasuredTemp(value);
	}
	
	public de.torgen.smarthome.SmartHomeState.AirConditioning de.torgen.smarthome.SmartHomeState.getAirConditioning() {
		return this.airConditioning;
	}
}