import java.util.Random;
import java.util.Scanner;

/**
 * Minijuego con tematica sobre la ruleta rusa
 * 
 * @author Sergio
 *
 */
public class RussianRoulette {
	static Scanner sc = new Scanner(System.in);
	static Random rand = new Random();
	private static String nombre = "";
	static int bala = 0;
	static int python = 0;
	static int pistola = 0;
	static int muerte= 0;
	static int eleccion = 0;
	static int eleccion2 = 0;
	static int modo = 0;
	static int dinero1 =0;
	static int dinero2=0;
	static int repe =0;


	/**
	 * Metodo main
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		RussianRoulette.logo(null);
		System.out.println(" ");  
		System.out.println(" ");  
		System.out.println(" "); 
		RussianRoulette.Historia(null);
		RussianRoulette.menu(null);
		if(modo==0) {
			RussianRoulette.Normas(null);
		}
		
		if(modo==1) {
			RussianRoulette.PlayervsIA(0);
		}
		if(modo==2) {
			
			RussianRoulette.PlayervsPlayer(0);
		
		}
	}

	/**
	 * Metodo que inicia el juego y pide el nombre al jugador
	 * @param comando
	 */
	public static void Nombre(String comando) {
		System.out.println("Introduce tu nombre completo: ");
		nombre =sc.nextLine();
		if(nombre.contains(" ")){
			System.out.println("              ");
		}
		else {
			System.out.println("Introduce apellido porfavor: ");
			nombre +=sc.nextLine();
		}
	
	}

	/**
	 * Metodo que imprime la historia del juego
	 * @param comando
	 * @throws InterruptedException
	 */
	public static void Historia(String comando) throws InterruptedException {
		String e = "";
	
		String dueño = "Vladimir Pikalov";
		System.out.println("Cualquier letra para start y exit para volver al HUB" );
		e = sc.nextLine();
	
		if(e.equals("exit")) {
			Terminal.main(null);
		}
		else {
			System.out.println("--------------------------------------------------------------------");
			RussianRoulette.Nombre(null);
			String nom = nombre;
			Thread.sleep(5000);	
			System.out.println("Domingo por la madrugada, 1:30 AM, Rusia, Moscú ");
			Thread.sleep(4000);	
			System.out.println(nom+" se despierta despues de haber estado inconsciente durante mas de 1 hora en la calle.");
			Thread.sleep(4000);	
			System.out.println(nom+" esta buscando desesperadamente su cartera y se da cuenta que no tiene nada, le han robado todo su dinero y la ropa.");
			Thread.sleep(4000);
			System.out.println(nom+" nervioso se pone a correr gritando y se encuentra com un extraño...");
			Thread.sleep(4000);
			System.out.println("Extraño: Que te ocurre, ¿que haces a estas horas gritando por la calle muchacho?");
			Thread.sleep(4000);
			System.out.println(nom+": Me pegaron una paliza unos bandidos y me he despertado sin dinero ni nada, mi vida esta acabada.");
			Thread.sleep(4000);
			System.out.println("Extraño: ¿Quieres ser tu propio jefe y ganar mucho dinero?");
			Thread.sleep(4000);
			System.out.println(nom+": Parece sospechoso, ¿quien eres?");
			Thread.sleep(4000);
			System.out.println("Extraño: Me llamo "+dueño+", soy dueño de un bar peculiar, donde la gente se puede ganar la vida literalmente ");
			Thread.sleep(4000);
			System.out.println(nom+": Todo lo que dices es muy raro pero no tengo nada que perder, enseñame esa manera de ganar dinero");
			Thread.sleep(4000);
			System.out.println(dueño+": acompañame al bar...");
			Thread.sleep(4000);
			System.out.println(dueño+" y "+nom+" llegan al bar...");
			Thread.sleep(4000);
			System.out.println(dueño+": Para ganarte la vida debes jugate la tuya jugando a la ruleta rusa chaval");
			Thread.sleep(4000);
			System.out.println(nom+": ¿Enserio? Bueno, ya no tengo nada que perder, vamo a juga");
			Thread.sleep(4000);
			System.out.println(nom+": Se sienta en una mesa con otro jugador...");
			Thread.sleep(2000);
			System.out.println("--------------------------------------------------------------------");
			Thread.sleep(1000);
		}
	
	
	}

	/**
	 * Metodo que simula el menu del juego
	 * @param comando
	 */
	public static void menu(String comando) {
		System.out.println("Selecciona un modo de juego: ");
		System.out.println("-----------------------------");
		System.out.println("0-Normas");
		System.out.println("1-Jugador vs IA");
		System.out.println("2-Jugador vs Jugador");
		modo = sc.nextInt();
	}


	/**
	 * Metodo que simula las normas del juego
	 * @param a
	 * @throws InterruptedException 
	 */
	public static void Normas (String a) throws InterruptedException{
		Random rand = new Random();
		System.out.println("*Normas del juego*");
		System.out.println("---------------------------------------------------------------");
		Thread.sleep(2000);
		System.out.println("-Hay dos modos de juego, jugador vs jugador y jugador vs la IA");
		Thread.sleep(2000);
		System.out.println("-Dentro de cada modo se estableceran dos tipos de pistolas");
		Thread.sleep(2000);
		System.out.println("-Una Phyton con con una capacidad de 6 balas en el cargador");
		Thread.sleep(1000);
		System.out.println("-Una Winchester .45 con con una capacidad de 4 balas en el cargador");
		Thread.sleep(2000);
		System.out.println("-Cada jugador tendrá que disparar una vez por turno");
		Thread.sleep(2000);
		System.out.println("-Pero si quieres pasar turno puedes hacerlo dando 1000€ al oponente (la IA nunca pasará su turno)");
		Thread.sleep(2000);
		System.out.println("-Si no cuentas con suficiente dinero el dueño del bar te matará por mentiroso");
		Thread.sleep(2000);
		System.out.println("-Al disparar se tendra que apuntar en la cabeza");
		Thread.sleep(2000);
		System.out.println("-Si la bala no sale te salvas y pasa tu turno");
		Thread.sleep(2000);
		System.out.println("-Cada vez que ganes a un oponente ganaras 2000€ y el dinero del oponente ya que estara muerto");
		Thread.sleep(2000);
		System.out.println("-Una vez ganas al oponente puedes marcharte si quieres o pedir otro rival");
		System.out.println("---------------------------------------------------------------------------");
		RussianRoulette.menu(null);
	}

	public static void PlayervsIA(int a) throws InterruptedException {
			if(modo==1) {
				do {
				do {
					System.out.println("Vladimir Pikalov: Escoje una pistola " +nombre+ "\n 1-Python  \n 2-Winchester.45");
					pistola = sc.nextInt();
				}while(pistola>=3||pistola<=0);
					if (pistola==1) {
						RussianRoulette.PythonIA(0);
						
					}
					else if(pistola ==2) {
						RussianRoulette.Winchester45IA(0);
					}
				}while (repe==1);
					}		
		}

	/**
	 * Metodo de juego jugador vs jugador
	 * @param a
	 * @throws InterruptedException
	 */
	public static void PlayervsPlayer(int a) throws InterruptedException {
		if(modo==2) {
			do {
			do {
			System.out.println("Vladimir Pikalov: Escoje una pistola " +nombre+ "\n 1-Python  \n 2-Winchester.45");
			pistola = sc.nextInt();
			}while(pistola>=3||pistola<=0);
			if (pistola==1) {
				RussianRoulette.Python(0);
				
			}
			else if(pistola ==2) {
				RussianRoulette.Winchester45(0);
			}
		}while (repe==1);
			}		
		}
	/**
	 * Este metodo es el codigo que simula el juego de la ruleta rusa
	 * 
	 * @param a
	 * @throws InterruptedException
	 */
	public static void Python (int a) throws InterruptedException {
		System.out.println("Vladimir Pikalov: Buena elección para principiantes, esta pistola cuenta con 1/6 balas,\nVladimir Pikalov: si en algún momento os quereis retirar podeis hacerlo perfectamente dando 1000â‚¬ al rival.\nVladimir Pikalov: Muchas gracias y buena suerte! \n    ");
		
		
		Thread.sleep(1000);
bala=Disparos(0);
do {
do {
	RussianRoulette.EleccionJ1(0);
		 	}while(eleccion>=3 || eleccion<-1);
	if (eleccion==1) {
		RussianRoulette.Jugador1(0);
	}
	if (eleccion==0) {
		RussianRoulette.Rendirse(0);
	}
	System.out.println(" ");
	System.out.println(" ");
	if (muerte == 0) {
		RussianRoulette.EleccionJ2(0);
if (eleccion2==1) {
	RussianRoulette.Jugador2(0);
	}
if (eleccion2==0) {
	RussianRoulette.Rendirse2(0);
}
	}
		}while (muerte==0);
RussianRoulette.RepetirRussianRoulette(0);
	}

	public static void PythonIA (int a) throws InterruptedException {
		System.out.println("Vladimir Pikalov: Buena elecció³n para principiantes, esta pistola cuenta con 1/6 balas,\nVladimir Pikalov: si en algún momento os quereis retirar podeis hacerlo perfectamente dando 1000â‚¬ al rival.\nVladimir Pikalov: Muchas gracias y buena suerte! \n    ");
				
			
			Thread.sleep(1000);
	bala=Disparos(0);
	do {
	do {
		RussianRoulette.EleccionJ1(0);
			 	}while(eleccion>=3 || eleccion<-1);
		if (eleccion==1) {
			RussianRoulette.Jugador1IA(0);
		}
		if (eleccion==0) {
			RussianRoulette.RendirseIA(0);
		}
		System.out.println(" ");
		System.out.println(" ");
		if (muerte == 0) {
			RussianRoulette.EleccionIA(0);
		}
			}while (muerte==0);
	Thread.sleep(1000);
	System.out.println(nombre+" Ha muerto...");
	Thread.sleep(1000);
	RussianRoulette.RepetirGameIA(0);
		}

	public static void Winchester45 (int a) throws InterruptedException {
			System.out.println("Vladimir Pikalov: Elección dura, esta pistola cuenta con 1/4 balas,\nVladimir Pikalov: si en algún momento os quereis retirar podeis hacerlo perfectamente dando 1000â‚¬ al rival.\nVladimir Pikalov: Muchas gracias y buena suerte! \n    ");
			
			
			Thread.sleep(1000);
	bala=Disparos2(0);
	do {
	do {
		RussianRoulette.EleccionJ1(0);
			 	}while(eleccion>=3 || eleccion<-1);
		if (eleccion==1) {
			RussianRoulette.Jugador1(0);
		}
		if (eleccion==0) {
			RussianRoulette.Rendirse(0);
		}
		System.out.println(" ");
		System.out.println(" ");
		if (muerte == 0) {
			RussianRoulette.EleccionJ2(0);
	if (eleccion2==1) {
		RussianRoulette.Jugador2(0);
		}
	if (eleccion2==0) {
		RussianRoulette.Rendirse2(0);
	}
		}
			}while (muerte==0);
	RussianRoulette.RepetirRussianRoulette(0);
			}

	public static void Winchester45IA (int a) throws InterruptedException {
			System.out.println("Vladimir Pikalov: Elección dura, esta pistola cuenta con 1/4 balas,\nVladimir Pikalov: si en algún momento os quereis retirar podeis hacerlo perfectamente dando 1000â‚¬ al rival.\nVladimir Pikalov: Muchas gracias y buena suerte! \n    ");
			
			
			Thread.sleep(1000);
	bala=Disparos2(0);
	do {
	do {
		RussianRoulette.EleccionJ1(0);
			 	}while(eleccion>=3 || eleccion<-1);
		if (eleccion==1) {
			RussianRoulette.Jugador1IA(0);
		}
		if (eleccion==0) {
			RussianRoulette.RendirseIA(0);
		}
		System.out.println(" ");
		System.out.println(" ");
		if (muerte == 0) {
			RussianRoulette.EleccionIA(0);
		}
			}while (muerte==0);
	Thread.sleep(1000);
	System.out.println(nombre+" Ha muerto...");
	Thread.sleep(1000);
	RussianRoulette.RepetirGameIA(0);
		}

	public static int  Disparos (int a){

		int x=0;
		a = rand.nextInt(7) + 0;	
		x = a;
		return x;
	}

    public static int  Disparos2 (int a){
		
		int x=0;
			a = rand.nextInt(5) + 0;	
		x = a;
		return x;
	}

	/**
     * Metodo que se ejecuta en el turno del jugador uno
     * 
     * @param a
     * @throws InterruptedException
     */
	public static void Jugador1 (int a) throws InterruptedException {
		System.out.println("...");
		System.out.println(" ");
		python++;
		Thread.sleep(1000);
		if(python!=bala) {
			System.out.println("Vladimir Pikalov: Felicidades, has sobrevivido");
			Thread.sleep(3000);
		}else {
			muerte++;
			System.out.println(nombre+" ha muerto");
			System.out.println(" ");
			RussianRoulette.death(null);
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("Vladimir Pikalov: Jugador 2 ha ganado");
			Thread.sleep(1000);
			System.out.println("Vladimir Pikalov: Jugador 2 ahora sera Jugador 1");
			nombre="Jugador 1";
			System.out.println("*Jugador 1 recibe 2000€*");
			dinero1=dinero1+2000;
		}
		}

	/**
	 * Metodo que se ejecuta en el turno del jugador dos
	 * @param a
	 * @throws InterruptedException
	 */
	public static void Jugador2 (int a) throws InterruptedException {
		python++;
		System.out.println("...");
		Thread.sleep(1000);
		System.out.println(" ");
		if(python!=bala) {
			System.out.println("Vladimir Pikalov: Felicidades, has sobrevivido");
			Thread.sleep(3000);
		}else {
			muerte++;
			System.out.println("Jugador 2 ha muerto");
			System.out.println(" ");
			RussianRoulette.death(null);
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			Thread.sleep(2000);
			System.out.println(nombre+" recibe 2000€");
			dinero1= dinero1 + 2000;
		}
}

	public static void Jugador1IA (int a) throws InterruptedException {
		System.out.println("...");
		System.out.println(" ");
		python++;
		Thread.sleep(1000);
		if(python!=bala) {
			System.out.println("Vladimir Pikalov: Felicidades, has sobrevivido");
			Thread.sleep(3000);
		}else {
			muerte++;
			System.out.println(nombre+" ha muerto");
			System.out.println(" ");
			RussianRoulette.death(null);
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("Vladimir Pikalov: El oponente ha ganado");
		}
	}

	/**
	 * Elecciones del jugador uno
	 * @param a
	 */
	public static void EleccionJ1(int a) {
		System.out.println("Turno de " +nombre);
		System.out.println("_________________________");
	 	
	 System.out.println("Â¿Que deberia hacer " +nombre+"?");
	System.out.println("1- Para disparar");
	System.out.println("0- Para pasar turno por 1000€");
	System.out.println("Tienes "+dinero1+"€");
	eleccion = sc.nextInt();
	}

	/**
	 * Elecciones del jugador dos
	 * @param a
	 */
	public static void EleccionJ2(int a) {
		System.out.println("Turno de Jugador 2");
		System.out.println("_________________________");
	 	
		 System.out.println("Â¿Que deberia hacer Jugador 2");
		System.out.println("1- Para disparar");
		System.out.println("0- Para pasar turno por 1000€");
		System.out.println("Tienes "+dinero2+"€");
		eleccion2 = sc.nextInt();
	}

	public static void EleccionIA(int a) throws InterruptedException {
		System.out.println("Turno del rival");
		System.out.println("_________________________");
		System.out.println("...");
		System.out.println(" ");
		python++;
		Thread.sleep(1000);
		if(python!=bala) {
			System.out.println("Vladimir Pikalov: Felicidades, has sobrevivido");
			Thread.sleep(3000);
		
	}
		else {
			muerte++;
			System.out.println(nombre+ " Ha ganado!");
			dinero1=dinero1+2000;
		}
	}

	/**
	 * Metodo para rendirse en el juego
	 * @param a
	 * @throws InterruptedException 
	 */
	public static void Rendirse(int a) throws InterruptedException {
		if(dinero1>=1000){
			System.out.println("*Das 1000 euros al rival*");
			dinero1=dinero1-1000;
			dinero2 =dinero2+1000;
		}else {
			System.out.println("Vladimir Pikalov: No tienes suficiente dinero, por tanto vas a morir por mentir en mi cara."); 
			muerte++;
			Thread.sleep(1000);
			RussianRoulette.death(null);
			System.out.println("Vladimir Pikalov: Jugador 2 ahora sera Jugador 1");
			nombre="Jugador 1";
			dinero1= 2000 + dinero1;
			System.out.println("Jugador 1 recibe 2000€");
		}
		}

	public static void Rendirse2(int a)throws InterruptedException {
		if(dinero2>=1000){
			System.out.println("*Das 1000 euros al rival*");
			dinero2 =dinero2-1000;
			dinero1 =dinero1+1000;
		}else {
			System.out.println("Vladimir Pikalov: No tienes suficiente dinero, por tanto vas a morir por mentir en mi cara."); 
			muerte++;
			Thread.sleep(1000);
			RussianRoulette.death(null);
			dinero1= 2000 + dinero1;
			System.out.println(nombre+" recibe 2000€");
		}
	}
	
	public static void RendirseIA(int a) throws InterruptedException {
			if(dinero1>=1000){
				System.out.println("*Das 1000 euros al rival*");
				dinero1=dinero1-1000;
				dinero2 =dinero2+1000;
			}else {
				System.out.println("Vladimir Pikalov: No tienes suficiente dinero, por tanto vas a morir por mentir en mi cara."); 
				Thread.sleep(1000);
				RussianRoulette.death(null);
				muerte++;
			}
	}

	/**
	 * Repite las rondas del juego hasta que el juego acaba
	 * @param a
	 * @throws InterruptedException
	 */
	public static void RepetirRussianRoulette(int a) throws InterruptedException {
		bala=0;
		python=0;
		Thread.sleep(1000);
		System.out.println("Vladimir Pikalov: ¿Quieres que venga otro oponente o quieres marcharte?");
		System.out.println("_________________________");
		System.out.println("1- para repetir");
		System.out.println("- Cualquier otro numero para marcharte");
		repe=sc.nextInt();
	}

	public static void RepetirGameIA(int a) throws InterruptedException {
		System.out.println("Vladimir Pikalov: ¿Que quieres hacer?: ");
		System.out.println("_________________________");
		System.out.println("1- para repetir");
		System.out.println("2- Marchar al menú");
		System.out.println(" - Cualquier numero para marcharte");
		repe=sc.nextInt();
		if(repe==2){
			RussianRoulette.main(null);
		}else {
			
		}
	
	}
	/**
	 * Imprime el logo del juego
	 * @param comando
	 */
	public static void logo(String comando) {
		System.out.println("8888888b.  888     888  .d8888b.   .d8888b. 8888888        d8888 888b    888 \r\n"
				+ "888   Y88b 888     888 d88P  Y88b d88P  Y88b  888         d88888 8888b   888 \r\n"
				+ "888    888 888     888 Y88b.      Y88b.       888        d88P888 88888b  888 \r\n"
				+ "888   d88P 888     888  \"Y888b.    \"Y888b.    888       d88P 888 888Y88b 888 \r\n"
				+ "8888888P\"  888     888     \"Y88b.     \"Y88b.  888      d88P  888 888 Y88b888 \r\n"
				+ "888 T88b   888     888       \"888       \"888  888     d88P   888 888  Y88888 \r\n"
				+ "888  T88b  Y88b. .d88P Y88b  d88P Y88b  d88P  888    d8888888888 888   Y8888 \r\n"
				+ "888   T88b  \"Y88888P\"   \"Y8888P\"   \"Y8888P\" 8888888 d88P     888 888    Y888 \r\n"
				);
		System.out.println("8888888b.   .d88888b.  888     888 888      8888888888 88888888888 88888888888 8888888888 \r\n"
				+ "888   Y88b d88P\" \"Y88b 888     888 888      888            888         888     888        \r\n"
				+ "888    888 888     888 888     888 888      888            888         888     888        \r\n"
				+ "888   d88P 888     888 888     888 888      8888888        888         888     8888888    \r\n"
				+ "8888888P\"  888     888 888     888 888      888            888         888     888        \r\n"
				+ "888 T88b   888     888 888     888 888      888            888         888     888        \r\n"
				+ "888  T88b  Y88b. .d88P Y88b. .d88P 888      888            888         888     888        \r\n"
				+ "888   T88b  \"Y88888P\"   \"Y88888P\"  88888888 8888888888     888         888     8888888888  "); 
	}

	/**
	 * Imprime la pantalla de derrota
	 * @param comando
	 */
	public static void death(String comando) {
		System.out.println("                 uuuuuuu\r\n"
				+ "             uu$$$$$$$$$$$uu\r\n"
				+ "          uu$$$$$$$$$$$$$$$$$uu\r\n"
				+ "         u$$$$$$$$$$$$$$$$$$$$$u\r\n"
				+ "        u$$$$$$$$$$$$$$$$$$$$$$$u\r\n"
				+ "       u$$$$$$$$$$$$$$$$$$$$$$$$$u\r\n"
				+ "       u$$$$$$$$$$$$$$$$$$$$$$$$$u\r\n"
				+ "       u$$$$$$\"   \"$$$\"   \"$$$$$$u\r\n"
				+ "       \"$$$$\"      u$u       $$$$\"\r\n"
				+ "        $$$u       u$u       u$$$\r\n"
				+ "        $$$u      u$$$u      u$$$\r\n"
				+ "         \"$$$$uu$$$   $$$uu$$$$\"\r\n"
				+ "          \"$$$$$$$\"   \"$$$$$$$\"\r\n"
				+ "            u$$$$$$$u$$$$$$$u\r\n"
				+ "             u$\"$\"$\"$\"$\"$\"$u\r\n"
				+ "  uuu        $$u$ $ $ $ $u$$       uuu\r\n"
				+ " u$$$$        $$$$$u$u$u$$$       u$$$$\r\n"
				+ "  $$$$$uu      \"$$$$$$$$$\"     uu$$$$$$\r\n"
				+ "u$$$$$$$$$$$uu    \"\"\"\"\"    uuuu$$$$$$$$$$\r\n"
				+ "$$$$\"\"\"$$$$$$$$$$uuu   uu$$$$$$$$$\"\"\"$$$\"\r\n"
				+ " \"\"\"      \"\"$$$$$$$$$$$uu \"\"$\"\"\"\r\n"
				+ "           uuuu \"\"$$$$$$$$$$uuu\r\n"
				+ "  u$$$uuu$$$$$$$$$uu \"\"$$$$$$$$$$$uuu$$$\r\n"
				+ "  $$$$$$$$$$\"\"\"\"           \"\"$$$$$$$$$$$\"\r\n"
				+ "   \"$$$$$\"                      \"\"$$$$\"\"\r\n"
				+ "     $$$\"                         $$$$\"");
	}
	
	
	
}