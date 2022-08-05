package trabalho_3_lpp;

public abstract class Mamifero {
    
    String nome;
    String especie;
    Double peso;

    public abstract String nome(String nome);

    public abstract String especie(String especie);

    public abstract Double peso(Double peso);
    
    public abstract void print();
       
}
