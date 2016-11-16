import java.util.ArrayList;

import jdk.net.NetworkPermission;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Player {
	private PApplet app;
	private PVector pos;
	private int puntaje;
	private PImage jugador;
	private Logica log;
	private float mx;
	private float my;

	public Player(Logica log) {
		app = Main.app;
		this.log = log;
		pos = new PVector(500,600);
		jugador = Carga.player;
	}

	public void mover(PVector leapV) {
		pos.x = leapV.x;
	}


	public void display() {
		app.pushMatrix();
		app.translate(pos.x, pos.y);
		app.image(jugador, 0, 0);
		app.popMatrix();
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
