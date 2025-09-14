package dao;

import entidad.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoProducto {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdinventario";
	
	public DaoProducto () {}
	
	public int altaProducto(Producto producto) {
	
		String query= "INSERT INTO productos (Nombre, Precio, Stock, IdCategoria) VALUES ('"+producto.getNombre()+"','"+producto.getPrecio()+"','"+producto.getStock()+"','"+producto.getIdCategoria()+"')";
		
		Connection cn =null;
		int filas = 0;
		try {
			cn= DriverManager.getConnection(host+dbName,user,pass);
			Statement st= cn.createStatement();
			filas= st.executeUpdate(query);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	
		return filas;
	}

	public ArrayList<Producto> listarProductos()
	{
		ArrayList<Producto> lista = new ArrayList<Producto>();

		try
		{
			Connection cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Productos");

			while (rs.next())
			{
				Producto p = new Producto();
				p.setCodigo(rs.getString("Codigo"));
				p.setNombre(rs.getString("Nombre"));
				p.setPrecio(rs.getFloat("Precio"));
				p.setStock(rs.getInt("Stock"));
				p.setIdCategoria(rs.getInt("IdCategoria"));
				lista.add(p);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return lista;
	}
	
	public int BajaProducto(Producto id) {
		String query = "DELETE FROM Productos AS P WHERE P.Codigo = " + id;
		int filas = 0;
		
		try {
			Connection cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			filas =  st.executeUpdate(query);
		}
		catch (Exception e){
		e.printStackTrace();
		}
		return filas;	
	}

}