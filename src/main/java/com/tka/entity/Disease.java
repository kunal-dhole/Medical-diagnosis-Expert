package com.tka.entity;

public class Disease {

	int DiseaseNumber;
	String DiseaseName;	
	String PrimarySymptom;
	String DiseaseImplication;
	String DiseaseType;	
	String DiagnosisType;
	String ChronicFlag;
	public Disease() {
		super();

	}
	public Disease(int diseaseNumber, String diseaseName, String primarySymptom, String diseaseImplication,
			String diseaseType, String diagnosisType, String chronicFlag) {
		super();
		DiseaseNumber = diseaseNumber;
		DiseaseName = diseaseName;
		PrimarySymptom = primarySymptom;
		DiseaseImplication = diseaseImplication;
		DiseaseType = diseaseType;
		DiagnosisType = diagnosisType;
		ChronicFlag = chronicFlag;
	}
	public int getDiseaseNumber() {
		return DiseaseNumber;
	}
	public void setDiseaseNumber(int diseaseNumber) {
		DiseaseNumber = diseaseNumber;
	}
	public String getDiseaseName() {
		return DiseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		DiseaseName = diseaseName;
	}
	public String getPrimarySymptom() {
		return PrimarySymptom;
	}
	public void setPrimarySymptom(String primarySymptom) {
		PrimarySymptom = primarySymptom;
	}
	public String getDiseaseImplication() {
		return DiseaseImplication;
	}
	public void setDiseaseImplication(String diseaseImplication) {
		DiseaseImplication = diseaseImplication;
	}
	public String getDiseaseType() {
		return DiseaseType;
	}
	public void setDiseaseType(String diseaseType) {
		DiseaseType = diseaseType;
	}
	public String getDiagnosisType() {
		return DiagnosisType;
	}
	public void setDiagnosisType(String diagnosisType) {
		DiagnosisType = diagnosisType;
	}
	public String getChronicFlag() {
		return ChronicFlag;
	}
	public void setChronicFlag(String chronicFlag) {
		ChronicFlag = chronicFlag;
	}
	@Override
	public String toString() {
		return "Disease [DiseaseNumber=" + DiseaseNumber + ", DiseaseName=" + DiseaseName + ", PrimarySymptom="
				+ PrimarySymptom + ", DiseaseImplication=" + DiseaseImplication + ", DiseaseType=" + DiseaseType
				+ ", DiagnosisType=" + DiagnosisType + ", ChronicFlag=" + ChronicFlag + "]";
	}



}
