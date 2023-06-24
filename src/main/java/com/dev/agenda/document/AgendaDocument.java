package com.dev.agenda.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class AgendaDocument implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgendaDocument that = (AgendaDocument) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
