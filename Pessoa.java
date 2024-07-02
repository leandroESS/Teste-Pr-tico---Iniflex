import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate Data_nasc;

    public Pessoa(String nome, LocalDate data_nasc) {
        this.nome = nome;
        Data_nasc = data_nasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData_nasc() {
        return Data_nasc;
    }

    public void setData_nasc(LocalDate data_nasc) {
        Data_nasc = data_nasc;
    }
}
