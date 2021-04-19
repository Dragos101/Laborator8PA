import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Moviedoa film = new Moviedoa();
        Genresdoa gen = new Genresdoa();
        Actoridoa actor = new Actoridoa();
        Directoridoa director = new Directoridoa();
        try{
            //gen.create("2", "actiune");
            //film.create("2", "Messi", "20", "3H", "2");
            //actor.create("Baciu", "Dragos");
            //director.create("Master", "Johbn");
            film.findByName("Dragos");
            film.findById("1");
            /*gen.findByName("Dragos");
            gen.findById("1");*/
            /*actor.findByNume("Baciu");
            actor.findByPrenume("Dragos");*/
            /*director.findByNume("Master");
            director.findByPrenume("Dragos");*/
        }
        catch (SQLException e){
            System.out.println(e.toString());
        }
    }

}
