import java.sql.*;

public class Genresdoa {

    private String id, title;
    public Connection connection;

    Genresdoa() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        this.connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "DRAGOS", "DRAGOS");
    }

    public void create(String id, String title) throws SQLException {
        String sql = "INSERT INTO GENRES(ID, NAME) VALUES(?,?)";

        try (Connection c = connection; PreparedStatement prep = connection.prepareStatement(sql)){
            prep.setString(1, id);
            prep.setString(2, title);
            prep.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.toString());
        }
    }
    public void findByName(String title) throws SQLException {
        Statement comanda = connection.createStatement();
        ResultSet rezultat = comanda.executeQuery("Select ID, NAME from GENRES where NAME like '" + title+"'");
        while (rezultat.next())
            System.out.println(rezultat.getString(1) + "  " + rezultat.getString(2));

    }
    public void findById(String id) throws  SQLException{
        Statement comanda = connection.createStatement();
        ResultSet rezultat = comanda.executeQuery("Select ID, NAME from GENRES where ID like '" + id +"'");
        while (rezultat.next())
            System.out.println(rezultat.getString(1) + "  " + rezultat.getString(2));
    }
}
