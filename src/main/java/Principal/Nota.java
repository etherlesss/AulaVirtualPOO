package Principal;

public class Nota {
    // ATRIBUTOS
    private int idRamo;
    private double nota;
    
    private Operaciones operaciones = new Operaciones();
    
    // CONSTRUCTORES
    public Nota(int idRamo, double nota) {
        this.idRamo = idRamo;
        this.nota = nota;
    }
    
    public Nota() {
        
    }
    
    // GETTERS
    public int getIdRamo() {
        return this.idRamo;
    }

    public double getNota() {
        return this.nota;
    }

    public Operaciones getOperaciones() {
        return this.operaciones;
    }
    
    // SETTERS
    public void setIdRamo(int idRamo) {
        this.idRamo = idRamo;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setOperaciones(Operaciones operaciones) {
        this.operaciones = operaciones;
    }
    
    // METODOS
    public void crearDatos(int idRamo) {
        double notaIngresada = 0;
        
        System.out.println("Ingrese las notas: ");
        this.idRamo = idRamo;
        while (notaIngresada == 0) {
            System.out.print("Nota: ");
            notaIngresada = operaciones.validarNotaIngresada();
        }
        this.nota = notaIngresada;
    }
}
