package CLEVERCLOUD;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // Datos de conexión
        String url = "jdbc:mysql://bk6fmz2rcvm468amypdt-mysql.services.clever-cloud.com:3306/bk6fmz2rcvm468amypdt?useSSL=true&serverTimezone=UTC";
        String user = "ubnrqfecii6csss1";
        String password = "GLQeZtuRM8l7WTeNtHex";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a Clever Cloud");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Personas");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Nombre: " + rs.getString("nombre") +
                        ", Apellido: " + rs.getString("apellido") +
                        ", Edad: "+ rs.getString("edad"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}