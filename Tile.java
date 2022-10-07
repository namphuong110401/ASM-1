public class Tile {
    private int food;
    private boolean aBeeHiveBuilt;
    private boolean aHornetNestBuilt;
    private boolean tilePartOfPath;
    private Tile fromHornetToHive;
    private Tile fromHiveToHornet;
    private HoneyBee beePosOnTile;
    private SwarmOfHornets hornetPosOnTile;

    public Tile() {
        food = 0;
        aBeeHiveBuilt = false;
        aHornetNestBuilt = false;
        tilePartOfPath = false;
        beePosOnTile = null;
        fromHiveToHornet = null;
        fromHornetToHive = null;
    }

    public Tile(int food, boolean aBeeHiveBuilt, boolean aHornetNestBuilt, boolean tilePartOfPath, Tile fromHornetToHive, Tile fromHiveToHornet, HoneyBee beePosOnTile, SwarmOfHornets hornetPosOnTile) {
        this.food = food;
        this.aBeeHiveBuilt = aBeeHiveBuilt;
        this.aHornetNestBuilt = aHornetNestBuilt;
        this.tilePartOfPath = tilePartOfPath;
        this.fromHornetToHive = fromHornetToHive;
        this.fromHiveToHornet = fromHiveToHornet;
        this.beePosOnTile = beePosOnTile;
        this.hornetPosOnTile = hornetPosOnTile;
    }

    public boolean isHive(){
        return aBeeHiveBuilt;
    }

    public boolean isNest(){
        return aHornetNestBuilt;
    }

    public void buildHive(){
        this.aBeeHiveBuilt = true;
    }

    public void buildNest(){
        this.aHornetNestBuilt = true;
    }

    public boolean isOnThePath(){
        return this.tilePartOfPath;
    }

    public Tile towardTheHive(){
        return this.fromHornetToHive;
    }

    public Tile towardTheNest(){
        return this.fromHiveToHornet;
    }

    public void createPath(Tile fromHornetToHive, Tile fromHiveToHornet){
        this.fromHiveToHornet = fromHiveToHornet;
        this.fromHornetToHive = fromHornetToHive;
    }

    public int collectFood(){
        food = 0;
        return this.food;
    }

    public void storeFood(int food){
        this.food = food;
    }

    public HoneyBee getBee(){
        return this.beePosOnTile;
    }

    public Hornet getHornet(){
        return this.hornetPosOnTile.getFirstHornet();
    }

    public int getNumOfHornets() {
        return this.hornetPosOnTile.sizeOfSwarm();
    }

    public boolean addInsect(Insect insectToAdd){
        if (insectToAdd instanceof HoneyBee){
            // if there is any bee positioned on the tile or bee positioned on the nest return false
            if (insectToAdd.getPosition().getBee() != null || !this.aHornetNestBuilt) {
                return false;
            } else {
                this.beePosOnTile = (HoneyBee) insectToAdd;
                insectToAdd.setPosition(this);
                return true;
            }

        } else if (insectToAdd instanceof Hornet) {
            // hornet can only position on either the hornet nest, bee hive, or on tileisonpath
            if (!aHornetNestBuilt || aBeeHiveBuilt || this.isOnThePath()) {
                return false;
            } else {
                if (this.hornetPosOnTile == null) {
                    this.hornetPosOnTile = new SwarmOfHornets();
                }
                this.hornetPosOnTile.addHornet((Hornet) insectToAdd);
                insectToAdd.setPosition(this);
            }
        }
        return true;
    }

    public boolean removeInsect(Insect insectToRemove){
        if (insectToRemove instanceof Hornet){
            this.hornetPosOnTile.removeHornet((Hornet) insectToRemove);
        }
        insectToRemove.setPosition(null);
        return true;
    }





}
