package DataModel;

public class GateModel {
    private final Integer gateNo;
    private final GateTypeEnum gateType ;

    public GateModel(Integer gateNo, GateTypeEnum type){
        this.gateNo = gateNo ;
        this.gateType = type;
    }

    public GateTypeEnum getGateType(){
        return this.gateType ;
    }

    public Integer getGateNo(){
        return this.gateNo ;
    }
}
