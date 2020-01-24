/**
 * Un objeto de esta clase guarda informaci�n relativa a un juego
 * 
 * @author - Rub�n Gonz�lez
 */
public class Juego{
    private static final String SEPARADOR = ":";
    private String titulo;
    private Genero genero;
    private int year;
    private int[] valoraciones;

    /**
     *  Inicializa los atributos a partir de la informaci�n recibida
     *  Esta informaci�n se encuentra en linea
     */
    public Juego(String linea){
        String[] aux = linea.split(SEPARADOR);
        for(int i = 0; i < aux.length; i++) {
            aux[i] = aux[i].trim();
        }
        titulo = aux[0].toUpperCase();
        genero = Genero.valueOf(aux[1].toUpperCase());
        year = Integer.parseInt(aux[2]);
        valoraciones = new int[10];
        for(int i = 0; i < 10; i++){
            valoraciones[i] = Integer.parseInt(aux[i + 3]);
        }
    }

    /**
     * accesor t�tulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * accesor g�nero
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * accesor year
     */
    public int getYear() {
        return year;
    }

    /**
     * accesor valoraciones
     */
    public int[] getValoraciones() {
        return valoraciones;
    }

    /**
     * total votos emitidos
     */
    public int getVotos() {
        int total = 0;
        for(int i = 0; i < valoraciones.length; i++){
            total += valoraciones[i];
        }
        return total;
    }

    /**
     *  obtener valoraci�n media
     */
    public double getValoracionMedia() {
        int cont = 1;
        int puntos = 0;
        for(int i = 0; i < valoraciones.length; i++){
            puntos += (valoraciones[i] * cont); 
            cont++;
        }
        return puntos % getVotos();
    }

    /**
     *  Un usuario punt�a el juego con un valor entre 1 y 10 
     */
    public void puntuar(int puntuacion) {
        valoraciones[puntuacion - 1] ++;
    }

    /**
     * Representaci�n textual del juego 
     * (Ver enunciado)
     */
    public String toString() {
        return titulo + "\nG�nero: " + this.genero +
        "| Lanzamiento: " + this.year +
        "\nValoraci�n (" + getVotos() + " votos): "
        + String.format("%.2f", this.getValoracionMedia());

    }

    public static void main(String[] args) {
        Juego juego1 = new Juego(
                "Steep: deporte: 2016  : 0:0:0:0: 0: 0:0:0:12:  10");
        System.out.println(juego1.toString());

        Juego juego2 = new Juego(
                "For the King: estrategia: 2018  : 0:0:0:7: 12: 0:33:13:2: 0");
        System.out.println(juego2.toString());

    }
}
