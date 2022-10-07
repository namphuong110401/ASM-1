public class BusyBee extends HoneyBee{

    public BusyBee(Tile t) {
        super(t,5,2);
    }

    @Override
    public boolean takeAction() {
        this.getPosition().collectFood();
        this.getPosition().storeFood(2);
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
