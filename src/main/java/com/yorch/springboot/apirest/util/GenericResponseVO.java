package com.yorch.springboot.apirest.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GenericResponseVO extends ResponseEntity {
    public static GenericResponseVO SUCCESS = new GenericResponseVO(true);
    public static GenericResponseVO ERROR = new GenericResponseVO(false);

    protected boolean flagResult;
    protected String message;
    protected Object data;

    public GenericResponseVO(boolean flagResult) {
        this(flagResult, "");
    }

    public GenericResponseVO(boolean flagResult, String message) {
        super(HttpStatus.ACCEPTED);
        this.flagResult = flagResult;
        this.message = message;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }

    public void resetSuccess() {
        this.flagResult = true;
        this.message = "";
        this.data = null;
    }

    public void resetError() {
        this.flagResult = false;
        this.message = "";
        this.data = null;
    }
}
