package CustomException;

public class CustomParkingLotException extends RuntimeException{
    public CustomParkingLotException(String message){
        super(message);
    }
}
