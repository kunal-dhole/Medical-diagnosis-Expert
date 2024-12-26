package com.tka.entity;

public class Patient {

	int  PatientNumber;
	String PatientName;
	int Patientage;
	String PatientAddress;
	int pincode;
	String BloodGroup;
	int mobileno;
	public Patient() {
		super();
	
	}
	public Patient(int patientNumber, String patientName, int patientage, String patientAddress, int pincode,
			String bloodGroup, int mobileno) {
		super();
		PatientNumber = patientNumber;
		PatientName = patientName;
		Patientage = patientage;
		PatientAddress = patientAddress;
		this.pincode = pincode;
		BloodGroup = bloodGroup;
		this.mobileno = mobileno;
	}
	public int getPatientNumber() {
		return PatientNumber;
	}
	public void setPatientNumber(int patientNumber) {
		PatientNumber = patientNumber;
	}
	public String getPatientName() {
		return PatientName;
	}
	public void setPatientName(String patientName) {
		PatientName = patientName;
	}
	public int getPatientage() {
		return Patientage;
	}
	public void setPatientage(int patientage) {
		Patientage = patientage;
	}
	public String getPatientAddress() {
		return PatientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		PatientAddress = patientAddress;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getBloodGroup() {
		return BloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		BloodGroup = bloodGroup;
	}
	public int getMobileno() {
		return mobileno;
	}
	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}
	@Override
	public String toString() {
		return "Patient [PatientNumber=" + PatientNumber + ", PatientName=" + PatientName + ", Patientage=" + Patientage
				+ ", PatientAddress=" + PatientAddress + ", pincode=" + pincode + ", BloodGroup=" + BloodGroup
				+ ", mobileno=" + mobileno + "]";
	}
	
	
	
}
