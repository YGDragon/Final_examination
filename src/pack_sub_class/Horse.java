package pack_sub_class;

import implenent.InterfacePacks;
import super_class.Pack;

public class Horse extends Pack implements InterfacePacks {
    public Horse() {
        super.setSubKind("Лошадь");
    }

    @Override
    public void packCommand(String action) {

    }
}