package com.cg.iter.diagnosticCentre.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class RecordNotFoundException extends Exception {
	public RecordNotFoundException(String s) {
		super(s);
}
}
