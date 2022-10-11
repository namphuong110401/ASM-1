public class TankyBee extends HoneyBee{
    private int attackDamage;
    private int beeAmor;

    public TankyBee(Tile t, int attackDamage, int beeAmor) {
        super(t, 30, 3);
        this.attackDamage = attackDamage;
        this.beeAmor = beeAmor;
    }

    @Override
    public boolean takeAction() {
        Tile movingBee = this.getPosition();
        if (movingBee.getHornet() != null) {
            movingBee.getHornet().takeDamage(attackDamage);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        } else {
            TankyBee tankyBee = (TankyBee) obj;
            return (this.attackDamage == (tankyBee.attackDamage))
                    && this.beeAmor==tankyBee.beeAmor;
        }
    }

    @Override
    public void takeDamage(int damageReceived) {
        damageReceived = (int) (damageReceived * (double)100/(100+beeAmor));
        super.takeDamage(damageReceived);
    }


}

