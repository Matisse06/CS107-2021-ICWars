package ch.epfl.cs107.play.game.icwars.actor;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.window.Canvas;

public abstract class Soldat extends Unit {
    private final static int maxHp = 5;
    private final static int rayon = 2;
    private final static int attaque = 2;

    public Soldat(Area area, DiscreteCoordinates position, String faction) {
        super(area, position, faction);
        //setRayon(rayon);
        //setMaxHp(mapHp);

        // ? initialiser le rayon de déplacement
        // ici : on veut que maxHp = 5


        // sprite = new Sprite(nom, .... mais comment mettre le nom du sprite dedans
        // si on ne le prend pas en paramètre ?)
    }

    public int attaque() {
        return attaque;
    }

    @Override
    public void draw(Canvas canvas) {

    }

}
