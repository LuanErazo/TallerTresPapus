import java.util.ArrayList;

import jdk.net.NetworkPermission;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Player extends Thread {
	private PApplet app;
	private PVector pos;
	private int puntaje;
	private PImage jugador;
	private Logica log;

	public Player(Logica log) {
		app = Main.app;
		this.log = log;
		pos = new PVector(0,0);
		jugador = Carga.player;

		start();
	}

	public void mover(PVector v) {
		pos.set(v);
	}

	@Override
	public void run() {
		while (true) {
			try {
//				mover(log.vectorLeap());
			} catch (Exception e) {
//				System.out.println("crack");
			}
		}
	}

	public void display() {
		app.image(jugador, pos.x, pos.y);
	}

	public void sumarPuntaje(ArrayList<Proyectil> lista) {

	}

	public PVector getPos() {
		return pos;
	}

	public void setPos(PVector pos) {
		this.pos = pos;
	}
	
	
}
