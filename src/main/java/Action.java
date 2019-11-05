public class Action {

    private int name;
    private Object actuatorParam;
    private Actuator actuator;

    public Action(int name, Object actuatorParam, Actuator actuator) {
        this.name = name;
        this.actuatorParam = actuatorParam;
        this.actuator = actuator;
    }
}
