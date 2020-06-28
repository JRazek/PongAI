package jrazek.pong;

import jrazek.pong.templates.Entity;

import java.util.ArrayList;
import java.util.List;

public class Map<D extends Number, O> {
    Utils.Vector2I size;
    private List<Entity> entities = new ArrayList<>();
    public Map(Utils.Vector2I size){
        this.size = size;
    }
    public void step(){
        movePlayers();
    }
    private void movePlayers(){
        for(Entity e: entities){
            e.move();
        }
    }
    public List<Entity> getEntities() {
        return entities;
    }
    public Utils.Vector2I getSize() {
        return size;
    }
}
