import java.util.Random;
import java.util.Scanner;

/**
 * Juego de escribir palabras en el menor tiempo possible
 * al acabar las rondas debes tener menos tiempo que tu adversario para ganar
 * 
 * @author Darian
 *
 */

public class HiperShoot {


	public static Scanner scanner = new Scanner(System.in);
	public static Random random = new Random();


	public static int tiempoJugadorUno = 0;
	public static int tiempoJugadorDos = 0;
	public static int tiempoMaquina = 0;


	public static boolean reglasImprimidas = false;



	public static String[] palabras = {
			"Hola",
			"adios",
			"esternocleidomastoideo",
			"kalasnikov",
			"abecedario",
			"modelo",
			"vehiculo",
			"airear",
			"mistico",
			"doraemon",
			"supercagifragilisticoespialidoso",
			"comida",
			"ascensor",
			"dia",
			"pertenencia",
			"efímero",
			"audacia",
			"perspicacia",
			"honrado",
			"diestro",
			"componente",
			"bootstrap",
			"recursión",
			"deseoso"
	};


	/**
	 * Restartea las variables del juego
	 */
	public static void restartVariables() {
		tiempoJugadorUno = 0;
		tiempoJugadorDos = 0;
		tiempoMaquina = 0;
	}

	/**
	 * Inicia el juego
	 * @throws InterruptedException
	 */
	public static void initGame() throws InterruptedException {

		System.out.println(" __ __  ____  ____   ___  ____    _____ __ __   ___    ___   ______ \r\n" + 
				"|  |  ||    ||    \\ /  _]|    \\  / ___/|  |  | /   \\  /   \\ |      |\r\n" + 
				"|  |  | |  | |  o  )  [_ |  D  )(   \\_ |  |  ||     ||     ||      |\r\n" + 
				"|  _  | |  | |   _/    _]|    /  \\__  ||  _  ||  O  ||  O  ||_|  |_|\r\n" + 
				"|  |  | |  | |  | |   [_ |    \\  /  \\ ||  |  ||     ||     |  |  |  \r\n" + 
				"|  |  | |  | |  | |     ||  .  \\ \\    ||  |  ||     ||     |  |  |  \r\n" + 
				"|__|__||____||__| |_____||__|\\_|  \\___||__|__| \\___/  \\___/   |__|  \r\n" + 
				"                                                                    ");
		Thread.sleep(600);
		gameModeSelector();
	}


	/**
	 * Seleccionador del modo de juego
	 * 
	 * @throws InterruptedException
	 */
	public static void gameModeSelector() throws InterruptedException {
		restartVariables();
		System.out.println("1-PLAYER VS AI   2-PLAYER VS PLAYER   3-RETURN to Chernoville 4-Return to HUB");
		int eleccion = scanner.nextInt();
		if(eleccion == 1) {
			singlePlayerGame();	
		}
		else if(eleccion == 2) {
			multiPlayerGame();	
		}
		else if(eleccion == 3) {
			Chernoville.printarPantallaInicio();
		}
		else if(eleccion == 4) {
			Terminal.iniciarTerminal();
		}
		
		else {
			gameModeSelector();
		}
	}



	/**
	 * Juego un solo jugador
	 * 
	 * @throws InterruptedException
	 */
	public static void singlePlayerGame() throws InterruptedException {
		boolean gameIsRunning = true;
		if(!reglasImprimidas) {
			printGameControls();	
		}
		while(gameIsRunning) {
			bucleJuegoUnSoloJugador();	
		}	
	}

	/**
	 * Imprime los controles del juego
	 * 
	 * @throws InterruptedException
	 */
	public static void printGameControls() throws InterruptedException {
		System.out.println("\nEn autoshoot debes escribir en el minimo tiempo possible una serie de palabras que iran saliendo.\n");
		Thread.sleep(3000);
		System.out.println("Cuanto menos tiempo tardes mas puntos ganaras.\n");
		Thread.sleep(3000);
		System.out.println("Si tu adversario tarda menos tiempo en total, pierdes, si no, ganas!!\n");
		Thread.sleep(3000);
		System.out.println("El juego empezara.... YA!!!");
		reglasImprimidas = true;
		Thread.sleep(3000);
		

	}


	/**
	 * Bucle de ejcucion del modo un solo jugador contra la IA
	 * @throws InterruptedException
	 */
	public static void bucleJuegoUnSoloJugador() throws InterruptedException {
		for(int i=0;i<10;i++) {
			int indexArray = random.nextInt(palabras.length-1); 
			System.out.println("\nRonda :"+(i+1)+"\n");  
			System.out.print("La palabra es.");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".\n\n");
			System.out.println(palabras[indexArray]);
			adivinarPalabra(indexArray);
		}
		compararTiemposIaJugador();
	}


	/**
	 * Juego principal
	 * 
	 * @param index
	 * @throws InterruptedException
	 */
	public static void adivinarPalabra(int index) throws InterruptedException {
		int tiempo1 = (int) System.currentTimeMillis();

		String palabraAdivinada = scanner.next();
		int tiempo2 = (int) System.currentTimeMillis();

		if(palabraAdivinada.equals(palabras[index])) {
			System.out.println("\nPalabra escrita correctamente!\n");	
			Thread.sleep(1500);
		}
		else if(!palabraAdivinada.equals(palabras[index])) {
			System.out.println("No has acertado la palabra! Se penaliza tu tiempo");
			tiempoJugadorUno += 6;
		}
		tiempoJugadorUno+= (tiempo2 - tiempo1)/1000;
		tiempoMaquina += random.nextInt(5)+2;
	}




	/**
	 * Compara el tiempo de la IA y el jugador para ver quien ha ganado
	 * 
	 * @throws InterruptedException
	 */
	public static void compararTiemposIaJugador() throws InterruptedException {
		Thread.sleep(1500);
		System.out.println("Has hecho un tiempo de: ");
		Thread.sleep(2000);
		System.out.println(tiempoJugadorUno+" segundos");
		Thread.sleep(2000);
		System.out.println("\n\nLa maquina ha hecho un tiempo de:");
		Thread.sleep(2000);
		System.out.println(tiempoMaquina+" segundos");
		Thread.sleep(2000);
		compararGanadorPerdedor(tiempoJugadorUno, tiempoMaquina);
	}


	/**
	 * Imprime por pantalla el jugador del modo Player vs IA
	 * @param tJugadorUno
	 * @param tMaquina
	 * @throws InterruptedException
	 */
	public static void compararGanadorPerdedor(int tJugadorUno,int tMaquina) throws InterruptedException {
		if(tJugadorUno < tMaquina) {
			System.out.println("\nJugador Uno Gana!!");
			Thread.sleep(3000);
			initGame();
		}
		else if(tJugadorUno > tMaquina) {
			System.out.println("\nMaquina Gana!!");
			Thread.sleep(3000);
			initGame();
		}
		else if(tJugadorUno == tMaquina) {
			System.out.println("Vuestro tiempo es igual! Habeis empatado!");
			initGame();
		}
	}




	/**
	 * Modo de juego multijugador
	 * 
	 * @throws InterruptedException
	 */
	public static void multiPlayerGame() throws InterruptedException {
		boolean gameIsRunning = true;
		if(!reglasImprimidas) {
			printGameControls();	
		}
		bucleJuegoDosJugadores();	
		
	}



	/**
	 * Bucle de ejecución modo dos jugadores
	 * 
	 * @throws InterruptedException
	 */
	public static void bucleJuegoDosJugadores() throws InterruptedException {
		bucleJugadorUno();
		bucleJugadorDos();
		compararTiempoJugadores(tiempoJugadorUno, tiempoJugadorDos);
	}


	/**
	 * Bucle de ejecución del jugador uno
	 * 
	 * @throws InterruptedException
	 */
	public static void bucleJugadorUno() throws InterruptedException {
		System.out.println("\n\n__JUGADOR UNO__\n\n");
		for(int i=0;i<10;i++) {
			Thread.sleep(3000);
			int indexArray = random.nextInt(palabras.length-1); 
			System.out.println("\nRonda :"+(i+1)+"\n");  
			System.out.print("La palabra es.");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".\n\n");
			System.out.println(palabras[indexArray]);
			adivinarPalabraJugadorUno(indexArray);
		}
	}

	/**
	 * Bucle de ejecución del jugador dos
	 * 
	 * @throws InterruptedException
	 */
	public static void bucleJugadorDos() throws InterruptedException {
		System.out.println("\n\n__JUGADOR DOS__\n\n");
		for(int i=0;i<10;i++) {
			Thread.sleep(3000);
			int indexArray = random.nextInt(palabras.length-1); 
			System.out.println("\nRonda :"+(i+1)+"\n");  
			System.out.print("La palabra es.");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".\n\n");
			System.out.println(palabras[indexArray]);
			adivinarPalabraJugadorDos(indexArray);
		}
	}


	/**
	 * El jugador uno debe adivinar la palabra en el metodo
	 * 
	 * @param index
	 * @throws InterruptedException
	 */
	public static void adivinarPalabraJugadorUno(int index) throws InterruptedException {
		int tiempo1 = (int) System.currentTimeMillis();

		String palabraAdivinada = scanner.next();
		int tiempo2 = (int) System.currentTimeMillis();

		if(palabraAdivinada.equals(palabras[index])) {
			System.out.println("\nPalabra escrita correctamente!\n");	
			Thread.sleep(1500);
		}
		else if(!palabraAdivinada.equals(palabras[index])) {
			System.out.println("No has acertado la palabra! Se penaliza tu tiempo");
			tiempoJugadorUno += 6;
		}
		tiempoJugadorUno+= (tiempo2 - tiempo1)/1000;
	}

	/**
	 * El jugador dos debe adivinar la palabra en el metodo
	 * 
	 * @param index
	 * @throws InterruptedException
	 */
	public static void adivinarPalabraJugadorDos(int index) throws InterruptedException {
		int tiempo1 = (int) System.currentTimeMillis();

		String palabraAdivinada = scanner.next();
		int tiempo2 = (int) System.currentTimeMillis();

		if(palabraAdivinada.equals(palabras[index])) {
			System.out.println("\nPalabra escrita correctamente!\n");	
			Thread.sleep(1500);
		}
		else if(!palabraAdivinada.equals(palabras[index])) {
			System.out.println("No has acertado la palabra! Se penaliza tu tiempo");
			tiempoJugadorUno += 6;
		}
		tiempoJugadorDos+= (tiempo2 - tiempo1)/1000;	
	}

	/**
	 * Compara el tiempo entre el Jugado Uno y el Jugador Dos
	 * 
	 * @param tJugadorUno
	 * @param tJugadorDos
	 * @throws InterruptedException
	 */
	public static void compararTiempoJugadores(int tJugadorUno, int tJugadorDos) throws InterruptedException {
		if(tJugadorUno < tJugadorDos) {
			System.out.println("Jugador Uno Gana!!\n\n");
			Thread.sleep(3000);
			initGame();
		}
		else if(tJugadorUno > tJugadorDos) {
			System.out.println("Jugador Dos Gana!!\n\n");
			Thread.sleep(3000);
			initGame();
		}
		else if(tJugadorUno == tJugadorDos) {
			System.out.println("Los dos teneis el mismo tiempo es un empate!");
			Thread.sleep(3000);
			initGame();
		}
	}



	/**
	 * Metodo main de ejecucción
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		HiperShoot.initGame();
	}

}