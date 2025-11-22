// InsectExample.java
abstract class Insect {
    abstract void flystatus();
}

class Termite extends Insect {
    @Override
    void flystatus() {
        System.out.println("Termite cannot fly");
    }
}

class Grasshopper extends Insect {
    @Override
    void flystatus() {
        System.out.println("Grasshopper can fly");
    }
}

class Ant extends Insect {
    @Override
    void flystatus() {
        System.out.println("Ant cannot fly");
    }
}

public class InsectExample {
    public static void main(String[] args) {
        Insect[] arr = {new Termite(), new Grasshopper(), new Ant()};
        for (Insect ins : arr) ins.flystatus();
    }
}
