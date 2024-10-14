package com.alura.bases;

import java.time.LocalDate;

public class JsonFile implements Comparable<JsonFile>{
    private String fechaHoy = (LocalDate.now()).toString();
    private String deMoneda;
    private String aMoneda;
    private double tasaDeCambioBase;
    private double valorConvertido;


    public JsonFile() {
        this.fechaHoy = fechaHoy;
        this.deMoneda = deMoneda;
        this.aMoneda = aMoneda;
        this.tasaDeCambioBase = tasaDeCambioBase;
        this.valorConvertido = valorConvertido;
    }

    public String getFechaHoy() {
        return fechaHoy;
    }

    public void setFechaHoy(String fechaHoy) {
        this.fechaHoy = fechaHoy;
    }

    public String getDeMoneda() {
        return deMoneda;
    }

    public void setDeMoneda(String deMoneda) {
        this.deMoneda = deMoneda;
    }

    public String getAMoneda() {
        return aMoneda;
    }

    public void setAMoneda(String aMoneda) {
        this.aMoneda = aMoneda;
    }

    public double getTasaDeCambioBase() {
        return tasaDeCambioBase;
    }

    public void setTasaDeCambioBase(double tasaDeCambioBase) {
        this.tasaDeCambioBase = tasaDeCambioBase;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }

    public void setValorConvertido(double valorConvertido) {
        this.valorConvertido = valorConvertido;
    }

    @Override
    public int compareTo(JsonFile otroJsonFile) {
        return 0;
    }

    @Override
    public String toString() {
        return "(fechahoy=" + fechaHoy +
                ", deMoneda='" + deMoneda +
                ", aMoneda='" + aMoneda +
                ", tasaDeCambioBase=" + tasaDeCambioBase +
                ", ValorConvertido=" + valorConvertido +
                ")";
    }
}
