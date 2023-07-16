package pack_sub_class;

import implenent.InterfacePacks;
import super_class.Pack;

public class Camel extends Pack implements InterfacePacks {
    public Camel() {
        super.setSubKind("Верблюд");
    }

    @Override
    public void packCommand(String action) {
    }
}