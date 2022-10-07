public class Hornet extends Insect {
    private int attackDamage;

    public Hornet(Tile t, int hp, int attackDamage) {
        super(t, hp);
        this.attackDamage = attackDamage;
    }


    @Override
    public boolean takeAction() {
        //no bee on the same tile as hornet, hornet try to move towards bee hive
        if (this.getPosition().getBee() == null){
            if (this.getPosition().towardTheHive() != null){
                this.getPosition().removeInsect(this);
                this.getPosition().addInsect(this);
            }
            // bee pos on the same tile as hornet, hornet -> amount of damage= hornet attackDamage
        } else {
            this.getPosition().getBee().takeDamage(this.attackDamage);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj) == false) {
            return false;
        } else {
            Hornet hornet = (Hornet) obj;
            return (this.attackDamage == (hornet.attackDamage));
        }
    }
}