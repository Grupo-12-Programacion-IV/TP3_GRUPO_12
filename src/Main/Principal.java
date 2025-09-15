package Main;

import dao.DaoCategoria;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;

public class Principal {

	public static void main(String[] args) {
		DaoCategoria DaoC = new DaoCategoria();
		DaoProducto DaoP = new DaoProducto();

		Categoria cat = new Categoria();
		cat.setNombre("ropa");
		int filas2 = DaoC.altaCategoria(cat);
		if (filas2 == 1) {
			System.out.println("CATEGORIA AGREGADOA CORRECTAMENTE");
		} else {
			System.out.println("CATEGORIA NO PUDO AGREGARSE");
		}

		DaoC.BajaCategoria(cat);

		Producto pr1 = new Producto();
		pr1.setCodigo("ASDFG");
		pr1.setIdCategoria(1);
		pr1.setNombre("zapatilla");
		pr1.setPrecio(1500);
		pr1.setStock(2);
		int filas = DaoP.altaProducto(pr1);
		if (filas == 1) {
			System.out.println("PRODUCTO AGREGADO CORRECTAMENTE");
		} else {
			System.out.println("ProductO NO PUDO AGREGARSE");
		}

		DaoP.BajaProducto(pr1);

	}

}
