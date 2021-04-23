import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame( "RaskolnikovClickAndPoint");

        BufferedImage paper = ImageIO.read(Main.class.getResourceAsStream("backMessage.png"));
        BufferedImage porfiriy= ImageIO.read(Main.class.getResourceAsStream("porfiriy.png"));
        BufferedImage zosimov= ImageIO.read(Main.class.getResourceAsStream("zosimov.png"));
        BufferedImage razumihin= ImageIO.read(Main.class.getResourceAsStream("razumihin.png"));
        BufferedImage sonechka=ImageIO.read(Main.class.getResourceAsStream("sonechka.png"));

        ClickableObject start = new ClickableObject(false,false,330, 310, 200, 100, ImageIO.read(Main.class.getResourceAsStream("buttonImage.png")), paper, "60-е годы XIX в. Бедный район Петербурга, примыкающий к Сенной площади и Екатерининскому каналу. Вы, бывший студент Родион Раскольников, проспали до трех часов дня. Проснувшись, Вы вспоминаете о содеянном: вчера в седьмом часу Вы убили старуху-процентщицу и ее сестру, Лизаветку. Вам удалось уйти незамеченным, но Вы можете входить в список подозреваемых в качестве одного из тех, кто оставлял у нее залог. Хозяйка квартиры, обеспокоенная Вашим состоянием, вызывала юного врача, студента Зосимова. Также Ваш товарищ Разумихин уже ждет Вас у себя в гостях. Однако Вас ждет в своей конторе следователь по делу старухи - Порфирий Петрович. (Дисклеймер: события книги и игры не совпадают, так как это иной ход событий, а именно: что было бы, если бы Раскольникова не мучала совесть за содеянное)", new ClickListener() {
            @Override
            public void handleClick() {}
        });

        ArrayList<ClickableObject> objectsInFirstLocation = new ArrayList<>();
        ArrayList<ClickableObject> objectsInSecondLocation = new ArrayList<>();
        ArrayList<ClickableObject> objectsEmptyVersion=new ArrayList<>();

        ArrayList<ClickableObject> wardrobesInFirstLocation=new ArrayList<>();
        ArrayList<ClickableObject> wardrobesInSecondLocation=new ArrayList<>();
        ArrayList<ClickableObject> wardrobesEmptyVersion=new ArrayList<>();

        objectsInFirstLocation.add(0,new ClickableObject(false,false,550, 250, 80, 80,
                ImageIO.read(Main.class.getResourceAsStream("boots.png")),
                paper,"Вы нашли ботинки. Убедитесь, что больше не осталось вещей, указывающих на вашу причастность", new ClickListener() {
            @Override
            public void handleClick() {
                System.out.println("!!!!!");
            }
        }));
        objectsInFirstLocation.add(1,new ClickableObject(true,false,180, 180, 80, 80,
                ImageIO.read(Main.class.getResourceAsStream("hanky.png")),
                paper,"Вы нашли платок. Убедитесь, что больше не осталось вещей, указывающих на вашу причастность", new ClickListener() {
            @Override
            public void handleClick() {
                System.out.println("!!!!!");
            }
        }));
        objectsInFirstLocation.add(2,new ClickableObject(true,false,280, 180, 80, 80,
                ImageIO.read(Main.class.getResourceAsStream("books.png")),
                paper,"Вы нашли стопку книг. Убедитесь, что больше не осталось вещей, указывающих на вашу причастность", new ClickListener() {
            @Override
            public void handleClick() {
                System.out.println("!!!!!");
            }
        }));
        objectsInFirstLocation.add(3,new ClickableObject(true,false,380, 180, 80, 80,
                ImageIO.read(Main.class.getResourceAsStream("ashtray.png")),
                paper,"Вы нашли пепельницу. Убедитесь, что больше не осталось вещей, указывающих на вашу причастность", new ClickListener() {
            @Override
            public void handleClick() {
                System.out.println("!!!!!");
            }
        }));
        objectsInFirstLocation.add(4,new ClickableObject(true,true,480, 180, 80, 80,
                ImageIO.read(Main.class.getResourceAsStream("earrings.png")),
                paper,"Вы нашли серьги. Убедитесь, что больше не осталось вещей, указывающих на вашу причастность", new ClickListener() {
            @Override
            public void handleClick() {
                System.out.println("!!!!!");
            }
        }));

        objectsInSecondLocation.add(0,new ClickableObject(true,true,180, 180, 80, 80,
                ImageIO.read(Main.class.getResourceAsStream("axe.png")),paper , "Вы нашли топор. Убедитесь, что больше не осталось вещей, указывающих на вашу причастность", new ClickListener() {
            @Override
            public void handleClick() {
                System.out.println("!!!!!");
            }
        }));
        objectsInSecondLocation.add(1,new ClickableObject(true,true,283, 180, 75, 80,
                ImageIO.read(Main.class.getResourceAsStream("watch.png")),
                paper,"Вы нашли часы. Убедитесь, что больше не осталось вещей, указывающих на вашу причастность", new ClickListener() {
            @Override
            public void handleClick() {
                System.out.println("!!!!!");
            }
        }));
        objectsInSecondLocation.add(2,new ClickableObject(true,false,380, 180, 80, 80,
                ImageIO.read(Main.class.getResourceAsStream("wallet.png")),
                paper,"Вы нашли кошелек. Убедитесь, что больше не осталось вещей, указывающих на вашу причастность", new ClickListener() {
            @Override
            public void handleClick() {
                System.out.println("!!!!!");
            }
        }));
        objectsInSecondLocation.add(3,new ClickableObject(true,false,480, 187, 100, 41,
                ImageIO.read(Main.class.getResourceAsStream("glasses.png")),
                paper,"Вы нашли очки. Убедитесь, что больше не осталось вещей, указывающих на вашу причастность", new ClickListener() {
            @Override
            public void handleClick() {
                System.out.println("!!!!!");
            }
        }));

        wardrobesInFirstLocation.add(0,new ClickableObject(false, false,607, 70, 533, 400, ImageIO.read(Main.class.getResourceAsStream("wardrobeHiding1.png")), paper, "111111", new ClickListener() {
            @Override
            public void handleClick() {
                System.out.println("clicked");
            }
        }));
        wardrobesInSecondLocation.add(0,new ClickableObject(false,false, 405, 75, 360, 360, ImageIO.read(Main.class.getResourceAsStream("drawer.png")), paper, "111111", new ClickListener() {
            @Override
            public void handleClick() {
                System.out.println("clicked");
            }
        }));

        ArrayList<Hiding> hidingsEmptyVersion = new ArrayList<>();
        ArrayList<Hiding> hidings4 = new ArrayList<>();
        ArrayList<Hiding> hidings5 = new ArrayList<>();

        hidings4.add(0,new Hiding(1,680,185,315,325,ImageIO.read(Main.class.getResourceAsStream("dumpster.png")),"Вы можете спятать улики здесь. Это мусорка под окноами Вашей квартиры. Этот выбор повлияет на историю.",new ClickListener() {
            @Override
            public void handleClick() {
                System.out.println("eeeeeee");
            }
        }));
        hidings5.add(0,new Hiding(2,-130, 145, 453, 340, ImageIO.read(Main.class.getResourceAsStream("wardrobeHiding.png")), "Вы можете спрятать улики в шкафу. Это шкаф в квартире Разумихина. Этот выбор повлияет на историю.", new ClickListener() {
            @Override
            public void handleClick() {
                System.out.println("eeeeeee");
            }
        }));

        ArrayList<Dialogue> dialogueofporfiriy=new ArrayList<>();
        ArrayList<Dialogue> dialogueofzosimov=new ArrayList<>();
        ArrayList<Dialogue> dialogueofrazumihin=new ArrayList<>();
        ArrayList<Dialogue> dialogueofsonechka=new ArrayList<>();

        dialogueofporfiriy.add(new Dialogue(1));
        dialogueofporfiriy.get(0).scanText("raskolnikovAndPorfiriy.txt");

        dialogueofzosimov.add(new Dialogue(0));
        dialogueofzosimov.get(0).scanText("raskolnikovAndZosimov.txt");

        dialogueofrazumihin.add(new Dialogue(1));
        dialogueofrazumihin.get(0).scanText("raskolnikovAndRazumihin.txt");
        dialogueofrazumihin.add(new Dialogue(1));
        dialogueofrazumihin.get(1).scanText("raskolnikovAndRazumihin1.txt");
        dialogueofrazumihin.add(new Dialogue(1));
        dialogueofrazumihin.get(2).scanText("raskolnikovAndRazumihinAfterHiding.txt");
        dialogueofrazumihin.add(new Dialogue(1));
        dialogueofrazumihin.get(3).scanText("raskolnikovAndSonechkaAndRazumihin.txt");
        dialogueofrazumihin.add(new Dialogue(0));
        dialogueofrazumihin.get(4).scanText("raskolnikovAndSonechkaAndRazumihin1.txt");
        dialogueofrazumihin.add(new Dialogue(0));
        dialogueofrazumihin.get(5).scanText("raskolnikovAndSonechkaAndRazumihin2.txt");

        dialogueofsonechka.add(new Dialogue(1));
        dialogueofsonechka.get(0).scanText("raskolnikovAndSonechka.txt");
        dialogueofsonechka.add(new Dialogue(1));
        dialogueofsonechka.get(1).scanText("raskolnikovAndSonechka1.txt");

        OtherHero porfiriyHero = new OtherHero(500, 200, 176, 470, porfiriy,dialogueofporfiriy);
        OtherHero zosimovHero=new OtherHero(200,190,123,430,zosimov,dialogueofzosimov);
        OtherHero razumihinHero=new OtherHero(260,190,179,445,razumihin,dialogueofrazumihin);
        razumihinHero.nowActiveDialogue =0;
        OtherHero sonechkaHero=new OtherHero(70,275,236,420,sonechka,dialogueofsonechka);

        ArrayList<OtherHero> otherHeroesInFirstLocation= new ArrayList<>();
        ArrayList<OtherHero> otherHeroesInSecondLocation=new ArrayList<>();
        ArrayList<OtherHero> otherHeroesInThirdLocation=new ArrayList<>();
        ArrayList<OtherHero> otherHeroesInFourthLocation=new ArrayList<>();
        ArrayList<OtherHero> otherHeroesInFifthLocation=new ArrayList<>();
        ArrayList<OtherHero> otherHeroesInSixthLoaction=new ArrayList<>();

        otherHeroesInSecondLocation.add(zosimovHero);
        otherHeroesInThirdLocation.add(sonechkaHero);
        otherHeroesInSixthLoaction.add(porfiriyHero);
        otherHeroesInFifthLocation.add(razumihinHero);

        Location[] locations= new Location[6];
        locations[0] = new Location(ImageIO.read(Main.class.getResourceAsStream("raskolnikovRoom.jpg")), objectsInFirstLocation, hidingsEmptyVersion, otherHeroesInFirstLocation, wardrobesInFirstLocation );
        locations[1] = new Location(ImageIO.read(Main.class.getResourceAsStream("stairWell.jpg")),objectsInSecondLocation, hidingsEmptyVersion, otherHeroesInSecondLocation,wardrobesInSecondLocation);
        locations[2] = new Location(ImageIO.read(Main.class.getResourceAsStream("sonechkaRoom.jpg")),objectsEmptyVersion, hidingsEmptyVersion, otherHeroesInThirdLocation,wardrobesEmptyVersion);
        locations[3] = new Location( ImageIO.read(Main.class.getResourceAsStream("outdoors.jpg")),objectsEmptyVersion, hidings4, otherHeroesInFourthLocation,wardrobesEmptyVersion);
        locations[4] = new Location( ImageIO.read(Main.class.getResourceAsStream("razumihinRoom.jpg")),objectsEmptyVersion,hidings5,otherHeroesInFifthLocation,wardrobesEmptyVersion);
        locations[5] = new Location(ImageIO.read(Main.class.getResourceAsStream("office.jpg")),objectsEmptyVersion,hidingsEmptyVersion,otherHeroesInSixthLoaction,wardrobesEmptyVersion);
        AllLocationsConnect allLocationsConnect=new AllLocationsConnect(locations);
        Inventory inventory = new Inventory(new ArrayList<>());

        Hero hero=new Hero(90, 200,allLocationsConnect.locations[allLocationsConnect.nowHeroIsAt]);
        MyPanel myPanel= new MyPanel(hero, allLocationsConnect, inventory, new Tasks(), start);
        frame.add(myPanel);
        frame.setSize(960+15, 720);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        boolean zosimovGoesToRoom=false;
        boolean zosimovLeavesRoom=false;
        boolean heroesAreInFirstLocation=false;
        boolean razumihinLeaves=false;
        boolean sonechkaLeaves=false;

        while(true) {
            frame.repaint();
            if(!(allLocationsConnect.nowHeroIsAt ==1)&&dialogueofzosimov.get(0).dialogueIsOver &&zosimovGoesToRoom==false){
                zosimovGoesToRoom=true;
                otherHeroesInSecondLocation.remove(0);
                otherHeroesInFirstLocation.add(zosimovHero);
                dialogueofzosimov.remove(0);
                dialogueofzosimov.add(new Dialogue(1));
                dialogueofzosimov.get(0).scanText("raskolnikovAndZosimov1.txt");
                //первый даилог с Зосимовым завершен, он уходит в комнату игрока, как только тот покидает коридор, активируется новый диалог
            }
            if(!(allLocationsConnect.nowHeroIsAt ==0)&&dialogueofzosimov.get(0).dialogueIsOver &&zosimovLeavesRoom==false&&zosimovGoesToRoom){
                zosimovLeavesRoom=true;
                otherHeroesInFirstLocation.remove(0);
                //после завершения второго диалога Зосимов уходит, доступ к этому герою закрыт
            }
            if(dialogueofrazumihin.get(1).dialogueIsOver &&dialogueofsonechka.get(0).dialogueIsOver &&zosimovLeavesRoom&&heroesAreInFirstLocation==false&&dialogueofsonechka.get(1).dialogueIsOver ==false){
                otherHeroesInThirdLocation.remove(0);
                otherHeroesInFifthLocation.remove(0);
                otherHeroesInFirstLocation.add(sonechkaHero);
                otherHeroesInFirstLocation.add(razumihinHero);
                heroesAreInFirstLocation=true;
                razumihinHero.nowActiveDialogue =3;
                //ветка встречи Разумихина, Сонечки и игрока в его комнате, герои покидают свои локации до окончания ветки
            }
            if(otherHeroesInFifthLocation.size()!=0&&hidings5.get(0).closeButton.clicked){
                razumihinHero.nowActiveDialogue =2;
                //ветка, в которой Разумихин заметил попытку спрятать улики
            }
            if(dialogueofsonechka.get(1).dialogueIsOver &&sonechkaLeaves==false){
                if(allLocationsConnect.nowHeroIsAt ==0){
                    otherHeroesInFirstLocation.remove(0);
                }
                if(allLocationsConnect.nowHeroIsAt ==2){
                    otherHeroesInThirdLocation.remove(0);
                }
                sonechkaLeaves=true;
                //после окончания диалога с игроком Соня покидает локацию, доступ к героюю закрыт
            }
            if(!razumihinLeaves&&dialogueofrazumihin.get(5).dialogueIsOver){
                dialogueofrazumihin.remove(5);
                dialogueofrazumihin.remove(4);
                dialogueofrazumihin.remove(3);
                otherHeroesInFirstLocation.remove(1);
                otherHeroesInFifthLocation.add(razumihinHero);
                razumihinLeaves=true;
                //после завершения данной ветки доступ к ней закрывается, Разумихин возвращается в свою локацию
            }
            if(dialogueofporfiriy.get(0).dialogueIsOver &&myPanel.changeIsNeed ==0){
                myPanel.finalIsOn =true;
                //активация финального выбора
            }
            if(myPanel.changeIsNeed ==1){
                myPanel.finish =true;
                //активация финала
            }
            if(myPanel.endingIsOn){ //если активирована концовка
                if(myPanel.whereIsHidden==0){
                    myPanel.ending=0;
                    myPanel.endingText="Ища улики на протяжении всего дня, Порфирий Петровч все же решил добиться разрешения на осмотр жилищ подозреваемых. Для него все стало сразу понятно: улики были у Вас. Он добился того, чтобы Вас признали виномным и отпрвили на каторгу. Соне стало Вас жалко, и она решила отпрвиться за Вами. Разумихин, Ваша мать и сестра писали Вам, переживали и ждали обратно, от остальных известий не было";
                }
                if(myPanel.rightNumber==3&&myPanel.whereIsHidden==1&&myPanel.numberOfFinalChoice==1){
                    myPanel.ending=1;
                    myPanel.endingText="В тот же вечер Миколка находит за дверью коробочку с серьгами и, еще не зная об убийстве, закладывает драгоценности у хозяина распивочной Душкина. Душкин сообщает об этом подозрительном случае в полицию. Вскоре Миколка узнает про убийство старухи и начинает тревожиться. Кроме того, в его личной жизни есть некоторые постыдные факты, из-за которых, как ему кажется, его могли бы арестовать. В итоге впечатлительный Миколка решает сбежать из города. Сбежав на какой-то постоялый двор, Миколка пытается пoкoнчить собой, но его останаливают. После молодой человек объясняет, что сбежал из-за страха, что его засудят. Миколка является с повинной к следователю Порфирию и признает свою вину в убийстве старухи и ее сестры. Миколка считает этот шаг возможностью искупить свои грехи и принять страдание, чтобы стать лучше. Его отправляют на каторгу. Соня разочаровалсь в Вас и свела общение на нет. Остальные продолжали жть, ни о чем не ведая. Ваша же жизнь наладилась, и Вы даже вернулись в университет.";
                }
                if(myPanel.rightNumber==3&&myPanel.whereIsHidden==1&&myPanel.numberOfFinalChoice==2){
                    myPanel.ending=2;
                    myPanel.endingText="Множество фактов, ведущих к Миколке, противоречили местонахождению улик. Порфирий Петрович решил копнуть глубже и провел несколько допросови осмотров у других подозреваемых. Это отняло у него пару недель. Но все же он смог понять, кто был виновным. Он смог добиться своего, и уже через два месяца Вы были на каторге. Соня не смогла принять тот факт, что Вы все же не сознались, так еще и чуть не подставили друга, и осталсь в Петербурге. Мать и сестра писали Вам. Об остльных ничего не известно.";
                }
                if(myPanel.rightNumber==3&&myPanel.whereIsHidden==2&&myPanel.numberOfFinalChoice==1){
                    myPanel.ending=3;
                    myPanel.endingText="Множество фактов, ведущих к Миколке, противоречили местонахождению улик. Порфирий Петрович решил копнуть глубже и провел несколько допросови осмотров у других подозреваемых. Это отняло у него пару недель. Но все же он смог понять, кто был виновным. Он смог добиться своего, и уже через два месяца Вы были на каторге. Соня не смогла принять тот факт, что Вы все же не сознались, так еще и чуть не подставили друга, и осталсь в Петербурге. Разумихин не смог принять Ваше предательство и даже не пытлся связаться. Мать и сестра писали Вам. Об остльных ничего не известно.";
                }
                if(myPanel.rightNumber==3&&myPanel.whereIsHidden==2&&myPanel.numberOfFinalChoice==2){
                    myPanel.ending=4;
                    myPanel.endingText="Порфирия Петровича удивил этот ответ, но он все же решил проверить этот вариант. Обнаружив улики в квартире Разумихина, следователь признал свою ошибку и добился отправления Дмитрия на каторгу. Он не смог принять Ваше предательство и даже не читал Ваш письма. Соня отправилась за Разумихиным, желая помочь и поддержать. С Вами она не связвалась. Ваша же жизнь продолжилась, и Вы даже вернулись к учебе. Однако, прежнм ничего не останется.";
                }
                if(myPanel.rightNumber!=3&&myPanel.numberOfFinalChoice==1){
                    myPanel.ending=5;
                    myPanel.endingText="Ища улики на протяжении всего дня, Порфирий Петровч все же решил добиться разрешения на осмотр жилищ подозреваемых. Для него все стало сразу понятно. Он добился того, чтобы Вас признали виномным и отпрвили на каторгу. Соне стало Вас жалко, хотя она и была против Вашего обвинения Миколки, и она решила отпрвиться за Вами. Разумихин, Ваша мать и сестра писали Вам, от остальных известий не было";
                }
                if(myPanel.rightNumber!=3&&myPanel.numberOfFinalChoice==2){
                    myPanel.ending=6;
                    myPanel.endingText="Ища улики на протяжении всего дня, Порфирий Петровч все же решил добиться разрешения на осмотр жилищ подозреваемых. Для него все стало сразу понятно. Он добился того, чтобы Вас признали виномным и отпрвили на каторгу. Соне стало Вас жалко, хотя она и была против Вашего обвинения Разумихина, и она решила отпрвиться за Вами. Разумихин не смог принять Вашей попытки подставить его. Ваша мать и сестра писали Вам, от остальных известий не было";
                }
                if(myPanel.numberOfFinalChoice==3){
                    myPanel.ending=7;
                    myPanel.endingText="Порфирий Петрович был рад, что Вы сами признались. Он смог договоритья о сокращении срока на каторге, но все же вскоре Вы уже были там. Соня, увидев шаснс помочь Вам, отпрвилась вслед за Вами. Она передавал письма матери, сестры и Разумихина, который пытался всчески помочь.";
                }
            }
        }
    }
}