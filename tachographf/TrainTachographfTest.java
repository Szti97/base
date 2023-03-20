package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.interfaces.TrainController;
import hu.bme.mit.interfaces.TrainSensor;
import hu.bme.mit.interfaces.TrainUser;
import hu.bme.mit.system.TrainSystem;

public class TrainTachographfTest {

    TrainController controller;
    TrainUser user;
    TrainTachographf tachograph;

    @Before
    public void before(){
        TrainSystem system = new TrainSystem();
        controller = system.getController();
        user = system.getUser();
        TrainSensor sensor = system.getSensor();
        sensor.overrideSpeedLimit(50);
        tachograph = new TrainTachographf(controller, user);
    }

    @Test
    public void LogData() {
        tachograph.logdata();
        Table<long, int, int> table = tachograph.getTable();
        Assert.assertNotNull(table);
        int logcount = table.get(user.getJoystickPosition());
        Assert.assertEquals(1, logcount);
    }

}