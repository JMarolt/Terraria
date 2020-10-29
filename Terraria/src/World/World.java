package World;

import java.awt.Graphics;
import java.util.HashMap;

import Block.Air;
import Block.Block;
import Block.Diamond;
import Block.Dirt;
import Block.Grass;
import Block.Stone;
import Client.Cursor;
import Client.Window;
import Renderer.Texture;

public class World {

	private int tilesWidth, tilesHeight;
	public Tile[][] tiles;
	private boolean isRunning = false;
	private HashMap<Integer, Texture> textures = Texture.textures;
	private int mouseX;
	private int mouseY;
	private Tile prevTile;
	private boolean up = false, down = false, right = false, left = false;

	public World(int tilesWidth, int tilesHeight) {
		this.tilesWidth = tilesWidth;
		this.tilesHeight = tilesHeight;
		tiles = new Tile[this.tilesWidth][this.tilesHeight];
		createWorld();
	}

	public void update() {
		mouseX = Window.ML.x;
		mouseY = Window.ML.y;
//		for(int i = 0; i < tilesWidth; i++) {
//			for(int k = 0; k < tilesHeight; k++) {
//				if(cursor.getHotspot().intersects(tiles[i][k].getCollision())) {
//					tiles[i][k].getBlock().getTexture().setOpacity(0.2f);
//				}
//			}
//		}
	}

	private void createWorld() {
		int random = 0;
		int grassHeight = 0;
		for (int i = 0; i < tilesWidth; i++) {
			grassHeight = surfaceNoise(34, 37);
			for (int k = 0; k < tilesHeight; k++) {
				random = (int) (Math.random() * 4);
				tiles[i][k] = new Tile(i * 16, k * 16);
				if(k == grassHeight + 1) {
					tiles[i][k].setBlock(new Grass(tiles[i][k]));
				} else if (k < grassHeight + 1) {
					tiles[i][k].setBlock(new Air(tiles[i][k]));
				} else if (k > grassHeight && k < grassHeight + 5) {
					tiles[i][k].setBlock(new Dirt(tiles[i][k]));
				} else {
					tiles[i][k].setBlock(new Stone(tiles[i][k]));
				}
			}
		}
		noiseOres(40, 50);
	}
	
	private int surfaceNoise(int min, int max) {
		int random = (int)(Math.random()*(max-min)) + min;
		return random;
	}

	public void render(Graphics g) {
		for (int i = 0; i < tilesWidth; i++) {
			for (int k = 0; k < tilesHeight; k++) {
				if (tiles[i][k] != null) {
					tiles[i][k].getBlock().draw(g);
				}
			}
		}
	}
	//maybe try recursion
	private void noiseTestOres() {
		int random = 0;
		int odds = 9;
		for (int i = 0; i < tilesWidth; i++) {
			for (int k = 0; k < tilesHeight; k++) {
				random = (int) (Math.random() * 500);
				if(random == 0) {
					int x = i;
					int y = k;
					int[] directions = {0, 1, 2, 3};
					tiles[i][k].setBlock(new Diamond(tiles[i][k]));
					for(int j = 0; j < 4; j++) {
						int rd = (int)(Math.random()*directions.length);
						switch(directions[rd]) {
							case 0:
								y--;
								directions = remove(directions, 0);
								break;
							case 1:
								y++;
								directions = remove(directions, 1);
								break;
							case 2:
								x++;
								directions = remove(directions, 2);
								break;
							case 3:
								x--;
								directions = remove(directions, 3);
								break;
						}
					}
				}
			}
		}
	}

	private void noiseOres(int minHeight, int maxHeight) {
		int random = 0;
		int chance = 0;
		int odds = 9;
//		for (int i = 0; i < tilesWidth; i++) {
//			for (int k = 0; k < tilesHeight; k++) {
//				random = (int) (Math.random() * 500);
//				switch (random) {
//				case 0:
//					int x = 0;
//					int y = 0;
//					int[] directions = {0, 1, 2, 3};
//					tiles[i][k].setBlock(new Diamond(tiles[i][k]));
//					for (int direction = 0; direction < 4; direction++) {
//						chance = (int) (Math.random() * 10);
//						if (chance < odds) {
//							switch (direction) {
//							// north
//							case 0:
//								y--;
//								tiles[i + x][k + y].setBlock(new Diamond(tiles[i + x][k + y]));
//								break;
//							// south
//							case 1:
//								y++;
//								tiles[i + x][k + y].setBlock(new Diamond(tiles[i + x][k + y]));
//								break;
//							// east
//							case 2:
//								x++;
//								tiles[i + x][k + y].setBlock(new Diamond(tiles[i + x][k + y]));
//								break;
//							// west
//							case 3:
//								x--;
//								tiles[i + x][k + y].setBlock(new Diamond(tiles[i + x][k + y]));
//								break;
//							}
//							//if (odds >= 2)
//								//odds--;
//						}
//					}
//					break;
//				}
//			}
//		}
		int vein = 0;
		for (int i = 0; i < tilesWidth; i++) {
			for (int k = 0; k < tilesHeight; k++) {
				random = (int) (Math.random() * 200);
				if (random == 0 && k < maxHeight && k > minHeight) {
					tiles[i][k].setBlock(new Diamond(tiles[i][k]));
					for (int j = 0; j < 4; j++) {
						vein = (int) (Math.random() * 10);
						if (vein < 2) {
							tiles[i - 1][k].setBlock(new Diamond(tiles[i - 1][k]));
							left = true;
						}
						if (vein < 4 && vein >= 2) {
							tiles[i][k - 1].setBlock(new Diamond(tiles[i][k - 1]));
							up = true;
						}
						if (vein < 6 && vein >= 4) {
							tiles[i + 1][k].setBlock(new Diamond(tiles[i + 1][k]));
							right = true;
						}
						if (vein < 8 && vein >= 6) {
							tiles[i][k + 1].setBlock(new Diamond(tiles[i][k + 1]));
							down = true;
						}
					}
					for (int j = 0; j < 4; j++) {
						vein = (int) (Math.random() * 10);
						if (vein < 2 && left) {
							tiles[i - 2][k].setBlock(new Diamond(tiles[i - 2][k]));
						}
						if (vein < 4 && vein >= 2 && up) {
							tiles[i][k - 2].setBlock(new Diamond(tiles[i][k - 2]));
						}
						if (vein < 6 && vein >= 4 && right) {
							tiles[i + 2][k].setBlock(new Diamond(tiles[i + 2][k]));
						}
						if (vein < 8 && vein >= 6 && down) {
							tiles[i][k + 2].setBlock(new Diamond(tiles[i][k + 2]));
						}
					}
					for (int j = 0; j < 2; j++) {
						vein = (int) (Math.random() * 10);
						if (vein < 2) {
							tiles[i - 1][k - 1].setBlock(new Diamond(tiles[i - 1][k - 1]));
						}
						if (vein < 4 && vein >= 2) {
							tiles[i + 1][k - 1].setBlock(new Diamond(tiles[i + 1][k - 1]));
						}
						if (vein < 6 && vein >= 4) {
							tiles[i - 1][k + 1].setBlock(new Diamond(tiles[i - 1][k + 1]));
						}
						if (vein < 8 && vein >= 6) {
							tiles[i + 1][k + 1].setBlock(new Diamond(tiles[i + 1][k + 1]));
						}
					}
				}
				down = false;
				up = false;
				right = false;
				left = false;
			}
		}

//		for (int i = 0; i * 20 < Terraria.window.getWidth(); i++) {
//			for (int h = 0; h * 20 < Terraria.window.getHeight(); h++) {
//				random = (int) (Math.random() * 1000);
//				if (random < 1) {
//					g.setColor(Color.BLACK);
//					g.fillRect(i * 20, i * 20, 20, 20);
//					tempX = i;
//					tempY = h;
//					for (int j = 0; j < 10; j++) {
//						g.setColor(Color.BLACK);
//						vein = (int) (Math.random() * 16);
//						System.out.println(j);
//						if (vein < 2 && !right) {
//							tempX--;
//							g.fillRect(tempX * 20, tempY * 20, 20, 20);
//							left = true;
//							right = false;
//							down = false;
//							up = false;
//							upLeft = false;
//							upRight = false;
//							downLeft = false;
//							downRight = false;
//						}
//						if (vein < 4 && vein >= 2 && !left) {
//							tempX++;
//							g.fillRect(tempX * 20, tempY * 20, 20, 20);
//							left = false;
//							right = true;
//							down = false;
//							up = false;
//							upLeft = false;
//							upRight = false;
//							downLeft = false;
//							downRight = false;
//						}
//						if (vein < 6 && vein >= 4 && !down) {
//							tempY--;
//							g.fillRect(tempX * 20, tempY * 20, 20, 20);
//							left = false;
//							right = false;
//							down = false;
//							up = true;
//							upLeft = false;
//							upRight = false;
//							downLeft = false;
//							downRight = false;
//						}
//						if (vein < 8 && vein >= 6 && !up) {
//							tempY++;
//							g.fillRect(tempX * 20, tempY * 20, 20, 20);
//							left = false;
//							right = false;
//							down = true;
//							up = false;
//							upLeft = false;
//							upRight = false;
//							downLeft = false;
//							downRight = false;
//						}
//						if (vein < 10 && vein >= 8 && !downRight) {
//							tempY--;
//							tempX--;
//							g.fillRect(tempX * 20, tempY * 20, 20, 20);
//							left = false;
//							right = false;
//							down = false;
//							up = false;
//							upLeft = true;
//							upRight = false;
//							downLeft = false;
//							downRight = false;
//						}
//						if (vein < 12 && vein >= 10 && !downLeft) {
//							tempY--;
//							tempX++;
//							g.fillRect(tempX * 20, tempY * 20, 20, 20);
//							left = false;
//							right = false;
//							down = false;
//							up = false;
//							upLeft = false;
//							upRight = true;
//							downLeft = false;
//							downRight = false;
//						}
//						if (vein < 14 && vein >= 12 && !upRight) {
//							tempY++;
//							tempX--;
//							g.fillRect(tempX * 20, tempY * 20, 20, 20);
//							left = false;
//							right = false;
//							down = false;
//							up = false;
//							upLeft = false;
//							upRight = false;
//							downLeft = true;
//							downRight = false;
//						}
//						if (vein < 16 && vein >= 14 && !upLeft) {
//							tempY++;
//							tempX++;
//							g.fillRect(tempX * 20, tempY * 20, 20, 20);
//							left = false;
//							right = false;
//							down = false;
//							up = false;
//							upLeft = false;
//							upRight = false;
//							downLeft = false;
//							downRight = true;
//						}
//					}
//				}
//			}
//		}

	}

	private int[] remove(int[] arr, int num) {
		int[] temp = new int[arr.length];
		int n = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == num) {
				continue;
			}else {
				temp[n] = arr[i];
				n++;
			}
		}
		return temp;
	}
	
	public void mineBlock(int x, int y, Block block) {
		tiles[x / 16][y / 16].setBlock(block);
	}

	public void placeBlock(int x, int y, Block block) {
		if (tiles[x / 16][y / 16].getBlock().isAir()) {
			tiles[x / 16][y / 16].setBlock(block);
		}
	}
	
	public void jump() {
		for (int i = 0; i < tiles.length; i++) {
			for (int k = 0; k < tiles[0].length; k++) {
				System.out.println(tiles[i][k].getY());
				tiles[i][k].setY(tiles[i][k].getY() - 1);
				System.out.println("texture: " + tiles[i][k].getBlock().getTexture().getY());
			}
		}
	}

	private Tile getTile(int x, int y) {
		for (int i = 0; i < tiles.length; i++) {
			for (int k = 0; k < tiles[0].length; k++) {
				if (x == tiles[i][k].getX() && y == tiles[i][k].getY()) {
					return tiles[i][k];
				}
			}
		}
		return null;
	}

	public int getTilesWidth() {
		return tilesWidth;
	}

	public void setTilesWidth(int tilesWidth) {
		this.tilesWidth = tilesWidth;
	}

	public int getTilesHeight() {
		return tilesHeight;
	}

	public void setTilesHeight(int tilesHeight) {
		this.tilesHeight = tilesHeight;
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

}
