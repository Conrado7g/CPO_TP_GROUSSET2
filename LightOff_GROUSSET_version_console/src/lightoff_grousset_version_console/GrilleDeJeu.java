package lightoff_grousset_version_console;

import java.util.Random;

public class GrilleDeJeu {

    // ⚠️ On laisse SANS "private" pour la partie graphique (le PDF 2 y accède directement)
    CelluleLumineuse[][] matriceCellules;

    private int nbLignes;
    private int nbColonnes;

    private Random generateurAleatoire = new Random();

    public GrilleDeJeu(int p_nbLignes, int p_nbColonnes) {
        this.nbLignes = p_nbLignes;
        this.nbColonnes = p_nbColonnes;

        // 1) Réservation mémoire du tableau 2D
        this.matriceCellules = new CelluleLumineuse[nbLignes][nbColonnes];

        // 2) Création de chaque objet cellule
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                this.matriceCellules[i][j] = new CelluleLumineuse();
            }
        }
    }

    public int getNbLignes() {
        return nbLignes;
    }

    public int getNbColonnes() {
        return nbColonnes;
    }

    public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j].eteindreCellule();
            }
        }
    }

    public void activerLigneDeCellules(int idLigne) {
        if (idLigne < 0 || idLigne >= nbLignes) return;

        for (int j = 0; j < nbColonnes; j++) {
            matriceCellules[idLigne][j].activerCellule();
        }
    }

    public void activerColonneDeCellules(int idColonne) {
        if (idColonne < 0 || idColonne >= nbColonnes) return;

        for (int i = 0; i < nbLignes; i++) {
            matriceCellules[i][idColonne].activerCellule();
        }
    }

    public void activerDiagonaleDescendante() {
        int taille = Math.min(nbLignes, nbColonnes);
        for (int i = 0; i < taille; i++) {
            matriceCellules[i][i].activerCellule();
        }
    }

    public void activerDiagonaleMontante() {
        int taille = Math.min(nbLignes, nbColonnes);
        for (int i = 0; i < taille; i++) {
            int j = nbColonnes - 1 - i;
            matriceCellules[i][j].activerCellule();
        }
    }

    public void activerLigneColonneOuDiagonaleAleatoire() {
        int choix = generateurAleatoire.nextInt(4);

        switch (choix) {
            case 0:
                activerLigneDeCellules(generateurAleatoire.nextInt(nbLignes));
                break;
            case 1:
                activerColonneDeCellules(generateurAleatoire.nextInt(nbColonnes));
                break;
            case 2:
                activerDiagonaleDescendante();
                break;
            case 3:
                activerDiagonaleMontante();
                break;
        }
    }

    public void melangerMatriceAleatoirement(int nbTours) {
        eteindreToutesLesCellules();

        for (int i = 0; i < nbTours; i++) {
            activerLigneColonneOuDiagonaleAleatoire();
        }
    }

    public boolean cellulesToutesEteintes() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (!matriceCellules[i][j].estEteint()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("   |");
        for (int j = 0; j < nbColonnes; j++) {
            sb.append(" ").append(j).append(" |");
        }
        sb.append("\n");

        int largeur = 4 * (nbColonnes + 1) + 1;
        for (int k = 0; k < largeur; k++) sb.append("-");
        sb.append("\n");

        for (int i = 0; i < nbLignes; i++) {
            sb.append(" ").append(i).append(" |");
            for (int j = 0; j < nbColonnes; j++) {
                sb.append(" ").append(matriceCellules[i][j].toString()).append(" |");
            }
            sb.append("\n");
            for (int k = 0; k < largeur; k++) sb.append("-");
            sb.append("\n");
        }

        return sb.toString();
    }
}

