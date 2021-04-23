import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Location {

    ArrayList<ClickableObject> objects;
    ArrayList<OtherHero> otherHeroes;
    ArrayList<ClickableObject> wardrobes;
    BufferedImage background;
    ArrayList<Hiding> hidings;
    int height = 720;
    int width = 960;
    int taken=0;

    public Location(BufferedImage background, ArrayList<ClickableObject> objects, ArrayList<Hiding> hidings, ArrayList<OtherHero> otherHeroes, ArrayList<ClickableObject> wardrobes) {

        this.background = background;
        this.objects = objects;
        this.otherHeroes=otherHeroes;
        this.hidings=hidings;
        this.wardrobes=wardrobes;
    }

    public void buildLocation(Graphics g, Hero hero) throws IOException {
        g.drawImage(background, 0, 0, width, height, null);
        for(int i=0;i<wardrobes.size();i++){
            wardrobes.get(i).draw(g);
        }
        for (int i = 0; i < objects.size(); ++i) {
            taken=taken+objects.get(i).taken;
            if ((!objects.get(i).buttonIsClicked)&&(!objects.get(i).hidden)) {
                objects.get(i).draw(g);
            }
        }
        for(int i=0;i<hidings.size();i++){
            hidings.get(i).draw(g);
        }
        for(int i=0; i<otherHeroes.size(); i++){
            otherHeroes.get(i).drawOtherHero(g);
        }
        hero.drawRaskolnikov(g);
        for (int i=0; i<hidings.size();i++){
            hidings.get(i).drawMessage(g);
        }
        for (int i=0; i<wardrobes.size();i++){
            wardrobes.get(i).drawExplanationOfObject(1,g);
            if(wardrobes.get(i).explanationIsOn){
                for(int j=0; j<objects.size();j++){
                    if((objects.get(j).hidden)&&(!objects.get(j).buttonIsClicked)){
                        objects.get(j).draw(g);
                    }
                }
            }
        }
        for (int i=0;i<objects.size();i++){
            objects.get(i).drawExplanationOfObject(0,g);
        }
    }
}

