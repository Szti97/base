package hu.bme.mit.train.tachograph;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

//pontos idő, joystick, referencia

public class TrainTachographf {

    /*class Data
    {
        private long time;
        private int joystickPosition;
        private int referenceSpeed;

        public Data(long time, int joystickPosition, int referenceSpeed)
        {
            this.time=time;
            this.joystickPosition=joystickPosition;
            this.referenceSpeed=referenceSpeed;
        }

    }*/
    private TrainController controller;
    private TrainUser user;
    Table<long, int, int> tachoGraphfTable;

    public TrainTachographf(TrainController controller, TrainUser user)
    {
        this.controller=controller;
        this.user=user;
        tachoGraphfTable = HashBasedTable.create();
    }

    public void logdata()
    {
        tachoGraphfTable.put(System.currentTimeMillis(), user.getJoystickPosition(), controller.getReferenceSpeed());
    }

    public Table<long, int, int> getTable()
    {
        return tachoGraphfTable;
    }
}