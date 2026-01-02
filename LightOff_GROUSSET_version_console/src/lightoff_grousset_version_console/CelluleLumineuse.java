package lightoff_grousset_version_console;

public class CelluleLumineuse {

    // true = allumée, false = éteinte
    private boolean etat;

    // Constructeur : cellule éteinte au départ
    public CelluleLumineuse() {
        this.etat = false;
    }

    // Change l'état (on/off)
    public void activerCellule() {
        this.etat = !this.etat;
    }

    // Force l'extinction
    public void eteindreCellule() {
        this.etat = false;
    }

    // Renvoie true si éteinte
    public boolean estEteint() {
        return !this.etat;
    }

    // Renvoie l'état brut
    public boolean getEtat() {
        return this.etat;
    }

    // Affichage : X si allumée, O si éteinte
    @Override
    public String toString() {
        if (this.etat) {
            return "X";
        } else {
            return "O";
        }
    }
}

