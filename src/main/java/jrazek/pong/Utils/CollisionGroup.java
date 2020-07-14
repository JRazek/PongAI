package jrazek.pong.Utils;

import jrazek.pong.abstracts.DrawableObject;

import java.util.ArrayList;
import java.util.List;

public class CollisionGroup {
    private List<DrawableObject> list = new ArrayList<>(2);
    public void addToGroup(DrawableObject o){
        boolean ok = true;
        for(DrawableObject check : list){
            if(check.equals(o)) {
                ok = false;
                break;
            }
        }
        if(ok)
            list.add(o);
    }
    public void removeFromGroup(DrawableObject o){
        list.remove(o);
    }
    public boolean isInGroup(DrawableObject o){
        for(DrawableObject check : list){
            if(check.equals(o))
                return true;
        }
        return false;
    }
}
