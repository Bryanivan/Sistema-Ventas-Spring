package com.carlos.sistemat3.modelo;

import java.util.ArrayList;
import java.util.List;

/*
 * @author Carlos Chavez Laguna
 * */
public class Response<T> {	
	private List<T> data;	
	public static final int STATUS_OK=0,STATUS_ERROR=1;
	private int error;
	private String message;
	
	public Response() {
		this.error=0;
		this.message="";
		this.data = new ArrayList<T>();
	}
	
	/**
	 * @param status
	 */
	public Response(int status) {
		this();
		this.error=status;
		this.message="";
	}
	
	/**
	 * @param status
	 * @param message
	 */
	public Response(int status,String message) {
		this();
		this.error=status;
		this.message=message;
	}
	
	/**
	 * @param status
	 * @param data
	 */
	public Response(int error,List<T> data) {
		this();
		this.error=error;
		this.message="";
		this.data = data;
	}
	
	
	
	/**
	 * @return the error
	 */
	public int getError() {
		return error;
	}

	/**
	 * @param status the error to set
	 */
	public void setError(int error) {
		this.error = error;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the data
	 */
	public List<T> getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(List<T> data) {
		this.data = data;
	}
	
	
	
}
