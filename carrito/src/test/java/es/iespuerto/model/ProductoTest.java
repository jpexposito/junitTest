package es.iespuerto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ProductoTest {

    public static final String CODIGO = "codigo";
    public static final String DESCRIPCION = "descripcion";
    Producto producto;

    @BeforeEach
    public void before() {
        if (producto == null) {
            producto = new Producto(CODIGO, DESCRIPCION,
                    1,1,1);
        }
    }

    @Test
    public void constructorTest() {
       Assertions.assertNotNull(producto, "El objeto producto no puede ser NULO");
    }

    @Test
    public void toStringTest() {
        Assertions.assertNotNull(producto.toString(),"La respuesta es nula");
        Assertions.assertTrue(producto.toString().contains(CODIGO),"No contiene el codigo");
        Assertions.assertTrue(producto.toString().contains(DESCRIPCION),"No contiene el descripcion");
    }

}
