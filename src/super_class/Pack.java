package super_class;

public class Pack extends Animal {

    private String subKind;

    public String getKind() {
        return "Вьючное животное";
    }

    public void setSubKind(String subKind) {
        this.subKind = subKind;
    }

    @Override
    public String toString() {
        return "id<" + getId() + ">" +
                "вид<" + getKind().toUpperCase() + ">" +
                "подвид<" + subKind.toUpperCase() + ">" +
                "имя<" + getName().toUpperCase() + ">" +
                "команды<" + getCommands().toString().
                replace('[', ' ').replace(']', ' ').trim().toUpperCase() + ">" +
                "датарождения<" + getDate() + ">";
    }
}