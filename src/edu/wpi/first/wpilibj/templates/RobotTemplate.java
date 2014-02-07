/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
    Joystick joystick;
    Shooter shooter;
    boolean shootonce;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        joystick = new Joystick(Wiring.joystick);
        shooter = new Shooter();
    }

    /** 
     * This function is called periodically during autonomous
     */
    public void autonomousInit(){
        
    }
    public void autonomousPeriodic() {
        shooter.Cock();
        //if (SmartDashboard.getBoolean("HotGoal")) shooter.shoot();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopInit(){
        shootonce = true;
    }
    public void teleopPeriodic() {
        shooter.Cock();
        if (joystick.getRawButton(1) && shootonce) 
        {
            shooter.shoot();
            shootonce = false;
        }
        if (shooter.unCocked.get() >= 1)
        {
            shootonce = true;
            shooter.unCocked.reset();
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
