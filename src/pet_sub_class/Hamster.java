package pet_sub_class;

import implenent.InterfacePets;
import super_class.Pet;

public class Hamster extends Pet implements InterfacePets {
    public Hamster() {
        super.setSubKind("Хомяк");
    }

    @Override
    public void petCommand(String action) {
    }
}
