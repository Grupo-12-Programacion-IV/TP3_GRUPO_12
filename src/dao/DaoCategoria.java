package dao;

import entidad.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DaoCategoria
{
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdinventario";
	
	public DaoCategoria (){}

	public ArrayList<Categoria> listadoCategoria()
    {
        ArrayList<Categoria> lista = new ArrayList<Categoria>();

        try
        {
            Connection cn = DriverManager.getConnection(url, user, pass);
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
}