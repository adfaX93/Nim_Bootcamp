public class Pila {
    int pila;
    public Pila() {
        pila = 5;
    }
    public Pila(int tamaño){
        pila = tamaño;
    }

    public int getPila() {
        return pila;
    }

    public void setPila(int pila) {
        this.pila = pila;
    }
    //método para restar pila solo si es posible restar
    public boolean restaPila(int nroQuitar){
        if (pila>0 && nroQuitar<=pila){
            pila-=nroQuitar;
            return true;
        }else {
            return false;
        }
    }
    public boolean hayPila(){
        if(pila == 0){
            return false;
        }else {
            return true;
        }
    }
}

