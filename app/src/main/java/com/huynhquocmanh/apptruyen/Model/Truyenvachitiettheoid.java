package com.huynhquocmanh.apptruyen.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Truyenvachitiettheoid {

@SerializedName("IdTruyen")
@Expose
private String idTruyen;
@SerializedName("TenTruyen")
@Expose
private String tenTruyen;
@SerializedName("HinhTruyen")
@Expose
private String hinhTruyen;
@SerializedName("MoTaTruyen")
@Expose
private String moTaTruyen;
@SerializedName("TacGia")
@Expose
private String tacGia;

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

    public String getMoTaTruyen() {
        return moTaTruyen;
    }

    public void setMoTaTruyen(String moTaTruyen) {
        this.moTaTruyen = moTaTruyen;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }
}