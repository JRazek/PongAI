package jrazek.pong;

import jrazek.pong.abstracts.Entity;
import jrazek.pong.graphics.Frame;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private Utils.Vector2I size;
    private Frame frame;
    List<Entity> entities = new ArrayList<>();
    public Map(Utils.Vector2I size, Frame frame){
        this.size = size;
        this.frame = frame;
    }
    public void setEntities(List<Entity> entities){
        this.entities = entities;
    }
    public void addEntity(Entity e){
        this.entities.add(e);
    }
    public Frame getFrame() {
        return frame;
    }
    public Utils.Vector2I getSize() {
        return size;
    }
    public void step(){
        for(Entity entity : entities){
            boolean ok = true;
            if(entity.getPos().getX() <= 0 || entity.getPos().getX() >= size.getX()) {
                entity.onWallHit(true);
                ok = false;
            }
            if(entity.getPos().getY() <= 0 || entity.getPos().getY() >= size.getY()) {
                entity.onWallHit(false);
                ok = false;
            }
            if(ok)
                entity.move();
        }
    }
}
