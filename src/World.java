import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class World extends JPanel implements MouseListener {

    Hero hero;
    Tasks tasks;
    AllLocationsConnect allLocationsConnect;
    Location location;
    Inventory inventory;
    ClickableObject startButton;
    BufferedImage backImage;
    String endingText;

    boolean finalIsOn =false;
    int changeIsNeed =0;
    int numberOfFinalChoice=0;
    int rightNumber =0;
    int whereIsHidden=0;
    boolean finish =false;
    int ending;
    boolean endingIsOn=false;

    public World(Hero hero, AllLocationsConnect map, Inventory inventory, Tasks tasks, ClickableObject start) throws IOException {
        this.backImage = ImageIO.read(World.class.getResourceAsStream("backMessage.png"));
        this.startButton =start;
        this.hero=hero;
        this.tasks=tasks;
        this.allLocationsConnect =map;
        this.inventory=inventory;
        this.location=hero.location;
        this.addMouseListener(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        location.buildLocation(g,hero);
        for(int i =0; i<location.otherHeroes.size();i++){
            location.otherHeroes.get(i).drawOtherHero(g);
        }
        allLocationsConnect.openMapButton.drawButton(g);
        inventory.openInventoryButton.drawButton(g);
        tasks.openTasksButton.drawButton(g);
        if (allLocationsConnect.mapIsActive) {
            allLocationsConnect.drawLocationChange(g);
        }
        inventory.drawInventory(g);
        for(int i=0; i<location.otherHeroes.size(); i++) {
            if (location.otherHeroes.get(i).y + location.otherHeroes.get(i).height >= hero.yHero + hero.height) {
                location.otherHeroes.get(i).drawOtherHero(g);
            }
        }
        inventory.changeContent();
        tasks.drawTasksList(g);
        hero.updateHero();
        for(int i=0;i<location.hidings.size();i++){
            if(location.hidings.get(i).inPlace){
                for(int j=0; j<inventory.objects.size();j++) {
                    inventory.objects.remove(j);
                }
                location.hidings.get(i).inPlace=false;

            }
            if(location.hidings.get(i).buttonIsClicked){
                whereIsHidden=location.hidings.get(i).number;
            }
        }
        for(int i=0; i<location.otherHeroes.size(); i++) {
            if(location.otherHeroes.get(i).talking&&location.otherHeroes.get(i).changeIsNeed &&location.otherHeroes.get(i).dialogues.size()!=0){
                location.otherHeroes.get(i).dialogues.get(location.otherHeroes.get(i).nowActiveDialogue).drawDialogueBox(g);
            }
        }
        rightNumber =0; //считаем количество верных объектов
        for(int i=0;i<inventory.objects.size();i++){
            if(inventory.objects.get(i).isTaken &&inventory.objects.get(i).right){
                rightNumber = rightNumber +1;
            }
        }
        System.out.println(rightNumber);
        if(!startButton.buttonIsClicked){
            g.setColor(new Color(40, 92, 89));
            g.fillRect(-10,-10,1000,800);
            startButton.draw(g);
            startButton.drawObjectExplanation(2,g);
            if(!startButton.explanationIsOn ){
                g.setColor(Color.black);
                this.writeInRect(g,"Начать",360,320,150);
            }
        }
        if(finalIsOn){
            g.setColor(Color.white);
            g.fillRect(0, 620 - 40, 720, 100);
            g.setColor(Color.black);
            this.writeInRect(g,"И кто же преступник, Родион Романович?", 10,620-30,720);
        }
        if(finish){
            g.setColor(Color.white);
            g.fillRect(0, 620 - 40, 960, 100);
            g.setColor(Color.black);
            this.writeInRect(g,"Миколка", 20, 600,150);
            this.writeInRect(g,"Разумихин",200,600,150);
            this.writeInRect(g,"Сознаться",370,600,150);
        }
        if(endingIsOn){
            if(ending==0){
                g.setColor(new Color(40, 92, 89));
                g.fillRect(-10,-10,1000,800);
                g.drawImage(backImage, -210, 0, 1500, 900, null);
                g.setColor(Color.black);
                this.writeInRect(g, endingText, 90, 150, 400);
            }
            if(ending==1){
                g.setColor(new Color(40, 92, 89));
                g.fillRect(-10,-10,1000,800);
                g.drawImage(backImage, -210, 0, 1500, 900, null);
                g.setColor(Color.black);
                this.writeInRect(g, endingText, 90, 150, 400);
            }
            if(ending==2){
                g.setColor(new Color(40, 92, 89));
                g.fillRect(-10,-10,1000,800);
                g.drawImage(backImage, -210, 0, 1500, 900, null);
                g.setColor(Color.black);
                this.writeInRect(g, endingText, 90, 150, 400);
            }
            if(ending==3){
                g.setColor(new Color(40, 92, 89));
                g.fillRect(-10,-10,1000,800);
                g.drawImage(backImage, -210, 0, 1500, 900, null);
                g.setColor(Color.black);
                this.writeInRect(g, endingText, 90, 150, 400);
            }
            if(ending==4){
                g.setColor(new Color(40, 92, 89));
                g.fillRect(-10,-10,1000,800);
                g.drawImage(backImage, -210, 0, 1500, 900, null);
                g.setColor(Color.black);
                this.writeInRect(g, endingText, 90, 150, 400);
            }
            if(ending==5){
                g.setColor(new Color(40, 92, 89));
                g.fillRect(-10,-10,1000,800);
                g.drawImage(backImage, -210, 0, 1500, 900, null);
                g.setColor(Color.black);
                this.writeInRect(g, endingText, 90, 150, 400);
            }
            if(ending==6){
                g.setColor(new Color(40, 92, 89));
                g.fillRect(-10,-10,1000,800);
                g.drawImage(backImage, -210, 0, 1500, 900, null);
                g.setColor(Color.black);
                this.writeInRect(g, endingText, 90, 150, 400);
            }
            if(ending==7){
                g.setColor(new Color(40, 92, 89));
                g.fillRect(-10,-10,1000,800);
                g.drawImage(backImage, -210, 0, 1500, 900, null);
                g.setColor(Color.black);
                this.writeInRect(g, endingText, 90, 150, 400);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!startButton.explanationIsOn){
            startButton.checkClick(e);
        } else {
            startButton.closeButton.checkClick(e);
        }
        for (int i=0;i<location.hidings.size();i++){
            location.hidings.get(i).checkClick(e);
            if(location.hidings.get(i).explanationIsOn){
                location.hidings.get(i).closeButton.checkClick(e);
            }
        }

        for (int i = 0; i < location.objects.size(); ++i) {
            if (!location.objects.get(i).buttonIsClicked) {
                location.objects.get(i).checkClick(e);
                if (location.objects.get(i).explanationIsOn) {
                    location.objects.get(i).closeButton.checkClick(e);
                }
                if (location.objects.get(i).buttonIsClicked && !location.objects.get(i).isTaken) {
                    inventory.objects.add(location.objects.get(i));
                    location.objects.get(i).isTaken = true;
                }
            }
        }
        for(int i=0;i<location.wardrobes.size();i++){
            location.wardrobes.get(i).checkClick(e);
            if(location.wardrobes.get(i).explanationIsOn){
                location.wardrobes.get(i).closeButton.checkClick(e);
                for (int j=0;j<location.objects.size();j++){
                    if(location.objects.get(j).hidden){
                        location.objects.get(j).checkClick(e);
                        if (location.objects.get(j).explanationIsOn) {
                            location.objects.get(j).closeButton.checkClick(e);
                        }
                    }
                }
            }
        }

        if (inventory.objects.size() != 0 && inventory.inventoryIsOn) {
            for (int i = 0; i < inventory.objects.size(); ++i) {
                if(!inventory.objects.get(i).hidden) {
                    inventory.objects.get(i).checkClick(e);
                    if (inventory.objects.get(i).explanationIsOn) {
                        inventory.objects.get(i).closeButton.checkClick(e);
                    }
                }
            }
        }

        allLocationsConnect.openMapButton.checkClick(e);
        inventory.openInventoryButton.checkClick(e);
        tasks.openTasksButton.checkClick(e);

        if(tasks.tasksAreActive){
            tasks.closeTasksButton.checkClick(e);
        }
        if (inventory.inventoryIsOn) {
            inventory.closeInventoryButton.checkClick(e);
        }
        if (allLocationsConnect.mapIsActive) {
            allLocationsConnect.changeLocation(e);
            location = allLocationsConnect.locations[allLocationsConnect.nowHeroIsAt];
        }
        if(finalIsOn){
            if(e.getX()>=0&&e.getX()<=720&&e.getY()>=620 - 40&&e.getY()<=720){
                changeIsNeed =1;
            }
        }
        if(finish){
            if(e.getX()>=20&&e.getX()<=170&&e.getY()>=590&&e.getY()<=650){
                numberOfFinalChoice=1;
                endingIsOn=true;
            }
            if(e.getX()>=170&&e.getX()<=320&&e.getY()>=590&&e.getY()<=650){
                numberOfFinalChoice=2;
                endingIsOn=true;
            }
            if(e.getX()>=320&&e.getX()<=470&&e.getY()>=590&&e.getY()<=650){
                numberOfFinalChoice=3;
                endingIsOn=true;
            }
        }

        for(int i = 0; i< location.otherHeroes.size(); ++i) {
            if(location.otherHeroes.get(i).talking && location.otherHeroes.get(i).dialogues.size() !=0 ) {
                location.otherHeroes.get(i).dialogues.get(location.otherHeroes.get(i).nowActiveDialogue).checkClick(e);
            }
        }

        for (int i = 0; i < location.otherHeroes.size(); ++i) {
            if (location.otherHeroes.get(i).x < hero.xHero + 300 && location.otherHeroes.get(i).x > hero.xHero - 300) {
                location.otherHeroes.get(i).checkClick(e);
                location.otherHeroes.get(i).talking = true;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void writeInRect(Graphics g, String text, int x, int y, int width) {
        Font f = new Font("TimesRoman", Font.PLAIN, 15);
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

                if (stringWidth > width - 120) {
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
