package com.dev.agenda.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class AgendaDocument {
    @Id
    private String id;
    private String agendaName;
    private String title;
    private String agendaBody;
    private LocalDateTime agendaDate;
    private LocalDateTime registrationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAgendaName() {
        return agendaName;
    }

    public void setAgendaName(String agendaName) {
        this.agendaName = agendaName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAgendaBody() {
        return agendaBody;
    }

    public void setAgendaBody(String agendaBody) {
        this.agendaBody = agendaBody;
    }

    public LocalDateTime getAgendaDate() {
        return agendaDate;
    }

    public void setAgendaDate(LocalDateTime agendaDate) {
        this.agendaDate = agendaDate;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
