
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import becker.robots.Wall;

/*
//note: this should always work, no matter the position of the walls, or the things
//so long as the top left corner of the box remains in the same place
//ruby should always pick up all the things and return to the top left corner, faceing east
 */
/**
 *
 * @author holls9719
 */
public class A3Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creating new city
        City lego = new City();
        //creating new walls to build the enclosed room
        new Wall(lego, 1, 1, Direction.NORTH);
        new Wall(lego, 1, 2, Direction.NORTH);
        new Wall(lego, 1, 3, Direction.NORTH);
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
        
        //creating new things within the box wall for ruby to pick up
        //stack of two things
        new Thing(lego,2,1);
        new Thing(lego,2,1);
        
        new Thing(lego,1,1);
        //stack of three things
        new Thing(lego,1,2);
        new Thing(lego,1,2);
        new Thing(lego,1,2);
        
        new Thing(lego,1,3);
        
        new Thing(lego,2,1);
        
        new Thing(lego,3,3);
        
        new Thing(lego,3,5);
        
        new Thing(lego,4,5);
        

        //creating new robot ruby that starts in 1,1 lego city faceing east
        Robot ruby = new Robot(lego, 1, 1, Direction.EAST);
        //while there are things at the starting position, pick them up
        while(ruby.canPickThing()){
            ruby.pickThing();
        }
        ruby.move();
        //run this loop only if ruby is not in the starting position
        while (!(ruby.getAvenue() == 1 && ruby.getStreet() == 1)) {

            //while front is clear, move ruby, and pick up things on the way
            while (ruby.frontIsClear()) {
                while (ruby.canPickThing()) {
                    ruby.pickThing();
                }
                ruby.move();
            }
            //if the front is not clear, and it's faceing east, turn right and check if the front is clear
            if (!(ruby.frontIsClear()) && ruby.getDirection() == Direction.EAST) {
                ruby.turnLeft();
                ruby.turnLeft();
                ruby.turnLeft();
                //while there is something on the ground, pick it up
                while (ruby.canPickThing()) {
                    ruby.pickThing();
                }
                //if the front is clear, move down a row, and turn right
                if (ruby.frontIsClear()) {
                    ruby.move();
                    ruby.turnLeft();
                    ruby.turnLeft();
                    ruby.turnLeft();
                    //while there is anything on the ground, pick it up
                    while (ruby.canPickThing()) {
                        ruby.pickThing();
                    } 
                }
                //if ruby's front is not clear,meaning it is on the last row; turn right, then:
                if (!(ruby.frontIsClear())){
                    ruby.turnLeft();
                    ruby.turnLeft();
                    ruby.turnLeft();
                    //while ruby's front is clear
                    while(ruby.frontIsClear()){
                        //while ruby can pick thing, then pick thing
                        while(ruby.canPickThing()){
                            ruby.pickThing();
                        }
                        //ruby move
                        ruby.move();
                    }
                    //if ruby's front is not clear, turn right, then check if its clear and if it is, then move
                    if(!(ruby.frontIsClear())){
                        ruby.turnLeft();
                        ruby.turnLeft();
                        ruby.turnLeft();
                        while(ruby.frontIsClear()){
                            ruby.move();
                        }
                    }
                }
            }
            //if ruby is faceing west when it reaches the end of the row then turn left and;
            if (!(ruby.frontIsClear()) && ruby.getDirection() == Direction.WEST) {
                ruby.turnLeft();
                //while ruby can pick thing, ruby pick up thing
                while (ruby.canPickThing()) {
                    ruby.pickThing();
                }
                //if the front is clear then move, and turn left(moveing down a row)
                if (ruby.frontIsClear()) {
                    ruby.move();
                    ruby.turnLeft();
                }
                //this next 'if' statement gets ruby back to the start position
                //if the front is not clear, meaning it is on the last row, then turn left
                if (!(ruby.frontIsClear())) {
                    ruby.turnLeft();
                    //while ruby's front is clear:
                    while (ruby.frontIsClear()) {
                        //while there is something for ruby to pick up, pick it up
                        while (ruby.canPickThing()) {
                            ruby.pickThing();
                        }
                        //ruby move
                        ruby.move();
                    }
                    //turn left
                    ruby.turnLeft();
                    //while ruby has nothing in front of it, move
                    while(ruby.frontIsClear()){
                        ruby.move();
                    }
                    //turn left
                    ruby.turnLeft();
                    //while ruby has notyhing in front of it, move ruby
                    while(ruby.frontIsClear()){
                    ruby.move();
                }
                    //make ruby face east
                    ruby.turnLeft();
                    ruby.turnLeft();
                }
            }

        }

    }
}
