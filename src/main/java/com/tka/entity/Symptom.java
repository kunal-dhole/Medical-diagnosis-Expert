package com.tka.entity;

public class Symptom {


	int SymptomNumber;
	String SymptomDescription;
	String LongDescription;
	String Remarks;
	public Symptom() {
		super();
		
	}
	
	public Symptom(int symptomNumber, String symptomDescription, String longDescription, String remarks) {
		super();
		SymptomNumber = symptomNumber;
		SymptomDescription = symptomDescription;
		LongDescription = longDescription;
		Remarks = remarks;
	}

	public int getSymptomNumber() {
		return SymptomNumber;
	}

	public void setSymptomNumber(int symptomNumber) {
		SymptomNumber = symptomNumber;
	}

	public String getSymptomDescription() {
		return SymptomDescription;
	}

	public void setSymptomDescription(String symptomDescription) {
		SymptomDescription = symptomDescription;
	}

	public String getLongDescription() {
		return LongDescription;
	}

	public void setLongDescription(String longDescription) {
		LongDescription = longDescription;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	@Override
	public String toString() {
		return "Symptom [SymptomNumber=" + SymptomNumber + ", SymptomDescription=" + SymptomDescription
				+ ", LongDescription=" + LongDescription + ", Remarks=" + Remarks + "]";
	}


	
}
