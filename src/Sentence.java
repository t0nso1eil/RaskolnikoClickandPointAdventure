import java.awt.*;
import java.util.ArrayList;

public class Sentence {

    String text;
    Reply[] reply;

    public Sentence(String text) {
        this.text = text;
    }

    public void formatBySize(Graphics g, String text, int x, int y, int width) {
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

                if (stringWidth > width - 100) {
                    text = text.substring(strings.get(number).length() + 1);
                    number = number + 1;
                    strings.add("");
                }
            }
        }
        strings.set(number, text);
        for (int i = 0; i <= strings.size() - 1; i++) {
            g.drawString(strings.get(i), x + 10, y + 40 + i * 20);
        }
    }
}