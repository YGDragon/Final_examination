package pet_sub_class;

import implenent.InterfacePets;
import super_class.Pet;

public class Dog extends Pet implements InterfacePets {
    public Dog() {
        super.setSubKind("Собака");
    }

    @Override
    public void petCommand(String action) {
    }
}