public class Condition {

    private int name;
    private Object treshold;
    private Operator operator;
    private Sensor sensor;

    public Condition(int name, Object treshold, Operator operator, Sensor sensor) {
        this.name = name;
        this.treshold = treshold;
        this.operator = operator;
        this.sensor = sensor;
    }
}
