package com.huynhquocmanh.apptruyen.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gioithieu {

@SerializedName("IdQuangCao")
@Expose
private String idQuangCao;
@SerializedName("HinhAnh")
@Expose
private String hinhAnh;
@SerializedName("IdTruyen")
@Expose
private String idTruyen;
@SerializedName("TenTruyen")
@Expose
private String tenTruyen;
@SerializedName("HinhAnhTruyen")
@Expose
private String hinhAnhTruyen;
@SerializedName("TacGia")
@Expose
private String tacGia;

public String getIdQuangCao() {
return idQuangCao;
}

public void setIdQuangCao(String idQuangCao) {
this.idQuangCao = idQuangCao;
}

public String getHinhAnh() {
return hinhAnh;
}

public void setHinhAnh(String hinhAnh) {
this.hinhAnh = hinhAnh;
}

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

public String getHinhAnhTruyen() {
return hinhAnhTruyen;
}

public void setHinhAnhTruyen(String hinhAnhTruyen) {
this.hinhAnhTruyen = hinhAnhTruyen;
}

public String getTacGia() {
return tacGia;
}

public void setTacGia(String tacGia) {
this.tacGia = tacGia;
}

}