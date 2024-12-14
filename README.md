[Robo em batalha](https://youtu.be/KRQ-KQ0IOOg)
---

# **McClane3 Robocode Robot**

The **McClane3** robot is an advanced AI programmed for the *Robocode* game, a competitive programming environment where robots battle against each other. This robot is designed to implement a dynamic combat strategy by performing continuous radar scanning, adjusting its targeting system based on enemy positions, and employing evasion tactics to survive and deal damage. 

## **Features**

- **Constant Radar Scanning**: The robot continuously scans the environment to detect nearby enemies.
- **Targeting System**: It automatically adjusts its radar and gun to lock onto and fire at enemies.
- **Adaptive Evasion**: The robot changes its movement behavior based on its energy level and external threats, using random evasive maneuvers when necessary.
- **Escape Tactics**: If it gets hit by a bullet, the robot evaluates its energy level and either escapes or performs unpredictable maneuvers to avoid being hit again.
- **Collision Avoidance**: The robot avoids getting stuck on walls by executing random movements when a collision occurs.

## **Implementation Details**

### 1. **Main Execution Loop** (`run` method)

The core of the robot is the `run` method. This method sets the robot's behavior in a loop:

- **Radar and Gun Adjustments**: The robot's radar and gun are constantly adjusted to stay locked on enemies.
- **Infinite Loop for Scanning**: The robot rotates its radar 360 degrees continuously, ensuring that it always has up-to-date information on enemy positions. The `execute()` method ensures that the robot processes its actions continuously.

### 2. **Enemy Detection and Combat** (`onScannedRobot` method)

When the robot detects an enemy using its radar, the `onScannedRobot` method is called. This method contains the following actions:

- **Radar Alignment**: The radar is adjusted to follow the detected enemy's position.
- **Gun Alignment**: The robot’s gun is rotated to aim directly at the enemy.
- **Shooting Power**: The robot calculates the firing power based on the distance to the enemy. The firing power is higher when the enemy is closer, with three levels of shot power:
  - **Distance < 200**: High power (3)
  - **200 <= Distance < 400**: Medium power (2)
  - **Distance >= 400**: Low power (1)
- **Movement**: The robot performs an evasive move. It turns randomly to an angle between 90 and -90 degrees, then moves forward with a random distance to avoid being an easy target.

### 3. **Bullet Impact Response** (`onHitByBullet` method)

When the robot is hit by a bullet, the `onHitByBullet` method is triggered. The robot adjusts its behavior depending on its current energy level:

- **Low Energy (< 50)**: The robot prioritizes survival and performs an escape maneuver by turning away from the bullet's impact and moving forward.
- **High Energy (> 50)**: The robot performs random movement patterns to make it harder for the enemy to predict its next position and aim accurately.

### 4. **Wall Collision Response** (`onHitWall` method)

If the robot collides with a wall, the `onHitWall` method is triggered. This method prevents the robot from getting stuck by executing a maneuver that turns the robot and moves it backward to create space.

### 5. **Radar, Gun, and Movement Adjustments**

Throughout the robot's behavior, several methods control its physical components:

- **Radar Adjustments**: The radar is constantly rotated to follow enemies or to keep scanning the environment. The robot adjusts the radar's rotation based on the relative angle between the robot’s heading and the enemy's bearing.
- **Gun Adjustments**: The robot's gun is adjusted to align with the target's position, ensuring the robot can fire accurately.
- **Movement**: The robot's movement includes evasive maneuvers based on detected threats, random directions, and wall collision responses.

## **Robot Behavior Flow**

1. **Scanning**: The robot constantly scans for enemies.
2. **Combat**: Upon detecting an enemy:
   - The radar and gun are aligned.
   - The robot fires based on the distance to the enemy.
   - The robot moves evasively based on the detected enemy's position.
3. **Damage Response**: If the robot is hit by a bullet, it:
   - Escapes or performs random movements depending on its energy level.
4. **Wall Collision**: If the robot hits a wall, it:
   - Changes direction and moves backward to avoid getting stuck.

## **Usage**

To run this robot:

1. Download and set up the **Robocode** environment from [Robocode official website](http://robocode.sourceforge.net/).
2. Create a new robot project and name it `McClane3`.
3. Copy the provided code into your robot class.
4. Compile and run the robot in the Robocode arena against other robots.

## **Conclusion**

The **McClane3** robot is a highly dynamic and resilient bot in Robocode. Its combination of adaptive targeting, intelligent evasive maneuvers, and escape strategies make it a formidable opponent in the arena. By adjusting its behavior based on enemy detection and energy levels, it ensures that it remains a challenging adversary in combat.

---
