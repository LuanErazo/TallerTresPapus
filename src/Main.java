import de.voidplus.leapmotion.Finger;
import de.voidplus.leapmotion.Hand;
import de.voidplus.leapmotion.KeyTapGesture;
import de.voidplus.leapmotion.LeapMotion;
import processing.core.PApplet;
import processing.core.PVector;

public class Main extends PApplet {

	static public PApplet app;
	Logica log;
	LeapMotion leap;
	Hand handD;

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
		log = new Logica(this);
		leap = new LeapMotion(app);
		leap.allowGestures();
	}

	public void leapMotionPlz() {
		int fps = leap.getFrameRate();
		for (Hand hand : leap.getHands()) {
			PVector handStabilized = hand.getStabilizedPosition();
//			hand.draw();
			log.vectorLeap(handStabilized);
		}
	}
	
	public Hand getHand(){
		return handD;
	}

	public void leapOnKeyTapGesture(KeyTapGesture g) {
		int id = g.getId();
		Finger finger = g.getFinger();
		PVector position = g.getPosition();
		PVector direction = g.getDirection();
		long duration = g.getDuration();
		float durationSeconds = g.getDurationInSeconds();

		for (Hand hand : g.getHands()) {
			PVector v = hand.getStabilizedPosition();
			log.clicked(v, finger.getTypeName());
		}
		System.out.println("KeyTapGesture: " + id);
	}

	@Override
	public void draw() {
		background(255);
		log.draww();
		leapMotionPlz();
	}

}