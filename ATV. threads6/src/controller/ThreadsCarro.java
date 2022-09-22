package controller;

import java.util.concurrent.Semaphore;

public class ThreadsCarro extends Thread {

	private int idCarro;
	private int sentido;
	private String Lado;
	private Semaphore semaforo;

	public ThreadsCarro(int idCarro, Semaphore semaforo) {

		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			SentidoVirada();
		} catch (InterruptedException e) {

		} finally {
			semaforo.release();
		}

	}

	private void SentidoVirada() {
		if (idCarro==1) {
			 Lado= "esquerda para direita";
		}
		if (idCarro==2) {
			Lado="direita para esquerda";
		}
		if (idCarro==3) {
			Lado="cima para baixo";
		}
		if (idCarro==4) {
			Lado="baixo para cima";
		}
		System.out.println("carro"+idCarro +" esta cruzando do sentido: \n" +Lado);
		try {
			sleep(500);
		} catch (InterruptedException e) {
		}
		System.err.println("carro " +idCarro+" cruzou\n");
	}
}
