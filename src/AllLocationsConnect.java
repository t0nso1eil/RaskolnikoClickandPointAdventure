import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class AllLocationsConnect {

    Location[] locations;
    int nowHeroIsAt; //номер локации, в которой в данный момент находится игрок
    boolean mapIsActive = false; //открыто окно для переключения локаций или нет
    ClickableButton openMapButton = new ClickableButton(660, 5, 150, 40, "Карта",15,new ClickListener() {
        @Override
        public void handleClick() {
            mapIsActive = true;
        }
    });

    public AllLocationsConnect(Location[] locations) throws IOException {
        this.locations = locations;
        nowHeroIsAt = 0;
    }

    public void drawLocationChange(Graphics g) {
        g.setColor(new Color(93, 167, 157));
        g.fillRect(280, 150, 360, 420);
        g.setColor(Color.white);
        g.drawRect(310, 180, 300, 60);
        g.drawRect(310, 240, 300, 60);
        g.drawRect(310, 300, 300, 60);
        g.drawRect(310, 360, 300, 60);
        g.drawRect(310, 420, 300, 60);
        g.drawRect(310, 480, 300, 60);
        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString("Ваша комната", 373, 210);
        g.drawString("Лестничный пролет", 357, 270);
        g.drawString("Квартира Мармеладовых", 337, 330);
        g.drawString("Двор-колодец", 369, 390);
        g.drawString("Квартира Дмитрия", 354, 450);
        g.drawString("Контора Порфирия", 354, 510);
    }


    public void changeLocation(MouseEvent e) {
        if (e.getX() > 310 && e.getX() < 610 && e.getY() > 180 && e.getY() < 240) {
            nowHeroIsAt = 0;
            mapIsActive = false;
        }
        if (e.getX() > 310 && e.getX() < 610 && e.getY() > 240 && e.getY() < 300) {
            nowHeroIsAt = 1;
            mapIsActive = false;
        }
        if (e.getX() > 310 && e.getX() < 610 && e.getY() > 300 && e.getY() < 360) {
            nowHeroIsAt = 2;
            mapIsActive = false;
        }
        if (e.getX() > 310 && e.getX() < 610 && e.getY() > 360 && e.getY() < 420) {
            nowHeroIsAt = 3;
            mapIsActive = false;
        }
        if (e.getX() > 310 && e.getX() < 610 && e.getY() > 420 && e.getY() < 480) {
            nowHeroIsAt = 4;
            mapIsActive = false;
        }
        if (e.getX() > 310 && e.getX() < 610 && e.getY() > 480 && e.getY() < 540) {
            nowHeroIsAt = 5;
            mapIsActive = false;
        }
    }
}
