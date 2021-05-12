package rpg;

public class Player extends Character{
    private int exp;
    private int lvl;

    public Player(String nickname) {
        super(nickname);
        this.exp = 0;
        this.lvl = 1;
    }

    void gainExp(int exp){
        this.lvl = (int) Math.log(exp) + 1;
    }


}
