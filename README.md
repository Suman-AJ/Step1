# Magical Arena Game

This repository contains a simple Java program for a turn-based battle game between two players.

## Classes

### Player Class

Represents each player in the arena.

- **Attributes:**
  
![Reference Image](/Images/Attributes.png)

  - `attack`: The attack power of the player.
  - `health`: The health of the player.
  - `strength`: The strength of the player.
  

- ## Getter Methods:
- These methods provide access to the private attributes of the class. They are known as getter methods.


  - `getHealth()`, `getStrength()`, `getAttack()`: Getter methods.

- ![Method Image](/Images/Getter%20Method.png)

  
- getHealth(): Returns the health of the player.
- getStrength(): Returns the strength of the player.
- getAttack(): Returns the attack value of the player.
  

- ## Attack Method:
  
- This method allows one player to perform an attack on another player.
- ![Attack Image](/Images/Attack.png)

- `attack(Player opponent)`: Method to perform an attack on another player.
  
  - **1.Rolling the Dice:**

        The attacker rolls a dice to determine the attack roll (attackRoll).
        The opponent rolls a dice to determine the defense roll (defenseRoll).

  - **2.Calculating Damage:**
  
        damage is calculated by multiplying the player's attack value by the attack roll.
        defense is calculated by multiplying the opponent's strength value by the defense roll.

  - **3.Determining Damage Dealt:**
  
        damageDealt is the actual damage inflicted on the opponent. It is calculated by subtracting the defense from the damage. The Math.max(0, damage - defense) ensures that the damage dealt cannot be negative (i.e., minimum damage is 0).

  - **4.Updating Opponent’s Health:**

        The opponent's health is reduced by the damageDealt.

  - **5.Output:**
  
        The method prints the results of the attack roll, defense roll, damage dealt, and the opponent’s remaining health.

- ## RollDice:

- This private method simulates rolling a six-sided dice.
  
- ![RollDice](/Images/RollDice.png)
  

  - `rollDice()`: Method to roll a 6-sided dice.

### MagicalArena Class

Manages the game between two players.

- **Attributes:**
  - `playerA`: First player.
  - `playerB`: Second player.

- **Start Game Method:**

- ![startGame](/Images/StartGame.png)
  - `startGame()`: Starts the game and manages turns until one player wins.
  
    - This method starts the game.
    - It first determines which player will be the initial attacker. The player with the lower health starts as the attacker.
    - The defender is set to the other player.
  
- **Game Loop:**

- ![GameLoop](/Images/GameLoop.png)

     - The game runs in a loop as long as both players have health greater than zero.
     - In each iteration of the loop, the attacker performs an attack on the defender using the attack method defined in the Player class.
     - After each attack, the roles of attacker and defender are swapped.

- **End Of Game:**
  
- ![EndGame](/Images/EndGame.png)

    - When the loop exits (i.e., when one of the players' health drops to zero or below), the game ends.
    - A message "Game over!" is printed.
    - The method checks the health of both players to determine the winner and prints the appropriate message indicating which player won.

- ### Summary:
- In summary, the MagicalArena class:

    -  Initializes with two Player objects.
    -  Determines which player attacks first based on their health.
    -  Runs a loop where the attacker attacks the defender until one of the players' health reaches zero.
    -  Swaps roles of attacker and defender after each attack.
    -  Declares the winner once the game ends.


### Main Class

Contains the main method to run the game.

- **Creating Players:**

- ![creatingPalyer](/Images/Creating.png)

- Two Player objects, playerA and playerB, are created.
    - playerA has:
        - Health: 50
        - Strength: 5
        - Attack: 10
    - playerB has:
        - Health: 100
        - Strength: 10
        - Attack: 5

- **Creating and Starting the Arena:**

- ![creatingStarting](/Images/CreatingSorting.png) 

    - A MagicalArena object named arena is created, passing playerA and playerB as parameters to its constructor.
    - The startGame method of the MagicalArena object arena is called to begin the game. 

<!-- ## How to Run

1. Clone the repository.
2. Compile the Java files.
3. Run the `Main` class.` -->

## How to Run

1. Make sure you have Java installed on your system.
2. Clone this repository.
3. Navigate to the `src/main/java` directory.
4. Compile the Java files using the following command:

   ```bash
   javac Main.java game/MagicalArena.java game/Player.java

## Output 
- ![Output](/Images/Output.png)

- ## Combat Mechanics:
    
    - **1.Attack Calculation:**

        - The attacker's attack value is multiplied by the  dice roll result to determine the total   attack damage.
          
          Total Attack Damage =Attack x  Dice Roll
          
      
    - **2.Defense Calculation:**

         - The defender's strength value is multiplied by the dice roll result to determine the total defense value.
      
         -  Total Defense Value=Strength×Dice Roll
         
    - **3.Damage Calculation:**

        -  The actual damage dealt to the defender is the    difference between the total attack damage  and the total defense value. If this value is negative, the damage dealt is zero.
         
         - Damage Dealt=max(0,Total Attack Damage−Total Defense Value)
          
    - **4.Health Update:**

       - The defender's health is reduced by the damage dealt.

- ## Conclusion:
     - The game ends when Player B's health drops to -10.
     - Winner: Player A wins the game.
