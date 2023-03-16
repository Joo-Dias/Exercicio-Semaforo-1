package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class DirecaoController extends Thread{

	Random random = new Random();
	int rd = random.nextInt(3);
	
	private int numCarro;
	private String []direcaoCarro;
	private Semaphore semaforo;
	
	public DirecaoController(int numCarro, String []direcaoCarro, Semaphore semaforo) {
		this.numCarro = numCarro;
		this.direcaoCarro = direcaoCarro;
		this.semaforo = semaforo;
	}
	
	public void run() {
		try {
			semaforo.acquire();
			moveCarro();
			carroFinalizado();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	
	public void moveCarro() {
		int tempoEspera = (int) ((Math.random() + 1) * 5000);
		try {
			System.out.println("O "+numCarro+" carro está indo para a direção "+direcaoCarro[rd]);
			Thread.sleep(tempoEspera);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void carroFinalizado() {
		System.out.println("O carro "+numCarro+" já foi para "+direcaoCarro[rd]);
	}

}
