package entidad;

public class Producto {
	private String codigo;
    private String nombre;
    private float precio;
    private int stock;
    private int idCategoria; // referencia a Categoria (FK)

    // Constructores
    public Producto(){}

    public Producto(String codigo, String nombre, float precio, int stock, int idCategoria)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.idCategoria = idCategoria;
    }

    // Getters y setters
    public String getCodigo()
    {
        return codigo;
    }
    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }
    public String getNombre()
    {
        return nombre;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public float getPrecio()
    {
        return precio;
    }
    public void setPrecio(float precio)
    {
        this.precio = precio;
    }

    public int getStock()
    {
        return stock;
    }
    public void setStock(int stock)
    {
        this.stock = stock;
    }
    public int getIdCategoria()
    {
        return idCategoria;
    }
    public void setIdCategoria(int idCategoria)
    {
        this.idCategoria = idCategoria;
    }

    // toString
    @Override
    public String toString()
    {
        return "Producto [codigo=" + codigo 
                + ", nombre=" + nombre 
                + ", precio=" + precio 
                + ", stock=" + stock 
                + ", idCategoria=" + idCategoria + "]";
    }
}
