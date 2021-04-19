import javax.xml.transform.Result;
import java.sql.*;

public class Moviedoa {

    private int id, duration, score;
    private String title, date;

    public Connection connection;

    Moviedoa() throws ClassNotFoundException, SQLException{
        Class.forName("oracle.jdbc.driver.OracleDriver");

        this.connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "DRAGOS", "DRAGOS");
    }

    public void create(String id, String title, String date, String duration, String score) throws SQLException {
        String sql = "INSERT INTO MOVIES(ID, TITLE, RELEASE_DATE, DURATION, SCORE) VALUES(?,?,?,?,?)";

        try (Connection c = connection; PreparedStatement prep = connection.prepareStatement(sql)){
            prep.setString(1, id);
            prep.setString(2, title);
            prep.setString(3, date);
            prep.setString(4, duration);
            prep.setString(5, score);
            prep.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.toString());
        }
    }
    public void findByName(String title) throws SQLException {
        Statement comanda = connection.createStatement();
        ResultSet rezultat = comanda.executeQuery("Select ID, TITLE from MOVIES where TITLE like '" + title+"'");
        while (rezultat.next())
            System.out.println(rezultat.getString(1) + "  " + rezultat.getString(2));

    }
    public void findById(String id) throws  SQLException{
        Statement comanda = connection.createStatement();
        ResultSet rezultat = comanda.executeQuery("Select ID, TITLE from MOVIES where ID like '" + id +"'");
        while (rezultat.next())
            System.out.println(rezultat.getString(1) + "  " + rezultat.getString(2));
    }

}
