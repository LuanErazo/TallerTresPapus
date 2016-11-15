import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Proyectil {

	protected PApplet app;
	private PVector pos;// localizacion
	private PVector vel;// velocidad
	private PVector gravity;// gravedad
	private PImage bomba;

	protected int puntaje;

	public Proyectil() {
		app = Main.app;
		// Cargue la img
		bomba = Carga.bomba;
		vel = new PVector(1.5f, 1.5f); // La f al final le dice al programa que es un flotante, sin necesidad de cast
		pos = new PVector(app.width/2, 100);
		gravity = new PVector(0, 0.2f);

	}

	private void mover() {
		// agrega velocidad a la posicion
		pos.add(vel);
		// agrega gravedad a la velocidad
		vel.add(gravity);

		// esta joda hace que la esfera o el elemento, rebote en las esquinas
		if ((pos.x > app.width) || (pos.x < 0)) {
			vel.x = vel.x * -1;
		}
		if (pos.y >= app.height) {
			// esto reduce la velocidad de rebote si el elemento toca el piso
			vel.y = vel.y * - 0.95f;
			pos.y = app.height;
		}
	}

	public void display() {
		// agregue esto
		mover();
		app.imageMode(PConstants.CENTER);
		app.image(bomba, pos.x, pos.y);
	}

	/*
	 * cree getters y setters =======================================
	 */
	public PVector getLoc() {
		return pos;
	}

	public void setLoc(PVector loc) {
		this.pos = loc;
	}
	// ============================================
}
