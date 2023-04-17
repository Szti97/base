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
        // when(mockController.setSpeedLimit(-1));

        sensor.overrideSpeedLimit(-1);

        verify(mockUser, times(1)).setAlarmState(true);
    }

    @Test
    public void OverrideSpeedLimit_morethan500_AlarmState_True() {
        sensor.overrideSpeedLimit(501);

        verify(mockUser, times(1)).setAlarmState(true);
    }

    @Test
    public void OverrideSpeedLimit_lessthan50percent_AlarmState_True() {
        when(mockController.getReferenceSpeed()).thenReturn(150);
        sensor.overrideSpeedLimit(40);

        verify(mockUser, times(1)).setAlarmState(true);
    }

    @Test
    public void OverrideSpeedLimit_modifylimit_AlarmState_False() {
        when(mockController.getReferenceSpeed()).thenReturn(150);
        sensor.overrideSpeedLimit(170);
        verify(mockUser, times(0)).setAlarmState(true);
    }
}
