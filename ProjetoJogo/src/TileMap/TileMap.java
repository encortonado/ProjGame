package TileMap;

import java.awt.image.BufferedImage;
import java.util.Iterator;

import javax.imageio.ImageIO;

import com.sun.prism.Image;

import Main.GamePanel;

public class TileMap {

	// posição
	private double x;
	private double y;
	
	//bounds
	private int xmin;
	private int ymin;
	private int xmax;
	private int ymax;
	
	// mover camera suavemente de acordo com o player
	private double tween;
	
	// map
	private int[][] map;
	private int tileSize;
	private int numRows;
	private int numCols;
	private int height;
	private int weight;
	
	//tileset
	private BufferedImage tileSet;
	private int numTilesAcross;
	private Tile[][] tiles;
	
	// drawing
	private int rowOffSet; // Usamos isso pra reduzir o tamanho bruto do jogo em
	private int colOffSet; // tempo real, no caso 60 FPS, pois caso não tenha 
	private int numRowsToDraw; // isso, pode requisitar muito do computador
	private int numColsToDraw;
	
	
	public TileMap(int tileSize) {
		// TODO Auto-generated constructor stub
		this.tileSize = tileSize;
		numRowsToDraw = GamePanel.HEIGHT / tileSize + 2;
		numColsToDraw = GamePanel.WIDTH / tileSize + 2;
		tween = 0.07; 
	}
	
	public void loadTiles(String s) {
		try {
			tileSet = ImageIO.read(getClass().getResourceAsStream(s));
			numTilesAcross = tileSet.getWidth() / tileSize;
			tiles = new Tile[2][numTilesAcross];
			
			BufferedImage subimage;
			for (int col = 0; col < numTilesAcross; col++) {
				subimage = tileSet.getSubimage(col * tileSize, 0, tileSize, tileSize);
				tiles[0][col] = new Tile(subimage, Tile.NORMAL);
				subimage = tileSet.getSubimage(col * tileSize, tileSize, tileSize, tileSize);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void loadMap() {
		
	}

}
















