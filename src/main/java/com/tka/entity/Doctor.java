package com.tka.entity;

public class Doctor {

	int  DoctorNumber;
	String  DoctorName;
	String  DoctorQualification;
	String DoctorSpecialization;
	int  DoctorExperience;
	String  DoctorDesignation;
	
	public Doctor() {
		super();
		
	}

	public Doctor(int doctorNumber, String doctorName, String doctorQualification, String doctorSpecialization,
			int doctorExperience, String doctorDesignation) {
		super();
		DoctorNumber = doctorNumber;
		DoctorName = doctorName;
		DoctorQualification = doctorQualification;
		DoctorSpecialization = doctorSpecialization;
		DoctorExperience = doctorExperience;
		DoctorDesignation = doctorDesignation;
	}

	public int getDoctorNumber() {
		return DoctorNumber;
	}

	public void setDoctorNumber(int doctorNumber) {
		DoctorNumber = doctorNumber;
	}

	public String getDoctorName() {
		return DoctorName;
	}

	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}

	public String getDoctorQualification() {
		return DoctorQualification;
	}

	public void setDoctorQualification(String doctorQualification) {
		DoctorQualification = doctorQualification;
	}

	public String getDoctorSpecialization() {
		return DoctorSpecialization;
	}

	public void setDoctorSpecialization(String doctorSpecialization) {
		DoctorSpecialization = doctorSpecialization;
	}

	public int getDoctorExperience() {
		return DoctorExperience;
	}

	public void setDoctorExperience(int doctorExperience) {
		DoctorExperience = doctorExperience;
	}

	public String getDoctorDesignation() {
		return DoctorDesignation;
	}

	public void setDoctorDesignation(String doctorDesignation) {
		DoctorDesignation = doctorDesignation;
	}

	@Override
	public String toString() {
		return "Docter [DoctorNumber=" + DoctorNumber + ", DoctorName=" + DoctorName + ", DoctorQualification="
				+ DoctorQualification + ", DoctorSpecialization=" + DoctorSpecialization + ", DoctorExperience="
				+ DoctorExperience + ", DoctorDesignation=" + DoctorDesignation + "]";
	}
	
	
	
	
	
	
}
