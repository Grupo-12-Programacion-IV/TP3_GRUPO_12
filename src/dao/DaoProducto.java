package dao;

import entidad.Producto;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public void EjecutarSPagregarProducto (Producto producto){
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL sp_AgregarProducto(?,?,?,?,?,?)");
			cst.setString(1, producto.getCodigo());
			cst.setString(2, producto.getNombre());
			cst.setFloat(3, producto.getPrecio());
			cst.setInt(4, producto.getStock());
			cst.setInt(5, producto.getIdCategoria());
			System.out.println("Se logro agregar");
		}
		catch (Exception e){
			e.printStackTrace();
			System.out.println("No se logro agregar");
		}
	}
	
	public int editarProducto(Producto producto, String CodigoOriginal) {
	    String sql = "UPDATE productos SET Codigo = ?, Nombre = ?, Precio = ?, Stock = ?, idCategoria = ? WHERE Codigo = ?";
	    int filas = 0;

	    try (Connection cn = DriverManager.getConnection(host + dbName, user, pass);
	         PreparedStatement ps = cn.prepareStatement(sql)) {

	        ps.setString(1, producto.getCodigo());          
	        ps.setString(2, producto.getNombre());    
	        ps.setDouble(3, producto.getPrecio());    
	        ps.setInt(4, producto.getStock());        
	        ps.setInt(5, producto.getIdCategoria()); 
	        ps.setString(6, CodigoOriginal);                 

	        filas = ps.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return filas;
	}

			
	}


