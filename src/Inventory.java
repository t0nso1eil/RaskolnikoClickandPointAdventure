import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Inventory {
    ArrayList<ClickableObject> objects;
    BufferedImage backImage;
    boolean inventoryIsOn = false; //открыто ли окно инвентаря
    ClickableButton openInventoryButton = new ClickableButton(510, 5,150,40, "Инвентарь", 22, new ClickListener() {
        @Override
        public void handleClick() {
            inventoryIsOn = true;
        }
    });

    ClickableButton closeInventoryButton = new ClickableButton(440, 480, 150,40,"Закрыть", 10, new ClickListener() {
        @Override
        public void handleClick() {
            inventoryIsOn = false;
        }
    });

    public Inventory(ArrayList<ClickableObject> objects) throws IOException {
        this.objects = objects;
        backImage = ImageIO.read(Inventory.class.getResourceAsStream("backMessage.png"));
    }

    public void drawInventory(Graphics g) {
        if (inventoryIsOn) {
            g.drawImage(backImage, 0, 80, 800, 600, null);
            closeInventoryButton.drawButton(g);
            if (objects.size() != 0) {
                for (int i = 0; i < objects.size(); ++i) {
                    objects.get(i).draw(g);
                }
                for (int i = 0; i < objects.size(); ++i) {
                    objects.get(i).drawExplanationOfObject(0,g);
                }
            }
        }
    }

    public void changeContent() {
        for (int i = 0; i<objects.size(); ++i) {
            objects.get(i).width = 60;
            objects.get(i).height = 60;
            if (i % 2 == 0) {
                objects.get(i).x = 180;
                objects.get(i).y = 210 + 120*i/2 ;
            } else {
                objects.get(i).x = 300;
                objects.get(i).y = 210 + 120*(i-1)/2;
            }
        }
    }
}


