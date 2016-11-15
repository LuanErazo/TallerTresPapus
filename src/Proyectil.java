import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Proyectil {

	protected PApplet app;
	private PVector loc;// localizacion
	private PVector vel;// velocidad
	private PVector gravity;// gravedad
	private PImage bomba;

	protected int puntaje;

	public Proyectil() {
		app = Main.app;
		// Cargue la img
		bomba = Carga.bomba;
		vel = new PVector((float) 1.5, (float) 1.5);
		loc = new PVector(100, 100);
		gravity = new PVector(0, (float) 0.2);

	}

	public void pintar() {
		// agregue esto
		app.image(bomba, loc.x, loc.y);
	}

	public void mover() {
		// agrega velocidad a la posicion
		loc.add(vel);
		// agrega gravedad a la velocidad
		vel.add(gravity);

		// esta joda hace que la esfera o el elemento, rebote en las esquinas
		if ((loc.x > app.width) || (loc.x < 0)) {
			vel.x = vel.x * -1;
		}
		if (loc.y > app.height) {
			// esto reduce la velocidad de rebote si el elemento toca el piso
			vel.y = vel.y * -(float) 0.95;
			loc.y = app.height;
		}
	}

	public void display() {

	}

	/*
	 * cree getters y setters =======================================
	 */
	public PVector getLoc() {
		return loc;
	}

	public void setLoc(PVector loc) {
		this.loc = loc;
	}
	// ============================================
}
