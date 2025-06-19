import java.util.Random;
import java.util.Scanner;

class Player {
    String name;
    int hp = 100;
    int level = 1;
    int xp = 0;

    public void attack(Enemy enemy) {
        int damage = new Random().nextInt(15) + 5;
        System.out.println("💥 You strike the enemy for " + damage + " damage!");
        enemy.hp -= damage;
    }

    public void gainXP(int amount) {
        xp += amount;
        if (xp >= 100) {
            level++;
            hp = 100;
            xp -= 100;
            System.out.println("🔼 You leveled up! Now at level " + level);
        }
    }
}

class Enemy {
    int hp = 50;

    public void attack(Player player) {
        int damage = new Random().nextInt(10) + 3;
        System.out.println("👹 Enemy attacks you for " + damage + " damage!");
        player.hp -= damage;
    }
}

public class MiniRPG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player player = new Player();

        System.out.print("Enter your hero's name: ");
        player.name = sc.nextLine();

        System.out.println("⚔️ Welcome, " + player.name + "! Prepare to battle!");

        while (true) {
            Enemy enemy = new Enemy();
            System.out.println("\nA wild enemy appears!");

            while (enemy.hp > 0 && player.hp > 0) {
                System.out.println("\nYour HP: " + player.hp + " | Enemy HP: " + enemy.hp);
                System.out.println("Choose an action: [1] Attack  [2] Heal");

                int choice = sc.nextInt();

                if (choice == 1) {
                    player.attack(enemy);
                } else if (choice == 2) {
                    int heal = new Random().nextInt(10) + 5;
                    player.hp = Math.min(player.hp + heal, 100);
                    System.out.println("🧪 You heal " + heal + " HP!");
                }

                if (enemy.hp > 0) {
                    enemy.attack(player);
                }
            }

            if (player.hp <= 0) {
                System.out.println("\n💀 You were defeated. Game over!");
                break;
            } else {
                System.out.println("🏆 Enemy defeated!");
                player.gainXP(50);
            }

            System.out.print("\nContinue fighting? (y/n): ");
            if (!sc.next().equalsIgnoreCase("y")) break;
        }

        System.out.println("\nThanks for playing, " + player.name + "! Final Level: " + player.level);
    }
}
