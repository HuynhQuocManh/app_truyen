package com.huynhquocmanh.apptruyen.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThuNghiem {

@SerializedName("IdTruyen")
@Expose
private String idTruyen;
@SerializedName("TenTruyen")
@Expose
private String tenTruyen;
@SerializedName("HinhTruyen")
@Expose
private String hinhTruyen;
@SerializedName("Loctheo")
@Expose
private String loctheo;

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

public String getLoctheo() {
return loctheo;
}

public void setLoctheo(String loctheo) {
this.loctheo = loctheo;
}

}