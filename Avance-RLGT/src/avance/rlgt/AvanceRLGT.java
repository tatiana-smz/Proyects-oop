package avance.rlgt;

// interfaz RLGT con los métodos verProductos y devolver
interface RLGT {
    void verProductos();
    void devolver();
}

// clase abstracta Prenda con sus atributos y métodos get para cada uno de ellos
abstract class Prenda {
    // atributos privados de la clase Prenda (encapsulamiento)
    private String nombre;
    private String talla;
    private double precio;
    private String color;
    private String tipo;

    // constructor de la clase Prenda
    public Prenda(String marca, String talla, double precio, String color, String tipo) {
        this.nombre = marca;
        this.talla = talla;
        this.precio = precio;
        this.color = color;
        this.tipo = tipo;
    }

    // encapsulamiento de los atributos de la clase Prenda con sus métodos get
    public String getMarca() {
        return nombre;
    }
    public String getTalla() {
        return talla;
    }
    public double getPrecio() {
        return precio;
    }
    public String getColor() {
        return color;
    }
    public String getTipo() {
        return tipo;
    }
}

class Inventario {
    // compara dos prendas mostrando sus nombres
    public void compararPrendas(Prenda p1, Prenda p2) {
        System.out.println("Comparando: " + p1.getMarca() + " vs " + p2.getMarca());
    }
    // agrega una prenda al inventario
    public void agregarPrendas(Prenda p) {
        System.out.println("Añadiendo prenda: " + p.getMarca());
    }
    // actualiza los datos de una prenda
    public void actualizarPrendas(Prenda p) {
        System.out.println("Actualizando prenda: " + p.getMarca());
    }
    // muestra cuál prenda se compra más entre dos opciones
    public void masComprado(Prenda p1, Prenda p2) {
        System.out.println("Más comprado (ejemplo): " + p1.getMarca() + " o " + p2.getMarca());
    }
}

// clase Camiseta que hereda de Prenda e implementa la interfaz RLGT
// polimorfismo: redefine verProductos() y devolver() con su propio comportamiento
class Camiseta extends Prenda implements RLGT {
    public Camiseta(String marca, String talla, double precio, String color, String tipo) {
        super(marca, talla, precio, color, tipo);
    }
    // muestra los datos de la camiseta (Override = redefine el método de la interfaz)
    @Override
    public void verProductos() {
        System.out.println("Camiseta: " + getMarca() + ", Talla: " + getTalla()
                + ", Precio: " + getPrecio() + ", Color: " + getColor()
                + ", Tipo: " + getTipo());
    }
    // devuelve la camiseta (Override = redefine el método de la interfaz)
    @Override
    public void devolver() {
        System.out.println("Devolviendo camiseta: " + getMarca());
    }
}

class Pantalon extends Prenda implements RLGT {
    public Pantalon(String marca, String talla, double precio, String color, String tipo) {
        super(marca, talla, precio, color, tipo);
    }
    @Override
    public void verProductos() {
        System.out.println("Pantalon: " + getMarca() + ", Talla: " + getTalla()
                + ", Precio: " + getPrecio() + ", Color: " + getColor()
                + ", Tipo: " + getTipo());
    }
    @Override
    public void devolver() {
        System.out.println("Devolviendo pantalon: " + getMarca());
    }
}

public class AvanceRLGT {
    public static void main(String[] args) {

        // crear objetos de tipo Camiseta y Pantalon con sus datos
        Camiseta c = new Camiseta("Nike", "M", 85000, "Rojo", "Deportiva");
        Pantalon p = new Pantalon("Levis", "32", 110000, "Azul", "Jeans baggy");
        c.verProductos();
        p.verProductos();
        c.devolver();
        p.devolver();

        Inventario inv = new Inventario();
        inv.compararPrendas(c, p);
        inv.agregarPrendas(c);
        inv.actualizarPrendas(p);
        inv.masComprado(c, p);
    }
}