/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Main.GamePanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pcwgr
 */
public class KeySuport implements KeyListener {
    public static List<Key> keys = new ArrayList<Key>();
    
    public class Key {
        public int presses, absorbs;
        public boolean down, clicked;
        
        public Key() {
            keys.add(this);
        }
        
        public void toggle(boolean pressed) {
            if (pressed != down) {
                down = pressed;
            }
            if (pressed) {
                presses++;
            }
            
            
        }
        
        public void tick() {
            if (absorbs < presses) {
                absorbs++;
                clicked = true;
            } else {
                clicked = false;
            }
        }
    }
    
    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();
    public Key jump  = new Key();
    public Key menu = new Key();
    public Key confirm = new Key();
    public Key escape  = new Key();
     
    public KeySuport(GamePanel game) {
        game.addKeyListener(this);
    }
    
    public void releaseAll() {
        for (int i = 0; i < keys.size(); i++) {
            keys.get(i).down = false;
        }
    }
    
    public void tick() {
        for (int i = 0; i < keys.size(); i++) {
            keys.get(i).tick();
        }
    }
    
    public void toggle(KeyEvent e, boolean pressed) {
        if (e.getKeyCode() == KeyEvent.VK_W) up.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_S) down.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_A) left.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_D) right.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_SPACE) jump.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_E) menu.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_Z) confirm.toggle(pressed);
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) escape.toggle(pressed);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        // nothing yet..
    }

    @Override
    public void keyPressed(KeyEvent e) {
        toggle(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        toggle(e, false);
    }
    
}
