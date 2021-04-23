import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class OtherHero {

    public double x;
    public double y;
    public double width;
    public double height;
    public BufferedImage otherHeroImage;
    ArrayList <Dialogue> dialogues;
    int nowActiveDialogue;
    boolean changeIsNeed =false;
    boolean talking=false;

    public OtherHero(double x, double y, double width, double height, BufferedImage otherheroimage, ArrayList <Dialogue> dialogues) throws IOException {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.dialogues=dialogues;
        this.otherHeroImage =otherheroimage;
        nowActiveDialogue =0;
    }
    public void drawOtherHero(Graphics g) {
        g.drawImage(this.otherHeroImage, (int) x, (int) y, (int) width, (int) height, null);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        if (dialogues.size() != 0 && dialogues.get(nowActiveDialogue).dialogueIsOver) {
            talking = false;
            changeIsNeed = false;
            if (dialogues.size() > nowActiveDialogue + 1)
                nowActiveDialogue = nowActiveDialogue + 1; //переключение диалогов к массиве
        }
    }


    public void checkClick(MouseEvent e) {
        int xx = e.getX();
        int yy = e.getY();
        if(xx>=x && xx<=x+width && yy>=y && yy <= y + height) {
            changeIsNeed = true;
            System.out.println("eeeee");
        }
    }

}

