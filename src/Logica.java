import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;

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
	private PImage inicio, instrucciones, fondoCarro, fondoEnemigo, enemigo, bomba;
	private int cambio = 2;
	private Enemigo en;
	private PFont fuente;
	private ArrayList<Proyectil> proyectiles;

	// Aqui van todas las variables u objetos de prueba
	private Proyectil bala;

	public Logica() {
		app = Main.app;
		subirObjetos();
		proyectiles = new ArrayList<Proyectil>();
		der = leap.getRightHand();
		izq = leap.getLeftHand();

		CargaImg();

		fuente = app.createFont("Thinking_of_Betty.ttf", 40);

	}

	/**
	 * metodo que iguala todas las imagenes desde el la carga de datos
	 */
	private void CargaImg() {
		inicio = Carga.inicio;
		instrucciones = Carga.instrucciones;
		fondoCarro = Carga.fondoCarro;
		fondoEnemigo = Carga.fondoEnemigo;
		bomba = Carga.bomba;
	}

	/**
	 * metoddo donde inicializamos todos los objetos que se van a usar
	 */
	private void subirObjetos() {
		datos = new Carga();
		leap = new LeapMotion(app);
		jugador = new Player(this);
		en = new Enemigo();
		bala = new Proyectil();
	}

	public static boolean validar(float XUno, float YUno, float XDos, float YDos, float dist) {
		if (PApplet.dist(XUno, YUno, XDos, YDos) <= dist) {
			return true;
		}
		return false;
	}

	public void draww() {
		app.imageMode(PConstants.CORNER);
		switch (cambio) {
		case 0:

			app.image(inicio, 0, 0);

			break;
		case 1:

			app.image(instrucciones, 0, 0);

			break;
		case 2:
			
			Carga.cancionDos.play();
			app.image(fondoCarro, 0, 0);

			break;
		case 3:

			app.image(fondoEnemigo, 0, 0);
			en.display();
			timer();
			//Carga.fft.forward(Carga.cancion.mix);
			Carga.cancion.play();
			if (proyectiles.size() >0) {
				for (Proyectil proyectil : proyectiles) {
					proyectil.display();
				}
				
			}
			break;
		}
		leapMotionPlz();
		// jugador.mover(izq.getStabilizedPosition());
		jugador.display();
		// System.out.println(izq.getPalmPosition().x + " " +
		// izq.getPalmPosition().y);
		HUD();

	}

	private void timer() {
		if (app.frameCount % 60 == 0) {
			proyectiles.add(en.tirarBomba());
		}
	}

	public void leapMotionPlz() {
		int fps = leap.getFrameRate();
		for (Hand hand : leap.getHands()) {
			PVector handStabilized = hand.getStabilizedPosition();
			hand.draw();
			app.ellipse(handStabilized.x, handStabilized.y, 40, 40);
			if (handStabilized != null) {
				v = handStabilized;					
			}
		}
	}
	
	public PVector vectorLeap(){
		return v;
	}

	public void MinimUso() {

	}

	private void clicked() {
		/**
		 * areas sensibles para los cambos de pantalla
		 */
		if (app.mouseX > 495 && app.mouseX < 706 && app.mouseY > 524 && app.mouseY < 604 && cambio == 0) {
			cambio += 1;
		}
		
		if (app.mouseX > 1030 && app.mouseX < 1168 && app.mouseY > 70 && app.mouseY < 124 && cambio == 1) {
			cambio += 1;
		}
		
		if (app.mouseX > 58 && app.mouseX < 192 && app.mouseY > 574 && app.mouseY < 628 && cambio == 2) {
			cambio += 1;
		}
	}

	private void mover() {

	}

	private void HUD() {

	}

}
