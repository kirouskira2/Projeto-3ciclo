package br.com.casaverde.model;

import java.time.LocalDateTime;

/**
 * Agendamento de visita ao imóvel.
 */
public class Visita {

    private Long clienteId;
    private Long imovelId;
    private LocalDateTime dataHora;
    private String status; // ex.: "CRIADA", "CONFIRMADA", "CANCELADA"

    public Visita(Long clienteId, Long imovelId, LocalDateTime dataHora) {
        this.clienteId = clienteId;
        this.imovelId = imovelId;
        this.dataHora = dataHora;
        this.status = "CRIADA"; // começa criada
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getImovelId() {
        return imovelId;
    }

    public void setImovelId(Long imovelId) {
        this.imovelId = imovelId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

