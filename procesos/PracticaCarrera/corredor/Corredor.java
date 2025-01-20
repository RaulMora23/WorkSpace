package corredor;

import java.awt.Color;
import java.util.concurrent.CountDownLatch;

import javax.swing.JProgressBar;

import carrera.Carrera;

public class Corredor implements Runnable {
	private Carrera carrera;
	private int dorsal;
	private double tiempo;
	private JProgressBar barra;

	public Corredor(int dorsal, Carrera carrera) {
		this.carrera = carrera;
		this.dorsal = dorsal;
		tiempo=0;
		barra = new JProgressBar();
	}

	@Override
	public void run() {
		try {
			
			barra.setMaximum(carrera.getDistancia());
			carrera.añadirCorredor(barra);
			System.out.println("Corredor " + dorsal + " está listo");
			carrera.getEspera().await();
			while (!carrera.getFinalizada()) {
				try {
					if (barra.getValue() != barra.getMaximum()) {
						barra.setValue(barra.getValue() + 1);
						
					}else {
						barra.setBackground(Color.GREEN);
						carrera.setGanador(this);
					}
					long t=(long)(Math.random()*300);
					barra.updateUI();
					Thread.sleep(t);
					tiempo+=t;
				} catch (Exception e) {
					Thread.currentThread().interrupt();
				}
			}
			System.out.println("El corredor " + dorsal +" se ha quedado a " +(100-barra.getValue())+ " metros de la meta");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch bloc
		}

	}

	public int getDorsal() {
		// TODO Auto-generated method stub
		return dorsal;
	}

	public double getTiempo() {
		// TODO Auto-generated method stub
		return tiempo;
	}

}
