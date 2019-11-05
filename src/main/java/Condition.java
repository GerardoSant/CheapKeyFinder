public class Condition {

    private int name;
    private Object treshold;
    private Operator operator;
    private Sensor sensor;

    public Condition(Object treshold, Operator operator, Sensor sensor) {
        this.treshold = treshold;
        this.operator = operator;
        this.sensor = sensor;
    }

    public Sensor getSensor() {
        return sensor;
    }
}
