package Main;

import java.util.ArrayList;

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

		// Editar producto

		Producto pro = new Producto("1", "Producto1", 450, 20, 1);

		int filas_3 = DaoP.editarProducto(pro, "1");

		if (filas > 0) {
			System.out.println("Se actualizo correctamente");
		} else {
			System.out.println("No se encontro el producto");
		}

		// Editar categoria

		Categoria Cat = new Categoria(1, "Nueva categoria");

		int fila = DaoC.editarCategoria(Cat);

		if (fila > 0) {
			System.out.println("Se actualizo correctamente");
		} else {
			System.out.println("No se encontro la categoria");
		}

		// Lista Productos

		ArrayList<Producto> productos = DaoP.listarProductos();

		for (Producto p : productos) {
			System.out.println(
					"Código: " + p.getCodigo() +
							" | Nombre: " + p.getNombre() +
							" | Precio: " + p.getPrecio() +
							" | Stock: " + p.getStock() +
							" | IdCategoria: " + p.getIdCategoria());

		}

		// Lista Categoria

		ArrayList<Categoria> categorias = DaoC.listadoCategoria();

		for (Categoria c : categorias) {
			System.out.println("ID: " + c.getId() + " - Nombre: " + c.getNombre());

		}

	}
}
