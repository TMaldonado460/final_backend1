package com.ctd.finalbackend1.service;

import com.ctd.finalbackend1.model.TurnoDTO;

import java.util.Set;

public interface ITurnoService {
    TurnoDTO buscarPorId(Integer id);
    Set<TurnoDTO> buscarTodos();
    void eliminarTurno(Integer id);
    void actualizarTurno(TurnoDTO turnoDTO);
    TurnoDTO agregarTurno(TurnoDTO turnoDTO);
}
