

// Player class to represent each player in the arena
class Player {
    private int health;
    private int strength;
    private int attack;

    // Constructor
    public Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    // Getter methodsgit 
    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAttack() {
        return attack;
    }

    // Method to perform an attack on another player
    public void attack(Player opponent) {
        int attackRoll = rollDice();
        int defenseRoll = opponent.rollDice();

        int damage = attack * attackRoll;
        int defense = opponent.getStrength() * defenseRoll;

        int damageDealt = Math.max(0, damage - defense);
        opponent.health -= damageDealt;

        System.out.println("Attacker rolled a " + attackRoll + " for an attack of " + damage);
        System.out.println("Defender rolled a " + defenseRoll + " for a defense of " + defense);
        System.out.println("Damage dealt: " + damageDealt);
        System.out.println("Defender's health: " + opponent.health);
    }

    // Method to roll a dice
    private int rollDice() {
        return (int) (Math.random() * 6) + 1; // assuming a 6-sided dice
    }
}

// MagicalArena class to manage the game
class MagicalArena {
    private Player playerA;
    private Player playerB;

    // Constructor
    public MagicalArena(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    // Method to start the game
    public void startGame() {
        Player attacker = playerA.getHealth() < playerB.getHealth() ? playerA : playerB;
        Player defender = attacker == playerA ? playerB : playerA;

        while (playerA.getHealth() > 0 && playerB.getHealth() > 0) {
            attacker.attack(defender);

            // Swap attacker and defender
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        System.out.println("Game over!");
        if (playerA.getHealth() <= 0) {
            System.out.println("Player B wins!");
        } else {
            System.out.println("Player A wins!");
        }
    }
}

// Main class to run the program
public class Main {
    public static void main(String[] args) {
        // Create players
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);

        // Create the arena and start the game
        MagicalArena arena = new MagicalArena(playerA, playerB);
        arena.startGame();
    }
}


// higit 