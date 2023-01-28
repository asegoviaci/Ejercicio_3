package Ametz_Segovia;
import java.util.*;
public class Movie {
    private String nombre;
    private int minutos;
    private int año;
    public Movie(String nombre, int minutos, int año){
        this.nombre=nombre;
        this.minutos=minutos;
        this.año=año;
    }
    public String getNombre(){
        return nombre;
    }
    public int getMinutos(){
        return minutos;
    }
    public int getAño(){
        return año;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setMinutos(int minutos){
        this.minutos=minutos;
    }
    public void setAño(int año){
        this.año=año;
    }
    public String toString() {
        return "Nombre: " + nombre  + " Minutos: " + minutos + " Año: " + año;
    }
    public boolean isEqual(Movie m){
        return this.nombre.equalsIgnoreCase(m.nombre) && (this.minutos-5< m.minutos && this.minutos+5> m.minutos) && this.año == m.año;
    }
    public static void main(String[] args) {
        Movie m = new Movie("hola", 100, 1);
        Movie n = new Movie("hola", 100, 1);
        Movie ñ = new Movie("hola", 100, 1);
        Cinema c = new Cinema("hola", 10);
        c.addMovie(m,5);
        System.out.println(c.addMovie(n,2));
        System.out.println(c.addMovie(ñ));
        System.out.println(c.roomOfMovie("hola", 100, 1));
        m.isEqual(n);
        c.show();
        c.changeRoom(m);
        c.show();
        System.out.println(c.freeRooms());
        System.out.println(c.moviesShorterThan(1,40));
    }
}
