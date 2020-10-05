package barajacartas;

import java.util.Scanner;

import barajacartas.Funciones;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Carta baraja[] = new Carta[48];

		Carta montonUsado[] = new Carta[48];

		int cont = 0;

		// ///////// CREACIÓN DE BARAJA /////////////

		// Copas

		for (int i = 1; i < 13; i++) {

			String numCarta = String.valueOf(i);

			switch (i) {

			case 1:
				baraja[cont] = new Carta("Copas", "As");

				break;

			case 10:

				baraja[cont] = new Carta("Copas", "Sota");

				break;

			case 11:

				baraja[cont] = new Carta("Copas", "Caballo");

				break;

			case 12:

				baraja[cont] = new Carta("Copas", "Rey");

				break;

			default:

				baraja[cont] = new Carta("Copas", numCarta);

			}

			cont++;
		}

		// Espadas

		for (int i = 1; i < 13; i++) {

			String numCarta2 = String.valueOf(i);

			switch (i) {

			case 1:
				baraja[cont] = new Carta("Espadas", "As");

				break;

			case 10:

				baraja[cont] = new Carta("Espadas", "Sota");

				break;

			case 11:

				baraja[cont] = new Carta("Espadas", "Caballo");

				break;

			case 12:

				baraja[cont] = new Carta("Espadas", "Rey");

				break;

			default:

				baraja[cont] = new Carta("Espadas", numCarta2);

			}

			cont++;
		}

		// Bastos

		for (int i = 1; i < 13; i++) {

			String numCarta3 = String.valueOf(i);

			switch (i) {

			case 1:
				baraja[cont] = new Carta("Bastos", "As");

				break;

			case 10:

				baraja[cont] = new Carta("Bastos", "Sota");

				break;

			case 11:

				baraja[cont] = new Carta("Bastos", "Caballo");

				break;

			case 12:

				baraja[cont] = new Carta("Bastos", "Rey");

				break;

			default:

				baraja[cont] = new Carta("Bastos", numCarta3);

			}

			cont++;
		}

		// Oros

		for (int i = 1; i < 13; i++) {

			String numCarta = String.valueOf(i);

			switch (i) {

			case 1:
				baraja[cont] = new Carta("Oros", "As");

				break;

			case 10:

				baraja[cont] = new Carta("Oros", "Sota");

				break;

			case 11:

				baraja[cont] = new Carta("Oros", "Caballo");

				break;

			case 12:

				baraja[cont] = new Carta("Oros", "Rey");

				break;

			default:

				baraja[cont] = new Carta("Oros", numCarta);

			}

			cont++;
		}

		cont = 0;
		int opcion = 0;

		do {

			System.out.println();

			System.out.println("PROGRAMA DE GESTIÓN DE CARTAS");

			System.out.println();

			System.out.println("Indica que deseas hacer:");

			System.out.println();

			System.out.println("1.- Barajar");

			System.out.println();

			System.out.println("2.- Coger una carta");

			System.out.println();

			System.out.println("3.- Mostrar el numero de cartas disponibles");

			System.out.println();

			System.out.println("4.- Coger x numero de cartas");

			System.out.println();

			System.out.println("5.- Revelar el monton de cartas ya utilizadas");

			System.out.println();

			System.out.println("6.- Baraja restante");

			System.out.println();

			System.out.println("7.- Salir");

			System.out.println();

			opcion = scan.nextInt();

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
			}

		} while (opcion != 7);
	}
}
