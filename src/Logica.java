import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import com.leapmotion.leap.Leap;
import ddf.minim.Minim;
import de.voidplus.leapmotion.Hand;
import de.voidplus.leapmotion.LeapMotion;

public class Logica {

	private PApplet app;
	private LeapMotion leap;
	private Carga datos;
	private Player jugador;
	private Hand der;
	private Hand izq;
	private PVector v;
	private PImage inicio, instrucciones, fondoCarro, fondoEnemigo, enemigo;
	private int cambio = 3;
	private Enemigo en;

	public Logica() {
		app = Main.app;
		datos = new Carga();
		leap = new LeapMotion(app);
		der = leap.getRightHand();
		izq = leap.getLeftHand();
		v = new PVector(100, 100);
		jugador = new Player(v);
		inicio = Carga.inicio;
		instrucciones = Carga.instrucciones;
		fondoCarro = Carga.fondoCarro;
		fondoEnemigo = Carga.fondoEnemigo;
		enemigo = Carga.enemigo;
		en = new Enemigo();
	}

	public static boolean validar(float XUno, float YUno, float XDos, float YDos, float dist) {
		if (PApplet.dist(XUno, YUno, XDos, YDos) <= dist) {
			return true;
		}
		return false;
	}

	public void draww() {
		switch (cambio) {
		case 0:

			app.image(inicio, 0, 0);

			break;
		case 1:

			app.image(instrucciones, 0, 0);

			break;
		case 2:

			app.image(fondoCarro, 0, 0);

			break;
		case 3:

			app.image(fondoEnemigo, 0, 0);
			app.image(enemigo, en.getPos().x,en.getPos().y);
//			en.start();

			break;
		}
		leapMotionPlz();
		// jugador.mover(izq.getStabilizedPosition());
		jugador.display();
		// System.out.println(izq.getPalmPosition().x + " " +
		// izq.getPalmPosition().y);
		HUD();

	}

	public void leapMotionPlz() {
		int fps = leap.getFrameRate();
		for (Hand hand : leap.getHands()) {
			PVector handStabilized = hand.getStabilizedPosition();
			hand.draw();
			app.pushMatrix();
			app.translate(handStabilized.x, handStabilized.y, handStabilized.z);
			app.lights();
			app.sphere(50);
			app.popMatrix();
		}
	}

	public void MinimUso() {

	}

	private void clicked() {

	}

	private void mover() {

	}

	private void HUD() {

	}

}
