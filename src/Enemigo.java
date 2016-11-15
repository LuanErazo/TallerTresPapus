import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Enemigo extends Thread {

	private PApplet app;
	private PVector pos, vel;
	private boolean bomba;
	private int min;
	private ArrayList<Proyectil> tirables;
	private PImage enemigo;

	public Enemigo() {
		app = Main.app;
		tirables = new ArrayList<Proyectil>();
		enemigo  = Carga.enemigo;
		vel  = new PVector(10 , 0);
		pos = new PVector(50 , 0);
		start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				sleep(500);
				mover();
			} catch (Exception e) {

			}
		}
	}

	public void mover() {
		
		  pos.add(vel);
		  if ((pos.x > app.width) || (pos.x < 0)) {
		    vel.x = vel.x * -1;
		    //Aquí va la wea que te digo para que rote la imagen del enemigo.
		    app.pushMatrix();
		    app. rotateY(180);
		    app.popMatrix();
		  }
		
	}

	public PVector getPos() {
		return pos;
	}

	public void setPos(PVector pos) {
		this.pos = pos;
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
