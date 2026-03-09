package DataModel;

import java.util.List;

public class ParkingLotModel {
    private final String id ;
    private final String name ;
    private List<ParkingLevelModel> levels ;
    private List<GateModel> gates;

    public ParkingLotModel(String id, String name, List<ParkingLevelModel> levels, List<GateModel> gates){
        this.gates = gates ;
        this.id = id ;
        this.name = name ;
        this.levels = levels ;
        System.out.println("parking lot created with " + this.levels.size() + " levels and " + this.gates.size() + " gates");
    }

    public void addLevels(ParkingLevelModel level){
        this.levels.add(level);
    }

    public List<ParkingLevelModel> getLevels(){
        return this.levels ;
    }

    public List<GateModel> getGates(){
        return this.gates ;
    }
}
