public abstract class Insect {
    private Tile t;
    private int hp;

    public Insect(Tile t, int hp) {
        this.t = t;
        this.hp = hp;
    }

    public final Tile getPosition() {
        return t;
    }

    public final int getHealth() {
        return hp;
    }

    public void setPosition(Tile t) {
        this.t = t;
    }

}
