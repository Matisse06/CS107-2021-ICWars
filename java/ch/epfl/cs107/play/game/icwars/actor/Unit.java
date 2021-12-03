package ch.epfl.cs107.play.game.icwars.actor;
import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.math.DiscreteCoordinates;

import ch.epfl.cs107.play.window.Canvas;

public abstract class Unit extends ICWarsActor {
    // définir lien d'appartenance à une faction

    private String nom;
    private int hp;
    private Sprite sprite;
    private int rayon;

    public Unit(Area area, Orientation orientation, DiscreteCoordinates position, String faction) {
        super(area, orientation, position, faction);

        // valeur max dépend du type : ok comme j'ai fait ? (maxHp dans constructeur et
        // redéfinition dans autres méthodes..?) ou alors : méthode abstraite qui prend en paramètre la valeur max
        // mais alors comment insérer dans le constructeur

        // mettre un assert hp >= 0 ?
        // les points de vie ne peuvent pas être négatifs : méthode ok ?
    }

    public Unit(Area area, DiscreteCoordinates position, String faction) {
        super(area, position, faction);
    }

    public void setMaxHp(int hp) {
        this.hp = hp;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }

    public int getRayon() {
        return rayon;
    }

    public String getName() {
        return nom;
    }

    public void hpPositif() {
        if (hp < 0) {
            hp = 0;
        }
    }

    public boolean isVivant() {
        return (hp == 0);
    }

    public int getHp() {
        return hp;
    }

    public void damage(int nbPoints) {
        hp -= nbPoints;
    }

    public void heal(int nbPoints) {
        hp += nbPoints;
    }

    abstract public void getDamage(ICWarsActor ennemi, int pointsDeVie);

    abstract public void draw(Canvas canvas);

    // méthode qui fait que l'unité ne peut être déplacée que dans un "rayon" (entier en paramètre)
    // comme la méthode est redéfinir dans les autres classes, non nécessaire de la spécifier là si ?
    // appel à une méthode de GhostPlayer / MovableAreaEntity ou on doit la créer nous-mêmes ?
    // on doit vrmt le faire bouger ou juste renvoyer l'entier ?

    public boolean takeCellSpace() {
        return false;
    }

    public boolean isCellInteractable() {
        return true;
    }

    public boolean isViewInteractable() {
        return false;
    }

    // lier unit à interactor / interactable ?
}


