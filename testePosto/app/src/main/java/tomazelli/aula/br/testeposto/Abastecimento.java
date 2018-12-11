package tomazelli.aula.br.testeposto;

public class Abastecimento {


    private String Nome;
    private Float Km;
    private Float litro;
    private String data;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Float getKm() {
        return Km;
    }

    public void setKm(Float km) {
        Km = km;
    }

    public Float getLitro() {
        return litro;
    }

    public void setLitro(Float litro) {
        this.litro = litro;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
