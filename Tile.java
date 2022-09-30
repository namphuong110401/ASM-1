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
        Tile newTile = new Tile();
    }

    public Tile(int food, boolean aBeeHiveBuilt, boolean aHornetNestBuilt, boolean tilePartOfPath) {
        this.food = food;
        this.aBeeHiveBuilt = aBeeHiveBuilt;
        this.aHornetNestBuilt = aHornetNestBuilt;
        this.tilePartOfPath = tilePartOfPath;
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

    public boolean addInsect(Insect insect){
        if ( {

        }
        // check if there is any bee positioned on the tile
        // make sure no bee positioned on the nest
        // hornet can only position on either the hornet nest, bee hive, or on tileisonpath
        // return true if an insect is added to the tile, false otherwise
        // added insect = posOnTile

    }



}
