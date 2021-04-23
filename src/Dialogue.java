import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dialogue {

    ArrayList<Sentence> phrasesOfHero;
    ArrayList<OtherHeroSentence> phrases;
    int finishOfDialogue = -1;
    int phraseIndex = 0; //индексация в диалоге идет с 0
    int interactiveType; //какой тип диалога: с интерактивными ответами - 0, без интерактивных ответов - 1
    boolean otherHeroTurn = true; //сйечас фраза неигрового героя
    boolean dialogueIsOver = false;
    boolean startPhrase = false; //проверка на начало фразы

    public Dialogue(int type) {
        this.interactiveType = type;
        if (type==0) {
            phrasesOfHero = new ArrayList<>();
        }
        if (type==1) {
            phrases = new ArrayList<>();
        }
    }

    public void scanText(String name) throws IOException {
        BufferedReader readingText = new BufferedReader(new InputStreamReader(Dialogue.class.getResourceAsStream(name))); //файл должен быть формата: первая строка абзаца - идентификатор фразы, вторая - фраза героя, третья - количество вариантов ответов, четвертая - идентификатор фразы, которую скажет герой в случае первого варианта ответа, пятая - текст первого варианта ответа, шестая - идентификатор фразы, которую скажет npc в случае второго варианта ответа и тд
        String text;
        int number = -1;
        while ((text = readingText.readLine()) != null) {
            number = number + 1;
            if (text.equals("")) {
                number = -1;
            } else {
                if (number == 0) {
                    phraseIndex = Integer.parseInt(text);
                }
                if (interactiveType == 0) {
                    if (number == 1) {
                        phrasesOfHero.add(phraseIndex, new Sentence(text));
                    }
                    if (number == 2) {
                        phrasesOfHero.get(phraseIndex).reply = new Reply[Integer.parseInt(text)];
                        for (int i = 0; i < phrasesOfHero.get(phraseIndex).reply.length; ++i) {
                            phrasesOfHero.get(phraseIndex).reply[i] = new Reply();
                            phrasesOfHero.get(phraseIndex).reply[i].height = 100 / phrasesOfHero.get(phraseIndex).reply.length;
                            phrasesOfHero.get(phraseIndex).reply[i].y = 720 - (phrasesOfHero.get(phraseIndex).reply.length - i) * phrasesOfHero.get(phraseIndex).reply[i].height;
                        }
                    }
                    if (number >= 3) {
                        for (int i = 0; i < phrasesOfHero.get(phraseIndex).reply.length; ++i) {
                            if (number == 3 + 2 * i) {
                                phrasesOfHero.get(phraseIndex).reply[i].followingIndex = Integer.parseInt(text);
                            }
                            if (number == 3 + 2 * i + 1) {
                                phrasesOfHero.get(phraseIndex).reply[i].text = text;
                            }
                        }
                    }
                }
                if (interactiveType == 1) {
                    if (number == 1) {
                        phrases.add(phraseIndex, new OtherHeroSentence(text));
                    }
                }
            }
        }
        finishOfDialogue = phraseIndex +1;
        phraseIndex = 0;
    }

    public void checkClick(MouseEvent e) {
        if(interactiveType == 0) {
            if (otherHeroTurn) {
                if (phraseIndex == 0) {
                    if (startPhrase) {
                        otherHeroTurn = false;
                    }
                    startPhrase = true;
                } else otherHeroTurn = false;
            } else {
                int y = e.getY();
                for (int i = 0; i < phrasesOfHero.get(phraseIndex).reply.length; ++i) {
                    if (!otherHeroTurn && y > 720 - 40 - (i + 1) * phrasesOfHero.get(phraseIndex).reply[i].height && y < 720 - 40 - i * phrasesOfHero.get(phraseIndex).reply[i].height) { //проверяем, нужна ли смена фразы в диалоге (осуществляется при клике)
                        phraseIndex = phrasesOfHero.get(phraseIndex).reply[phrasesOfHero.get(phraseIndex).reply.length - i - 1].followingIndex; //смена фразы на фразу со следущим индексом
                        System.out.println(phraseIndex);
                        otherHeroTurn = true;
                    }
                }
            }
            if (phrasesOfHero.get(phraseIndex).reply.length == 0 && otherHeroTurn == false) {
                dialogueIsOver = true;
            }
        }
        if (interactiveType == 1) {

            if (phraseIndex == 0) {
                if (startPhrase) {
                    phraseIndex = phraseIndex + 1;
                }
                startPhrase = true;
            } else phraseIndex = phraseIndex + 1;
            if (phraseIndex == finishOfDialogue) {
                dialogueIsOver = true;
            }
        }
    }

    public void drawDialogueBox(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 620 - 75, 960, 160);
        g.setColor(Color.black);
        if (interactiveType == 0) {
            if (otherHeroTurn) {
                phrasesOfHero.get(phraseIndex).writeInRect(g, phrasesOfHero.get(phraseIndex).text, 0, 720 - 190, 885);
            } else {
                for (int i = 0; i < phrasesOfHero.get(phraseIndex).reply.length; ++i) {
                    phrasesOfHero.get(phraseIndex).reply[i].formatBySize(g);
                }
            }
        }
        if (interactiveType == 1) {
            phrases.get(phraseIndex).formatBySize(g, phrases.get(phraseIndex).text, 0, 720 - 190, 885);
        }
    }
}