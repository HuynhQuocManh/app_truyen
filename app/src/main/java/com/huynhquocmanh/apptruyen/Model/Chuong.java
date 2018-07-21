package com.huynhquocmanh.apptruyen.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chuong {

@SerializedName("TenChuong")
@Expose
private String tenChuong;
@SerializedName("NoiDungTruong")
@Expose
private String noiDungTruong;

public String getTenChuong() {
return tenChuong;
}

public void setTenChuong(String tenChuong) {
this.tenChuong = tenChuong;
}

public String getNoiDungTruong() {
return noiDungTruong;
}

public void setNoiDungTruong(String noiDungTruong) {
this.noiDungTruong = noiDungTruong;
}

}