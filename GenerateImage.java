import java.util.Random;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class GenerateImage {
    public static void main(String args[]) {
        generate(RandomGenerate.majorMinor(440));
    }
    

public static void generate(double[] song){
//image dimension
int width = song.length/1000;
int height = 400 ;
//create buffered image object img
BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
//file object
File f = null;
//SET BACKGROUND WHITE
  for(int y = 0; y < height; y++){
       for(int x = 0; x < width; x++){
         int a = 255; //alpha
         int r = 255; //red
         int g = 255; //green
         int b = 255; //blue
 
         int p = (a<<24) | (r<<16) | (g<<8) | b; //pixel
         img.setRGB(x, y, p);
       }
     }
//MODIFY TO ADD IN SONG WITH FULL VALUES
     /*
for(int x = 0; x < width; x++){
         int a = 255; //alpha
         int r = 0; //red
         int g = 0; //green
         int b = 0; //blue
 
         int p = (a<<24) | (r<<16) | (g<<8) | b; //pixel
 System.out.println(x);
  System.out.println((int)Math.ceil(200*song[x]));
         img.setRGB(x,200+(int)Math.ceil(200*song[x]), p);
       }
*/
//WITH ROUNDED VALUES
int lineInterval=30;
for(int x = 0; x < width; x+=lineInterval){
double j= ArrayTools.meanArray(ArrayTools.copyArray(song,x,x+lineInterval));
System.out.println(j);
        int a = 255; //alpha
         int r = 0; //red
         int g = 0; //green
         int b = 0; //blue
 
         int p = (a<<24) | (r<<16) | (g<<8) | b; //pixel

if(x+lineInterval<width){
  for(int n=0; n<lineInterval; n++){
     System.out.println(x+n);
  System.out.println((int)Math.ceil(200*j));
         img.setRGB(x+n,200+(int)Math.ceil(200*j), p);
}
}
         
       }

try{
       f = new File("D:\\Image\\Output.png");
       ImageIO.write(img, "png", f);
     }catch(IOException e){
       System.out.println("Error: " + e);
     }
    } 



}