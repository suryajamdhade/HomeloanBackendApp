package com.re.app.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO {

	private int docID;
	private byte[] addressProof;
	private byte[] itr;
	private byte[] adharCard;
	private byte[] panCard;
	private byte[] photo;
	private byte[] signature;
	private byte[] bankCheque;
    private byte[] accountStatement;
    private byte[] salarySlips;
    private byte[] GST;
	
}
