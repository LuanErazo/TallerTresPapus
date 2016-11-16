import java.awt.Color;

import processing.core.PApplet;
import processing.core.PImage;
import sun.security.timestamp.TimestampToken;

public class Carro {
	private PApplet app;
	int cellsize = 2; // Dimensions of each cell in the grid
	int mira = 0;
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
		if (app.mouseX > app.width/2 && app.mouseX < app.width && mira == 0) {
			app.tint(255, 100, 50);
			app.image(carro, app.width/2, app.height/2);
		} else{
			app.noTint();
		}
	}
	
	private void pixelsUno(){
		/**
		 * método pixel que me cambia el color de la imagen
		 */
		if (app.mouseX > app.width/2 && app.mouseX < app.width && mira == 1) {
			app.tint(100, 200, 50);
			app.image(carro, app.width/2, app.height/2);
		} else{
			app.noTint();
		}
	}
	
	private void PixelsDos(){
		/**
		 * método pixel que me cambia el color de la imagen
		 */
		if (app.mouseX > app.width/2 && app.mouseX < app.width && mira ==  2) {
			app.tint(10, 20, 220);
			app.image(carro, app.width/2, app.height/2);
		} else{
			app.noTint();
		}
	}
	
	
}

