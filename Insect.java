public abstract class Insect {
    private Tile t;
    private int hp;

    public Insect(Tile t, int hp) {
        this.t = t;
        this.hp = hp;

        if(this instanceof HoneyBee) {
            if (((HoneyBee)this).getPosition().getBee() != null) {
                ((HoneyBee)this).setPosition(null);
                throw new IllegalArgumentException("Insect does not fit on tile.");
            }
        }
    }

    public final Tile getPosition() {
        return t;
    }

    public final int getHealth() {
        return hp;
    }

    public void setPosition(Tile t) {
        this.t = t;
    }

    public void takeDamage(int damageReceived){
        // if bee pos on bee hive, damage should be reduced by 10% before being applied
        if(this instanceof HoneyBee) {
            if (this.getPosition().isHive()) {
                damageReceived = (int)(damageReceived * 0.9);
                hp = hp - damageReceived;
            } else{
                hp = hp - damageReceived;
                if (hp <= 0) {
                    this.getPosition().removeInsect(this);
                }
            }
        } else {
            hp = hp - damageReceived;
            if (hp <= 0) {
                this.getPosition().removeInsect(this);
            }
        }
    }

    public abstract boolean takeAction();

    public boolean equals(Object obj){
        if (!(obj instanceof Insect)) {
            return false;
        } else {
            Insect insect = (Insect) obj;
            return this.getClass().equals(insect.getClass())
                    && (this.hp == (insect.hp))
                    && insect.t.equals(this.t);
        }
    }

}
