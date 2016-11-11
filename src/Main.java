import processing.core.PApplet;

public class Main extends PApplet {

	static public PApplet app;
	Logica log;

	public static void main(String[] args) {
		PApplet.main("Main");
	}

	@Override
	public void settings() {
		size(1200, 700);
	}

	@Override
	public void setup() {
		Main.app = this;
		log = new Logica();

	}

	@Override
	public void draw() {
		background(255);
		log.draww();
	}

}