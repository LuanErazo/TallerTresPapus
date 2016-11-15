import processing.core.PApplet;
import processing.core.PVector;

public class Proyectil {

	protected PApplet app;
	protected PVector pos;
	private PVector loc;// localizacion
	private PVector vel;// velocidad
	private PVector acc;// aceleracion
	private PVector gravity;// gravedad
	private float mass;// masa

	protected int puntaje;

	public Proyectil() {
		app = Main.app;
		// bomba = Carga.bomba;
		vel = new PVector((float) 1.5, (float) 1.5);
		loc = new PVector(100, 100);
		acc = new PVector(0, 0);
		mass = (float) 10.0;
		gravity = new PVector(0, (float) 0.2);

	}

	protected void pintar() {
		app.stroke(255);
		app.strokeWeight(2);
		app.fill(127);
		app.ellipse(loc.x, loc.y, 48, 48);
	}

	public void mover() {
		loc.add(vel);
		  // Add gravedad a la velocidad
		  vel.add(gravity);
		  
		  // esta joda hace que la esfera o el elemento, rebote en las esquinas
		  if ((loc.x > app.width) || (loc.x < 0)) {
		    vel.x = vel.x * -1;
		  }
		  if (loc.y > app.height) {
		    // esto reduce la velocidad de rebote si el elemento toca el piso
		    vel.y = vel.y * -(float)0.95; 
		    loc.y = app.height;
		  }
	}

	public void display() {

	}
}
