package dao;

import entidad.Categoria;
import entidad.Producto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoCategoria
{
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "BaseDeDatos_1";
	private String dbName = "bdinventario";
	
	public DaoCategoria (){}

	public ArrayList<Categoria> listadoCategoria()
    {
        ArrayList<Categoria> lista = new ArrayList<Categoria>();

        try
        {
            Connection cn= DriverManager.getConnection(host+dbName,user,pass);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Categorias");

            while (rs.next())
            {
                Categoria c = new Categoria();
                c.setId(rs.getInt("IdCategoria"));
                c.setNombre(rs.getString("Nombre"));
                lista.add(c);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return lista;  
    }
	
	public int BajaCategoria(Categoria id) {
		String query = "DELETE FROM Categorias WHERE IdCategoria = ?";
		int filas = 0;
		
		try (Connection cn = DriverManager.getConnection(host+dbName, user, pass);
		PreparedStatement pst = cn.prepareStatement(query)){
			pst.setInt(1, id.getId());
			filas = pst.executeUpdate();
		}
		catch (Exception e){
		e.printStackTrace();
		}
		return filas;	
	}
	
	public int editarCategoria(Categoria categoria) {
	    String query = "UPDATE categorias SET Nombre = ? WHERE IdCategoria = ?";
	    int filas = 0;

	    try (Connection cn = DriverManager.getConnection(host + dbName, user, pass);
	         PreparedStatement pst = cn.prepareStatement(query)) {
	        
	    	pst.setString(1, categoria.getNombre());  
	        pst.setInt(2, categoria.getId()); 
	        

	        filas = pst.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return filas;
	}
	
}