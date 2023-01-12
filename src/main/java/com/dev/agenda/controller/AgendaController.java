package com.dev.agenda.controller;

import com.dev.agenda.document.AgendaDocument;
import com.dev.agenda.service.AgendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class AgendaController {

    @Autowired
    AgendaService agendaService;

    @GetMapping("/notes")
    public ResponseEntity<Page<AgendaDocument>> getAllNotes(@PageableDefault
        (page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)
        Pageable pageable, @RequestParam(required = false) String flag) {
        Page<AgendaDocument> agendaPage = agendaService.findAll(pageable, flag);
        if(agendaPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Page<AgendaDocument>>(agendaPage, HttpStatus.OK);
        }
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<AgendaDocument> getOneNote(@PathVariable(value = "id") String id){
        Optional<AgendaDocument> noteOne = agendaService.findById(id);
        if (noteOne.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return  new ResponseEntity<AgendaDocument>(noteOne.get(), HttpStatus.OK);
        }
    }

    @PostMapping("/notes")
    public ResponseEntity<AgendaDocument> newNote(@RequestBody @Valid AgendaDocument agendaDocument){
        agendaDocument.setRegistrationDate(LocalDateTime.now());
        return new ResponseEntity<AgendaDocument>(agendaService.save(agendaDocument), HttpStatus.CREATED);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") String id) {
        Optional<AgendaDocument> noteOne = agendaService.findById(id);
        if (noteOne.isEmpty()) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            agendaService.delete(noteOne.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @PutMapping("/notes/{id}")
    public ResponseEntity<AgendaDocument> updateNote(@PathVariable(value="id") String id,
        @RequestBody @Valid AgendaDocument agendaDocument) {
        Optional<AgendaDocument> noteOne = agendaService.findById(id);
        if(!noteOne.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            agendaDocument.setId(noteOne.get().getId());
            return new ResponseEntity<AgendaDocument>(agendaService.save(agendaDocument), HttpStatus.OK);
        }
    }
}

