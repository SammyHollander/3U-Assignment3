
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;

/*
 *Note: this code should work for any number of things in the pile
 * as well as any number of piles within the avenue
 * I just used an example of the number of things and the number of rows here
 */
/**
 *
 * @author holls9719
 */
public class A3Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creating new city
        City lego = new City();

        //creating new robot, ruby in lego at 0,1 faceing south
        Robot ruby = new Robot(lego, 0, 1, Direction.SOUTH);

        //shows the number of things in a stack
        lego.showThingCounts(true);

        //creating the line of things to form the bar graph
        new Thing(lego, 1, 1);
        new Thing(lego, 1, 1);
        new Thing(lego, 2, 1);
        new Thing(lego, 2, 1);
        new Thing(lego, 2, 1);
        new Thing(lego, 3, 1);

        //moveing ruby onto the path of things to start the alarithm to form a bar graph
        ruby.move();

        //while ruby can pick up something, turn that into a row on the bar graph
        while (ruby.canPickThing()) {

            //make ruby pick up as many things as are on the intersection
            while (ruby.canPickThing()) {
                ruby.pickThing();
            }
            //make ruby turn left to start the bar graph
            ruby.turnLeft();

            //count things in backpack
            //number of things in back pack is the number of times it runs this loop
            while (ruby.countThingsInBackpack() > 0) {
                ruby.move();
                ruby.putThing();
            }
            //turn ruby around
            ruby.turnLeft();
            ruby.turnLeft();
            //moves ruby back to the trail of thins
            while (ruby.getAvenue() > 1) {
                ruby.move();
            }
            //makes ruby face the right direction and move to start the next row of graph
            ruby.turnLeft();
            ruby.move();
        }
    }
}