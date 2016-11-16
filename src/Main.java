import de.voidplus.leapmotion.LeapMotion;
import processing.core.PApplet;

public class Main extends PApplet {

	static public PApplet app;
	Logica log;
	LeapMotion leap;

	public static void main(String[] args) {
		PApplet.main("Main");
	}

	@Override
	public void settings() {
		size(1200, 700, P3D);
	}

	@Override
	public void setup() {
		Main.app = this;
		log = new Logica();
		leap = new LeapMotion(app);

	}

	@Override
	public void draw() {
		background(255);
		log.draww();
	}

}