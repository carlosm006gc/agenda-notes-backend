package com.dev.agenda.repository;

import com.dev.agenda.document.AgendaDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AgendaRepository extends MongoRepository<AgendaDocument, String> {

    Page<AgendaDocument> findByAgendaDateAfterOrderByAgendaDateAsc(LocalDateTime date, Pageable pageable);
    Page<AgendaDocument> findByAgendaDateBeforeOrderByAgendaDateDesc(LocalDateTime date, Pageable pageable);

}
