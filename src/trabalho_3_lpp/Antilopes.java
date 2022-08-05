package trabalho_3_lpp;

public class Antilopes extends Mamifero{
    
@Override
    public String nome(String nome) {
        this.nome = nome;
        return nome;
    }

    @Override
    public String especie(String especie) {
        this.especie = especie;
        return especie;
    }

    @Override
    public Double peso(Double peso) {
        this.peso = peso;
        return peso;
    }
    
    @Override
    public void print (){
        System.out.println("\n-----Animal Mamífero Antílope----- " + "\nNome- " + this.nome + "\nEspécie- " + this.especie + "\nPeso- " + this.peso + "\n");
    }

}
