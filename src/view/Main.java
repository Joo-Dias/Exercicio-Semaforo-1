package view;

import java.util.concurrent.Semaphore;
import controller.DirecaoController;

public class Main {
	
	public static Semaphore semaforo;

	public static void main(String[] args) {
		
		String[] direcaoCarro = {"Norte", "Sul", "Leste", "Oeste"};
		int maxCarros = 1;
		
		semaforo = new Semaphore(maxCarros);
		for(int i = 0; i < 4; i++) {
			Thread direcaoCar = new DirecaoController(i, direcaoCarro, semaforo);
			direcaoCar.start();
		}
	}

}
