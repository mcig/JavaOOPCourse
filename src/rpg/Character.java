package rpg;

public class Character {
    private String nickname;
    private int hp;
    private int ad;

    //constructor
    public Character(String nickname) {
        this.nickname = nickname;
        this.hp = 100;
        this.ad = 10;
    }
    //getter and setters
    public String getNickname() {
        return nickname;
    }

    public int getHp() {
        return hp;
    }

    public int getAd() {
        return ad;
    }

    //custom methods
    void getDamage(int thisManyDamage) {
        int newHp = this.hp - thisManyDamage;
        this.hp = newHp <= 0 ? 0 : newHp;
    }

    double makeDamage() {
        System.out.println(this.ad);
        System.out.println(Math.random());

        return 10 * this.ad * Math.random();
    }

    void fillHp() {
        this.hp = 100;
    }
}
