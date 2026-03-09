package DataModel;

public class VehicleModel {
    private final String vehicleNumber ;
    private final VehicleTypeEnum type;
    private final VehicleSizeEnum size ;

    public VehicleModel(String vehicleNumber, VehicleTypeEnum type, VehicleSizeEnum size){
        this.vehicleNumber = vehicleNumber ;
        this.type = type ;
        this.size = size ;
    }

    public String getVehicleNumber() {
        return this.vehicleNumber;
    }

    public VehicleTypeEnum getType(){
        return this.type ;
    }

    public VehicleSizeEnum getSize(){
        return this.size ;
    }
}
