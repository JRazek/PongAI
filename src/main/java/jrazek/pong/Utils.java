package jrazek.pong;
import java.awt.*;
import java.lang.reflect.Type;
import java.util.Random;

public class Utils {
    public static class Vector2I{
        private int x, y;
        public Vector2I(int x, int y){
            this.x = x; this.y = y;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
        public void setX(int x) {
            this.x = x;
        }
        public void setY(int y) {
            this.y = y;
        }
    }
    public static class Vector2F{
        private float x, y;
        public Vector2F(float x, float y){
            this.x = x; this.y = y;
        }
        public float getX() {
            return x;
        }
        public float getY() {
            return y;
        }
        public void setX(float x) {
            this.x = x;
        }
        public void setY(float y) {
            this.y = y;
        }
    }
    public static double randomDouble(){
        return randomDouble(Double.MIN_VALUE, Double.MAX_VALUE);
    }
    public static double randomDouble(double min, double max){
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }
    public static int randomInt(){
        return randomInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static int randomInt(int min, int max){
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
