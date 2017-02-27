
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Wall;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author holls9719
 */
public class A3Q7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creating new city
        City lego = new City();

        //creating new walls to form the city blocks
        new Wall(lego, 2, 1, Direction.SOUTH);
        new Wall(lego, 2, 2, Direction.SOUTH);
        new Wall(lego, 2, 2, Direction.EAST);
        new Wall(lego, 1, 2, Direction.EAST);
        new Wall(lego, 1, 2, Direction.NORTH);
        new Wall(lego, 1, 1, Direction.NORTH);
        new Wall(lego, 1, 1, Direction.WEST);
        new Wall(lego, 2, 1, Direction.WEST);

        new Wall(lego, 2, 4, Direction.SOUTH);
        new Wall(lego, 2, 5, Direction.SOUTH);
        new Wall(lego, 2, 5, Direction.EAST);
        new Wall(lego, 1, 5, Direction.EAST);
        new Wall(lego, 1, 5, Direction.NORTH);
        new Wall(lego, 1, 4, Direction.NORTH);
        new Wall(lego, 1, 4, Direction.WEST);
        new Wall(lego, 2, 4, Direction.WEST);

        new Wall(lego, 5, 1, Direction.SOUTH);
        new Wall(lego, 5, 2, Direction.SOUTH);
        new Wall(lego, 5, 2, Direction.EAST);
        new Wall(lego, 4, 2, Direction.EAST);
        new Wall(lego, 4, 2, Direction.NORTH);
        new Wall(lego, 4, 1, Direction.NORTH);
        new Wall(lego, 4, 1, Direction.WEST);
        new Wall(lego, 5, 1, Direction.WEST);

        new Wall(lego, 5, 4, Direction.SOUTH);
        new Wall(lego, 5, 5, Direction.SOUTH);
        new Wall(lego, 5, 5, Direction.EAST);
        new Wall(lego, 4, 5, Direction.EAST);
        new Wall(lego, 4, 5, Direction.NORTH);
        new Wall(lego, 4, 4, Direction.NORTH);
        new Wall(lego, 4, 4, Direction.WEST);
        new Wall(lego, 5, 4, Direction.WEST);

        //creating new robot ruby that starts in the middle of the four blocks faceing south
        Robot ruby = new Robot(lego, 3, 3, Direction.SOUTH);

        //make ruby go around all four blocks
        for (int i = 0; i < 16; i = i + 1) {
            ruby.move();
            ruby.move();
            ruby.move();
            if (!(ruby.getAvenue() == 3 && ruby.getStreet() == 3)) {
                ruby.turnLeft();
            }
        }

    }
}
