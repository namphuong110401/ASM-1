public abstract class HoneyBee extends Insect {
    private int beeCost;

    public HoneyBee(Tile t, int hp, int beeCost) {
        super(t, hp);
        this.beeCost = beeCost;
    }

    public int getBeeCost() {
        return beeCost;
    }

}
