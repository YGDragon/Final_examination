package pet_sub_class;

import implenent.InterfacePets;
import super_class.Pet;

public class Cat extends Pet implements InterfacePets {
    public Cat() {
        super.setSubKind("Кошка");
    }

    @Override
    public void petCommand(String action) {
    }
}