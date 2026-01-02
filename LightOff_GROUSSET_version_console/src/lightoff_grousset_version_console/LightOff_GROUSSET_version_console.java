package lightoff_grousset_version_console;

public class LightOff_GROUSSET_version_console {

    public static void main (String[] args) {

        CelluleLumineuse c1 = new CelluleLumineuse();
        CelluleLumineuse c2 = new CelluleLumineuse();

        System.out.println("Etat initial c1 : " + c1); // O
        System.out.println("Etat initial c2 : " + c2); // O

        c1.activerCellule();
        System.out.println("Après activerCellule(), c1 : " + c1); // X

        c1.eteindreCellule();
        System.out.println("Après eteindreCellule(), c1 : " + c1); // O

        System.out.println("c1 est eteint ? " + c1.estEteint()); // true
        System.out.println("Etat brut c1 (getEtat) : " + c1.getEtat()); // false
    }
}

