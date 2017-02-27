
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Wall;

/*
 //this code should work for no matter the box size, or where ruby starts in the box
 * //ruby can be faceing any direction, and it will find its way out of the box and stop once it exits
 * //the walls are just used as one example for how ruby can escape
 */
/**
 *
 * @author holls9719
 */
public class A3Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creating new city
        City lego = new City();
        //creating new walls to create the 'escape box'
        new Wall(lego, 1, 1, Direction.NORTH);
        new Wall(lego, 1, 2, Direction.NORTH);

        new Wall(lego, 1, 4, Direction.NORTH);
        new Wall(lego, 1, 5, Direction.NORTH);


        new Wall(lego, 1, 1, Direction.WEST);
        new Wall(lego, 2, 1, Direction.WEST);
        new Wall(lego, 3, 1, Direction.WEST);
        new Wall(lego, 4, 1, Direction.WEST);

        new Wall(lego, 1, 5, Direction.EAST);
        new Wall(lego, 2, 5, Direction.EAST);
        new Wall(lego, 3, 5, Direction.EAST);
        new Wall(lego, 4, 5, Direction.EAST);

        new Wall(lego, 4, 1, Direction.SOUTH);
        new Wall(lego, 4, 2, Direction.SOUTH);
        new Wall(lego, 4, 3, Direction.SOUTH);
        new Wall(lego, 4, 4, Direction.SOUTH);
        new Wall(lego, 4, 5, Direction.SOUTH);

        //creating new robot inside the escape box
        //for this algarithm it does not matter where ruby is made, or the direction, it will always escape)
        Robot ruby = new Robot(lego, 2, 5, Direction.EAST);
        //if ruby starts in the middle of the box, it moves to the edge
        while (ruby.frontIsClear()) {
            ruby.move();
        }
        //once it reaches the edge
        while (!(ruby.frontIsClear())) {
            //turn left
            ruby.turnLeft();
            //if after ruby turns left and the front is clear(meaning it hit a corner)
            while (ruby.frontIsClear()) {
                //turn right
                ruby.turnLeft();
                ruby.turnLeft();
                ruby.turnLeft();
                //if its front is clear, move out of the box
                if (ruby.frontIsClear()) {
                    ruby.move();
                    //end the loop
                    break;
                }
                //if the front is not clear in the corner,turn left
                if (!(ruby.frontIsClear())) {
                    ruby.turnLeft();
                    //if the front is clear after turning left, then move
                    if (ruby.frontIsClear()) {
                        ruby.move();
                    }
                }
            }
        }
    }
}
