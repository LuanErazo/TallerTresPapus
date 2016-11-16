import java.awt.Color;

import processing.core.PApplet;

public class Carro {
	private PApplet app;
	int cellsize = 2; // Dimensions of each cell in the grid
	int cols, rows;

	public Carro() {
		app = Main.app;
	}
	
	public void display(){
		for ( int i = 0; i < cols;i++) {
		    // Begin loop for rows
		    for ( int j = 0; j < rows;j++) {
		      int x = i*cellsize + cellsize/2; // x position
		      int y = j*cellsize + cellsize/2; // y position
		      int loc = x + y*app.width;           // Pixel array location
		      int c = Carga.carro.pixels[loc];       // Grab the color
		      // Calculate a z position as a function of mouseX and pixel brightness
		      float z = (float) ((app.mouseX/(float)app.width) * brightness(Carga.carro.pixels[loc]) - 100.0);
		      // Translate to the location, set fill and stroke, and draw the rect
		      app.pushMatrix();
		      app.translate(x,y,z);
		      app.fill(c);
		      app.noStroke();
		      app.rectMode(app.CENTER);
		      app.rect(0,0,cellsize,cellsize);
		      app.popMatrix();
		    }
		  }
	}
	
	private float brightness(int R) {
		return 0;
	}

	public void pixels(){
		
		
	}
	
	private void pixelsUno(){
		
	}
	
	private void PixelsDos(){
		
	}
	
	
}
