import java.util.Random;
import java.util.Scanner;

/**
 * Minijuego que forma parte del juego Chernoville
 * 
 * Consta de una serie de indicadores que debemos mantener a un nivel optimo para ganar, parecido al famoso juego "Reigns"
 * 
 * En el juego hay una serie de eventos que dependiendo de lo que elijamos suben o bajan esos indicadores
 * 
 * @author Gabri
 *
 */
public class JuegoNuclearCare {


	public static Random random = new Random();
	public static Scanner scanner = new Scanner(System.in);

	public static int nivelEnergiaReactor = 50;
	public static int nivelEnfadoJefes = 50;
	public static int nivelEnfadoNovia = 50;
	public static boolean indicadoresErroneos = false;
	public static boolean gameWin = true;
	public static int rondas = 1;

	
	
	public static String[] frasesJessica = {
			"Oye he pensado en vender tu consola y con el dinero comprarme ropa.\nTe llamo para avisar, gracias cielo!!\n\n",
			"Hola! Te llamo para decirte que te he rallado el coche nuevo al aparcar jiji.\nPerdona, mañana lo llevo al taller dejame la tarjeta y de paso compro mas ropa para mi!\n\n",
			"Hola amor! Decirte que ha venido tu amigo a casa y bueno una vecina lo ha visto,despues de ducharse, saltar por la ventana desnudo\npara salvar un gatito, lo digo por si comenta algo no te extrañes, besos!\n\n",
			"Que tal va el trabajo? Espero que bien! He tirado un par de ropa que tenias para \nmeter ropa mia, ah y la tele se ha estropeado sola, estaba viendola he tocado un cable y ya no va, arreglala cuando llegues!\n\n"
	};


	public static String[] frasesJefe = {
			"Miralo holgazaneando como siempre! Si sigues asi acabaras despedido creeme! A trabajar.",
			"Como al reactor le pase algo te despedire tan fuerte que hasta tus futuros hijos acabaran despedidos en el futuro cuando nazcan!",
			"Soy tu superior, y como tal debes respetarme, porque gano mas que tu!",
			"Oye tu trabajador numero 42, trabaja mas fuerte!"
	};

	
	/**
	 * Imprime la intro del juego
	 * 
	 * @throws InterruptedException
	 */
	public static void printIntro() throws InterruptedException {
		System.out.println("\n\nTu trabajo consiste en un juego de elecciones\n");
		Thread.sleep(2000);
		System.out.println("Tendras que mantener el nivel de energia nuclear en niveles optimos para evitar una explosion\n");
		Thread.sleep(2000);
		System.out.println("A la vez tendras que vigilar de no enfadar tus superiores mientras trabajas\n");
		Thread.sleep(2000);
		System.out.println("A parte de esos peligros tu novia te llama por telefono cada dos por tres! Mantenla contenta o se divorciara de ti!\n");
		Thread.sleep(2000);
		System.out.println("En el juego veras tres indicadores, debes mantenerlos a un nivel menor del maximo para no perder!\n");
		Thread.sleep(3000);
		System.out.println("Tambien si alguno de los indicadores cae a un nivel inferior al minimo pierdes!\n");
		Thread.sleep(2000);
		System.out.println("Acaba las 5 rondas con niveles optimos (entre 0% y 100%), sino el reactor acabara dañado!\n");
		System.out.println("Mucha suerte!\n");
		Thread.sleep(3000);
		bucleRonda();
	}


	/**
	 * Imprime los indicadores de cada personaje o reactor
	 */
	public static void printarIndicadores() {
		System.out.print("\n\n___INDICADORES___\n");
		System.out.println("INDICADOR ENERGIA: "+nivelEnergiaReactor+"%");
		System.out.println("INDICADOR ENFADO JEFES: "+nivelEnfadoJefes+"%");
		System.out.println("INDICADOR ENFADO NOVIA: "+nivelEnfadoNovia+"%\n\n");
	}
	

	/**
	 * Imprime la intro del juego
	 * @throws InterruptedException
	 */
	public static void introRondas() throws InterruptedException {
		System.out.println("Jefe Vladimir: Oye tu! Que haces holgazaneando. Ponte a trabajar!");
		Thread.sleep(2000);
		System.out.println("Jefe Vladimir: Si te veo sin trabajar ni que sea un momento preparate porque duraras poco mocoso!");
		Thread.sleep(2000);
		System.out.println("RING....RING....");
		Thread.sleep(3000);
		System.out.println("Jessica: Oye! Porque tardas tanto en cogerme el telefono?");
		Thread.sleep(2000);
		System.out.println("Jessica: Mañana tenemos cena con mis padres acuerdate!");
		Thread.sleep(2000);
		System.out.println("Jessica: Y como tardes en cogerme el telefono de nuevo la tendremos!");
		Thread.sleep(4000);
	}


	/**
	 * Bucle que ejecuta las rondas del juego
	 * 
	 * @throws InterruptedException
	 */
	public static void bucleRonda() throws InterruptedException {

		for(int i=0;i<=5;i++) {
			printarIndicadores();
			Thread.sleep(3000);

			if(rondas == 1) {
				System.out.println("\nRONDA: "+rondas+"\n");
				introRondas();
				rondas++;
			}
			else if(rondas > 1 && rondas <= 5) {
				System.out.println("\nRONDA: "+rondas+"\n");
				routerEventos(numeroEventosRonda());
				rondas++;
			}
		}
		finJuego();
	}

	/**
	 * Router de los possibles eventos de cada ronda
	 * @param numeroAleatorio
	 * @throws InterruptedException
	 */
	public static void routerEventos(int numeroAleatorio) throws InterruptedException {
		switch(numeroAleatorio) {
		case 1: eventoNovia();
		case 2:	eventoJefe();
		case 3: eventoReactor();
		case 4: eventoNoviaReactor();
		case 5: eventoNoviaJefe();
		case 6: eventoJefeReactor();
		}
	}


	/**
	 * Evento de la novia
	 * 
	 * @throws InterruptedException
	 */
	public static void eventoNovia() throws InterruptedException {
		System.out.println("RIINNNG.... RIIINGGG");
		System.out.println("Es Jessica. Coges el telefono?\n");
		System.out.println(" 1-SI   2-NO\n");
		int eleccion = scanner.nextInt();
		
		if(eleccion == 1) {
			eventoNoviaOpcionUno();
		}
		else if(eleccion == 2) {
			eventoNoviaOpcionDos();
		}
	}
	
	/**
	 * Opcion uno evento novia
	 * @throws InterruptedException
	 */
	public static void eventoNoviaOpcionUno() throws InterruptedException {
		int aumentoAleatorio = random.nextInt(15)+10;
		conversaJessica();
		System.out.println("Has cogido el telefono a Jessica su nivel de enfado ha bajado.");
		nivelEnfadoNovia-=aumentoAleatorio;
		Thread.sleep(3000);
	}
	
	
	/**
	 * Opcion dos evento novia
	 * 
	 * @throws InterruptedException
	 */
	public static void eventoNoviaOpcionDos() throws InterruptedException {
		int aumentoAleatorio = random.nextInt(15)+10;
		System.out.println("No le has cogido el numero a Jessica."); 
		Thread.sleep(3000);
		System.out.println("Su nivel de enfado ha aumentado.");
		nivelEnfadoNovia+=aumentoAleatorio;
		Thread.sleep(3000);
	}
	
	/**
	 * Conversa con la novia
	 * 
	 * @throws InterruptedException
	 */
	public static void conversaJessica() throws InterruptedException {
		int numeroRandom = random.nextInt(4);
		System.out.println("Jessica: "+frasesJessica[numeroRandom]);
		Thread.sleep(4000);
	}
	
	
    /**
     * Evento jefe
     * 
     * @throws InterruptedException
     */
	public static void eventoJefe() throws InterruptedException {
		System.out.println("\nJefe Vladimir: Oye tu! Estaras trabajando no??\n");
		System.out.println("1-Si  2-No");
		int eleccion = scanner.nextInt();
		int aumentoAleatorio = random.nextInt(15)+10;
		if(eleccion == 1) {
			eventoJefeOpcionUno();
		}
		else if(eleccion == 2) {
			eventoJefeOpcionDos();
		}
	}
	
	/**
	 * Primera opcion evento jefe
	 * 
	 * @throws InterruptedException
	 */
	public static void eventoJefeOpcionUno() throws InterruptedException {
		int aumentoAleatorio = random.nextInt(15)+10;
		conversaJefe(); 
		Thread.sleep(3000);
		System.out.println("Tu jefe se va contento, el nivel de enfado baja\n");
		nivelEnfadoJefes-=aumentoAleatorio;
	}
	
	/**
	 * Segunda opcion evento jefe
	 * 
	 * @throws InterruptedException
	 */
	public static void eventoJefeOpcionDos() throws InterruptedException {
		int aumentoAleatorio = random.nextInt(15)+10;
		System.out.println("Jefe Vladimir: Maldito insolente! Como sigas asi te despido!\n");
		Thread.sleep(2000);
		System.out.println("Has enfadado a tu jefe, su nivel de enfado ha subido\n");
		nivelEnfadoJefes+=aumentoAleatorio;
		Thread.sleep(3000);	
	}
	
	
	/**
	 * Imprime una conversa con tu jefe
	 * 
	 * @throws InterruptedException
	 */
	public static void conversaJefe() throws InterruptedException {
		int numeroRandom = random.nextInt(4);
		System.out.println("Jefe Vladimir: "+frasesJefe[numeroRandom]+"\n");

	}
	
	/**
	 * Evento del reactor
	 * 
	 * @throws InterruptedException
	 */
	public static void eventoReactor() throws InterruptedException {
		System.out.println("PELIGRO REACTOR SOBRECARGADO\n");
		Thread.sleep(3000);
		System.out.println("Arreglar fallo?\n");
		System.out.println("1-SI   2-NO");
		int eleccion = scanner.nextInt();
		if(eleccion == 1) {
			eventoReactorOpcionUno();
		}
		else if(eleccion == 2) {
			eventoReactorOpcionDos();
		}
	}
	
	
	/**
	 * Primera opcion evento reactor
	 * @throws InterruptedException
	 */
	public static void eventoReactorOpcionUno() throws InterruptedException {
		int aumentoAleatorio = random.nextInt(15)+10;
		System.out.println("Nivel de energia del reactor disminuido\n");
		nivelEnergiaReactor-=aumentoAleatorio;
		Thread.sleep(3000);
	}
	
	/**
	 * Segunda opcion evento reactor
	 * @throws InterruptedException
	 */
	public static void eventoReactorOpcionDos() throws InterruptedException {
		int aumentoAleatorio = random.nextInt(15)+10;
		System.out.println("El nivel de energia del reactor ha aumentado");
		nivelEnergiaReactor+=aumentoAleatorio;
		Thread.sleep(3000);
	}
	
	
	
	
    /**
     * Evento novia - reactor
     * @throws InterruptedException
     */
	public static void eventoNoviaReactor() throws InterruptedException {
		System.out.println("\n\nTu novia te llama mientras el reactor entra en modo peligro.\n");
		Thread.sleep(3000);
		System.out.println("Aceptas la llamada de tu novia o arreglas el reactor?\n");
		System.out.println("1-NOVIA   2-REACTOR\n");
		int eleccion = scanner.nextInt();
		if(eleccion == 1) {
			eventoNoviaReactorOpcionNovia();
		}
		else if(eleccion == 2) {
			eventoNoviaReactorOpcionReactor();
		}
	}
	
    
	
	/**
	 * Opcion novia
	 * @throws InterruptedException
	 */
	public static void eventoNoviaReactorOpcionNovia() throws InterruptedException {
		int aumentoAleatorio = random.nextInt(15);
		conversaJessica();
		System.out.println("Has cogido el telefono a tu novia, su nivel de enfado baja.");
		Thread.sleep(3000);
		System.out.println("No has arreglado el reactor su nivel de peligro sube.");
		Thread.sleep(3000);
		nivelEnergiaReactor+= aumentoAleatorio;
		nivelEnfadoNovia-= aumentoAleatorio;
	}
	
	/**
	 * Opcion reactor
	 * @throws InterruptedException
	 */
	public static void eventoNoviaReactorOpcionReactor() throws InterruptedException {
		int aumentoAleatorio = random.nextInt(15);
		System.out.println("No has cogido el telefono a tu novia su nivel de enfado sube");
		Thread.sleep(3000);
		System.out.println("Has arreglado el reactor su nivel de peligro sube");
		Thread.sleep(3000);
		nivelEnergiaReactor-= aumentoAleatorio;
		nivelEnfadoNovia+= aumentoAleatorio;	
	}
	

	/**
	 * Evento jefe - novia
	 * @throws InterruptedException
	 */
	public static void eventoNoviaJefe() throws InterruptedException {
		System.out.println("\n\nTu novia te llama mientras tu jefe te pide ayuda.\n");
		Thread.sleep(3000);
		System.out.println("Aceptas la llamada de tu novia o ayudas a tu jefe?\n");
		System.out.println("1-NOVIA   2-JEFE\n");
		
		int eleccion = scanner.nextInt();
		if(eleccion == 1) {
			eventoNoviaJefeOpcionNovia();
		}
		else if(eleccion == 2) {
			eventoNoviaJefeOpcionJefe();
		}
	}
	
	/**
	 * Opcion novia
	 * 
	 * @throws InterruptedException
	 */
	public static void eventoNoviaJefeOpcionNovia() throws InterruptedException {
		int aumentoAleatorio = random.nextInt(15);
		conversaJessica();
		System.out.println("Has cogido el telefono a tu novia, su nivel de enfado baja.");
		Thread.sleep(3000);
		System.out.println("No has ayudado a tu jefe su nivel de enfado sube.");
		Thread.sleep(3000);
		nivelEnfadoJefes+= aumentoAleatorio;
		nivelEnfadoNovia-= aumentoAleatorio;
	}
	
	/**
	 * Opcion jefe
	 * 
	 * @throws InterruptedException
	 */
	public static void eventoNoviaJefeOpcionJefe() throws InterruptedException {
	    int aumentoAleatorio = random.nextInt(15);
		System.out.println("No has cogido el telefono a tu novia su nivel de enfado sube");
		Thread.sleep(3000);
		System.out.println("Has ayudado a tu jefe su nivel de enfado baja.");
		Thread.sleep(3000);
		nivelEnfadoJefes-= aumentoAleatorio;
		nivelEnfadoNovia+= aumentoAleatorio;
	}
	
	/**
	 * Evento jefe - reactor
	 * 
	 * @throws InterruptedException
	 */
	public static void eventoJefeReactor() throws InterruptedException {
		System.out.println("\n\nTu jefe te pide ayuda mientras el reactor entra en modo peligro.\n");
		Thread.sleep(3000);
		System.out.println("Ayudas a tu jefe o arreglas el reactor?\n");
		System.out.println("1-JEFE   2-REACTOR\n");
		int eleccion = scanner.nextInt();
		if(eleccion == 1) {
			eventoJefeReactorOpcionJefe();
		}
		else if(eleccion == 2) {
		  eventoJefeReactorOpcionReactor();
		}
	}
	
	/**
	 * Opcion jefe
	 * 
	 * @throws InterruptedException
	 */
	public static void eventoJefeReactorOpcionJefe() throws InterruptedException {
		int aumentoAleatorio = random.nextInt(15);
		conversaJefe();
		System.out.println("Has ayudado a tu jefe su nivel de enfado baja.");
		Thread.sleep(3000);
		System.out.println("No has arreglado el reactor su nivel de peligro sube.");
		Thread.sleep(3000);
		nivelEnergiaReactor+= aumentoAleatorio;
		nivelEnfadoJefes-= aumentoAleatorio;
	}
	
	/**
	 * Opcion reactor
	 * 
	 * @throws InterruptedException
	 */
	public static void eventoJefeReactorOpcionReactor() throws InterruptedException {
		int aumentoAleatorio = random.nextInt(15);
		System.out.println("No has ayudado a tu jefe su nivel de enfado sube");
		Thread.sleep(3000);
		System.out.println("Has arreglado el reactor su nivel de peligro sube");
		Thread.sleep(3000);
		nivelEnergiaReactor-= aumentoAleatorio;
		nivelEnfadoJefes+= aumentoAleatorio;	
	}

	/**
	 * Fin del juego
	 * 
	 * @throws InterruptedException
	 */
	public static void finJuego() throws InterruptedException {
		System.out.println("Has acabado las rondas!");
		Thread.sleep(1500);
		System.out.println("Este es el resultado...");
		Thread.sleep(3000);
		System.out.println("\n\n\nNivel energia Reactor= "+nivelEnergiaReactor);
		System.out.println("Nivel enfado Jefes= "+nivelEnfadoJefes);
		System.out.println("Nivel enfado Novia= "+nivelEnfadoNovia+"\n\n");
		Thread.sleep(3000);
		if(nivelEnergiaReactor > 100 || nivelEnfadoJefes > 100 || nivelEnfadoNovia > 100) {
			Chernoville.reactorDañado = true; 
		}
	}
	
	
    /**
     * Numero de eventos por ronda, es aleatorio del 1 al 6
     * @return
     */
	public static int numeroEventosRonda() {
		int numRandom = random.nextInt(6)+1;
		return numRandom;
	}

    /**
     * Inicia el juego
     * 
     * @throws InterruptedException
     */
	public static void initGame() throws InterruptedException {
		printIntro();
	}


	/**
	 * Metodo main
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		JuegoNuclearCare.initGame();
	}

}