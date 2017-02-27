
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author holls9719
 */
public class A3Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //createing new city
        City lego = new City();
        //turning on the thing counter to easily see how many things are in a stack
        lego.showThingCounts(true);
        //creating new pile of 10 things
        new Thing(lego, 1, 2);
        new Thing(lego, 1, 2);
        new Thing(lego, 1, 2);
        new Thing(lego, 1, 2);
        new Thing(lego, 1, 2);
        new Thing(lego, 1, 2);
        new Thing(lego, 1, 2);
        new Thing(lego, 1, 2);
        new Thing(lego, 1, 2);
        new Thing(lego, 1, 2);
        //creating new robot ruby in lego city
        Robot ruby = new Robot(lego, 1, 2, Direction.EAST);
        //do this nine times
        for (int i = 0; i < 9; i = i + 1) {
            //pick up thing
            ruby.pickThing();
            //move
            ruby.move();
            //put down
            ruby.putThing();
            //turn around
            ruby.turnLeft();
            ruby.turnLeft();
            //move
            ruby.move();
            //turn around
            ruby.turnLeft();
            ruby.turnLeft();
        }
        //pick up the last thing, move then put the last thing down on the pile
        ruby.pickThing();
        ruby.move();
        ruby.putThing();

    }
}
