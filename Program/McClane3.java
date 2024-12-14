package DieHard;

import robocode.*;
import static robocode.util.Utils.normalRelativeAngleDegrees;

/**
 * The McClane3 class is an advanced robot that implements a combat strategy
 * in the Robocode game. The robot performs constant scanning to detect enemies,
 * adjusts its gun and radar to target them, and adopts evasion and escape strategies when necessary.
 */
public class McClane3 extends AdvancedRobot {

    private boolean visibility = false;

    /**
     * Main execution method of the robot. This method performs constant scanning
     * of the environment to detect enemies and executes actions in a loop.
     */
    public void run() {
        setAdjustGunForRobotTurn(true);
        setAdjustRadarForGunTurn(true);
        setAdjustRadarForRobotTurn(true);

        // Starts an infinite loop for the robot to constantly scan the radar.
        while (true) {
            turnRadarRight(360); // Constantly scans the environment to detect enemies
            execute();
        }
    }

    /**
     * Method called when an enemy is detected by the radar.
     * Adjusts the gun and radar to follow the enemy, determines the shot power
     * based on the distance, and performs an evasive maneuver.
     *
     * @param e Event containing information about the detected robot.
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        visibility = true;

        // Adjusts the radar to follow the enemy
        double radarRotation = normalRelativeAngleDegrees(getHeading() + e.getBearing() - getRadarHeading());
        setTurnRadarRight(radarRotation);

        // Adjusts the gun to target the enemy
        double gunRotation = normalRelativeAngleDegrees(getHeading() + e.getBearing() - getGunHeading());
        setTurnGunRight(gunRotation);

        // Determines the shot power based on the distance
        double distance = e.getDistance();
        double shotPower = distance < 200 ? 3 : distance < 400 ? 2 : 1;
        fire(shotPower);

        // Moves the robot away from the enemy while shooting
        double escapeAngle = normalRelativeAngleDegrees(e.getBearing() + 90 - (Math.random() * 180));
        setTurnRight(escapeAngle);
        setAhead(100 + Math.random() * 50); // Evasive move with random distance
    }

    /**
     * Method called when the robot is hit by a bullet.
     * Performs an escape if the energy is low, or random movements
     * to make it harder to aim if the energy is higher.
     *
     * @param e Event containing information about the bullet impact.
     */
    public void onHitByBullet(HitByBulletEvent e) {
        if (getEnergy() < 50) {
            // Escape when energy is low
            setTurnRight(normalRelativeAngleDegrees(e.getBearing() + 90));
            setAhead(200);
        } else {
            // Random movements to make it harder to aim
            setTurnLeft(Math.random() * 100 + 90);
            setAhead(Math.random() * 150 + 50);
        }
        execute();
    }

    /**
     * Method called when the robot collides with a wall.
     * Performs a movement to avoid getting stuck.
     *
     * @param e Event containing information about the wall collision.
     */
    public void onHitWall(HitWallEvent e) {
        // Avoids getting stuck on a wall
        setTurnRight(90);
        setBack(100);
    }
}
