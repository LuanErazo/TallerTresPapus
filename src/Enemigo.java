import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class Enemigo extends Thread {

	private PApplet app;
	private PVector pos;
	private boolean bomba;
	private int min;
	private ArrayList<Proyectil> tirables;

	public Enemigo() {
		app = Main.app;
		tirables = new ArrayList<Proyectil>();
	}
	
	public void mover(){
		
	}
	
	public void display(){
		
	}
	
	public Proyectil tirarBomba(){
		Proyectil ob = null;
		for (int i = 0; i < tirables.size(); i++) {
			ob = tirables.get(i);
		}
		return ob;
	}
	
	public void contador(){
		
	}

	
}
