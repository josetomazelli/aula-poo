package tomazelli.aula.br.a05_abastecimento;

import java.io.Serializable;

public class Abastecimento implements  Serializable
{
    private long id;
    private double km;
    private double litros;
    private double lat;
    private double lng;
    private String dataAbastecimento;
    private String posto;

    public Abastecimento()
    {
        this.setId(-1);
    }

    public double getKm()
    {
        return km;
    }

    public void setKm(double kmAtual)
    {
        this.km = kmAtual;
    }

    public double getLitros()
    {
        return litros;
    }

    public void setLitros(double litrosAbastecidos)
    {
        this.litros = litrosAbastecidos;
    }

    public String getDataAbastecimento()
    {
        return dataAbastecimento;
    }

    public void setDataAbastecimento(String dataAbastecimento)
    {
        this.dataAbastecimento = dataAbastecimento;
    }

    public String getPosto()
    {
        return posto;
    }

    public void setPosto(String posto)
    {
        this.posto = posto;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public double getLat()
    {
        return lat;
    }

    public void setLat(double lat)
    {
        this.lat = lat;
    }

    public double getLng()
    {
        return lng;
    }

    public void setLng(double lng)
    {
        this.lng = lng;
    }
}
