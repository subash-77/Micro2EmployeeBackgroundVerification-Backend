package com.subash.api.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "verifysource")
public class VerifySource {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int verifyId;
	
	@Lob
    @Column(name = "resume",length=1000000000)
    private byte[] resume;
	
	@Lob
    @Column(name = "educationTenth",length=1000000000)
    private byte[] educationTenth;
	
	@Lob
    @Column(name = "educationTwelth",length=1000000000)
    private byte[] educationTwelth;
	
	@Lob
    @Column(name = "sem1",length=1000000000)
    private byte[] sem1;
	
	@Lob
    @Column(name = "sem2",length=1000000000)
    private byte[] sem2;
	
	@Lob
    @Column(name = "sem3",length=1000000000)
    private byte[] sem3;
	@Lob
    @Column(name = "sem4",length=1000000000)
    private byte[] sem4;
	@Lob
    @Column(name = "sem5",length=1000000000)
    private byte[] sem5;
	@Lob
    @Column(name = "sem6",length=1000000000)
    private byte[] sem6;
	
	@Lob
    @Column(name = "sem7",length=1000000000)
    private byte[] sem7;
	
	@Lob
    @Column(name = "sem8",length=1000000000)
    private byte[] sem8;
	
	@Lob
    @Column(name = "drivingLicense",length=1000000000)
    private byte[] drivingLicense;
	
	@Lob
    @Column(name = "aadhaar",length=1000000000)
    private byte[] aadhaar;

	
	
	public VerifySource() {
		super();
		// TODO Auto-generated constructor stub
	}



	public VerifySource(int verifyId, byte[] resume, byte[] educationTenth, byte[] educationTwelth, byte[] sem1,
			byte[] sem2, byte[] sem3, byte[] sem4, byte[] sem5, byte[] sem6, byte[] sem7, byte[] sem8,
			byte[] drivingLicense, byte[] aadhaar) {
		super();
		this.verifyId = verifyId;
		this.resume = resume;
		this.educationTenth = educationTenth;
		this.educationTwelth = educationTwelth;
		this.sem1 = sem1;
		this.sem2 = sem2;
		this.sem3 = sem3;
		this.sem4 = sem4;
		this.sem5 = sem5;
		this.sem6 = sem6;
		this.sem7 = sem7;
		this.sem8 = sem8;
		this.drivingLicense = drivingLicense;
		this.aadhaar = aadhaar;
	}



	public int getVerifyId() {
		return verifyId;
	}



	public void setVerifyId(int verifyId) {
		this.verifyId = verifyId;
	}



	public byte[] getResume() {
		return resume;
	}



	public void setResume(byte[] resume) {
		this.resume = resume;
	}



	public byte[] getEducationTenth() {
		return educationTenth;
	}



	public void setEducationTenth(byte[] educationTenth) {
		this.educationTenth = educationTenth;
	}



	public byte[] getEducationTwelth() {
		return educationTwelth;
	}



	public void setEducationTwelth(byte[] educationTwelth) {
		this.educationTwelth = educationTwelth;
	}



	public byte[] getSem1() {
		return sem1;
	}



	public void setSem1(byte[] sem1) {
		this.sem1 = sem1;
	}



	public byte[] getSem2() {
		return sem2;
	}



	public void setSem2(byte[] sem2) {
		this.sem2 = sem2;
	}



	public byte[] getSem3() {
		return sem3;
	}



	public void setSem3(byte[] sem3) {
		this.sem3 = sem3;
	}



	public byte[] getSem4() {
		return sem4;
	}



	public void setSem4(byte[] sem4) {
		this.sem4 = sem4;
	}



	public byte[] getSem5() {
		return sem5;
	}



	public void setSem5(byte[] sem5) {
		this.sem5 = sem5;
	}



	public byte[] getSem6() {
		return sem6;
	}



	public void setSem6(byte[] sem6) {
		this.sem6 = sem6;
	}



	public byte[] getSem7() {
		return sem7;
	}



	public void setSem7(byte[] sem7) {
		this.sem7 = sem7;
	}



	public byte[] getSem8() {
		return sem8;
	}



	public void setSem8(byte[] sem8) {
		this.sem8 = sem8;
	}



	public byte[] getDrivingLicense() {
		return drivingLicense;
	}



	public void setDrivingLicense(byte[] drivingLicense) {
		this.drivingLicense = drivingLicense;
	}



	public byte[] getAadhaar() {
		return aadhaar;
	}



	public void setAadhaar(byte[] aadhaar) {
		this.aadhaar = aadhaar;
	}



	@Override
	public String toString() {
		return "VerifySource [verifyId=" + verifyId + ", resume=" + Arrays.toString(resume) + ", educationTenth="
				+ Arrays.toString(educationTenth) + ", educationTwelth=" + Arrays.toString(educationTwelth) + ", sem1="
				+ Arrays.toString(sem1) + ", sem2=" + Arrays.toString(sem2) + ", sem3=" + Arrays.toString(sem3)
				+ ", sem4=" + Arrays.toString(sem4) + ", sem5=" + Arrays.toString(sem5) + ", sem6="
				+ Arrays.toString(sem6) + ", sem7=" + Arrays.toString(sem7) + ", sem8=" + Arrays.toString(sem8)
				+ ", drivingLicense=" + Arrays.toString(drivingLicense) + ", aadhaar=" + Arrays.toString(aadhaar) + "]";
	}



	
	
	
	
}
