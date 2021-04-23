import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dialogue {

    int phraseIndex = 0;
    int interactiveType;
    ArrayList<Sentence> phrasesOfHero;
    ArrayList<OtherHeroSentence> phrases1;
    boolean npcLine = true;
    int finishOfDialogue = -1;
    boolean dialogueIsOver = false;
    boolean startPhrase = false;

    public Dialogue(int type) {
        this.interactiveType = type;
        if (type==0) {
            phrasesOfHero = new ArrayList<>();
        }
        if (type==1) {
            phrases1 = new ArrayList<>();
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
                        phrases1.add(phraseIndex, new OtherHeroSentence(text));
                    }
                }
            }
        }
        finishOfDialogue = phraseIndex +1;
        phraseIndex = 0;
    }

    public void checkClick(MouseEvent e) {
        if(interactiveType == 0) {
            if (npcLine) {
                if (phraseIndex == 0) {
                    if (startPhrase) {
                        npcLine = false;
                    }
                    startPhrase = true;
                } else npcLine = false;
            } else {
                int y = e.getY();
                for (int i = 0; i < phrasesOfHero.get(phraseIndex).reply.length; ++i) {
                    if (!npcLine && y > 720 - 40 - (i + 1) * phrasesOfHero.get(phraseIndex).reply[i].height && y < 720 - 40 - i * phrasesOfHero.get(phraseIndex).reply[i].height) {
                        phraseIndex = phrasesOfHero.get(phraseIndex).reply[phrasesOfHero.get(phraseIndex).reply.length - i - 1].followingIndex;
                        System.out.println(phraseIndex);
                        npcLine = true;
                    }
                }
            }
            if (phrasesOfHero.get(phraseIndex).reply.length == 0 && npcLine == false) {
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

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 620 - 75, 960, 160);
        g.setColor(Color.black);
        if (interactiveType == 0) {
            if (npcLine) {
                phrasesOfHero.get(phraseIndex).writeInRect(g, phrasesOfHero.get(phraseIndex).text, 0, 720 - 190, 885, 150);
            } else {
                for (int i = 0; i < phrasesOfHero.get(phraseIndex).reply.length; ++i) {
                    phrasesOfHero.get(phraseIndex).reply[i].formatBySize(g);
                }
            }
        }
        if (interactiveType == 1) {
            phrases1.get(phraseIndex).formatBySize(g, phrases1.get(phraseIndex).text, 0, 720 - 190, 885, 160);
        }
    }

    public void write() {
        if (interactiveType == 0) {
            System.out.println(phrasesOfHero.size());
            for (int i = 0; i < phrasesOfHero.size(); ++i) {
                System.out.println(i);
                System.out.println(phrasesOfHero.get(i).text);
                System.out.println(phrasesOfHero.get(i).reply.length);
                for (int j = 0; j < phrasesOfHero.get(i).reply.length; ++j) {
                    System.out.println(phrasesOfHero.get(i).reply[j].followingIndex);
                    System.out.println(phrasesOfHero.get(i).reply[j].text);
                }
            }
        }
    }
}