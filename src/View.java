import java.util.List;

public class View {
    public static String[] menu = {
            "Завести новое животное",
            "Вывести все команды, которые выполняет животное",
            "Обучить животное новой команде",
            "Просмотреть данные о всех животных",
            "Выход из программы"
    };
    static String[] subKindPet = new String[]{"СОБАКА", "КОШКА", "ХОМЯК"};
    static String[] subKindPack = new String[]{"ЛОШАДЬ", "ОСЕЛ", "ВЕРБЛЮД"};

    public static void startMenuMessage() {
        int count = 0;
        System.out.println("\nсистема учета питомника:".toUpperCase());
        for (String item : menu
        ) {
            count++;
            System.out.printf("\t%d.%s\n", count, item);
        }
        System.out.print("введите номер действия из меню -> ".toUpperCase());
    }

    public static void definitionKindMessage() {
        System.out.println("какое животное зарегистрировать:".toUpperCase());
    }

    public static void seeSubKindMessage() {
        StringBuilder sb = new StringBuilder();
        for (String subKind : subKindPet
        ) {
            sb.append(subKind).append(" ");
        }
        for (String subKind : subKindPack
        ) {
            sb.append(subKind).append(" ");
        }
        System.out.print(sb + "-> ");
    }

    public static void fillNameMessage() {
        System.out.print("введите имя -> ".toUpperCase());
    }

    public static void fillCommandMessage() {
        System.out.print("введите через пробел комманды -> ".toUpperCase());
    }

    public static void fillDateMessage() {
        System.out.print("введите дату рождения -> ".toUpperCase());
    }

    public static void idNumberMessage() {
        System.out.print("введите ID-номер -> ".toUpperCase());
    }

    public static void newCommandMessage() {
        System.out.print("Введите новую команду для животного -> ".toUpperCase());
    }

    public static void mainMessage1() {
        System.out.println("программа остановлена!".toUpperCase());
    }

    public static void mainMessage2() {
        System.out.println("действие не выбрано!".toUpperCase());
    }

    public static void printAllCommands(String[] actions) {
        System.out.print("животное выполняет команды: ".toUpperCase());
        for (String action : actions) {
            System.out.printf("%s ", action);
        }
    }

    public static void printRegisterData(List<String> registerData) {
        if (registerData.size() == 0) {
            System.out.println("реестр пустой, данные отсутствуют!".toUpperCase());
        } else {
            for (String data : registerData
            ) {
                System.out.println(data);
            }
        }
    }
}