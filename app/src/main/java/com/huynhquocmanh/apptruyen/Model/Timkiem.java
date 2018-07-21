package com.huynhquocmanh.apptruyen.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timkiem {
    @SerializedName("IdTruyen")
    @Expose
    private String idTruyen;
    @SerializedName("TenTruyen")
    @Expose
    private String tenTruyen;
    @SerializedName("HinhTruyen")
    @Expose
    private String hinhTruyen;
    @SerializedName("TacGia")
    @Expose
    private String tacGia;
    @SerializedName("Sochuong")
    @Expose
    private String sochuong;

    public String getIdTruyen() {
        return idTruyen;
    }

    public void setIdTruyen(String idTruyen) {
        this.idTruyen = idTruyen;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getHinhTruyen() {
        return hinhTruyen;
    }

    public void setHinhTruyen(String hinhTruyen) {
        this.hinhTruyen = hinhTruyen;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getSochuong() {
        return sochuong;
    }

    public void setSochuong(String sochuong) {
        this.sochuong = sochuong;
    }
}
