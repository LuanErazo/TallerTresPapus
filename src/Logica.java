import processing.core.PApplet;

public class Logica {

	private PApplet app;
	
	public Logica() {
		app = Main.app;
	}
	
	public  boolean validar(float XUno, float YUno, float XDos, float YDos, float dist){
		if(PApplet.dist(XUno, YUno, XDos, YDos)<= dist){
			return true;
		}
		return false;
	}
	
	public void draww(){
		
		HUD();
	}
	
	public void leapMotionPlz(){
		
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
