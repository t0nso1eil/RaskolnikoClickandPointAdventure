import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;


public class ClickableObject {

    public int x;
    public int y;
    public int width;
    public int height;
    public int taken=0;
    public BufferedImage objectImage;
    public BufferedImage backImage;
    public String explanationText;
    public boolean explanationIsOn = false; //открыто окно с пояснительным текстом к объекту
    public ClickableButton closeButton;
    public boolean buttonIsClicked = false;
    public boolean hidden;
    public boolean right;
    public boolean isTaken = false;
    public ClickListener clickListener;

    public ClickableObject(boolean hidden, boolean right, int x, int y, int width, int height, BufferedImage image, BufferedImage paper, String text, ClickListener clickListener) throws IOException {
        this.hidden=hidden;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.objectImage = image;
        this.backImage = paper;
        this.explanationText = text;
        this.clickListener = clickListener;
        this.right=right;
        closeButton = new ClickableButton(530, 380, 150,40,"Понятно", 10, new ClickListener() {
            @Override
            public void handleClick() {
                explanationIsOn = false;
                buttonIsClicked = true;
                taken=1;
            }
        });
    }

    public void draw(Graphics g) {
        g.drawImage(objectImage, x, y, width, height, null);
    }

    public  void drawExplanationOfObject(int way, Graphics g){
        if (explanationIsOn) {
            if(way==0){
                g.drawImage(backImage, 80, 30, 880, 500, null);
                g.setColor(Color.black);
                this.formatBySize(g, explanationText, 300, 150, 350, 600);
                closeButton.drawButton(g);
            }
            if(way==2){
                closeButton.x=670;
                closeButton.y=495;
                g.drawImage(backImage, -145, 15, 1360, 720, null);
                g.setColor(Color.black);
                this.formatBySize(g, explanationText, 145, 150, 350, 600);
                closeButton.drawButton(g);
            }
            if(way==1){
                closeButton.x=670;
                closeButton.y=495;
                g.drawImage(backImage, -145, 15, 1360, 720, null);
                g.setColor(Color.black);
                closeButton.drawButton(g);
            }
        }
    }


    public void checkClick(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        boolean todo = true;
        if (x < this.x || x > this.x + width) {
            todo = false;
        }
        if (y < this.y || y > this.y + height) {
            todo = false;
        }

        if (todo) {
            this.clickListener.handleClick();
            explanationIsOn = true;
        }
    }
    public void formatBySize(Graphics g, String text, int x, int y, int width, int height) {
        Font textFont = new Font("TimesRoman", Font.PLAIN, 15);
        g.setFont(textFont);
        ArrayList<String> strings = new ArrayList<>();
        strings.add(0, "");
        int number = 0;

        for (int i = 0; i <= text.length() - 1; i++) {
            if (text.charAt(i) == ' ') {
                String textpart = text.substring(0, i);
                FontMetrics fm = g.getFontMetrics();
                int stringWidth = fm.stringWidth(textpart);
                strings.set(number, textpart);

                if (stringWidth > width - 120) {
                    text = text.substring(strings.get(number).length() + 1);
                    number = number + 1;
                    strings.add("");
                }
            }
        }
        strings.set(number, text);
        for (int i = 0; i <= strings.size() - 1; i++) {
            g.drawString(strings.get(i), x + 30, y + 40 + i * 20);
        }
    }
}
