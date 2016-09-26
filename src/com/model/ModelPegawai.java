package com.model;

import java.io.Serializable;

public class ModelPegawai implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idpegawai;
	private String nama;
	private String alamat;
	private String jenis_kelamin;
	
	public ModelPegawai(){
		
	}
	
	

	public ModelPegawai(int idpegawai, String nama, String alamat, String jenis_kelamin) {
		this.idpegawai = idpegawai;
		this.nama = nama;
		this.alamat = alamat;
		this.jenis_kelamin = jenis_kelamin;
	}



	public ModelPegawai( String nama, String alamat, String jenis_kelamin) {
		this.nama = nama;
		this.alamat = alamat;
		this.jenis_kelamin = jenis_kelamin;
	}

	public int getIdpegawai() {
		return idpegawai;
	}

	public void setIdpegawai(int idpegawai) {
		this.idpegawai = idpegawai;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getJenis_kelamin() {
		return jenis_kelamin;
	}

	public void setJenis_kelamin(String jenis_kelamin) {
		this.jenis_kelamin = jenis_kelamin;
	}
	
	

	
	
	
}
