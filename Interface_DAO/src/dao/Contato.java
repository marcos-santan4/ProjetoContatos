package dao;
public class Contato {
    int codigo;
    String nome;
    String email;
    String celular;

    public Contato() {
        this.codigo = 0;
        this.nome = "";
        this.email = "";
        this.celular = "";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String imprime() {
        return "\nCódigo: " + this.codigo +
               "\nNome: " + this.nome +
               "\nE-mail: " + this.email +
               "\nCelular: " + this.celular;
    }
}



