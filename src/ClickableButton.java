import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ClickableButton {
    int x;
    int y;
    public int width;
    public int height;
    public String buttonText;
    public boolean clicked=false;
    public int textBorders = 5;
    public BufferedImage buttonImage;
    public ClickListener clickListener;

    public ClickableButton(int x, int y, int width, int height, String text,int xtext, ClickListener clickListener) throws IOException {
        buttonImage = ImageIO.read(ClickableObject.class.getResourceAsStream("buttonImage.png"));
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.buttonText = text;
        this.textBorders = xtext;
        this.clickListener = clickListener;
    }

    public void drawButton(Graphics g) {
        g.drawImage(buttonImage,x,y,width,height,null);
        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString(buttonText,x+ textBorders,y+27);
    }

    public void checkClick(MouseEvent e) {
        int xx = e.getX();
        int yy = e.getY();
        boolean todo = true;
        if(xx<x || xx>x + width) {
            todo = false;
        }
        if(yy<y || yy>y + height) {
            todo = false;
        }

        if(todo) {
            clicked=true;
            this.clickListener.handleClick();
        }
    }
}
