package paquete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultas {
	
	public static void main(String[] args) {
		
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
			
			System.out.println("CONSULTAS");
			System.out.println("*************");
			System.out.println("Ejer 1");
			System.out.println();
			String sql = "Select * FROM departamentos";
			Statement sentencia = conexion.createStatement();
			ResultSet resul= sentencia.executeQuery(sql);
			while (resul.next()) {	
				
				System.out.printf("%d, %s, %s %n", resul.getInt(1), resul.getString(2), resul.getString(3));
				
			}
			resul.close();
			sentencia.close();
			System.out.println("*************");
			System.out.println("Ejer 2");
			System.out.println("*************");
			sql = "Select * FROM empleados where dept_no = 10";
			sentencia = conexion.createStatement();
			resul= sentencia.executeQuery(sql);			
			while (resul.next()) {	
				
				System.out.printf("%s, %s, %d € %n", resul.getString(2), resul.getString(3), resul.getInt(6));
				
			}
			resul.close();
			sentencia.close();
			System.out.println("*************");
			System.out.println("Ejer 3");
			System.out.println("*************");
			sql = "Select * FROM empleados where salario in (select max(salario) FROM empleados)";
			sentencia = conexion.createStatement();
			resul= sentencia.executeQuery(sql);
			while (resul.next()) {	
				
				System.out.printf("%s, %d €, %s %n", resul.getString(2), resul.getInt(6), resul.getString(8));
				
			}
			
			resul.close();
			sentencia.close();
			
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
