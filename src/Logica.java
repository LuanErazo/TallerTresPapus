import processing.core.PApplet;
import com.leapmotion.leap.Leap;
import ddf.minim.Minim;
import de.voidplus.leapmotion.Hand;
import de.voidplus.leapmotion.LeapMotion;

public class Logica {

	private PApplet app;
	private LeapMotion leap;
	
	public Logica() {
		app = Main.app;
		leap = new LeapMotion(app);
		
	}
	
	public static boolean validar(float XUno, float YUno, float XDos, float YDos, float dist){
		if(PApplet.dist(XUno, YUno, XDos, YDos)<= dist){
			return true;
		}
		return false;
	}
	
	public void draww(){
		leapMotionPlz();
		HUD();
	}
	
	public void leapMotionPlz(){
		for (Hand hand : leap.getHands()) {
			hand.draw();
		}
	}
	
	public void MinimUso(){
		
	}
	
	private void clicked(){
		
	}
	
	private void mover(){
		
	}
	
	private void HUD(){
		
	}
	
}
