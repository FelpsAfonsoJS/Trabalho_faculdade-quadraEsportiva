package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Aluguel {
    private Cliente cliente;
    private LocalDate data;
    private LocalTime horaInicio;
    private int duracaoMinutos;

    public Aluguel(Cliente cliente, LocalDate data, LocalTime horaInicio, int duracaoMinutos) {
        this.cliente = cliente;
        this.data = data;
        this.horaInicio = horaInicio;
        this.duracaoMinutos = duracaoMinutos;
    }

    public double calcularTotal() {
        return (duracaoMinutos / 60.0) * 100;
    }

    public LocalTime getHoraFim() {
        return horaInicio.plusMinutes(duracaoMinutos);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }
}