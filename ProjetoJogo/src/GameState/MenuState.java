/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

import TileMap.Background;
import Util.KeySuport;
import Util.MouseSuport;
import java.awt.image.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 *
 * @author pcwgr
 */
public class MenuState extends GameState {

    private Background bg;
    
    private int currentChoice = 0;
    
    private String[] options = {"Começar", "Ajuda", "Sair"};
    
    private Color titleColor;
    private Font titleFont;
    
    private Font font;
    
    public MenuState(GameStateManager gsm) {
        this.gsm = gsm;
        
        try {
            bg = new Background("/Backgrounds/menubg.gif", 2);
            bg.setVector(-0.1, 0);
            
            titleColor = new Color(128, 0 , 0 );
            titleFont = new Font("Century Gothic", Font.PLAIN, 28);
            
            font = new Font("Arial", Font.PLAIN, 12);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        
    }

    @Override
    public void update() {
        bg.update();
    }

    @Override
    public void draw(Graphics2D g) {
        // draw bg
        bg.draw(g);
        
        // draw title
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("Colete o Lixo", 80, 70);
        
        // draw Menu opções
        g.setFont(font);
        for (int i = 0; i < options.length; i++) {
            if (i == currentChoice) {
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.RED);
            }
            g.drawString(options[i], 145, 140 + i * 15);
        }
    }

    private void select() {
        if (currentChoice == 0) {
            // começar
        	gsm.setState(GameStateManager.LEVEL_ONE_STATE);
        }
        if (currentChoice == 1) {
            // ajuda
        }
        if (currentChoice == 2) {
            System.exit(0);
        }
    }
    
    @Override
    public void keyPressed(int k) {
        if (k == KeyEvent.VK_ENTER) {
            select();
        }
        if (k == KeyEvent.VK_UP) {
            currentChoice--;
            if (currentChoice == -1) {
                currentChoice = options.length - 1;
            }
        }
        if (k == KeyEvent.VK_DOWN) {
            currentChoice++;
            if (currentChoice == options.length) {
                currentChoice = 0;
            }
        }
    }
    
    @Override
    public void input(MouseSuport mouse, KeySuport key) {
        
    }

	
	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}
    
    
}
