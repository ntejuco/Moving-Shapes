/*
 * ===============================================================================
 * MovingLogo.java : A shape that is a car logo.
 * A logo has 4 handles shown when it is selected (by clicking on it).
 * 
 * Name: Nathan Novakowski-Tejuco
 * UPI: nnov539
 * ID: 6300573
 * ===============================================================================
 */
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
public class MovingLogo extends MovingShape {
  
  BufferedImage logoImage;

 /** constuctor to create a rectangle with default values
  */
 public MovingLogo() {
  super();
 }

 /** constuctor to create a car logo shape
  */
 public MovingLogo(int x, int y, int w, int h,  int mw, int mh, int pathType, Color fillColor, Color borderColor) {
  super(x ,y ,w, h ,mw ,mh ,pathType ,fillColor ,borderColor);
 }

 /** draw the logo with the fill colour
  * If it is selected, draw the handles
  * @param g the Graphics control
  */
 public void draw(Graphics g) {
   try{
   logoImage = ImageIO.read(new File("logo.gif"));
   } catch (IOException e){
   System.out.print(e);
   }
   g.drawImage(logoImage, p.x, p.y, width, height, currentFillColor, null);
   g.setColor(currentBorderColor);
   g.drawRect(p.x, p.y, width, height);
   drawHandles(g);
 }

 /** Returns whether the point is in the logo or not
  * @return true if and only if the point is in the rectangle, false otherwise.
  */
 public boolean contains(Point mousePt) {
  return (p.x <= mousePt.x && mousePt.x <= (p.x + width + 1) && p.y <= mousePt.y && mousePt.y <= (p.y + height + 1));
 }
}