package carrera;

import java.util.concurrent.CountDownLatch;

import javax.swing.JProgressBar;

import corredor.Corredor;

public class Carrera {

	private CountDownLatch espera;
	private Pista pista;
	private int distancia=100;
	private double velocidad = 500;
	private Thread[] lista;
	private boolean finalizada;

	public Carrera(int nCorredores) {
		pista = new Pista();
		espera = new CountDownLatch(1);
		lista = new Thread[nCorredores];
		for (int i = 0; i < nCorredores; i++) {
			lista[i] = new Thread(new Corredor(i, this));
			lista[i].start();
		}
		pista.setVisible(true);
		try {
			Thread.sleep(1500);
			System.out.println("Preparados...");
			Thread.sleep(1500);
			System.out.println("Listos...");
			Thread.sleep(1500);
			System.out.println("YA!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		espera.countDown();
	}

	public CountDownLatch getEspera() {
		// TODO Auto-generated method stub
		return espera;
	}

	public void añadirCorredor(JProgressBar barra) {
		pista.getContentPane().add(barra);

	}

	public double getVelocidad() {
		// TODO Auto-generated method stub
		return velocidad;
	}

	public synchronized void setGanador(Corredor ganador) {
		if (!finalizada) {
			System.out.println("El corredor " + ganador.getDorsal() + " gana " + " ha tardado: " + ganador.getTiempo()/1000 + " segundos");
			finalizada=true;
		}
		for (Thread loser : lista) {
			loser.interrupt();
		}

	}

	public boolean getFinalizada() {
		// TODO Auto-generated method stub
		return finalizada;
	}

	public int getDistancia() {
		// TODO Auto-generated method stub
		return distancia;
	}
}
