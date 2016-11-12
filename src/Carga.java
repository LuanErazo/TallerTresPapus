import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

public class Carga {
	private PApplet app;
	public static PImage carro;
	public static PImage player;
	public static PImage enemigo;
	public static PImage bomba;
	public static PImage sparkie;
	public static PImage sparkieReal;
	public static PImage fondoCarro;
	public static PImage fondoEnemigo;
	public static PImage instrucciones;
	public static PImage inicio;

	public Carga() {
		app = Main.app;
		carro = app.loadImage("../data/imagenMJ2.png");
		player = app.loadImage("../data/carrito.png");
		enemigo = app.loadImage("../data/enemigo.png");
		bomba = app.loadImage("../data/bomba.png");
		sparkie = app.loadImage("../data/sparkie.png");
		sparkieReal = app.loadImage("../data/sparkieReal.png");
		fondoCarro = app.loadImage("../data/pantallaTres.png");
		fondoEnemigo = app.loadImage("../data/pantallaCuatro.png");
		instrucciones = app.loadImage("../data/pantallaDos.png");
		inicio = app.loadImage("../data/pantallaUno.png");

	}

}
