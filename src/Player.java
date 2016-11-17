import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Player {
	private PApplet app;
	private PVector pos;
	private int puntaje;
	private PImage jugador;

	public Player() {
		app = Main.app;
		pos = new PVector(500,600);
		jugador = Carga.player;
	}

	public void mover(PVector leapV) {
		pos.x = leapV.x;
	}

	public void moverMouse(){
		pos.x = app.mouseX;
	}

	public void display() {
		app.pushMatrix();
		app.translate(pos.x, pos.y);
		app.image(jugador, 0, 0);
		app.popMatrix();
		app.textAlign(PConstants.CENTER, PConstants.CENTER);
		app.text(puntaje, app.width/2, 80);
	}

	public void sumarPuntaje(ArrayList<Proyectil> lista) {
			if (lista.size() >0) {
				for (int i = 0; i < lista.size(); i++) {
					Proyectil proyectil = lista.get(i);
					if (Logica.validar(pos.x, pos.y, proyectil.getPos().x, proyectil.getPos().y, 80)) {
						puntaje += proyectil.getPuntaje();
						proyectil.setPuntaje(0);
						lista.remove(proyectil);
					}
				
					
				}				
			}

	}

	public PVector getPos() {
		return pos;
	}

	public void setPos(PVector pos) {
		this.pos = pos;
	}

	public int getPuntaje() {
		return puntaje;
	}
	
	
	
	
}
