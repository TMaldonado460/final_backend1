package com.ctd.finalbackend1.service;

import com.ctd.finalbackend1.model.PacienteDTO;

import java.util.Set;

public interface IPacienteService {
    PacienteDTO buscarPorId(Integer id);
    Set<PacienteDTO> buscarTodos();
    void eliminarPaciente(Integer id);
    void actualizarPaciente(PacienteDTO pacienteDTO);
    PacienteDTO agregarPaciente(PacienteDTO pacienteDTO);
}
