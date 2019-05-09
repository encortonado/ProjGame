/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

import Util.KeySuport;
import Util.MouseSuport;
import java.util.ArrayList;

/**
 *
 * @author pcwgr
 */
public class GameStateManager {
    
    private ArrayList<GameState> gameStates;
    private int currentState;
    
    public static final int MENU_STATE = 0;
    public static final int LEVEL_ONE_STATE = 1;
    public static final int PAUSE = 2;
    public static final int GAMEOVER = 3;
    
    public GameStateManager() {
        gameStates = new ArrayList<GameState>();
        
        currentState = MENU_STATE;
        gameStates.add(new MenuState(this));
        gameStates.add(new Level1State(this));
    }
    
    public void setState(int state) {
        currentState = state;
        gameStates.get(currentState).init();
    }
    
    public void update() {
        gameStates.get(currentState).update();
    }
    
    public void draw(java.awt.Graphics2D g) {
        gameStates.get(currentState).draw(g);
    }
    
    public void input(MouseSuport mouse, KeySuport key) {
        for (int i = 0; i < gameStates.size(); i++) {
            gameStates.get(i).input(mouse, key);
        }
    }
    
    
    public void keyPressed(int k) {
        gameStates.get(currentState).keyPressed(k);
    }
    public void keyReleased(int k) {
        gameStates.get(currentState).keyPressed(k);
    } 
}
