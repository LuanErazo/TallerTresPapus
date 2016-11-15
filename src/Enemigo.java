import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Enemigo extends Thread {

	private PApplet app;
	private PVector pos, vel;
	private boolean bomba;
	private boolean cambiodirec;
	private int min;
	private ArrayList<Proyectil> tirables;
	private PImage enemigo;

	public Enemigo() {
		app = Main.app;
		tirables = new ArrayList<Proyectil>();
		enemigo = Carga.enemigo;
		vel = new PVector(1, 0);
		pos = new PVector(50, 100);
		start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				sleep(2);
				mover();
			} catch (Exception e) {

			}
		}
	}

	public void mover() {

		pos.add(vel);
		if ((pos.x > app.width + enemigo.width) || (pos.x < 0 - enemigo.width)) {
			vel.x = vel.x * -1;
			cambiodirec = !cambiodirec;
		}

	}

	public PVector getPos() {
		return pos;
	}

	public void setPos(PVector pos) {
		this.pos = pos;
	}
/**
 * metodo que cambio y pinta la direccion del pj
 */
	public void display() {
		app.imageMode(PConstants.CENTER);
		app.pushMatrix();
		app.translate(pos.x, pos.y);
		if (!cambiodirec) {
			app.rotateY(PConstants.PI);
		}
		app.image(enemigo, 0, 0);
		app.popMatrix();

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
