package org.usfirst.frc.team3245.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 *
 *This is the best repository don't @ me
 */
public class Robot extends IterativeRobot {
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();
	
		Accelerometer accel = new BuiltInAccelerometer();
			double xVal,yVal,maxY,zVal,maxZ;
			
			//Two controllers, one driver one operator
		Joystick drivercontrol = new Joystick(0);
		Joystick operatorcontrol = new Joystick(1);
			//Two Driving Motor Controls
		Talon rightdrive = new Talon (0);          //This is defining the PWMs because I'm special
		Talon leftdrive = new Talon (1);
		//With this template, you can define more motor commands
		
	double fastLeft = 1, fastRight = 1, slowLeft = .5, slowRight = .5,// topslowspeed = .6
			
	// Slow factor is the number you want the top speed to be divided by
			// if slow factor is 2, top speed is 50%
			//if slow factor is 3, top speed is 33%
	slowfactor = 2;
	
		

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		SmartDashboard.putData("Auto choices", chooser);
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		autoSelected = chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		switch (autoSelected) {
		case customAuto:
			// Put custom auto code here
			break;
		case defaultAuto:
		default:
			// Put default auto code here
			break;
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		// right side controls right, left side controls left on the controller
		//you can check this on driver station (ask Zahara if you don't know how)
		fastLeft = drivercontrol.getRawAxis(1);
		fastRight = drivercontrol.getRawAxis(3);

		//Fast buttons and slow bottons on controller
		if(drivercontrol.getRawButton(6)) {
			leftDrive.set(fastLeft *.3);
			rightDrive.set(fastRight *.3);
		}
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
}

