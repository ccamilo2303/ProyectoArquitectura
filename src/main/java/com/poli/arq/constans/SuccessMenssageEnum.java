package com.poli.arq.constans;

public enum SuccessMenssageEnum {

	LOGIN_MESSAGE_OK("Usuario válido");
	
	private String value;

	SuccessMenssageEnum(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
