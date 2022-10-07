public abstract class HoneyBee extends Insect {
    private int beeCost;

    public HoneyBee(Tile t, int hp, int beeCost) {
        super(t, hp);
        this.beeCost = beeCost;
    }

    public int getCost() {
        return beeCost;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        } else {
            HoneyBee honeyBee = (HoneyBee) obj;
            return this.getCost() == honeyBee.getCost();
        }
    }
}


