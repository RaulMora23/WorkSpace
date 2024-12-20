package corredor;

import java.util.concurrent.CountDownLatch;

public class Corredor implements Runnable {
	private int dorsal;
	private double tiempo;
	private CountDownLatch espera;
	public Corredor(int dorsal, CountDownLatch espera) {
		this.dorsal = dorsal;
		this.espera = espera;
	}
	@Override
	public void run() {
		try {
			System.out.println("Corredor "+dorsal+" está listo");
			espera.await();
			tiempo= 9 + Math.random()*2;
			tiempo= tiempo*100;
			int tiempoInt = (int) tiempo;
			tiempo= ((double)tiempoInt)/100;
			System.out.println("El dorsal "+dorsal+" ha tardado "+tiempo+" segundos");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
