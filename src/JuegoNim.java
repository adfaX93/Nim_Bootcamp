import java.util.Optional;
import java.util.Scanner;

public class JuegoNim {
    //método para verificar la opción del usuario
    public static int validarOpcion(String opcion){
        switch (opcion){
            case "A":
            case "a":
                return   1;//retorna 1ra opción
            case "B":
            case "b":
                return   2;//retorna 2da opción
            case "C":
            case "c":
                return    3;//retorna 3ra opción
            default:
                return   -1;//retorna una opción inválida
        }
    }
    public static boolean restar(int opcion, Pila a, Pila b, Pila c, int nroRestar){
        boolean valido = false;
        switch (opcion){
            case 1:
                if ((a.hayPila()) && (nroRestar <= a.getPila())){
                    a.restaPila(nroRestar);
                    valido = true;
                }/* else if (a.hayPila() && (nroRestar>a.getPila())) {
                    System.out.println("No puedes Restar esa cantidad!, Introduce otra");
                } else if (a.hayPila()==false) {
                }*/
                break;
            case 2:
                if ((b.hayPila()) && (nroRestar<=b.getPila())){
                    b.restaPila(nroRestar);
                    valido = true;
                }
                break;
            case 3:
                if((c.hayPila()) && (nroRestar<=c.getPila())){
                    c.restaPila(nroRestar);
                    valido = true;
                }
                break;
            default:
                break;
        }
        return valido;
    }
    public static boolean validarNumero(String numero){
        try {
            Integer.parseInt(numero);
            return true;
        } catch (Exception exception) {
            System.out.println("Ingrese un valor numérico:");
            return false;
        }
    }
    public static int introducirOpcion(Jugador jugador){
        int opcionSeleccionada;
        String opcionPila;
        Scanner sc = new Scanner(System.in);
        System.out.println(jugador.getNombre() + " Elija una Pila (A, B ó C):");
        opcionPila = sc.next();
        opcionSeleccionada = validarOpcion(opcionPila);
        return opcionSeleccionada;
    }
    public static void main(String[] args) {
        //valores por defecto de las pilas
        Pila a = new Pila(3);
        Pila b = new Pila(4);
        Pila c = new Pila(5);
        Scanner sc = new Scanner(System.in);
        //String opcionPila;
        int opcionSeleccionada;
        boolean operacionValida;
        String cantidadRestar;
        int cantRestar;
        System.out.println("Jugador A, ingrese su nombre:");
        Jugador jugador1 = new Jugador(sc.nextLine(),1);
        System.out.println("Jugador B, ingrese su nombre:");
        Jugador jugador2 = new Jugador(sc.nextLine(),2);
        do {
            System.out.println("A: " + a.getPila() + " B: " + b.getPila() + " C: " + c.getPila());
            if (jugador1.getTurno() < jugador2.getTurno()) {
                do {
                    opcionSeleccionada = introducirOpcion(jugador1);
                    if (opcionSeleccionada==-1){
                        System.out.println("Opción incorrecta!");
                    }else {
                        System.out.println("Cuantos quitaras de la pila:");
                        //do{
                            do {
                                cantidadRestar = sc.next();
                            }while (!validarNumero(cantidadRestar));
                            cantRestar = Integer.parseInt(cantidadRestar);
                            operacionValida = restar(opcionSeleccionada,a,b,c,cantRestar);
                        //}while (!operacionValida);
                        if(operacionValida) {
                            jugador1.subeTurno();
                        } else {
                            System.out.println("valor no valido!");
                            System.out.println("A: " + a.getPila() + " B: " + b.getPila() + " C: " + c.getPila());
                        }
                    }
                }while (opcionSeleccionada==-1);
            }else {
                do {
                    opcionSeleccionada = introducirOpcion(jugador2);
                    if (opcionSeleccionada==-1){
                        System.out.println("Opción incorrecta!");
                    }else {
                        System.out.println("Cuantos quitaras de la pila:");
                        //do{
                        do {
                            cantidadRestar = sc.next();
                        }while (!validarNumero(cantidadRestar));
                        cantRestar = Integer.parseInt(cantidadRestar);
                        operacionValida = restar(opcionSeleccionada,a,b,c,cantRestar);
                        //}while (!operacionValida);
                        if(operacionValida) {
                            jugador2.subeTurno();
                        } else {
                            System.out.println("valor no valido!");
                            System.out.println("A: " + a.getPila() + " B: " + b.getPila() + " C: " + c.getPila());
                        }
                    }
                }while (opcionSeleccionada==-1);
            }
        }while (a.hayPila() || b.hayPila() || c.hayPila());
        if(jugador1.getTurno()>jugador2.getTurno()){
            System.out.println(jugador2.getNombre()+" Ganaste!!!");
        }else {
            System.out.println(jugador1.getNombre()+" Ganaste!!!");
        }
    }
}
