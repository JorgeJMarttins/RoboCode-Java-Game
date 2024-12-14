[Meu Vídeo]("C:\Users\jorge\Videos\Captures\robot battle.mp4")
---
# English :us:
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



# Português :brazil:
# **Robô McClane3 Robocode**

O robô **McClane3** é uma IA avançada programada para o jogo *Robocode*, um ambiente de programação competitiva onde robôs batalham entre si. Este robô foi projetado para implementar uma estratégia dinâmica de combate, realizando varredura contínua de radar, ajustando seu sistema de mira com base nas posições dos inimigos e empregando táticas de evasão para sobreviver e causar dano.

## **Características**

- **Varredura Contínua de Radar**: O robô realiza uma varredura contínua do ambiente para detectar inimigos próximos.
- **Sistema de Mira**: O robô ajusta automaticamente seu radar e sua arma para travar e disparar nos inimigos.
- **Evasão Adaptativa**: O robô altera seu comportamento de movimento com base no nível de energia e nas ameaças externas, utilizando manobras evasivas aleatórias quando necessário.
- **Táticas de Fuga**: Se for atingido por uma bala, o robô avalia seu nível de energia e, dependendo disso, escapa ou realiza manobras imprevisíveis para evitar ser atingido novamente.
- **Evitação de Colisão**: O robô evita ficar preso nas paredes, executando movimentos aleatórios quando uma colisão ocorre.

## **Detalhes da Implementação**

### 1. **Loop de Execução Principal** (`run`)

O núcleo do robô é o método `run`. Este método define o comportamento do robô em um loop:

- **Ajustes de Radar e Arma**: O radar e a arma do robô são ajustados continuamente para manter o bloqueio nos inimigos.
- **Loop Infinito para Varredura**: O robô gira seu radar 360 graus continuamente, garantindo que sempre tenha informações atualizadas sobre as posições dos inimigos. O método `execute()` garante que o robô processe suas ações de forma contínua.

### 2. **Detecção de Inimigos e Combate** (`onScannedRobot`)

Quando o robô detecta um inimigo usando seu radar, o método `onScannedRobot` é chamado. Este método contém as seguintes ações:

- **Alinhamento do Radar**: O radar é ajustado para seguir a posição do inimigo detectado.
- **Alinhamento da Arma**: A arma do robô é girada para mirar diretamente no inimigo.
- **Potência de Disparo**: O robô calcula a potência do disparo com base na distância até o inimigo. A potência de disparo é maior quando o inimigo está mais próximo, com três níveis de potência:
  - **Distância < 200**: Alta potência (3)
  - **200 <= Distância < 400**: Potência média (2)
  - **Distância >= 400**: Baixa potência (1)
- **Movimento**: O robô realiza um movimento evasivo. Ele gira aleatoriamente para um ângulo entre 90 e -90 graus, e então se move para frente com uma distância aleatória para evitar ser um alvo fácil.

### 3. **Resposta ao Impacto de Bala** (`onHitByBullet`)

Quando o robô é atingido por uma bala, o método `onHitByBullet` é acionado. O robô ajusta seu comportamento dependendo do seu nível de energia atual:

- **Baixa Energia (< 50)**: O robô prioriza a sobrevivência e realiza uma manobra de fuga, girando para longe do impacto da bala e se movendo para frente.
- **Alta Energia (> 50)**: O robô realiza padrões de movimento aleatórios para dificultar que o inimigo preveja sua próxima posição e mire com precisão.

### 4. **Resposta à Colisão com a Parede** (`onHitWall`)

Se o robô colidir com uma parede, o método `onHitWall` é acionado. Este método impede que o robô fique preso executando uma manobra que gira o robô e o move para trás para criar espaço.

### 5. **Ajustes no Radar, Arma e Movimento**

Ao longo do comportamento do robô, vários métodos controlam seus componentes físicos:

- **Ajustes no Radar**: O radar é constantemente girado para seguir inimigos ou para continuar a varredura do ambiente. O robô ajusta a rotação do radar com base no ângulo relativo entre a direção do robô e o ângulo do inimigo.
- **Ajustes na Arma**: A arma do robô é ajustada para alinhar com a posição do alvo, garantindo que o robô possa disparar com precisão.
- **Movimento**: O movimento do robô inclui manobras evasivas baseadas em ameaças detectadas, direções aleatórias e respostas a colisões com a parede.

## **Fluxo de Comportamento do Robô**

1. **Varredura**: O robô está constantemente escaneando em busca de inimigos.
2. **Combate**: Ao detectar um inimigo:
   - O radar e a arma são alinhados.
   - O robô dispara com base na distância até o inimigo.
   - O robô se move evasivamente com base na posição do inimigo detectado.
3. **Resposta ao Dano**: Se o robô for atingido por uma bala, ele:
   - Escapa ou realiza movimentos aleatórios dependendo do seu nível de energia.
4. **Colisão com a Parede**: Se o robô colidir com a parede, ele:
   - Muda de direção e se move para trás para evitar ficar preso.

## **Uso**

Para executar este robô:

1. Baixe e configure o ambiente **Robocode** a partir do [site oficial do Robocode](http://robocode.sourceforge.net/).
2. Crie um novo projeto de robô e nomeie-o como `McClane3`.
3. Copie o código fornecido para a classe do seu robô.
4. Compile e execute o robô na arena do Robocode contra outros robôs.

## **Conclusão**

O robô **McClane3** é um bot altamente dinâmico e resiliente no Robocode. Sua combinação de mira adaptativa, manobras evasivas inteligentes e estratégias de fuga o tornam um oponente formidável na arena. Ao ajustar seu comportamento com base na detecção de inimigos e nos níveis de energia, ele garante que continue sendo um adversário desafiador no combate.
