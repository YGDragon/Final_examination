import counter.IdCounter;
import super_class.Animal;

import java.util.HashMap;
import java.util.List;

public class Register {
    public static void main(String[] args) {
        boolean stopLoop = false;
        while (!stopLoop) {
            View.startMenuMessage();
            switch (Model.in.nextLine()) {
                case "1" -> {
                    List<String> animalsData = Model.readFromRegister();
                    View.definitionKindMessage();
                    View.seeSubKindMessage();
                    Animal animal = Model.definitionKind(
                            View.subKindPet, View.subKindPack);
                    try (IdCounter id = new IdCounter()) {
                        animal.setId(id.getId());
                        View.fillNameMessage();
                        animal.setName(Model.in.nextLine());
                        View.fillCommandMessage();
                        animal.setCommands(Model.in.nextLine());
                        View.fillDateMessage();
                        //
                        animal.setDate(Model.in.nextLine());
                        id.add();
                        Model.writeToFile(String.valueOf(id.getId()), id.fileName);
                    } catch (Exception e) {
                        System.out.println("Счетчик не закрыт");
                    }
                    //
                    animalsData.add(animal.toString());
                    System.out.println(animalsData);
                    Model.writeListToRegister(animalsData, Model.fileName);
                }
                case "2" -> {
                    View.idNumberMessage();
                    View.printAllCommands(
                            Model.getAllCommands(
                                    Model.parseData(
                                            Model.readFromRegister())));
                }

                case "3" -> {
                    List<HashMap<String, String>> animalsData = Model.parseData(Model.readFromRegister());
                    View.idNumberMessage();
                    String findId = Model.in.nextLine();
                    View.newCommandMessage();
                    String command = Model.in.nextLine();
                    Model.writeListToRegister(
                            Model.converterList(
                                    Model.learnCommand(findId, command, animalsData)),
                            Model.fileName);
                }
                case "4" -> {
                    View.printRegisterData(
                            Model.readFromRegister());
                }
                case "5" -> {
                    stopLoop = true;
                    View.mainMessage1();
                }
                default -> {
                    View.mainMessage2();
                }
            }
        }
    }
}