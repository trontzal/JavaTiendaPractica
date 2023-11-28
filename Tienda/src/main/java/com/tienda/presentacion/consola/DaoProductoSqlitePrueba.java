package com.tienda.presentacion.consola;

import java.util.Scanner;

import com.tienda.accesodatos.DaoProducto;
import com.tienda.accesodatos.DaoProductoSqlite;
import com.tienda.entidades.Productos;

public class DaoProductoSqlitePrueba {

	public static void main(String[] args) {
		DaoProducto dao = new DaoProductoSqlite();
		Scanner scanner = new Scanner(System.in);

		int opcion;
		do {
			System.out.println("Seleccione una opción:");
			System.out.println("1. Ver todos los productos");
			System.out.println("2. Modificar un producto");
			System.out.println("3. Borrar un producto");
			System.out.println("4. Buscar producto por el nombre");
			System.out.println("5. Añadir un producto nuevo");
			System.out.println("6. Salir");
			System.out.print("Opción: ");

			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer del Scanner

			switch (opcion) {
			case 1:
				System.out.println("Listado de productos:");
				for (Productos p : dao.obtenerTodos()) {
					System.out.println(p);
				}
				break;

			case 2:
				System.out.print("Introduce el ID del producto a modificar: ");
				long idModificar = scanner.nextLong();
				scanner.nextLine(); // Limpiar el buffer del Scanner

				Productos productoAModificar = dao.obtenerPorId(idModificar);
				if (productoAModificar != null) {
					System.out.print("Introduce el nuevo nombre: ");
					String nuevoNombre = scanner.nextLine();
					productoAModificar.setNombre(nuevoNombre);

					dao.modificar(productoAModificar);
					System.out.println("Producto modificado con éxito.");
				} else {
					System.out.println("No se encontró ningún producto con ese ID.");
				}
				break;

			case 3:
				System.out.print("Introduce el id a eliminar: ");
				long idAEliminar = scanner.nextLong();
				scanner.nextLine();

				Productos productoAEliminar = dao.obtenerPorId(idAEliminar);
				if (productoAEliminar != null) {
					dao.borrar(idAEliminar);
					System.out.println("Producto eliminado correctamente");
				} else {
					System.out.println("Error al eliminar el producto");
				}
				break;

			case 4:
				System.out.print("Introduce el nombre del producto: ");
				String nombreProducto = scanner.nextLine();

				// Obtener productos por nombre
				Iterable<Productos> productosPorNombre = dao.obtenerPorNombre(nombreProducto);

				System.out.println("Productos encontrados con el nombre '" + nombreProducto + "':");
				for (Productos p : productosPorNombre) {
					System.out.println(p);
				}
				break;

			case 5:
				System.out.print("Nombre del producto nuevo: ");
				String nombreProductoNuevo = scanner.nextLine();
				
				dao.insertar(new  Productos(nombreProductoNuevo));
				break;
			case 6:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opción inválida, por favor seleccione una opción válida.");
				break;

			}
		} while (opcion != 6);

		scanner.close();
	}
}
