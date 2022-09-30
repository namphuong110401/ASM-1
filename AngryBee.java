public class AngryBee extends HoneyBee{
    private int attackDamage;

    public AngryBee(Tile t, int attackDamage) {
        super(t, 10, 1);
        this.attackDamage = attackDamage;
    }
}
