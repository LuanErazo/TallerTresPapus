import processing.core.PApplet;
import processing.core.PVector;

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
	
	public Logica() {
		app = Main.app;
		datos = new Carga();
		leap = new LeapMotion(app);
		der = leap.getRightHand();
		izq = leap.getLeftHand();
		v = new PVector(100,100);
		jugador = new Player(v);
		
	}
	
	public static boolean validar(float XUno, float YUno, float XDos, float YDos, float dist){
		if(PApplet.dist(XUno, YUno, XDos, YDos)<= dist){
			return true;
		}
		return false;
	}
	
	public void draww(){
		leapMotionPlz();
//		jugador.mover(izq.getStabilizedPosition());
		jugador.display();
//		System.out.println(izq.getPalmPosition().x + " " + izq.getPalmPosition().y);
		HUD();
	}
	
	public void leapMotionPlz(){
		 int fps = leap.getFrameRate();
		for (Hand hand : leap.getHands()) {
			PVector handStabilized     = hand.getStabilizedPosition();
			hand.draw();
			app.pushMatrix();
			app.translate(handStabilized.x, handStabilized.y,  handStabilized.z);
			app.lights();
			app.sphere(50);
			app.popMatrix();
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
