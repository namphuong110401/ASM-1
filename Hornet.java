public class Hornet extends Insect {
    private int attackDamage;

    public Hornet(Tile t, int hp, int attackDamage) {
        super(t, hp);
        this.attackDamage = attackDamage;
        this.getPosition().addInsect(this);
    }


    @Override
    public boolean takeAction() {
        //no bee on the same tile as hornet, hornet try to move towards bee hive
        if (this.getPosition().getBee() != null) { //found a bee
            this.getPosition().getBee().takeDamage(this.attackDamage);
            return true;
        }
        else{ // not find
            if(this.getPosition().towardTheHive() != null){
                this.getPosition().removeInsect(this);
                this.getPosition().towardTheHive().addInsect(this);
                return true;
            } else{
                return false;
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        } else {
            Hornet hornet = (Hornet) obj;
            return (this.attackDamage == (hornet.attackDamage));
        }
    }
}