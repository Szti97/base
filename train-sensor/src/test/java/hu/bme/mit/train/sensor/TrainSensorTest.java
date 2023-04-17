package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.interfaces.TrainController;

import static org.mockito.Mockito.*;
//import hu.bme.mit

public class TrainSensorTest {

    private TrainUser mockUser;
    private TrainController mockController;
    private TrainSensorImpl sensor;

    @Before
    public void before() {
        mockUser = mock(TrainUser.class);
        mockController = mock(TrainController.class);
        sensor = new TrainSensorImpl(mockController, mockUser);
    }
    // 0 alá
    // 500 felé
    // relatív 150-nel megy és 40 a refseb.
    // 0-500 között, követi sebességet (gyorsul?)

    @Test
    public void OverrideSpeedLimit_lessthan0_AlarmState_True() {
        mockController.setSpeedLimit(-1);
        Assert.assertTrue(mockUser.getAlarmState());
    }

    @Test
    public void OverrideSpeedLimit_morethan500_AlarmState_True() {

    }
}
