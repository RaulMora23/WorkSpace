package imprimirNombre;

public class Main1 {
	public static void main(String[] args) {
		new Thread(new Hilo("Pepe")).start();
		new Thread(new Hilo("Juan")).start();
		new Thread(new Hilo("Pepa")).start();
	}
}
	
