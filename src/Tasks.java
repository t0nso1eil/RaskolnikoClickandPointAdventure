import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tasks {

    BufferedImage tasksImage;
    boolean tasksAreActive = false;
    ClickableButton openTasksButton = new ClickableButton(810, 5, 150, 40, "Задания", 22, new ClickListener() {
        @Override
        public void handleClick() {
            tasksAreActive = true;
        }
    });
    ClickableButton closeTasksButton = new ClickableButton(490, 540, 150, 40,"Закрыть",10, new ClickListener() {
        @Override
        public void handleClick() {
            tasksAreActive = false;
        }
    });

    public Tasks() throws IOException {
        tasksImage = ImageIO.read(Tasks.class.getResourceAsStream("tasksList.png"));
    }

    public void drawTasks(Graphics g) {
        if (tasksAreActive) {
            g.drawImage(tasksImage, 90, 0, 800, 800, null);
            closeTasksButton.drawButton(g);
        }
    }
}

