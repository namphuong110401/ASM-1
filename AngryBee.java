public class AngryBee extends HoneyBee{
    private int attackDamage;

    public AngryBee(Tile t, int attackDamage) {
        super(t, 10, 1);
        this.attackDamage = attackDamage;
    }

    @Override
    public boolean takeAction() {
        if (this.getPosition().towardTheHive() == null || this.getPosition().getBee() == null){
            if ()
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj) == false) {
            return false;
        } else {
            AngryBee angryBee = (AngryBee) obj;
            return (this.attackDamage == (angryBee.attackDamage))
                    && this.getCost()==angryBee.getCost();
        }
    }
}
