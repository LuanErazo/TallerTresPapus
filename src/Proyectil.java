import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Proyectil {

	protected PApplet app;
	private PVector pos;// localizacion
	private PVector vel;// velocidad
	private PVector gravity;// gravedad
	protected PImage selecta;
	protected Enemigo en;

	protected int puntaje;

	public Proyectil(Enemigo en) {
		this.en = en;
		app = Main.app;
		// Cargue la img
		vel = new PVector(1.5f, 1.5f); // La f al final le dice al programa que es un flotante, sin necesidad de cast
		pos = new PVector(-10,-10);
		gravity = new PVector(0, 0.2f);

	}

	public void mover() {
		

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
			vel.y = vel.y * - 0.5f;
			pos.y = app.height;
		}
	}

	public void display() {
		// agregue esto
		app.imageMode(PConstants.CENTER);
		app.image(selecta, pos.x, pos.y);
		mover();
	}

	/*
	 * cree getters y setters =======================================
	 */
	public PVector getPos() {
		return pos;
	}

	public void setPos(PVector loc) {
		this.pos = loc;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	
	
	// ============================================
}
