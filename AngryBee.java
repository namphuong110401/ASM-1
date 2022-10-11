public class AngryBee extends HoneyBee{
    private int attackDamage;

    public AngryBee(Tile t, int attackDamage) {
        super(t, 10, 1);
        this.attackDamage = attackDamage;
    }

    @Override
    public boolean takeAction() {
        if (this.getPosition().isOnThePath() || this.getPosition().isHive()){
           if (detectHornet()) {
               return true;
           }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        } else {
            AngryBee angryBee = (AngryBee) obj;
            return (this.attackDamage == (angryBee.attackDamage))
                    && this.getCost()==angryBee.getCost();
        }
    }

    private boolean detectHornet() {
        Tile movingBee = this.getPosition();
        while (true) {
            if (movingBee.getHornet() != null && !movingBee.isNest()) {
                movingBee.getHornet().takeDamage(attackDamage);
                return true;
            } else {
                if (movingBee.isNest()){
                    return false;
                }
                movingBee = this.getPosition().towardTheNest();
            }
        }
    }
}
