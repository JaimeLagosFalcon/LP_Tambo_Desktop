package hilos;

import javax.swing.JFrame;

import vista.LogueoTambo;

public class HiloCerrar extends Thread {
	
	private JFrame ventana;
	
	public HiloCerrar (JFrame ventana){
		this.ventana=ventana;
	}
	
	public void run(){
		for (int i = 15; i >=0; i--) {
			LogueoTambo.lblstiempo.setText(i+"s");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Error en el sleep del contador");
			}
		}
		ventana.dispose();
	}

}
