import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;

import ddf.minim.Minim;

public class Logica {

	private PApplet app;
	private Carga datos;
	private Player jugador;
	private PImage inicio, instrucciones, fondoCarro, fondoEnemigo, enemigo, bomba;
	private int cambio = 0;
	private Enemigo en;
	private PFont fuente;
	private ArrayList<Proyectil> proyectiles;

	// Aqui van todas las variables u objetos de prueba
	private Proyectil bala;
	private Main main;

	public Logica(Main main) {
		app = Main.app;
		this.main = main;
		subirObjetos();
		proyectiles = new ArrayList<Proyectil>();

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
		jugador = new Player(this);
		en = new Enemigo();
		bala = new Proyectil();
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

			app.image(fondoCarro, 0, 0);

			break;
		case 3:
			app.image(fondoEnemigo, 0, 0);
			en.display();
			timer();
			// Carga.fft.forward(Carga.cancion.mix);
			Carga.cancion.play();
			if (proyectiles.size() > 0) {
				for (Proyectil proyectil : proyectiles) {
					proyectil.display();
				}

			}
			jugador.display();
			break;
		}
		// jugador.mover(izq.getStabilizedPosition());
	}

	private void timer() {
		if (app.frameCount % 60 == 0) {
			proyectiles.add(en.tirarBomba());
		}
	}

	public void paraLeap(PVector v) {


	}

	public void vectorLeap(PVector v) {
		if (cambio == 0) {
			app.ellipse(v.x, v.y, 50, 50);
		}
		if (cambio == 1) {
			app.ellipse(v.x, v.y, 50, 50);

		}
		if (cambio == 2) {
			app.ellipse(v.x, v.y, 50, 50);

		}
		if (cambio == 3) {
			jugador.mover(v);
		}

	}

	public void MinimUso() {

	}

	public void clicked(PVector v, String string) {
		/**
		 * Áreas sensibles para cambios de pantalla
		 */if (string == "index") {			
			 if (v.x > 495 && v.x < 706 && v.y > 524 && v.y < 604 && cambio == 0) {
				 cambio += 1;
			 }
			 
			 if (v.x > 1030 && v.x < 1168 && v.y > 70 && v.y < 124 && cambio == 1) {
				 cambio += 1;
			 }
			 
			 if (v.x > 58 && v.x < 192 && v.y > 574 && v.y < 628 && cambio == 2) {
				 cambio += 1;
			 }
		}
	}

	private void mover() {

	}
	
	

	public int getCambio() {
		return cambio;
	}

	public static boolean validar(float XUno, float YUno, float XDos, float YDos, float dist) {
		if (PApplet.dist(XUno, YUno, XDos, YDos) <= dist) {
			return true;
		}
		return false;
	}

}
