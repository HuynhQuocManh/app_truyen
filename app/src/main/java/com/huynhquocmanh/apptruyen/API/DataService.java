package com.huynhquocmanh.apptruyen.API;

import com.huynhquocmanh.apptruyen.Model.Chuong;
import com.huynhquocmanh.apptruyen.Model.Gioithieu;
import com.huynhquocmanh.apptruyen.Model.Laytruyentheotheloai;
import com.huynhquocmanh.apptruyen.Model.Theloai;
import com.huynhquocmanh.apptruyen.Model.ThuNghiem;
import com.huynhquocmanh.apptruyen.Model.Timkiem;
import com.huynhquocmanh.apptruyen.Model.Truyenvachitiettheoid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DataService {
    @GET("gioithieu.php")
    Call<List<Gioithieu>> Getdatagioithieu();

    @GET("theloai.php")
    Call<List<Theloai>> Getdatatheloai();

    @GET("laytruyentheoloaitruyen.php")
    Call<List<Laytruyentheotheloai>> Gettruyentheotheloai(@Query("idtheloai") int idTheLoai);

    @GET("chitiettruyen.php")
    Call<List<Truyenvachitiettheoid>> Getchitiettruyen(@Query("idtruyen") int idtruyen);

    @GET("truyenmoi.php")
    Call<List<ThuNghiem>> Getdatatruyenmoi();

    @GET("chuongmoi.php")
    Call<List<ThuNghiem>> Getdatachuongmoi();

    @GET("yeuthich.php")
    Call<List<ThuNghiem>> Getdatayeuthich();

    @GET("timkiem.php")
    Call<List<Timkiem>> Getdatatimkiem(@Query("tukhoa") String tukhoa);

    @GET("tenchuong.php")
    Call<List<Chuong>> Getchuong(@Query("idtruyen") int idtruyen);

    @FormUrlEncoded
    @POST("Updateyeuthich.php")
    Call<String> Updateyeuthich(@Field("yeuthich") String yeuthich, @Field("idtruyen") int idtruyen);

}
