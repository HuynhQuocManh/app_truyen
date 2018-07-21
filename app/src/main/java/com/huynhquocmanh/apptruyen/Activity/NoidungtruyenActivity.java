package com.huynhquocmanh.apptruyen.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.huynhquocmanh.apptruyen.API.APIService;
import com.huynhquocmanh.apptruyen.API.DataService;
import com.huynhquocmanh.apptruyen.Model.Chuong;
import com.huynhquocmanh.apptruyen.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoidungtruyenActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    TextView textView;
    ListView listView1;
    String noidungchuong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noidungtruyen);
        Anhxa();
        Getdatachuong(chitiettruyenActivity.idtruyen);
        Intent intent = getIntent();
        noidungchuong = intent.getStringExtra("noidungchuong");
        textView.setText(noidungchuong);
    }

    private void Anhxa() {
        drawerLayout = findViewById(R.id.drawerlayout);
        textView = findViewById(R.id.textviewnoidungchuong);
        drawerLayout = findViewById(R.id.drawerlayout);
        listView1 = findViewById(R.id.listview1);
    }

    private void Getdatachuong(int idtruyen) {
        DataService dataService = APIService.getdata();
        Call<List<Chuong>> callback = dataService.Getchuong(idtruyen);
        callback.enqueue(new Callback<List<Chuong>>() {
            @Override
            public void onResponse(Call<List<Chuong>> call, Response<List<Chuong>> response) {
                final List<Chuong> tenchuong = response.body();
                final ArrayList<String> mangtenchuong = new ArrayList<>();
                for (int i = 0; i < tenchuong.size(); i++) {
                    mangtenchuong.add(tenchuong.get(i).getTenChuong());
                }
                ArrayAdapter adapter = new ArrayAdapter(NoidungtruyenActivity.this, android.R.layout.simple_list_item_1, mangtenchuong);
                listView1.setAdapter(adapter);
                listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        textView.setText(tenchuong.get(position).getNoiDungTruong());
                        drawerLayout.closeDrawer(listView1);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Chuong>> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_listchuong, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.listchuong:
                drawerLayout.openDrawer(listView1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
