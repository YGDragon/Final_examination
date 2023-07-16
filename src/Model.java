import super_class.Animal;
import super_class.Pack;
import super_class.Pet;

import java.io.*;
import java.util.*;

public class Model {
    static String fileName = "register.txt";
    static Scanner in = new Scanner(System.in);

    /*
     * Получение списка данных о животных из реестра питомника
     */
    public static List<String> readFromRegister(String fileName) {
        List<String> registerData = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(fileName))) {
            String readData;
            while ((readData = buffer.readLine()) != null) {
                registerData.add(readData);
            }
        } catch (IOException e) {
            System.out.println("файла реестра отсутствует -> создан новый пустой файл реестра");
            writeToFile("", fileName);
        }
        return registerData;
    }

    /*
     * Парсинг данных о животных из списка
     */
    public static List<HashMap<String, String>> parseData(List<String> data) {
        int counter = 0;
        List<HashMap<String, String>> parseData = new ArrayList<>();
        for (String datum : data) {
            HashMap<String, String> hashData = new HashMap<>();
            int sizeString = datum.length();
            for (int i = 0; i < sizeString; i++) {
                counter++;
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                do {
                    sb1.append(datum.charAt(i));
                    i++;
                } while (datum.charAt(i) != '<');
                do {
                    i++;
                    if (datum.charAt(i) == '>') {
                        break;
                    }
                    sb2.append(datum.charAt(i));
                } while (datum.charAt(i) != '>');
                if (counter <= 4) {
                    hashData.put(sb1.toString(), sb2.substring(0, 1) + sb2.substring(1, sb2.length()).toLowerCase());
                } else {
                    hashData.put(sb1.toString(), sb2.toString().toLowerCase());
                }
            }
            parseData.add(hashData);
        }
        return parseData;
    }

    /*
     * Получение из реестра комманд по ID-номеру животного
     */
    public static String[] getAllCommands(List<HashMap<String, String>> hash) {
        String animalId = in.nextLine();
        String[] actions = new String[0];
        for (HashMap<String, String> h : hash
        ) {
            if (h.get("id").equals(animalId)) {
                actions = h.get("команды").split(" ");
            }
        }
        return actions;
    }

    /*
     * Задание подвида животного
     */
    public static Animal definitionKind(String[] subKindPet, String[] subKindPack) {
        String subKind = in.nextLine().toUpperCase();
        for (String s : subKindPet
        ) {
            if (subKind.equals(s)) {
                Pet pet = new Pet();
                pet.setSubKind(subKind);
                return pet;
            }
        }
        for (String s : subKindPack
        ) {
            if (subKind.equals(s)) {
                Pack pack = new Pack();
                pack.setSubKind(subKind);
                return pack;
            }
        }
        return new Animal();
    }

    /*
     * Обучение животного новой команде
     */
    public static List<HashMap<String, String>> learnCommand(
            String findId, String commands, List<HashMap<String, String>> animalsData) {
        for (HashMap<String, String> animal : animalsData
        ) {
            if (animal.get("id").equals(findId)) {
                if (!animal.get("id").equals("")) {
                    animal.merge("команды", commands, (a, b) -> a + " " + b);
                } else {
                    animal.merge("команды", commands, (a, b) -> a + b);
                }
                break;
            }
        }
        return animalsData;
    }

    /*
     * Конвертирование списка хэша в список строк
     */
    public static List<String> converterList(List<HashMap<String, String>> animalsData) {
        List<String> stringData = new ArrayList<>();
        for (HashMap<String, String> animal : animalsData
        ) {
            stringData.add("id<" + animal.get("id") + ">" +
                    "вид<" + animal.get("вид") + ">" +
                    "подвид<" + animal.get("подвид") + ">" +
                    "имя<" + animal.get("имя") + ">" +
                    "команды<" + animal.get("команды") + ">" +
                    "датарождения<" + animal.get("датарождения") + ">");
        }
        return stringData;
    }

    /*
     * перезапись данных в реестр питомника
     */
    public static void writeListToRegister(List<String> list, String fileName) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(fileName))) {
            for (String data : list) {
                buffer.write(data);
                buffer.newLine();
            }
        } catch (IOException e) {
            System.out.println("ошибка записи файла".toUpperCase() + fileName);
        }
    }

    /*
     * Запись строки с даными в файл
     */
    public static void writeToFile(String data, String fileName) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(fileName))) {
            buffer.write(data);
            if (data.length() != 0) {
                buffer.newLine();
            }
        } catch (IOException e) {
            System.out.println("ошибка записи файла".toUpperCase() + fileName);
        }
    }
}