
public class Bomba extends Proyectil {
 
	public Bomba(Enemigo en) {
		super(en);
		selecta = Carga.bomba;
		puntaje = -10;
	}
}
