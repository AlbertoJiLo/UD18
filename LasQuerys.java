package UD18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.sql.*;

public class LasQuerys {
	private Connection conexion = null;
	
	public void establecerCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.38:3306?useTimezone=true&serverTimezone=UTC",
					"alberto","Z001349ebeadr@");
			System.out.println("Server connected");
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
	}

	public void cerrarCon() {
		try {
			conexion.close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el server");
		} catch (SQLException ex) {
			Logger.getLogger(LasQuerys.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	

	public void crearDB(String name) {
		try {
		String Query = "CREATE DATABASE "+name+";";
		String Query2 =  "DROP DATABASE IF EXISTS "+name+";";
		Statement st = conexion.createStatement();
		st.executeUpdate(Query2);
		st.executeUpdate(Query);
		System.out.println(" Server connected ");
		}catch(SQLException ex ){
			System.out.println("No se ha podido conectar con la base de datos o ya existe");		
		}
		
	}
	
	public void crearTabla(String db, String name, String valores) {

        try {

            String Querydb = "USE " + db + ";";
            Statement stdb =  conexion.createStatement();
            stdb.executeUpdate(Querydb);

            String Query = "CREATE TABLE "+ name +""+valores+";";
            Statement st =  conexion.createStatement();
            st.executeUpdate(Query);
            System.out.println("Tabla "+name+ " creada correctamente");
        } catch (Exception ex) {

            System.out.println(ex);

        }

    }
	
	public void insertarDatos(String db, String valores) {
		try {

            String Querydb = "USE " + db + ";";
            Statement stdb =  conexion.createStatement();
            stdb.executeUpdate(Querydb);

            String Query = valores;
            Statement st =  conexion.createStatement();
            st.executeUpdate(Query);
            
            System.out.println("Datos insertados correctamente");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
        }
	}

}
