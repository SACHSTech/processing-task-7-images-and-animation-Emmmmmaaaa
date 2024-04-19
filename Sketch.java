import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	
  PImage imgPig; 
  PImage imgSky;

  float fltPigX = 200;
  float fltPigY = 200;
  float fltPigSpeed = 2; 
  float fltPigDirectionX = -1; 
  float fltPigDirectionY = -1; 

  float fltSqrX = width/2;
  float fltSqrY = width/2; 
  float fltSqrSpeed = 5; 
  float fltSqrDirectionX = -1; 
  float fltSqrDirectionY = -1; 

  public void settings() {
	// put your size call here
    size(400, 400);

  }

  public void setup() {
    background(0);

    imgSky = loadImage("/images/Sky.jpg");
    imgSky.resize(width, height);
    imgPig = loadImage("/images/pig_001.png"); 
    imgPig.resize(imgPig.width/2,imgPig.height/2);

  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    image(imgSky, 0, 0);

    image(imgPig, fltPigX, fltPigY); 
    fltPigX = fltPigX + (fltPigDirectionX*fltPigSpeed);
    if (fltPigX < 0 || fltPigX > width - imgPig.width){
      fltPigDirectionX = fltPigDirectionX * -1; 
    }
    fltPigY = (float)0.02 * (float)Math.pow(fltPigX - 125, 2); 
    fltPigY = fltPigY + (fltPigDirectionY*fltPigSpeed);
    if (fltPigY < 0 || fltPigY > height - imgPig.height){
      fltPigDirectionY = fltPigDirectionY * -1; 
    }

    fill(255,0,0); 
    rect(fltSqrX, fltSqrY, 50, 50);
      fltSqrX = fltSqrX + (fltSqrDirectionX*fltSqrSpeed);
    if (fltSqrX < 0 || fltSqrX > width - 50){
      fltSqrDirectionX *= -1; 
    }

    fltSqrY = fltSqrY + (fltSqrDirectionY*fltSqrSpeed);
    if (fltSqrY < 0 || fltSqrY > height - 50){
      fltSqrDirectionY *= -1; 
    }
  }
  
  // define other methods down here.
}