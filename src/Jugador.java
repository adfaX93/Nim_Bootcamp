public class Jugador {
    String nombre;
    int turno;
    public Jugador() {
        nombre = "Jugador";
        turno = 0;
    }
    public Jugador(String nombre, int turno){
        this.nombre = nombre;
        this. turno = turno;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //método para incrementar el turno, tiene que intercalar con el otro jugador (subir de a 2)
    public void subeTurno(){
        turno+=2;
    }
}
