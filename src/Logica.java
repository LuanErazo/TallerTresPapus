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
	private PImage inicio, instrucciones, fondoCarro, fondoEnemigo, enemigo, bomba, perder;
	private int cambio, cambioDos;
	private boolean chi = false, chiDos = false, chiTres = false;
	private Enemigo en;
	private Carro ca;
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
		app.textFont(fuente);

		cambio = 3;
		cambioDos = 0;
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
		perder = Carga.perder;
	}

	/**
	 * metoddo donde inicializamos todos los objetos que se van a usar
	 */
	private void subirObjetos() {
		datos = new Carga();
		jugador = new Player(this);
		en = new Enemigo();
		ca = new Carro();
		bala = new Proyectil();
	}

	public void draww() {
		System.out.println("x" + app.mouseX);
		System.out.println(app.mouseY);
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
			ca.display(127, ca.pos);
			break;

		case 3:
			app.image(fondoEnemigo, 0, 0);
			en.display();
			timer();
			Carga.cancion.play();
			if (proyectiles.size() > 0) {
				for (Proyectil proyectil : en.getTirables()) {
					proyectil.display();
				}

			}
			jugador.display();
			jugador.moverMouse();
			jugador.sumarPuntaje(proyectiles);
			break;
		}
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
			ca.mover(v);
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
		 */
		if (string == "index") {
			if (v.x > 495 && v.x < 706 && v.y > 524 && v.y < 604 && cambio == 0) {
				cambio += 1;
			}

			if (v.x > 1030 && v.x < 1168 && v.y > 70 && v.y < 124 && cambio == 1) {
				cambio += 1;
			}

			if (v.x > 58 && v.x < 192 && v.y > 574 && v.y < 628 && cambio == 2) {
				cambio += 1;
			}
			if (v.x > 81 && v.x < 137 && v.y > 230 && v.y < 337 && cambio == 2 && chi == false) {
				chi = true;
			}
			if (v.x > 155 && v.x < 215 && v.y > 210 && v.y < 305 && cambio == 2 && chiDos == false) {
				chiDos = true;
			}
			if (v.x > 230 && v.x < 290 && v.y > 177 && v.y < 278 && cambio == 2 && chiTres == false) {
				chiTres = true;
			}
		}
	}

	private void mover() {

	}

	public int getCambio() {
		return cambio;
	}
/**
 * sirve para validar distancias en cualquier clase
 * @param XUno posicion X del elemento uno
 * @param YUno posicion Y del elemento uno
 * @param XDos posion X del elemento dos
 * @param YDos posicion Y del elemento dos
 * @param dist rango minimo donde se tocan los dos elementos
 * @return si el elemento 2 esta a la distancia (dist) del elemento uno
 */
	public static boolean validar(float XUno, float YUno, float XDos, float YDos, float dist) {
		if (PApplet.dist(XUno, YUno, XDos, YDos) <= dist) {
			return true;
		}
		return false;
	}

}
