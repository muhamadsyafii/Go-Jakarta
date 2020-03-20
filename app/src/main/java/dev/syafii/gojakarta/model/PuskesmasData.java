package dev.syafii.gojakarta.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PuskesmasData {

	@SerializedName("faximile")
	private List<String> faximile;

	@SerializedName("kepala_puskesmas")
	private String kepalaPuskesmas;

	@SerializedName("telepon")
	private List<String> telepon;

	@SerializedName("kode_kota")
	private int kodeKota;

	@SerializedName("kode_kelurahan")
	private long kodeKelurahan;

	@SerializedName("location")
	private PuskesmasLocation location;

	@SerializedName("kode_kecamatan")
	private int kodeKecamatan;

	@SerializedName("id")
	private int id;

	@SerializedName("nama_Puskesmas")
	private String namaPuskesmas;

	@SerializedName("email")
	private String email;

	public void setFaximile(List<String> faximile){
		this.faximile = faximile;
	}

	public List<String> getFaximile(){
		return faximile;
	}

	public void setKepalaPuskesmas(String kepalaPuskesmas){
		this.kepalaPuskesmas = kepalaPuskesmas;
	}

	public String getKepalaPuskesmas(){
		return kepalaPuskesmas;
	}

	public void setTelepon(List<String> telepon){
		this.telepon = telepon;
	}

	public List<String> getTelepon(){
		return telepon;
	}

	public void setKodeKota(int kodeKota){
		this.kodeKota = kodeKota;
	}

	public int getKodeKota(){
		return kodeKota;
	}

	public void setKodeKelurahan(long kodeKelurahan){
		this.kodeKelurahan = kodeKelurahan;
	}

	public long getKodeKelurahan(){
		return kodeKelurahan;
	}

	public void setLocation(PuskesmasLocation location){
		this.location = location;
	}

	public PuskesmasLocation getLocation(){
		return location;
	}

	public void setKodeKecamatan(int kodeKecamatan){
		this.kodeKecamatan = kodeKecamatan;
	}

	public int getKodeKecamatan(){
		return kodeKecamatan;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setNamaPuskesmas(String namaPuskesmas){
		this.namaPuskesmas = namaPuskesmas;
	}

	public String getNamaPuskesmas(){
		return namaPuskesmas;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}