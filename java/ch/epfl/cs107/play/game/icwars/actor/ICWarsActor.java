package ch.epfl.cs107.play.game.icwars.actor;
import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.MovableAreaEntity;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.math.DiscreteCoordinates;

import java.util.Collections;
import java.util.List;

public abstract class ICWarsActor extends MovableAreaEntity {
    String faction;

    // chaque joueur extends ICWarsActor et va se servir d'unités de combat (elles-mêmes des ICWarsActor)

    /**
     *
     * @param area        (Area): Owner area. Not null
     * @param orientation (Orientation): Initial orientation of the entity. Not null
     * @param position    (Coordinate): Initial position of the entity. Not null
     */
    public ICWarsActor(Area area, Orientation orientation, DiscreteCoordinates position, String faction) {
        super(area, orientation, position);
        this.faction = faction;
    }
    public ICWarsActor(Area area, DiscreteCoordinates position, String faction) {
        this(area, Orientation.UP, position, faction);
    }


    public void leaveArea(){
        getOwnerArea().unregisterActor(this);
    }

    /**
     *
     * @param area (Area): initial area, not null
     * @param position (DiscreteCoordinates): initial position, not null
     */
    public void enterArea(Area area, DiscreteCoordinates position){
        area.registerActor(this);
        setOwnerArea(area);
        setCurrentPosition(position.toVector());
    }

    @Override
    public List<DiscreteCoordinates> getCurrentCells() {
        return Collections.singletonList(getCurrentMainCellCoordinates());
    }
}



