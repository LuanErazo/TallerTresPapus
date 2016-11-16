import java.awt.Color;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import sun.security.timestamp.TimestampToken;

public class Carro {
	private PApplet app;
	int mira = 0;
	private PImage carro, carroPixel;
	public PVector pos;

	public Carro() {
		app = Main.app;
		carro = Carga.carro;
		carroPixel = app.createImage(carro.width, carro.height, app.ARGB);
		pos = new PVector(500, 600);
	}

	public void display(float umbral) {

		pixels(umbral);

		carro.loadPixels();
		carroPixel.loadPixels();
		for (int i = 0; i < carro.height; i++) {
			for (int j = 0; j < carro.width; j++) {
				int loc = j + (i * carro.width);
				int colorActual = carro.pixels[loc];
				float valorR = app.red(colorActual);
				float valorG = app.green(colorActual);
				float valorB = app.blue(colorActual);
				float promedio = (valorR + valorG + valorB) / 3;

				float distMouse = PApplet.dist(app.mouseX, app.mouseY, j, i);
				if (distMouse < 100) {
					carroPixel.pixels[loc] = app.color(PApplet.map(distMouse, 0, 600, valorR, 0),
							PApplet.map(distMouse, 0, 600, valorG, 0), PApplet.map(distMouse, 0, 600, valorB, 0),
							PApplet.map(distMouse, 0, 600, 255, 0));
				} else {
					carroPixel.pixels[loc] = app.color(promedio);
				}

			}
		}
		carroPixel.updatePixels();
		app.image(carroPixel, app.width / 2 - 180, app.height / 2 - 50);
	}

	public void mover(PVector leapV) {
		pos.x = leapV.x;
		pos.y = leapV.y;
	}

	public void pixels(float umbral) {

		carro.loadPixels();
		carroPixel.loadPixels();

		for (int i = 0; i < carro.width; i++) {
			int colorActual = carro.pixels[i];
			float valorR = app.red(colorActual);
			float valorG = app.green(colorActual);
			float valorB = app.blue(colorActual);
			float promedio = (valorR + valorG + valorB) / 3;

			if (promedio > 0 && promedio <= 80) {
				carroPixel.pixels[i] = app.color(255, 255, 0);
			} else if (promedio > 80 && promedio <= 160) {
				carroPixel.pixels[i] = app.color(0, 0, 255);
			} else {
				carroPixel.pixels[i] = app.color(255, 0, 0);
			}

			if (promedio > umbral) {
				carroPixel.pixels[i] = app.color(255, 5);
			} else {
				carroPixel.pixels[i] = app.color(0);
			}
			carroPixel.updatePixels();
		}

	}

	public PVector getPos() {
		return pos;
	}

	public void setPos(PVector pos) {
		this.pos = pos;
	}

}
