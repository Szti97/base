package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainEmergencyBreak;

public class TrainControllerImpl implements TrainController, TrainEmergencyBreak {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;

	@Override
	public void followSpeed() {
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
			if (referenceSpeed + step > 0) {
				referenceSpeed += step;
			} else {
				referenceSpeed = 0;
			}
		}

		enforceSpeedLimit();
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();

	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;
	}

	@Override
	public void emergencyBreak() {
		referenceSpeed = 0;
	}

	@Override
	public void setReferenceSpeed(int newspeed) {
		if (newspeed < 0)
			this.referenceSpeed = 0;
		else if (newspeed > speedLimit)
			this.referenceSpeed = speedLimit;
		else
			this.referenceSpeed = newspeed;
	}

}
