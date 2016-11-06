import processing.core.PApplet;
import processing.core.PShape;

public class Carga {
	private PApplet app;
	public static PShape carro;
	public static PShape player;
	public static PShape enemigo;
	public static PShape bomba;
	public static PShape sparkie;
	public static PShape sparkieReal;
	public static PShape fondoCarro;
	public static PShape fondoEnemigo;
	public static PShape instrucciones;

	public Carga() {
		carro = app.loadShape("../data/");
		player = app.loadShape("../data/");
		enemigo = app.loadShape("../data/");
		bomba = app.loadShape("../data/");
		sparkie = app.loadShape("../data/");
		sparkieReal = app.loadShape("../data/");
		fondoCarro = app.loadShape("../data/");
		fondoEnemigo = app.loadShape("../data/");
		instrucciones = app.loadShape("../data/");

	}

}
