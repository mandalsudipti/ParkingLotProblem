package DataModel;

import java.util.Collections;
import java.util.List;

public class ParkingLotModel {
    private final String id ;
    private final String name ;
    private List<ParkingLevelModel> levels ;

    public ParkingLotModel(String id, String name, List<ParkingLevelModel> levels){
        this.id = id ;
        this.name = name ;
        this.levels = Collections.synchronizedList(levels) ;
        System.out.println("parking lot created with " + this.levels.size() + " levels");
    }

    public void addLevels(ParkingLevelModel level){
        this.levels.add(level);
    }

    public List<ParkingLevelModel> getLevels(){
        return this.levels ;
    }
}
