package GameState;

import java.awt.Graphics2D;

import TileMap.TileMap;
import Util.KeySuport;
import Util.MouseSuport;

public class Level1State extends GameState {

	private TileMap tileMap;
	
	public Level1State(GameStateManager gsm) {
		// TODO Auto-generated constructor stub
		this.gsm = gsm;
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		tileMap = new TileMap(30);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void input(MouseSuport mouse, KeySuport key) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub

	}

}
