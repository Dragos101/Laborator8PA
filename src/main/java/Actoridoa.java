import java.sql.*;

public class Actoridoa {
    public Connection connection;

    Actoridoa() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        this.connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "DRAGOS", "DRAGOS");
    }

    public void create(String nume, String prenume) throws SQLException {
        String sql = "INSERT INTO ACTORI(NUME, PRENUME) VALUES(?, ?)";

        try (Connection c = connection; PreparedStatement prep = connection.prepareStatement(sql)){
            prep.setString(1, nume);
            prep.setString(2, prenume);
            prep.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.toString());
        }
    }
    public void findByNume(String nume) throws SQLException {
        Statement comanda = connection.createStatement();
        ResultSet rezultat = comanda.executeQuery("Select NUME, PRENUME from ACTORI where NUME like '" + nume+"'");
        while (rezultat.next())
            System.out.println(rezultat.getString(1) + "  " + rezultat.getString(2));

    }
    public void findByPrenume(String prenume) throws  SQLException{
        Statement comanda = connection.createStatement();
        ResultSet rezultat = comanda.executeQuery("Select NUME, PRENUME from ACTORI where PRENUME like '" + prenume +"'");
        while (rezultat.next())
            System.out.println(rezultat.getString(1) + "  " + rezultat.getString(2));
    }
}
