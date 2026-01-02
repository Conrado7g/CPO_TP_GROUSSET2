package lightoff_grousset_version_console;

public class LightOff_GROUSSET_version_console {

   public static void main(String[] args) {

    GrilleDeJeu g = new GrilleDeJeu(7, 7);

    System.out.println("Grille initiale :");
    System.out.println(g);

    g.activerLigneDeCellules(0);
    System.out.println("Après activation ligne 0 :");
    System.out.println(g);

    g.activerColonneDeCellules(0);
    System.out.println("Après activation colonne 0 :");
    System.out.println(g);

    g.activerDiagonaleDescendante();
    System.out.println("Après activation diagonale descendante :");
    System.out.println(g);

    g.melangerMatriceAleatoirement(10);
    System.out.println("Après mélange :");
    System.out.println(g);

    System.out.println("Tout éteint ? " + g.cellulesToutesEteintes());
}

}

