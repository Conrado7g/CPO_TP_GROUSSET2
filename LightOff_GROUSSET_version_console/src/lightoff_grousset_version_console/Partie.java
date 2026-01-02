package lightoff_grousset_version_console;

import java.util.Scanner;

public class Partie {

    private GrilleDeJeu grille;
    private int nbCoups;

    public Partie() {
        // Grille 5x5 comme dans le sujet (tu peux mettre 7x7 si votre PDF l'indique, mais sujet = 5x5)
        this.grille = new GrilleDeJeu(5, 5);
        this.nbCoups = 0;
    }

    public void initialiserPartie() {
        // Mélange : nombre de tours au hasard (ex : 10)
        grille.melangerMatriceAleatoirement(10);
    }

    public void lancerPartie() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== LIGHTS OFF (console) ===");
        System.out.println("But : éteindre toutes les lumières avec le moins de coups possibles.");
        System.out.println("A chaque coup, tu choisis une ligne/colonne/diagonale à activer.");
        System.out.println();

        while (!grille.cellulesToutesEteintes()) {

            System.out.println(grille);
            System.out.println("Coups : " + nbCoups);

            System.out.println("Choisis une action :");
            System.out.println("1 - Activer une ligne");
            System.out.println("2 - Activer une colonne");
            System.out.println("3 - Activer diagonale descendante");
            System.out.println("4 - Activer diagonale montante");

            int choix;
            do {
                System.out.print("Ton choix (1-4) : ");
                choix = sc.nextInt();
            } while (choix < 1 || choix > 4);

            switch (choix) {
                case 1:
                    System.out.print("Numéro de ligne (0 à " + (grille.getNbLignes() - 1) + ") : ");
                    int ligne = sc.nextInt();
                    grille.activerLigneDeCellules(ligne);
                    break;

                case 2:
                    System.out.print("Numéro de colonne (0 à " + (grille.getNbColonnes() - 1) + ") : ");
                    int colonne = sc.nextInt();
                    grille.activerColonneDeCellules(colonne);
                    break;

                case 3:
                    grille.activerDiagonaleDescendante();
                    break;

                case 4:
                    grille.activerDiagonaleMontante();
                    break;
            }

            nbCoups++;
            System.out.println();
        }

        System.out.println(grille);
        System.out.println("✅ BRAVO ! Tu as éteint toutes les lumières.");
        System.out.println("Score (nombre de coups) = " + nbCoups);
    }
}

