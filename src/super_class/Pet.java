package super_class;

public class Pet extends Animal {
    public String kind = "Домашнее животное";
    private String subKind;

    public void setSubKind(String subKind) {
        this.subKind = subKind;
    }

    @Override
    public String toString() {
        return "id<" + getId() + ">" +
                "вид<" + kind.toUpperCase() + ">" +
                "подвид<" + subKind.toUpperCase() + ">" +
                "имя<" + getName().toUpperCase() + ">" +
                "команды<" + getCommands().toString().
                replace('[', ' ').replace(']', ' ').trim().toUpperCase() + ">" +
                "датарождения<" + getDate() + ">";
    }
}