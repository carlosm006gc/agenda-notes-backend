package com.dev.agenda.service.exception;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(Object id) {
        super("ObjectNotFound. id" + id);
    }
}