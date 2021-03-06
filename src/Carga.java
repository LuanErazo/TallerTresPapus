import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;
import processing.core.PImage;

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
	public static PImage perder;
	
	//parte de sonido
	
	public static Minim minim;
	public static AudioPlayer cancion;
	public static AudioPlayer cancionDos;
	public static FFT fft;
	public static FFT fftDos;

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
		perder = app.loadImage("../data/perdiste.png");
		
		//carga del audio
		
		minim = new Minim(app);
		cancion = minim.loadFile("../data/Cancion.mp3", 512);
		cancionDos = minim.loadFile("../data/CancionDos.mp3", 512);
		fft = new FFT(cancion.bufferSize(),cancion.sampleRate());
		fftDos = new FFT(cancionDos.bufferSize(),cancionDos.sampleRate());

	}

}
