package es.iespuerto.vista;

import es.iespuerto.controlador.Carrito;
import es.iespuerto.model.Producto;
import es.iespuerto.utils.Utilidades;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;

public class Tienda {



    /**
     * Funcion main de la clase principal
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        List<Producto> productos = new ArrayList<>();
        Carrito carro = new Carrito();
        Utilidades utilidades = new Utilidades();
        Tienda compra = new Tienda();
        productos = utilidades.leerProductos("productos.txt");
        utilidades.leerCarrito("compra.txt",productos);
        System.out.println(carro.imprimirTicket());
        
    }
}