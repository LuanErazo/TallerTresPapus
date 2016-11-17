import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Enemigo extends Thread {

	private PApplet app;
	private PVector pos, vel;
	private boolean cambiodirec;
	private ArrayList<Proyectil> tirables;
	private ArrayList<Proyectil> preTirables;

	private PImage enemigo;

	public Enemigo() {
		app = Main.app;
		tirables = new ArrayList<Proyectil>();
		preTirables = new ArrayList<Proyectil>();
		enemigo = Carga.enemigo;
		vel = new PVector(1, 0);
		pos = new PVector(50, 100);
		arrayTirables();
		start();
	}

	/**
	 * metodo que carga los proyectiles para que al generar un random las
	 * probabilidades sean correctas
	 */
	private void arrayTirables() {
		  
		preTirables.add(new Bomba(this));
		preTirables.add(new Bomba(this));
		preTirables.add(new Sparkie(this));
		preTirables.add(new Sparkie(this));
		preTirables.add(new SparkieReal(this));		
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
		contador();
	}

	public Proyectil tirarBomba() {

			return tirables.get((int) app.random(tirables.size()-1));		
	}
/**
 * metodo que agrega cada segundo un nuevo elemtno para que el enemigo tire
 */
	public void contador() {
		if (app.frameCount % 60*1 == 0) {
			 int ran = (int) app.random(preTirables.size());
			tirables.add(preTirables.get(ran));
			preTirables.remove(ran);
		}
		if (app.frameCount % 60*1 == 0) {
			preTirables.add(new Bomba(this));
		}
		if (app.frameCount % 60*2 == 0) {
			preTirables.add(new Sparkie(this));
		}
		if (app.frameCount % 60*4 == 0) {
			preTirables.add(new SparkieReal(this));
		}
	}

public ArrayList<Proyectil> getTirables() {
	return tirables;
}

public PVector getPos() {
	return pos;
}
	
	
	

}
