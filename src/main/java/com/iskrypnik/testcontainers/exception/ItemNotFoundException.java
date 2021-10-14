package com.iskrypnik.testcontainers.exception;

import lombok.Data;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException() {
        super();
    }
}
