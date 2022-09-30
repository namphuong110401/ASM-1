public class TankyBee extends HoneyBee{
    private int attackDamge;
    private int beeAmor;

    public TankyBee(Tile t, int attackDamge, int beeAmor) {
        super(t, 30, 3);
        this.attackDamge = attackDamge;
        this.beeAmor = beeAmor;
    }
}
