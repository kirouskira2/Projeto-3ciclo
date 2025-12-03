package br.com.casaverde.service;

import br.com.casaverde.model.Visita;
import java.time.LocalDateTime;

/**
 * Operações de agendamento de visita.
 */
public class VisitaService {

    public Visita criarVisita(Long clienteId, Long imovelId, LocalDateTime dataHora) {
        if (clienteId == null || clienteId <= 0) return null;
        if (imovelId == null || imovelId <= 0) return null;
        if (dataHora == null || !dataHora.isAfter(LocalDateTime.now())) return null; // precisa ser futura
        return new Visita(clienteId, imovelId, dataHora);
    }

    public boolean cancelar(Visita visita) {
        if (visita == null) return false;
        visita.setStatus("CANCELADA");
        return true;
    }

    public boolean confirmar(Visita visita) {
        if (visita == null) return false;
        visita.setStatus("CONFIRMADA");
        return true;
    }

    public boolean reagendar(Visita visita, LocalDateTime novaDataHora) {
        if (visita == null) return false;
        if (novaDataHora == null || !novaDataHora.isAfter(LocalDateTime.now())) return false;
        visita.setDataHora(novaDataHora);
        visita.setStatus("CRIADA"); // volta para criada
        return true;
    }
}

