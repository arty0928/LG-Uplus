package com.uplus.eureka.book.model.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class Book implements Serializable {
	private static final long serialVersionUID=1L;
	private String isbn         ;
	private String title        ;
	private String author       ;
	private int 	price       ;
	private String describ      ;
	private String img          ;
}
