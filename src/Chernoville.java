import java.util.Random;
import java.util.Scanner;
/**
 * Juego sobre el desastre nuclear de Chernovyl. 
 * Consta de varios dias y las acciones que hagas afectan al final del juego
 * 
 * @author Gabri
 *
 */

public class Chernoville {



	public static Scanner scanner = new Scanner(System.in);
	public static Random random = new Random();

	public static String arrayInfoJugador[] = new String[3];

	public static boolean tuberiaAgrietada = false;
	public static boolean reactorDañado = false;
	public static boolean storyLogActualizado = false;


	public static String arrayInformes[] = new String[3];
	public static String arrayAcontecimientos[] = new String[2];




    /**
     * Imprime el titulo del juego
     * 
     */
	public static void introCrypto() {
		System.out.println("   (       )                                  (   (        \r\n" + 
				"   )\\   ( /(    (   (                 )   (   )\\  )\\   (   \r\n" + 
				" (((_)  )\\())  ))\\  )(    (      (   /((  )\\ ((_)((_) ))\\  \r\n" + 
				" )\\___ ((_)\\  /((_)(()\\   )\\ )   )\\ (_))\\((_) _   _  /((_) \r\n" + 
				"((/ __|| |(_)(_))   ((_) _(_/(  ((_)_)((_)(_)| | | |(_))   \r\n" + 
				" | (__ | ' \\ / -_) | '_|| ' \\))/ _ \\\\ V / | || | | |/ -_)  \r\n" + 
				"  \\___||_||_|\\___| |_|  |_||_| \\___/ \\_/  |_||_| |_|\\___|  ");
	}


    /**
     * Imprime el menu principal del juego
     * @throws InterruptedException
     */
	public static void printarPantallaInicio() throws InterruptedException {
		introCrypto();
		Thread.sleep(500);
		int eleccion = 0;
		System.out.println("\n\n1- Jugar  2-Story Log  3-Multiplayer Game   4-Exit  \n");
		eleccion = scanner.nextInt();

		if(eleccion == 1) {
			start();
		}
		else if(eleccion == 2) {
			comprobarStoryLog();
		}
		else if(eleccion == 3) {
			if(!storyLogActualizado) {
				System.out.println("\n\n\n\nDebes acabar el juego para jugar el minijuego!\n\n\n");
				Thread.sleep(2000);
				printarPantallaInicio();
			}
			HiperShoot.initGame();
		}
		else if(eleccion == 4) {
          Terminal.iniciarTerminal();
		}
		else {
			printarPantallaInicio();
		}
	}


	/**
	 * Desbloquea el story log al acabar el juego
	 * @throws InterruptedException
	 */
	public static void comprobarStoryLog() throws InterruptedException {
		if(storyLogActualizado) {
			printarStoryLog();
		}
		else if(!storyLogActualizado) {
			System.out.println("\n\n\n\nDebes acabar el juego para desbloquear el Story Log!\n\n\n\n");
			Thread.sleep(3000);
		}
		printarPantallaInicio();
	}


	/**
	 * Imprime el contenido del story log
	 * @throws InterruptedException
	 */
	public static void printarStoryLog() throws InterruptedException {
		System.out.println("  Estos son tus informes:  \n\n");
		for(int i=1;i<=2;i++) {
			System.out.println(arrayInformes[i]);
			System.out.println("\n");
		}
		System.out.println("\n\n\n\n");

		System.out.println("  Nombre de tu personaje: ");
		System.out.println(arrayInfoJugador[0]);
		Thread.sleep(5000);
		printarPantallaInicio();
	}

	
    /**
     * Imprime una cuenta artras
     * @throws InterruptedException
     */
	public static void printCountDown() throws InterruptedException {
		for(int i=0;i<10;i++) {
			System.out.println("Countdown "+(10-i));
			Thread.sleep(400);
		}
	}


	/**
	 * Metodo que inicia el juego
	 * @throws InterruptedException
	 */
	public static void start() throws InterruptedException {
		beginGameIntro();
		printPrimerDia();

	}

	/**
	 * Inicia la historia principal del juego
	 * @throws InterruptedException
	 */
	public static void beginGameIntro() throws InterruptedException {
		System.out.println("\n\n\n | 24 de Abril 1986 |\n");
		Thread.sleep(2000);
		System.out.println("Anatoly: Hola mi nombre es Anatoly!");
		Thread.sleep(2000);
		System.out.println("Anatoly: Soy el encargado de vigilar la central hoy. Mi trabajo como ingeniero jefe es mantener la seguridad.");
		Thread.sleep(2500);
		System.out.println("Anatoly: Dime como te llamas?");
		System.out.print("\nNombre: ");
		arrayInfoJugador[0] = scanner.next();
		System.out.println("Anatoly: Bien "+arrayInfoJugador[0]+" acompañame!");
		Thread.sleep(2000);
	}


	/**
	 * Imprime el texto del primer dia
	 * @throws InterruptedException
	 */
	public static void printPrimerDia() throws InterruptedException {
		System.out.println("Anatoly: Te han asignado trabajar en el sector 5.");
		Thread.sleep(2000);
		System.out.println("Anatoly: Aqui las cosas son muy tranquilas, has tenido suerte!");
		Thread.sleep(2000);
		System.out.println("Anatoly: Tendras que vigilar un par de tuberias y ya. No es mucho trabajo pero tendras que hacerlo bien.");
		Thread.sleep(2000);
		System.out.println("Anatoly: Cualquier error podria provocar hasta que la central explotase! Imagina el desastre que esto supondria.");
		Thread.sleep(2000);
		System.out.println("Anatoly: Bueno "+arrayInfoJugador[0]+" te dejo trabajar!");
		Thread.sleep(2000);
		System.out.println("Anatoly: Cuando acabes tu jornada escribe un informe de como te ha ido el dia, acuerdate de hacerlo es muy importate!");
		Thread.sleep(2000);
		pantallaCarga();
		trabajoJugadorChernovyl();
	}

	/**
	 * Imprime una pantalla de carga
	 * 
	 * @throws InterruptedException
	 */
	public static void pantallaCarga() throws InterruptedException {
		System.out.println("\n\nCargando Dia Laboral...10%...");
		Thread.sleep(1500);
		System.out.println("Cargando Dia Laboral...28%...");
		Thread.sleep(1500);
		System.out.println("Cargando Dia Laboral...39%...");
		Thread.sleep(1500);
		System.out.println("Cargando Dia Laboral...76%...");
		Thread.sleep(1500);
		System.out.println("Cargando Dia Laboral...100%...\n\n\n");
	}


	/**
	 * Primer dia de trabajo del jugador
	 * 
	 * @throws InterruptedException
	 */
	public static void trabajoJugadorChernovyl() throws InterruptedException {
		System.out.println("\n\n\n\n||                  Bienvenido a tu primer dia de trabajo!!!!!                     ||");
		System.out.println("\n||  Tendras que adivinar el numero que la maquina genere, tendras 10 intentos      ||\n");
		System.out.println("||   Si no lo consigues una tuberia se agrietara, aumentando el riesgo de explotar ||");
		Thread.sleep(4000);
		int numeroRandom = random.nextInt(99)+1;
		int numeroElegido = 0;
		int tantoPorCientoTuberiaAgrietada = 0;

		for(int i=0;i<3;i++) {
			tantoPorCientoTuberiaAgrietada += rondaJuego(numeroRandom,numeroElegido);
			numeroRandom = random.nextInt(100)+1;
		}
		rellenarInforme(1);
		comprobadorTuberiaAgrietada(tantoPorCientoTuberiaAgrietada);
		printSegundoDia();
	}



	/**
	 * Ronda de juego del primer dia de trabajo
	 * @param numeroRandom
	 * @param numeroElegido
	 * @return
	 * @throws InterruptedException
	 */
	public static int rondaJuego(int numeroRandom,int numeroElegido) throws InterruptedException {
		int numeroIntentos = 0;
		System.out.println("\nQue numero crees que ha generado la maquina? (Del 1 al 100)");
		while(numeroRandom != numeroElegido && numeroIntentos < 10) {
			System.out.print("\nNumero: ");
			numeroElegido = scanner.nextInt();	
			boolean resultado = comparadorNumeros(numeroRandom,numeroElegido);
			numeroIntentos++;
			if(resultado) {
				System.out.println("Muy bien! Has adivinado el numero, la tuberia no se agrieta!\n");
				return 0;
			}
		}
		System.out.println("Has agotado los intentos! La tuberia se ha agrietado un tercio mas. \n");
		Thread.sleep(2000);
		return 33;
	}



    /**
     * Compara los numeros del primer minijuego para ver si el jugador ha acertado
     *
     * @param num1
     * @param num2
     * @return
     * @throws InterruptedException
     */
	public static boolean comparadorNumeros(int num1, int num2) throws InterruptedException {
		if(num1 < num2) {
			System.out.println("\nEl numero introducido es mas grande que el numero que buscas!\n");
			return false;
		}
		else if(num1 > num2) {
			System.out.println("\nEl numero introducido es mas pequeño que el numero que buscas!\n");
			return false;
		}
		else if(num1 == num2) {
			System.out.println("\nHas adivinado el numero! Bien hecho!\n");
			Thread.sleep(1200);
			return true;
		}
		return false;
	}



    /**
     * Metodo para rellenar informes de trabajo
     * @param dia
     * @throws InterruptedException
     */
	public static void rellenarInforme(int dia) throws InterruptedException {
		System.out.println("Has acabado tu dia laboral numero "+dia);
		Thread.sleep(2000);
		System.out.println("Rellena el informe diario sobre todo lo que has hecho hoy!");
		Thread.sleep(3000);
		System.out.println("Informe del dia:");
		System.out.println("---------------");
		arrayInformes[dia] = scanner.next();
		System.out.println("\n\n\n\n\n");
		System.out.println("Informe añadido! Que tengas un buen dia "+ arrayInfoJugador[0]);
		Thread.sleep(2000);
	}



	/**
	 * Comprueba si el resultado del primer dia de trabajo ha sido bueno o malo
	 * @param tantoPorCiento
	 * @throws InterruptedException
	 */
	public static void comprobadorTuberiaAgrietada(int tantoPorCiento) throws InterruptedException {
		if(tantoPorCiento < 60 ) {
			tuberiaNoEstaAgrietada();
		}
		else if(tantoPorCiento > 60) {
			tuberiaEstaAgrietada();
		}
	}


	/**
	 * Si el resultado del primer dia de trabajo ha sido bueno se ejecuta
	 * @throws InterruptedException
	 */
	public static void tuberiaNoEstaAgrietada() throws InterruptedException {
		System.out.println("Has acabado tu jornada laboral sin daños estructurales! Bien hecho");
		Thread.sleep(2000);
		arrayAcontecimientos[0] = "No has roto la tuberia";
		System.out.println("Este acontecimiento repercutira en el futuro....");
		Thread.sleep(2000);
		finDelDia();
	}

    /**
     * Si el resultado del primer dia de trabajo ha sido malo se ejecuta
     * @throws InterruptedException
     */
	public static void tuberiaEstaAgrietada() throws InterruptedException {
		System.out.println("\nHas acabado tu jornada laboral y has destruido unas tuberias!");
		arrayAcontecimientos[0] = "Has roto la tuberia";
		tuberiaAgrietada = true;
		Thread.sleep(2000);
		System.out.println("\nEste acontecimiento repercutira en el futuro....");
		Thread.sleep(2000);
		finDelDia();
	}

	/**
	 * Fin del primer dia de trabajo
	 * 
	 * @throws InterruptedException
	 */
	public static void finDelDia() throws InterruptedException {
		System.out.println("\nHas acabado el dia...");
		Thread.sleep(2000);
		System.out.println("\n__Siguiente dia__\n");
		Thread.sleep(2000);

	}


	/**
	 * Imprime el texto del segundo dia de trabajo
	 * @throws InterruptedException
	 */
	public static void printSegundoDia() throws InterruptedException {
		System.out.println(" | 25 de Abril 1986 |\n");
		Thread.sleep(2000);
		System.out.println("Anatoly: Hola buenos dias "+arrayInfoJugador[0]+" que tal has dormido?\n");
		Thread.sleep(3000);
		if(arrayAcontecimientos[0].charAt(0) == 'N') {
			System.out.println("Anatoly: Buen trabajo el de ayer! Si alguna de esas tuberias hubiese explotado habria sido una locura!\n");
			Thread.sleep(2000);
			System.out.println("Anatoly: Ven te enseñare algo\n");
			Thread.sleep(2000);
			segundoDiaIntroduccion();
		}
		else if(arrayAcontecimientos[0].charAt(0) == 'H') {
			System.out.println("Anatoly: Me entere de tu desempeño del otro dia. Es inaceptable, tendre que reducirte el sueldo un 50%...\n");
			Thread.sleep(2000);
			System.out.println("Tu sueldo se ha reducido un 50%...\n");
			arrayInfoJugador[1] = "Sueldo: 1000";
			Thread.sleep(2000);
			System.out.println("Anatoly: No te despido porque necesitamos toda la gente possible. Ven, te enseñare algo!\n");
			Thread.sleep(2000);
			segundoDiaIntroduccion();
		}
	}




	/**
	 * Imprime texto de la historia
	 * @throws InterruptedException
	 */
	public static void segundoDiaIntroduccion() throws InterruptedException {
		System.out.println("Anatoly: Esta es la sala del reactor principal.");
		Thread.sleep(2000);
		System.out.println("Anatoly: Aqui es donde almacenamos todo nuestro plutonio");
		Thread.sleep(2000);
		System.out.println("Anatoly: Hoy te ocuparas de vigilarlo");
		Thread.sleep(2000);
		System.out.println("Anatoly: Es muy importante que estes muy atento");
		Thread.sleep(2000);
		System.out.println("Anatoly: EL MAS MINIMO ERROR PUEDE PROVOCAR UNA CATASTROFE");
		Thread.sleep(2000);
		System.out.println("Anatoly: Ah! Sobretodo no toques el boton rojo con el simbolo de muerte.\n\n\n");
		Thread.sleep(3000);
		trabajoSegundoDia();
	}


	/**
	 * Inicia el segundo dia de trabajo
	 * @throws InterruptedException
	 */
	public static void trabajoSegundoDia() throws InterruptedException {
		System.out.println("\n\n\n\n||                  Bienvenido a tu segundo dia de trabajo!!!!!                     ||");
		System.out.println("\n||  Tendras que vigilar el reactor principal de la central con mucho cuidado.       ||\n");
		System.out.println("||   Caulquier error podria provocar un fallo en el reactor en el futuro!           ||");
		Thread.sleep(3000);
		JuegoNuclearCare.initGame();
		finDiaDos();

	}

	/**
	 * Finaliza el segundo dia
	 * @throws InterruptedException
	 */
	public static void finDiaDos() throws InterruptedException {
		if(reactorDañado) {
			System.out.println("Anatoli: Pero bueno, como puedes ser tan descuidado! Has roto el reactor \n");
			Thread.sleep(3000);
			System.out.println("Anatoli: Pensaba que podia confiar en ti para este trabajo. Pero veo que no\n");
			Thread.sleep(3000);
			System.out.println("Anatoli: Vete a casa anda! Y mañana ven mas atento...");
			Thread.sleep(3000);
			System.out.println("Has roto el reactor. Este acontecimiento repercutira en el futuro.\n");
			Thread.sleep(3000);
			rellenarInforme(2);
			diaLaboralTres();
		}
		else if(!reactorDañado) {
			System.out.println("Anatoli: Buen trabajo, has vigilado bien el reactor!\n");
			Thread.sleep(3000);
			System.out.println("Anatoli: Sabia que podia confiar en ti "+arrayInfoJugador[0]+"\n");
			Thread.sleep(3000);
			System.out.println("Anatoli: Ve a dormir! Mañana sera un dia importante. Pondremos el reactor a máxima potencia!\n");
			Thread.sleep(3000);
			rellenarInforme(2);
			diaLaboralTres();
		}
	}



	/**
	 * Inicia el tercer dia de trabajo
	 * @throws InterruptedException
	 */
	public static void diaLaboralTres() throws InterruptedException {
		System.out.println("\n\n\n | 26 de Abril 1986 |\n");
		Thread.sleep(3000);
		System.out.println("Anatoli: Bien "+arrayInfoJugador[0]+" espero que hayas descansado porque nos espera un dia largo.");
		Thread.sleep(3000);
		System.out.println("Anatoli: Hoy realizaremos una prueba de potencia en el reactor. Lo pondremos a maxima potencia!");
		Thread.sleep(3000);
		System.out.println("Anatoli: Adelante! Poned el reactor a máxima potencia!!!!");
		Thread.sleep(3000);
		tercerDiaLaboral();
	}


	/**
	 * Comprueba las acciones del jugador
	 * @throws InterruptedException
	 */
	public static void tercerDiaLaboral() throws InterruptedException {
		if(tuberiaAgrietada && reactorDañado) {
			reactorExplota();
		}
		else if(!tuberiaAgrietada && !reactorDañado) {
			reactorNoExplota();
		}
		else if(tuberiaAgrietada || reactorDañado) {
			int numRandom = random.nextInt(2);
			if(numRandom == 1) {
				reactorExplota();	
			}
			else if(numRandom == 0) {
				reactorNoExplota();
			}
		}
	}




	/**
	 * Final malo
	 * 
	 * @throws InterruptedException
	 */
	public static void reactorExplota() throws InterruptedException {
		System.out.println("Anatoli: Vamos a aumentar el nivel a la maxima potencia!!!!\n");
		Thread.sleep(3000);
		System.out.println("Las tuberias del reactor estan fallando...\n");
		Thread.sleep(3000);
		System.out.println("Anatoli: Vamos muchachos! Aun no esta del todo al máximo!\n");
		Thread.sleep(3000);
		System.out.println("El nucleo del reactor esta fallando....");
		Thread.sleep(3000);
		System.out.println("Anatoli: Que esta pasando?!?!!?! El reactor esta fallando!!!\n");
		Thread.sleep(3000);
		System.out.println("Anatoli: ABORTEN EL TEST!! YA!!!!");
		pantallaReactorExplotado();
	}


	/**
	 * Actualiza el story log
	 */
	public static void actualizarStoryLog() {
		storyLogActualizado = true;
	}


	/**
	 * Final malo
	 * @throws InterruptedException
	 */
	public static void pantallaReactorExplotado() throws InterruptedException {
		System.out.println("         _ ._  _ , _ ._\r\n" + 
				"        (_ ' ( `  )_  .__)\r\n" + 
				"      ( (  (    )   `)  ) _)\r\n" + 
				"     (__ (_   (_ . _) _) ,__)\r\n" + 
				"         `~~`\\ ' . /`~~`\r\n" + 
				"              ;   ;\r\n" + 
				"              /   \\\r\n" + 
				"_____________/_ __ \\_____________");
		Thread.sleep(3000);
		System.out.println("Debido a tus acciones el reactor ha explotado!");
		Thread.sleep(3000);
		System.out.println("GAME OVER");
		Thread.sleep(2000);
		actualizarStoryLog();
		printarPantallaInicio();
	}

	/**
	 * Final bueno
	 * 
	 * @throws InterruptedException
	 */
	public static void reactorNoExplota() throws InterruptedException {
		System.out.println("Anatoli: Vamos muchachos poned el reactor a máxima potencia!!");
		Thread.sleep(3000);
		System.out.println("Anatoli: Asi me gusta! Subidlo al tope!!");
		Thread.sleep(3000);
		System.out.println("Anatoli: Bien chicos! Parece que todo esta en orden!.");
		Thread.sleep(3000);
		System.out.println("Anatoli: Buen trabajo! Apagadlo todo y mañana repetiremos el test!!");
		Thread.sleep(3000);
		pantallaReactorSinExplotar();

	}

	/**
	 * Final bueno
	 * @throws InterruptedException
	 */
	public static void pantallaReactorSinExplotar() throws InterruptedException {
		System.out.println("\n\n\n\n\n          ) ) )                     ) ) )\r\n" + 
				"        ( ( (                      ( ( (\r\n" + 
				"      ) ) )                       ) ) )\r\n" + 
				"   (~~~~~~~~~)                 (~~~~~~~~~)\r\n" + 
				"    | POWER |                   | POWER |\r\n" + 
				"    |       |                   |       |\r\n" + 
				"    I      _._                  I       _._\r\n" + 
				"    I    /'   `\\                I     /'   `\\\r\n" + 
				"    I   |   N   |               I    |   N   |\r\n" + 
				"    f   |   |~~~~~~~~~~~~~~|    f    |    |~~~~~~~~~~~~~~|\r\n" + 
				"  .'    |   ||~~~~~~~~|    |  .'     |    | |~~~~~~~~|   |\r\n" + 
				"/'______|___||__###___|____|/'_______|____|_|__###___|___|");
		Thread.sleep(3000);
		System.out.println("\nDebido a tus acciones la central no ha explotado!");
		Thread.sleep(3000);
		System.out.println("\nFIN DEL JUEGO");
		Thread.sleep(3000);
		System.out.println("\n\n\n\n\n\n\n");
		actualizarStoryLog();
		printarPantallaInicio();
	}





	/**
	 * Inicia el juego
	 * @throws InterruptedException
	 */
	public static void iniciarJuego() throws InterruptedException {
		introCrypto();
		printarPantallaInicio();
	}



	/**
	 * Cliente de la clase o metodo main
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Chernoville.printarPantallaInicio();
	}
}