import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Hero {

    Direction direction;
    BufferedImage rascolnikovImage;
    BufferedImage rascolnikovImage1;
    public int width=264;
    public int height=470;
    public double xHero;
    public double yHero;
    Location location;
    Controller controller = new Controller(this);

    public void imageOfRascolnikov() throws IOException {
        this.rascolnikovImage = ImageIO.read(Hero.class.getResourceAsStream("raskolnikov1.png"));
        this.rascolnikovImage1 = ImageIO.read(Hero.class.getResourceAsStream("raskolnikov.png"));
    }

    public Hero(double xHero, double yHero, Location location) throws IOException {
        this.xHero=xHero;
        this.yHero=yHero;
        this.location=location;
        imageOfRascolnikov();
    }

    public void updateHero(){
        if(yHero+height>=220){
            if(controller.pressed){
                xHero=xHero+ direction.dx;
                yHero=yHero+direction.dy;
                controller.pressed=false;
            }
        } else {
            yHero=yHero+1;
        }
    }

    public void drawRaskolnikov(Graphics g){
        if(direction==Direction.RIGHT){
            g.drawImage(rascolnikovImage, (int)xHero,(int)yHero, width,height, null);
        } else {
            g.drawImage(rascolnikovImage1, (int)xHero,(int)yHero, width,height, null);
        }
    }
}

