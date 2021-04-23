import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Hiding {

    public int x0;
    public int y0;
    public int width;
    public int height;
    public int number;

    public BufferedImage hidingImage;
    public BufferedImage backImage;
    public String explanationText;
    public boolean explanationIsOn = false; //открыто пояснение к сокрытию объектов
    public ClickableButton closeButton;

    public boolean buttonIsClicked = false;
    public boolean inPlace = false; //объект убран в шкаф, ящик и тд

    public ClickListener clickListener;

    public Hiding(int number,int x0, int y0, int width, int height, BufferedImage image, String text, ClickListener clickListener) throws IOException {
        backImage= ImageIO.read(Hiding.class.getResourceAsStream("backMessage.png"));
        this.x0 = x0;
        this.y0 = y0;
        this.width = width;
        this.height = height;
        this.hidingImage = image;
        this.explanationText = text;
        this.number=number;
        this.clickListener = clickListener;
        closeButton = new ClickableButton(530, 380, 150, 40, "Спрятать", 10,new ClickListener() {
            @Override
            public void handleClick() {
                explanationIsOn = false;
                buttonIsClicked = true;
                inPlace=true;
            }
        });
    }

    public void draw(Graphics g) {
        g.drawImage(hidingImage, x0, y0, width, height, null);
    }

    public  void drawHidingExplanation(Graphics g){
        if (explanationIsOn) {
            g.drawImage(backImage, 80, 30, 880, 500, null);
            g.setColor(Color.black);
            this.formatBySize(g, explanationText, 280, 150, 400);
            closeButton.drawButton(g);
        }
    }

    public void checkClick(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        boolean todo = true;
        if (x < x0 || x > x0 + width) {
            todo = false;
        }
        if (y < y0 || y > y0 + height) {
            todo = false;
        }
        if (todo) {
            this.clickListener.handleClick();
            explanationIsOn = true;
        }
    }
    public void formatBySize(Graphics g, String text, int x, int y, int width) {
        Font f = new Font("TimesRoman", Font.PLAIN, 20);
        g.setFont(f);
        ArrayList<String> strings = new ArrayList<>();
        strings.add(0, "");
        int n = 0;

        for (int i = 0; i <= text.length() - 1; i++) {
            if (text.charAt(i) == ' ') {
                String textpart = text.substring(0, i);
                FontMetrics fm = g.getFontMetrics();
                int stringWidth = fm.stringWidth(textpart);
                strings.set(n, textpart);

                if (stringWidth > width - 100) {
                    text = text.substring(strings.get(n).length() + 1);
                    n = n + 1;
                    strings.add("");
                }
            }
        }
        strings.set(n, text);
        for (int i = 0; i <= strings.size() - 1; i++) {
            g.drawString(strings.get(i), x + 30, y + 40 + i * 20);
        }
    }
}

