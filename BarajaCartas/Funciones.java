package barajacartas;

import barajacartas.Carta;

public class Funciones {
	
	/**
	 * Cambia posiciones entre 2 cartas del array al azar
	 * 
	 * @param baraja
	 */

	public static void Shuffle(Carta baraja[]) {

		for (int i = 0; i < 48; i++) {

			int random = (int) (Math.random() * 48);

			Carta saved = baraja[i];

			baraja[i] = baraja[random];
			baraja[random] = saved;
		}
	}

	/**
	 * Otorga la próxima carta de la baraja. Indica cuando no quedan.
	 * 
	 * @param baraja
	 * @param cont
	 * @param montonUsado
	 */

	public static void Next(Carta baraja[], int cont, Carta montonUsado[]) {

		if (cont < 48) {

			System.out.println(baraja[cont]);
			montonUsado[cont] = baraja[cont];

		} else {

			System.out.println("No quedan más cartas en la baraja.");

		}

	}

	/**
	 * Otorga al usuario x cartas de la baraja. Muestra un mensaje cuando
	 * no quedan cartas en la baraja
	 * 
	 * @param baraja
	 * @param cont
	 * @param noCard
	 * @param montonUsado
	 */

	public static void Give(Carta baraja[], int cont, int noCard, Carta montonUsado[]) {

		if (noCard < (48 - cont)) {

			for (int i = 0; i < noCard; i++) {

				System.out.println(baraja[cont]);
				montonUsado[cont] = baraja[cont];

				cont++;

			}

		} else {

			System.out.println("Lo sentimos, no hay suficientes cartas en la baraja");

		}
	}
}
