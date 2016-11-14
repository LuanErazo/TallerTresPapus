import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Enemigo extends Thread {

	private PApplet app;
	private PVector pos, vel, acc;
	private boolean bomba;
	private int min;
	private ArrayList<Proyectil> tirables;
	private PImage enemigo;

	public Enemigo() {
		app = Main.app;
		tirables = new ArrayList<Proyectil>();
		enemigo  = Carga.enemigo;
		vel  = new PVector(0, 0);
		acc  = new PVector(0, 0);
		pos = new PVector(pos.x, pos.y);
	}

	@Override
	public void run() {
		while (true) {
			try {
				sleep(1000);
				mover();
			} catch (Exception e) {

			}
		}
	}

	public void mover() {
		
	    vel.add(acc);
	    pos.add(vel);
		
	}

	public void display() {

		app.image(enemigo, pos.x, pos.y);
		
	}

	public Proyectil tirarBomba() {
		Proyectil ob = null;
		for (int i = 0; i < tirables.size(); i++) {
			ob = tirables.get(i);
		}
		return ob;
	}

	public void contador() {

	}

}
