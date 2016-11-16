import java.awt.Color;

import processing.core.PApplet;
import processing.core.PImage;
import sun.security.timestamp.TimestampToken;

public class Carro {
	private PApplet app;
	int cellsize = 2; // Dimensions of each cell in the grid
	int cols, rows;
	private PImage carro;

	public Carro() {
		app = Main.app;
		carro = Carga.carro;
	}
	
	public void display(){
		/*
		 * cargo las imagenes del carro y sus varaciones
		 */
		app.image(carro, app.width/2, app.height/2);
		pixels();
		pixelsUno();
		PixelsDos();
		
	}

	public void pixels(){
		/**
		 * método pixel que me cambia el color de la imagen
		 */
		if (app.mouseX > app.width/2 && app.mouseX < app.width) {
			app.tint(255, 100, 50);
			app.image(carro, app.width/2, app.height/2);
		}
	}
	
	private void pixelsUno(){
		
	}
	
	private void PixelsDos(){
		
	}
	
	
}
