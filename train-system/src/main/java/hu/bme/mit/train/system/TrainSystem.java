package hu.bme.mit.train.system;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;
import hu.bme.mit.train.interfaces.TrainEmergencyBreak;
//import java.lang.Thread;

public class TrainSystem {

	private TrainControllerImpl controllerimp = new TrainControllerImpl();
	private TrainController controller = controllerimp;
	private TrainUser user = new TrainUserImpl(controller);
	private TrainSensor sensor = new TrainSensorImpl(controller, user);
	private TrainEmergencyBreak emergencyBreak = controllerimp;

	public TrainController getController() {
		return controller;
	}

	public TrainSensor getSensor() {
		return sensor;
	}

	public TrainUser getUser() {
		return user;
	}

	public TrainEmergencyBreak getEmergencyBreak()
	{
		return emergencyBreak;
	}

	public void runTrain(long millisecinterval, long duration) throws InterruptedException
	{		
		for(long i=0;i<duration/millisecinterval;i++)
		controller.followSpeed();
		Thread.sleep(millisecinterval);
	}	

}
