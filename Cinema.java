package Ametz_Segovia;
import java.util.*;
public class Cinema {
    private String nombre;
    private ArrayList<Movie> peliculas;
    private Movie[] busyRooms;
    public Cinema(String nombre, int salas){
        this.nombre=nombre;
        this.peliculas= new ArrayList<>();
        this.busyRooms = new Movie[salas];
    }
    public String getNombre(){
        return this.nombre;
    }
    public ArrayList<Movie> getPeliculas(){
        return this.peliculas;
    }
    public Movie[] getBusyRooms(){
        return this.busyRooms;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setPeliculas(ArrayList<Movie> peliculas){
        this.peliculas=peliculas;
    }
    public void setBusyRooms(Movie[] busyRooms){
        this.busyRooms=busyRooms;
    }
    public void setBusyRoomsNumber(int salas){
        this.busyRooms= new Movie[salas];
    }
    public String roomOfMovie(String nombre, int duracion, int año){
        for (int i=0; i < busyRooms.length; i++){
            if (busyRooms[i] != null && busyRooms[i].isEqual(new Movie(nombre, duracion, año))) {
                return String.valueOf(i);
            }
        }
        return "No se ha encontrado";
    }
    public String addMovie(Movie pelicula) {
        for (int i = 0; i < busyRooms.length; i++){
            if (busyRooms[i] != null && busyRooms[i].isEqual(pelicula)){
                return "Pelicula ya existente";
            }
        }
        if (!peliculas.contains(pelicula)) {
            for (int i = 0; i < busyRooms.length; i++){
                if (busyRooms[i]==null){
                    busyRooms[i]=pelicula;
                    peliculas.add(pelicula);
                    return String.valueOf(i);
                }
            }
        }
        return "No se ha podido";
    }
    public boolean addMovie(Movie pelicula, int numerosala){
        for (int i = 0; i < busyRooms.length; i++){
            if (busyRooms[i] != null && busyRooms[i].isEqual(pelicula)){
                return false;
            }
        }
        if (!peliculas.contains(pelicula) && busyRooms[numerosala]==null){
            busyRooms[numerosala]= pelicula;
            peliculas.add(pelicula);
            return true;
        }
        return false;
    }
    public void show(){
        System.out.println("Cine: " + this.nombre);
        for (int i = 0; i < busyRooms.length; i++){
            if (busyRooms[i] != null) {
                System.out.println("Sala: " + i + busyRooms[i]);
            }
        }
    }
    public void removeMovie(String pelicula){
        for (int i = 0; i < busyRooms.length; i++){
            if (busyRooms[i] != null && busyRooms[i].getNombre().startsWith(pelicula)){
                busyRooms[i]=null;
                peliculas.remove(busyRooms[i]);
            }
        }
    }
    public ArrayList<Integer> freeRooms(){
        ArrayList<Integer> freeRooms = new ArrayList<>();
        for (int i = 0; i < busyRooms.length; i++){
            if (busyRooms[i] == null){
                freeRooms.add(i);
            }
        }
        return freeRooms;
    }
    public void changeRoom(Movie pelicula){
        for (int i = 0; i<busyRooms.length; i++){
            if (busyRooms[i] != null && busyRooms[i].isEqual(pelicula)){
                System.out.println("Sala: "+ i);
                System.out.println("Salas libres: ");
                for (int x = 0; x<busyRooms.length; x++){
                    if (busyRooms[x] == null ){
                        System.out.print(x+", ");
                    }
                }
                System.out.println("A donde lo quieres mover?");
                Scanner leer = new Scanner(System.in);
                int sala= leer.nextInt();
                if (busyRooms[sala]== null){
                    busyRooms[sala]=busyRooms[i];
                    busyRooms[i]=null;
                    break;
                }
            }
        }
    }
    public void resetCinema(){
        for (int i = 0; i<busyRooms.length; i++){
            if (busyRooms[i] != null ){
                busyRooms[i]=null;
            }
        }
    }
    public ArrayList<String> moviesShorterThan(int horas, int minutos){
        int duracion= horas * 60 +minutos;
        ArrayList<String> shorterMovies = new ArrayList<>();
        for (Movie pelicula : peliculas){
            if (pelicula.getMinutos()<duracion){
                shorterMovies.add(pelicula.getNombre());
            }
        }
        return shorterMovies;
    }
}
