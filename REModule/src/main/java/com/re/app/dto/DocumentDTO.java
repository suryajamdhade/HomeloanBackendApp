package com.re.app.dto;

import lombok.Data;

@Data
public class DocumentDTO {

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
