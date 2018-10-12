/**
 * 
 */
package com.sampana.cms.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;



public class ResponseDTO implements Serializable {

	private static final long serialVersionUID = -212651961961257920L;

	private HttpStatus status;

	private int code;

	private Object data;

	private String message = "";

	
	public ResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ResponseDTO(HttpStatus status, int code, String message) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
	}



	public ResponseDTO(HttpStatus status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}

	
	public ResponseDTO(HttpStatus status, int code, Object data, String message) {
		super();
		this.status = status;
		this.code = code;
		this.data = data;
		this.message = message;
	}

	
	public ResponseDTO(HttpStatus status, Object data, String message) {
		super();
		this.status = status;
		this.data = data;
		this.message = message;
	}

	
	public final HttpStatus getStatus() {
		return status;
	}

	
	public final void setStatus(HttpStatus status) {
		this.status = status;
	}

	
	public final Object getData() {
		return data;
	}

	
	public final void setData(Object data) {
		this.data = data;
	}

	
	public final String getMessage() {
		return message;
	}

	
	public final void setMessage(String message) {
		this.message = message;
	}

	public final int getcode() {
		return code;
	}

	
	public final void setcode(int code) {
		this.code = code;
	}

}
