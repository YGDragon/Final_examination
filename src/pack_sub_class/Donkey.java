package pack_sub_class;

import implenent.InterfacePacks;
import super_class.Pack;

public class Donkey extends Pack implements InterfacePacks {
    public Donkey() {
        super.setSubKind("Осел");
    }

    @Override
    public void packCommand(String action) {
    }
}