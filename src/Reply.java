import java.awt.*;
import java.util.ArrayList;

public class Reply {

    String text;
    int height;
    int y;
    int followingIndex;

    public Reply(){
    }

    public void formatBySize(Graphics g) {
        int x =0;
        int width = 720;
        String text = this.text;
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

                if (stringWidth > width - 100) {
                    text = text.substring(strings.get(n).length() + 1);
                    n = n + 1;
                    strings.add("");
                }
            }
        }
        strings.set(n, text);
        for (int i = 0; i <= strings.size() - 1; i++) {
            g.drawString(strings.get(i), x + 30, y  + i * 20);
        }
    }
}

