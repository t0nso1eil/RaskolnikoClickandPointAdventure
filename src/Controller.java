import java.awt.*;
import java.awt.event.KeyEvent;

public class Controller {
    KeyboardFocusManager keyboard;
    public boolean pressed=false;
    Controller(Hero hero) {
        keyboard = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        keyboard.addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if(e.getID()==KeyEvent.KEY_PRESSED){
                    if(e.getKeyCode()==KeyEvent.VK_UP){
                        hero.direction=Direction.UP;
                        pressed=true;
                    }
                    if(e.getKeyCode()==KeyEvent.VK_LEFT){
                        hero.direction=Direction.LEFT;
                        pressed=true;
                    }
                    if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                        hero.direction=Direction.RIGHT;
                        pressed=true;
                    }
                    if(e.getKeyCode()==KeyEvent.VK_DOWN){
                        hero.direction=Direction.DOWN;
                        pressed=true;
                    }
                }
                return false;
            }
        });
    }
}

