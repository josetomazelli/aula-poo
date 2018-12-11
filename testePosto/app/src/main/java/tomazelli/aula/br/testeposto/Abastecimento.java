package tomazelli.aula.br.testeposto;

public class Abastecimento {


    private String Nome;
    private Float Km;
    private Float litro;
    private String data;
    private double latitude;
    private  double longitude;

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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
