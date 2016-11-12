import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Player extends Thread {
	private PApplet app;
	private PVector pos;
	private int puntaje;
	private PImage jugador;

	public Player(PVector nVector) {
		app = Main.app;
		jugador = Carga.player;
		pos = new PVector(0,0);

		start();
	}

	public void mover(PVector v) {
		this.pos.set(v);
	}

	@Override
	public void run() {
		while (true) {
			try {

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void display() {
		app.image(jugador, pos.x, pos.y);
	}

	public void sumarPuntaje(ArrayList<Proyectil> lista) {

	}
}
