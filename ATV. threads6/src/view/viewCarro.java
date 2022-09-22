package view;

import java.util.concurrent.Semaphore;
import controller.ThreadsCarro;

public class viewCarro {

	public static void main(String[] args) {


		Semaphore semaforo = new Semaphore(1);

		for (int i = 1; i <= 4; i++) { 

			ThreadsCarro  carro = new ThreadsCarro(i, semaforo);
			carro.start();

		}

	}

}