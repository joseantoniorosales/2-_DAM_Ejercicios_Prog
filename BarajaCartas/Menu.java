package barajacartas;

import java.io.PrintStream;

import java.util.Scanner;

// Intento de implementación del menu por separado del main. Se corregirá en el futuro

public class Menu {

	public Scanner scan = new Scanner(System.in);

	Carta baraja[] = new Carta[48];

	Carta montonUsado[] = new Carta[48];

	int cont = 0;

	

	public Menu(Scanner scan, Carta[] baraja, Carta[] montonUsado, int cont) {
		super();
		this.scan = scan;
		this.baraja = baraja;
		this.montonUsado = montonUsado;
		this.cont = cont;
	}

	public void Options() {

		System.out.println("PROGRAMA DE GESTIÓN DE BARAJAS");

		System.out.println();

		System.out.println("Elija una de las siguientes opciones: ");

		System.out.println();

		System.out.println("1.- BARAJAR");

		System.out.println();

		System.out.println("2.- SIGUIENTE CARTA");

		System.out.println();

		System.out.println("3.- CARTAS DISPONIBLES");

		System.out.println();

		System.out.println("4.- DAR CARTAS");

		System.out.println();

		System.out.println("5.- MONTÓN DE CARTAS");

		System.out.println();

		System.out.println("6.- MOSTRAR BARAJA");

		System.out.println();

		System.out.println("7.- TERMINAR");

		System.out.println();

	}

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
	 * Indica cual será la próxima carta de la baraja. Indica cuando no quedan.
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

	public void Available() {

	}

	/**
	 * Otorga al usuario la siguiente carta de la baraja. Muestra un mensaje cuando
	 * no quedan cartas en la baraja
	 * 
	 * @param baraja
	 * @param cont
	 * @param noCard
	 * @param montonUsado
	 */

	public void Give(Carta baraja[], int cont, int noCard, Carta montonUsado[]) {

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

	public void Showed() {

	}

	public void Show() {

	}

	public void MenuStart() {

		/* Muestra el menu de opciones */

		Options();

		int opcion = scan.nextInt();

		switch (opcion) {

		case 1:

			Funciones.Shuffle(baraja);

			System.out.println("Barajado correctamente");

			break;

		case 2:

			Funciones.Next(baraja, cont, montonUsado);

			cont++;

			break;
			
		// Indica las cartas restantes en la baraja

		case 3:

			System.out.println("\n" + "Quedan " + (48 - cont) + " cartas restantes");

			break;

		case 4:

			System.out.println("\n" + "Indique el numero de cartas que desea robar:");

			int numCard = scan.nextInt();

			Funciones.Give(baraja, cont, numCard, montonUsado);

			cont += numCard;

			break;
			
		// Revela el monton de cartas ya utilizadas

		case 5:

			if (cont != 0) {

				for (int i = 0; i < cont; i++) {

					System.out.println(montonUsado[i]);
				}

			} else {

				System.out.println("Lo siento, todavia no ha salido ninguna carta");

			}

			break;
			
			// Muestra las cartas restantes en la baraja

		case 6:

			if (cont < 48) {

				for (int i = cont; i < 48; i++) {

					System.out.println(baraja[i]);
				}

			} else {

				System.out.println("Lo siento, no quedan cartas");

			}

			break;
			
		case 7:

			return;

		default:

			System.out.println("La opcion introducida no es correcta");

			break;
		} while (opcion != 7);
	


	}
}
