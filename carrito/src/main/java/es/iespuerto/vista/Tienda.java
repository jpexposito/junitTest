package es.iespuerto.vista;

import es.iespuerto.controlador.Carrito;
import es.iespuerto.model.Producto;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;

public class Tienda {

    private List<Producto> productos = new ArrayList<>();
    private Carrito carro = new Carrito();

    /**
     * Funcion que permite leer los elementos del fichero de productos
     * @param ficheroProductos Nombre del fichero de productos
     * @throws FileNotFoundException Excepcion indicando que el fichero no existe
     */
    public void leerProductos(String ficheroProductos) throws FileNotFoundException {
        Scanner fichero = new Scanner(new File(ficheroProductos));
        String linea;
        String[] lineaDatos;
        fichero.nextLine();
        while (fichero.hasNextLine()) {
            linea = fichero.nextLine();
            lineaDatos = linea.split(";");
            productos.add(new Producto(lineaDatos[0], lineaDatos[1], Double.parseDouble(lineaDatos[2]),
                    Double.parseDouble(lineaDatos[3]), Integer.parseInt(lineaDatos[4])));
        }
    }

    /**
     * Funcion que permite buscar un producto.
     * @param codigo Codigo del producto que se desea buscar
     * @return Producto relacionado con el codigo
     */
    public Producto buscarProducto(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Funcion que lee los elementos del carrito
     * @param ficheroCantidades Fichero con los elementos del carro de la compra
     * @throws FileNotFoundException Exception indicando que el fichero no existe
     */
    public void leerCarrito(String ficheroCantidades) throws FileNotFoundException {
        Scanner fichero = new Scanner(new File(ficheroCantidades));
        String linea;
        String[] lineaDatos;
        fichero.nextLine();
        Producto p;
        int cantidad;
        while (fichero.hasNextLine()) {
            linea = fichero.nextLine();
            lineaDatos = linea.split(";");
            cantidad = Integer.parseInt(lineaDatos[1]);
            p = buscarProducto(lineaDatos[0]);
            if (cantidad <= p.getStock()) {
                p.changeStock(-cantidad);
                carro.add(p, cantidad);
            } else {
                System.out.printf(
                        "Lo siento, no hay suficiente stock del producto %s. Cantidad pedida: %d; Cantidad disponible: %d%n",
                        p.getCodigo(), cantidad, p.getStock());
            }
        }
    }

    /**
     * Funcion encargada de obtener el path del ficero
     * @param nombreFichero Nombre del fichero a buscar
     * @return Path completo del fichero
     * @throws URISyntaxException Exception por la URL mal formada
     */
    public String obtenerPathFichero(String nombreFichero) throws URISyntaxException {
        URL res = getClass().getClassLoader().getResource(nombreFichero);
        File file = Paths.get(res.toURI()).toFile();
        String absolutePath = file.getAbsolutePath();
        return absolutePath;
    }


    /**
     * Funcion main de la clase principal
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        Tienda compra = new Tienda();
        compra.leerProductos(compra.obtenerPathFichero("productos.txt"));
        compra.leerCarrito(compra.obtenerPathFichero("compra.txt"));
        compra.carro.imprimirTicket();
    }
}