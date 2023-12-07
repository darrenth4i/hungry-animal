import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public int score = 0;
    Label scoreLabel;
    private long endTimer;
    private boolean ended = false;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 200);
        
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 20, 30);
        
        createApple();
    }
    
    //Method to increase the score by 1
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
    }
    
    //End the game when the apple falls too far down
    public void gameOver(){
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
        ended = true;
        endTimer = System.currentTimeMillis();
    }    
    
    public void act() {
        if (ended && System.currentTimeMillis() - endTimer > 2000) {
            Greenfoot.setWorld(new MyWorld());
        }
    }
    
    //Create an apple in a random x-value at the top
    public void createApple(){
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
}
