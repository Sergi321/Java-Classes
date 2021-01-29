import java.util.*;

/**
 * Programa que simula una terminal de Linux. Dentro de la terminal podemos encontrar 3 minijuegos con tematica de Chernovyl.
 * 
 * Contiene una serie de comandos que vienen detallados en el manual de la simulación de bach (ejecutar comando "man")
 * 
 * @version 1.0
 * @author Darian,Gabri,Sergio
 * @category Games
 * 
 * 
 * 
 */
public class Terminal {

	private static Scanner scanner = new Scanner(System.in);
	static Stack<String> stack = new Stack<String>();
	static Stack<String> dir = new Stack<String>();
	static Stack<String> archivo = new Stack<String>();
	static Stack<String> scripts = new Stack<String>();
	static int num = 2;
	static int numsh = 0;
	
	//Directorio con el que inicia la terminal
	private static String directorioActual = directoriostack(stack).elementAt(num);

	//Directorio para el cat
	private static String catactual = "/";
	private static String shactual = "/";

	

	/**
	 * Este metodo añade todas las rutas possibles al stack de rutas
	 * 
	 * @param stack Stack de las rutas
	 * @return
	 */
	public static Stack<String> directoriostack(Stack<String> stack) {
		stack.add("/"); 
		stack.add("/home"); 
		stack.add("/home/admin_routeSV05"); 
		stack.add("/home/admin_routeSV05/Games");   
		return stack;   
	}

	/**
	 * Añade al archivo de ficheros un archivo decorativo
	 * 
	 * @param archivo Nombre del archivo decorativo
	 * @return Archivo
	 */
	public static Stack<String> archivostexto(Stack<String> archivo) {
		archivo.add("/home/admin_routeSV05/SecretosNucleares.txt");
		return archivo;   
	}

	/**
	 * Metodo para llenar el stack de archivos .sh ejecutables disponibles
	 * 
	 * @param sh Stack de todos los scripts disponibles para ejecutar
	 * @return Devuelve un stack con todos los archivos .sh possibles
	 */
	public static Stack<String> archivoscript(Stack<String> sh) {
		sh.add("autor.sh");
		sh.add("/home/admin_routeSV05/./autor.sh");
		sh.add("information.sh");
		sh.add("version.sh");
		sh.add("exit.sh");
		sh.add("chernoville.sh");
		sh.add("russianroulette.sh");
		sh.add("hipershoot.sh");
		return sh;   
	}

	/**
	 * Metodo que añade las rutas possibles a la simulacion del directorio raiz.
	 * 
	 * @param dir Stack representativo del directorio raiz
	 * @return Devuelve el stack de rutas del directorio raiz
	 */
	public static Stack<String> directorioprohibido(Stack<String> dir) {
		dir.add("/bin");
		dir.add("/etc");
		dir.add("/lost+found");
		dir.add("/root");
		dir.add("/snap");
		dir.add("/usr");
		dir.add("/boot");
		dir.add("/mnt");
		dir.add("/run");
		dir.add("/sys");
		dir.add("/var");
		dir.add("/lib");
		dir.add("/opt");
		dir.add("/srv");
		dir.add("/dev");
		dir.add("/lib64");
		dir.add("/proc");
		dir.add("/sbin");
		dir.add("/tmp");
		return dir;   
	}


	/**
	 * Metodo que imprime el SSH al iniciar la ejecucion del programa
	 * 
	 * @throws InterruptedException
	 */
	public static void imprimirSSH() throws InterruptedException {
		System.out.print("[nchernovyl@retrobyl:~] $ ssh ");
		Thread.sleep(1000);
		System.out.print("admin");
		Thread.sleep(1000);
		System.out.print("routeSV05@");
		Thread.sleep(1000);
		System.out.print("10.0");
		Thread.sleep(1000);
		System.out.println("3.170");
		System.out.println("admin_routeSV05@10.0.3.170's password:");
		Thread.sleep(3000);
		System.out.println("Access RetroByl LTS (GNU/LINUX 3.13.0.24-generic x86_64)");
		System.out.println("\n * Documentation : https://github.com/GabrielVoica/Java-Ruso/");
		System.out.println("Last Login : Fti Apr 25 10:44:14 2020");
		System.out.println("\nbash: man: modo de empleo: ejecutar comando man");
	}



	/**
	 * Metodo que imprime el prompt de la terminal
	 */
	public static void imprimirTerminal(){
		System.out.print("[admin_routeSV05@server05:~] $ ");
	}

	/**
	 * Inicia la terminal
	 * @throws InterruptedException
	 */
	public static void iniciarTerminal() throws InterruptedException {
		controladorTerminal();
	}

	/**
	 * Controla cada sequencia de comandos en la terminal
	 * @throws InterruptedException
	 */
	public static void controladorTerminal() throws InterruptedException {
		imprimirTerminal();
		String comando = scanner.nextLine();
		if(comando.length()<=0) {
			controladorTerminal();
		}
		routerComandos(comando);
	}


	/**
	 * Este metodo hace de router para usar el comando introducido por consola
	 * 
	 * @param comando Comando introducido por el usuario
	 * @throws InterruptedException
	 */
	public static void routerComandos(String comando) throws InterruptedException {
		if(comando.equals("ls")) {
			comandoList();
		}
		else if (comando.equals("pwd")) {
			System.out.println(""+directorioActual+"");
			controladorTerminal();
		}

		else if(comando.charAt(0)=='c' && comando.charAt(1)=='d' && comando.length() > 3 ) {
			comandoChangeDirectory(comando.substring(3,comando.length()));
		}

		else if(comando.charAt(0)=='c' && comando.charAt(1)=='a' && comando.charAt(2)=='t' && comando.length() > 4) {
			comandoCAT(comando.substring(4,comando.length()));
		}
		else if(comando.equals("..")) {
			comandoChangeDirectoryBack(comando);
		}
		else if(comando.charAt(0)=='.' && comando.charAt(1)=='/') {
			comandoSH(comando.substring(2,comando.length()));
		}
		else if(comando.equals("man")) {
			comandoMAN(comando);
		}
		else if (comando.equals("clear")) {
			comandoClear(comando);
		}
		else if (comando.equals("irssi")) {
			try {
				comandoirssi(comando);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("bash: " + comando + ": orden no encontrada");
			controladorTerminal();
		}
	}




	/**
	 * Metodo de la simulacion del comando "ls"
	 * 
	 * @throws InterruptedException
	 */
	public static void comandoList() throws InterruptedException {
		if(directorioActual.equals("/home/admin_routeSV05/Games" )) {
			System.out.println("\nchernoville.sh   russianroulette.sh   hipershoot.sh");
			controladorTerminal();
		}

		else if(directorioActual.equals("/home/admin_routeSV05")) {
			System.out.println("\nGames   information.sh   version.sh");
			System.out.println("autor.sh   exit.sh   SecretosNucleares.txt\n");
			controladorTerminal();
		}

		else if(directorioActual.equals("/home")) {
			System.out.println("admin_routeSV05");
			controladorTerminal();
		}

		else if(directorioActual.equals("/")) {
			System.out.println("bin                 etc   lost+found    root            snap    usr");
			System.out.println("boot                home  mnt           run             sys     var");
			System.out.println("desktopfs-pkgs.txt  lib   opt           rootfs-pkgs.txt srv");
			System.out.println("dev                 lib64 proc          sbin            tmp		");
			controladorTerminal();
		}


		else {
			System.out.println("bash: No exite el fichero o el directorio");
			controladorTerminal();
		}
	}

	/**
	 * Metodo de la simulacion del comando "cd"
	 * @param directory
	 * @throws InterruptedException
	 */
	public static void comandoChangeDirectory(String directory) throws InterruptedException {

		if(directoriostack(stack).contains(directory)) {
			directorioActual = directory;


			while(directorioActual != directoriostack(stack).elementAt(num)) {
				num++;
				directorioActual = directoriostack(stack).elementAt(num);
			}
		}
		else if(directorioprohibido(dir).contains(directory)) {
			System.out.println("Bash: cd: " + directory + ": Permiso denegado");	
		}

		else {
			System.out.println("bash: cd: No existe el fichero o el directorio" );
		}
		controladorTerminal();
	}

	/**
	 * Metodo que simula el comando "cd .."
	 * @param directory
	 * @throws InterruptedException
	 */
	public static void comandoChangeDirectoryBack(String directory) throws InterruptedException {

		if(num <= 0) {
			num++;		
		}
		if(directorioActual == directoriostack(stack).elementAt(num)) {
			num--;
			directorioActual = directoriostack(stack).elementAt(num);
		}

		controladorTerminal();
	}

	/**
	 * Metodo que simula el comando "man"
	 * 
	 * @param comando
	 * @throws InterruptedException
	 */
	public static void comandoMAN(String comando) throws InterruptedException {
		System.out.println("MAN(1)                     User Commands                     MAN(1)");
		System.out.println("Name: Description:");
		System.out.println("ls - listar elementos del directorio actual");
		System.out.println("cd - acceder a un directorio, la ruta es absoluta (Tienes que introducir la ruta entera)");
		System.out.println("pwd - ver la ruta actual");
		System.out.println("man - abrir el archivo de ayuda");
		System.out.println("cat - leer un archivo");
		System.out.println("clear - limpiar terminal");
		System.out.println("irssi - conexión IRC");
		System.out.println("./ - sirve para ejecutar un script - Solo funciona por ruta relativa (Estar dentro de la ruta donde esta el SCRIPT)");
		System.out.println("\nName: Example:");
		System.out.println("cd /direcorio1/subdirectorio");
		System.out.println("cat /directorio1/subdirectorio/archivetexto.txt");
		System.out.println("./Script.sh");
		controladorTerminal();
	}


	/**
	 * Metodo que simula el comando para ejecutar scripts
	 * Hace una funcion de router
	 * 
	 * @param comando
	 * @throws InterruptedException
	 */
	public static void comandoSH(String comando) throws InterruptedException {

		if(archivoscript(scripts).contains(comando)) {
			shactual = comando;

			if(shactual.equals("autor.sh") && directorioActual == directoriostack(stack).elementAt(2)) {
				autorsh(comando);
			}
			else if(shactual.equals("version.sh") && directorioActual == directoriostack(stack).elementAt(2)) {
				versionsh(comando);

			}
			else if(shactual.equals("information.sh") && directorioActual == directoriostack(stack).elementAt(2)) {
				informationsh(comando);

			}

			else if(shactual.equals("exit.sh") && directorioActual == directoriostack(stack).elementAt(2)) {
				exitsh(comando);

			}
			
			else if(shactual.equals("chernoville.sh") && directorioActual == directoriostack(stack).elementAt(3)) {
				Chernoville.main(null);

			}
			
			else if(shactual.equals("russianroulette.sh") && directorioActual == directoriostack(stack).elementAt(3)) {
				RussianRoulette.main(null);

			}
			
			else if(shactual.equals("hipershoot.sh") && directorioActual == directoriostack(stack).elementAt(3)) {
				HiperShoot.initGame();

			}
			
			else {
				System.out.println("bash: " + comando +": No existe el fichero o el directorio o la ruta es incorrecta");
				
			}

		}
		else {
			System.out.println("bash: " + comando +": No existe el fichero o el directorio o la ruta es incorrecta");
		}

		controladorTerminal();

	}

	/**
	 * Contenido del archivo autor.sh
	 * 
	 * @param comando
	 * @throws InterruptedException
	 */
	public static void autorsh(String comando) throws InterruptedException {

		if(numsh == 0) {
			irssitexto(comando);
		}
		if(numsh > 0) {
			System.out.println("Darian Manasturean --> Porgramador - DAW1: Ingene");
			System.out.println("Sergio Martín --> Porgramador - DAW1");
			System.out.println("Gabriel Voica --> Porgramador - DAW1");

		}
		controladorTerminal();

	}
	/**
	 * Contenido del archivo versions.sh
	 * 
	 * @param comando
	 * @throws InterruptedException
	 */
	public static void versionsh(String comando) throws InterruptedException {
		if(numsh == 0) {
			irssitexto(comando);
		}
		if(numsh > 0) {
			System.out.println("Version - 1.0.0");

		}
		controladorTerminal();


	}
	/**
	 * Contenido del archivo information.hs 
	 * 
	 * @param comando
	 * @throws InterruptedException
	 */
	public static void informationsh(String comando) throws InterruptedException {
		if(numsh == 0) {
			irssitexto(comando);
		}
		if(numsh > 0) {
			System.out.println("El objetivo de este proyecto es simular una terminal conectada a un servidor de Chernobyl");

		}
		controladorTerminal();

	}

	/**
	 * Sale de la terminal
	 * 
	 * @param comando
	 */
	public static void exitsh(String comando) {
		System.out.println("bash: exit: saliendo del terminal");		

	}

	/**
	 * Metodo que se ejecuta al intentar ingresar a un fichero o directorio que no existe
	 * 
	 * @param comando
	 */
	public static void negacion(String comando) {
		System.out.println("bash: cat: No existe el fichero o el directorio o la ruta es incorrecta");

	}


	/**
	 * Si no se tiene acceso al archivo se imprime el texto del metodo
	 * @param comando
	 */
	public static void irssitexto(String comando) {

		if(numsh == 0) {
			System.out.println("bash: ./: No tiene acceso al archivo. Haz un comando 'irssi' para pedir permisos al general Vladimir Pikalov");

		}
		else {
		}

	}


	/**
	 * Metodo que simula una conversacion con un personaje al crear la conexion irssi
	 * 
	 * @param comando
	 * @throws InterruptedException
	 */
	public static void comandoirssi(String comando) throws InterruptedException {
		Thread.sleep(1000);
		System.out.println(" Irssi v1.2.0 - https://irssi.org");
		System.out.println("-!- Irssi: Looking up chat.10.03.170");
		System.out.println("-!- Irssi: conected to #principal");

		if(numsh == 0) {
			Thread.sleep(3000);
			System.out.println("20:50 -!- vlad1mirpikal0v: ¿Que desea?");
			Thread.sleep(3000);
			System.out.println("20:50 -!- admin_route_sv05: Hola, necesito acceso a varios scripts en el terminal 5 de Chernobyl");
			Thread.sleep(3000);
			System.out.println("20:50 -!- vlad1mirpikal0v: ¿Ahora?");
			Thread.sleep(3000);
			System.out.println("20:51 -!- admin_route_sv05: Si, es urgente");
			Thread.sleep(5000);
			System.out.println("20:59 -!- vlad1mirpikal0v: Ya tienes acceso, y ahora, dejame acabar este vodka tranquilo");
			System.out.println("20:59 -!- vlad1mirpikal0v has left the chat\r\n");
			numsh++;
			controladorTerminal();

		}
		if(numsh > 0) {
			Thread.sleep(3000);
			System.out.println("20:50 -!- vlad1mirpikal0v: ¿!Otra vez tú!?");
			Thread.sleep(3000);
			System.out.println("20:50 -!- admin_route_sv05: Perdón, me he equivocado");
			Thread.sleep(3000);
			System.out.println("20:50 -!- vlad1mirpikal0v: !Por la madre russia y los osos de nuestro amado país, como puedes cometer un error así!");
			Thread.sleep(3000);
			System.out.println("20:51 -!- admin_route_sv05: Lo siento, no volverá a ocurrir");
			Thread.sleep(5000);
			System.out.println("20:59 -!- vlad1mirpikal0v: No, no volverá a ocurrir, me encargaré de ello");
			Thread.sleep(3500);
			System.out.println("20:59 -!- vlad1mirpikal0v has left the chat\r\n");
			Thread.sleep(3500);
			System.out.println("20:59 -!- vlad1mirpikal0v has open the chat\r\n");
			Thread.sleep(3500);
			System.out.println("20:59 -!- vlad1mirpikal0v: De ello, ello, ello");
			Thread.sleep(3500);
			System.out.println("20:59 -!- vlad1mirpikal0v has left the chat\r\n");
			controladorTerminal();

		}

	}


	/**
	 * Metodo que simula el comando "cat"
	 * 
	 * @param comando
	 * @throws InterruptedException
	 */
	public static void comandoCAT(String comando) throws InterruptedException {

		if(archivostexto(archivo).contains(comando)) {
			catactual = comando;

			if(catactual.equals("/home/admin_routeSV05/SecretosNucleares.txt")) {
				System.out.println("Hola");
			}
		}
		else {
			System.out.println("bash: cat: No existe el fichero o el directorio");
		}


		controladorTerminal();
	}
	
	/**
	 * Metodo que simula el comando "cls"
	 * 
	 * @param comando
	 * @throws InterruptedException
	 */
	public static void comandoClear(String comando) throws InterruptedException {
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		controladorTerminal();
	}


	/**
	 * Metodo main
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Terminal.imprimirSSH();
		Terminal.iniciarTerminal();


	}

}