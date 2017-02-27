
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import becker.robots.Wall;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author holls9719
 */
public class A3Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creating new city
        City lego = new City();
        //creating new robot ruby
        Robot ruby = new Robot(lego, 1, 1, Direction.EAST);
        //creating things in its path
        new Thing(lego, 1, 3);
        //creating a wall in its path
        new Wall(lego, 1, 5, Direction.EAST);
        //move ruby while it cannot pick thing, or the front is clear
        while (!(ruby.canPickThing()) && ruby.frontIsClear()) {
            ruby.move();
        }

    }
}
