package rpg;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String plyrName, npcName;
        System.out.println("Hello Stranger, What is your name?");
        plyrName = scanner.nextLine();

        Player player1 = new Player(plyrName);
        System.out.println("Oh hi " + player1.getNickname() + " nice to meet you. I also see that you have a companion skeleton, what is its name?");

        npcName = scanner.nextLine();
        NPC npc1 = new NPC(npcName);
        System.out.println("Heheheh boiii lets hit " + npc1.getNickname());

        double dmg = player1.makeDamage();
        System.out.println("Your dmg is: " + dmg);

        npc1.getDamage((int)dmg);
        System.out.println("Big oof your skelly friend has " + npc1.getHp() + "hp now");
        System.out.println("Lets use one of your health potions yoink!");
        npc1.fillHp();
        System.out.println("Yeaaah now we are talking, how are you feeling " + npc1.getNickname() + "?");
        System.out.println("Bruh:"+npc1.getHp());

    }
}
