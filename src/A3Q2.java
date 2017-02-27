
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
public class A3Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creating new city
        City lego = new City();
        //creating new walls to form the square
        new Wall(lego, 1, 1, Direction.NORTH);
        new Wall(lego, 1, 2, Direction.NORTH);

        new Wall(lego, 1, 1, Direction.WEST);
        new Wall(lego, 1, 2, Direction.EAST);
        new Wall(lego, 2, 1, Direction.WEST);
        new Wall(lego, 2, 2, Direction.EAST);

        new Wall(lego, 2, 1, Direction.SOUTH);
        new Wall(lego, 2, 2, Direction.SOUTH);

        //creating new robot in lego city
        Robot ruby = new Robot(lego, 0, 3, Direction.WEST);

        //creating loop to travel one side of the square
        //loop will repeat until it has gone around the square twice
        for (int i = 0; i < 8; i = i + 1) {
            ruby.move();
            ruby.move();
            ruby.move();
            ruby.turnLeft();


        }

    }
}
