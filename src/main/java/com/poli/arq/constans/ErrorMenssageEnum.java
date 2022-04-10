package com.poli.arq.constans;

public enum ErrorMenssageEnum {

	ERROR_REQUEST_VALIDATION("Datos requeridos, por favor valide la información de entrada"),
	ERROR_VALIDATION_QUERY_USER("Error en los datos consultados, por  favor verifique e intente de nuevo"),
	ERROR_EMAIL_FORMAT("Formato de email incorrecto");
	
	private String value;
	
	ErrorMenssageEnum(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
