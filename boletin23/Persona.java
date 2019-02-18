package boletin23;

public class Persona {

    private int idade;

    public Persona(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "\nidade=" + idade;
    }

}
