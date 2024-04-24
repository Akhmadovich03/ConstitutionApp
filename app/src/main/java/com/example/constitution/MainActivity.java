package com.example.constitution;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    ListView departments_list;
    private final ArrayList<List_item> departments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();

        Toolbar toolbar = findViewById(R.id.m_toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        departments_list = findViewById(R.id.departments_list);

        setSupportActionBar(toolbar);

        List_item_Adapter adapter = new List_item_Adapter(this, R.layout.list_item, departments);

        departments_list.setAdapter(adapter);

        toolbar.setNavigationOnClickListener(v -> {
            if (drawerLayout.isDrawerOpen(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START);
            else
                drawerLayout.openDrawer(GravityCompat.START);
        });

        departments_list.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, ChapterActivity.class);

            intent.putExtra("department", position);

            if(position != 0)
                intent.putExtra("department_name", departments.get(position).getText().split("\\.")[1]);
            else
                intent.putExtra("department_name", departments.get(position).getText());

            startActivity(intent);
        });

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.settings) {
                showToast("Sozlamalar clicked");
                return true;
            } else if (itemId == R.id.info) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("CONSTITUTION.UZ");
                builder.setMessage("Loyihaning maqsadi foydalanuvchilar uchun Respublikamizning " +
                        "asosiy qomusi - Konstitutsiya haqida ma'lumot berish bilan birgalikda" +
                        "aholining huquqiy ongi va madanaiyatini yuksaltirishga ko'maklashishdan iborat\n" +
                        "\n Ma'lumot talqini: 20230521");
                builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());

                AlertDialog dialog = builder.create();

                dialog.show();
                return true;
            } else if (itemId == R.id.share) {
                showToast("Bo'lishish clicked");
                return true;
            } else {
                return false;
            }
        });
    }

    private void setInitialData(){
        departments.add(new List_item("MUQADDIMA"));
        departments.add(new List_item("BIRINCHI BO'LIM. ASOSIY PRINSIPLAR"));
        departments.add(new List_item("IKKINCHI BO'LIM. INSON VA FUQAROLARNING ASOSIY HUQUQLARI, ERKINLIKLARI VA BURCHLARI"));
        departments.add(new List_item("UCHINCHI BO'LIM. JAMIYAT VA SHAXS"));
        departments.add(new List_item("TO'RTINCHI BO'LIM. MA'MURIY-HUDUDIY VA DAVLAT TUZILISHI"));
        departments.add(new List_item("BESHINCHI BO'LIM. DAVLAT HOKIMIYATINING TASHKIL ETILISHI"));
        departments.add(new List_item("OLTINCHI BO'LIM. KONSTITUTSIYANI O'ZGARTIRISH TARTIBI"));
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
