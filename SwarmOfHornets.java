//import java.util.Arrays;

import java.sql.SQLOutput;

public class SwarmOfHornets {
    private int size;
    private Hornet[] swarm;

    public SwarmOfHornets() {
        int size = 0;
        swarm = new Hornet[1];

    }

    public int sizeOfSwarm(){
        return size;
    }

    public Hornet[] getHornets(){
        return this.swarm;
    }

    public Hornet getFirstHornet(){
        if (size != 0) {
            return swarm[0];
        } else {
            return null;
        }
    }

    public void addHornet(Hornet hornet){
        if(size == 0 && swarm.length == 1){
            swarm[0] = hornet;
        }
        Hornet[] newSwarm = copyOf(swarm);
        newSwarm[newSwarm.length-1] = hornet;
        this.swarm = newSwarm;
    }

    public boolean removeHornet(Hornet hornet){
        if(swarm[0]==null){
            return false;
        }
        for (int i = 0; i < swarm.length; i++) {
            if(swarm[i].equals(hornet)){
                this.swarm[i] = null; //remove first hornet
                this.swarm = reOrder(this.swarm);  //reorder after removing
                size--;
                return true;
            }
        }
        return false;
    }


    // Helper Methods
    private Hornet[] copyOf(Hornet[] swarm){
        size++;

        Hornet[] newSwarm = new Hornet[size];
        for (int i = 0; i < swarm.length; i++) {
            newSwarm[i] = swarm[i];

        }
        return newSwarm;
    }

    private Hornet[] reOrder(Hornet[] swarm){
        int a = 0;
        Hornet[] newSwarm = new Hornet[swarm.length - 1];
        for (int hornet = 0; hornet < swarm.length -1; hornet++) {
            if (swarm[hornet] != null){
                if (hornet + a == swarm.length) break;
                newSwarm[hornet] = swarm[hornet+a];
            } else{
                if(hornet + 1 == swarm.length) break;
                a = 1;
                newSwarm[hornet] = swarm[hornet + 1];
            }
        }
        return newSwarm;
    }



}
