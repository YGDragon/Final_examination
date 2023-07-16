package super_class;

import java.util.ArrayList;

public class Animal {
    private Integer id;
    private String name;
    private String date;
    private ArrayList<String> commands = new ArrayList<>();

    public Animal() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(String action) {
        this.commands.add(action);
    }
}