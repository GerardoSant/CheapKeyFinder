import java.util.List;

public class Rule {

    private String name;
    private String description;
    private boolean active;
    private List<Condition> conditions;
    private List<Action> actions;

    public Rule(String name, String description, boolean active, List<Condition> conditions, List<Action> actions) {
        this.name = name;
        this.description = description;
        this.active = active;
        this.conditions = conditions;
        this.actions = actions;
    }
}
