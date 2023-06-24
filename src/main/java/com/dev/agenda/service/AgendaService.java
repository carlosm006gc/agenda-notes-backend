package com.dev.agenda.service;

import com.dev.agenda.document.AgendaDocument;
import com.dev.agenda.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AgendaService {

    @Autowired
    AgendaRepository agendaRepository;

    public Page<AgendaDocument> findAll(Pageable pageable, String flag){
        if (flag != null && flag.equals("next")){
            return agendaRepository.findByAgendaDateAfterOrderByAgendaDateAsc(LocalDateTime.now(), pageable);
        } else if (flag != null && flag.equals("waiting")) {
            return agendaRepository.findByAgendaDateBeforeOrderByAgendaDateDesc(LocalDateTime.now(), pageable);
        }
        else {
            return agendaRepository.findAll(pageable);
        }
    }
    public Optional<AgendaDocument> findById(String id){
        return agendaRepository.findById(id);
    }
    public AgendaDocument save(AgendaDocument agendaDocument){
        return agendaRepository.save(agendaDocument);
    }
    public void delete(AgendaDocument agendaDocument){
        agendaRepository.delete(agendaDocument);
    }
}
