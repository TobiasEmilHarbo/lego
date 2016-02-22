import lejos.nxt.*;

public class StopAtLine 
{
	public static void main(String [] args)
	throws Exception 
	{
		final int forward 	= 1;
		final int power 	= MotorPort.MAX_POWER;
		final int stop 		= MotorPort.STOP;

		final int dist 		= 40;
		final int interval 	= 500;

		UltrasonicSensor us = new UltrasonicSensor(SensorPort.S4);
		
		while (!Button.ESCAPE.isDown())
		{
			if(us.getDistance() <= dist)
			{
				MotorPort.B.controlMotor(stop, forward);
				MotorPort.C.controlMotor(stop, forward);
			}
			else
			{
				MotorPort.B.controlMotor(power, forward);
				MotorPort.C.controlMotor(power, forward);
			}

			Thread.sleep(interval);
		}
	}
}
