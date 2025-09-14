package entidad;

public class Categoria {
		private int id;
	    private String nombre;
	    
	    // Constructores
	    public Categoria(){}

	    public Categoria(int id, String nombre)
	    {
	        this.id = id;
	        this.nombre = nombre;
	    }

	    // Getters y setters
	    public int getId()
	    {
	        return id;
	    }
	    public void setId(int id)
	    {
	        this.id = id;
	    }
	    public String getNombre()
	    {
	        return nombre;
	    }
	    public void setNombre(String nombre)
	    {
	        this.nombre = nombre;
	    }

	    // toString
	    @Override
	    public String toString()
	    {
	        return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	    }
}
