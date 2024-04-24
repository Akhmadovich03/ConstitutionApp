package com.example.constitution;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChapterActivity extends AppCompatActivity {
    TextView department_name;
    ListView chapter_list;
    Toolbar toolbar;
    private final ArrayList<List_item> chapters = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        toolbar = findViewById(R.id.ch_toolbar);
        department_name = findViewById(R.id.department_text);
        chapter_list = findViewById(R.id.chapters_list);

        setSupportActionBar(toolbar);

        Bundle department = getIntent().getExtras();
        assert department != null;
        department_name.setText(department.getString("department_name"));

        setInitialData(department.getInt("department"), department);

        List_item_Adapter ch_adapter = new List_item_Adapter(this, R.layout.list_item, chapters);
        chapter_list.setAdapter(ch_adapter);

        chapter_list.setOnItemClickListener((parent, view, position, id) -> {
            Intent sub_intent = new Intent(this, SubstanceActivity.class);

            sub_intent.putExtra("department", department.getInt("department"));
            sub_intent.putExtra("chapter_num", chapters.get(position).getText().split(" ")[0]);
            sub_intent.putExtra("chapter_name", chapters.get(position).getText().split("\\.")[1]);

            startActivity(sub_intent);
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setInitialData(int position, Bundle finalDepartment){
        switch(position){
            case 0:
                Intent intent = new Intent(this, LastActivity.class);

                intent.putExtra("department", finalDepartment.getInt("department"));
                intent.putExtra("sub_name", finalDepartment.getString("department_name"));

                startActivity(intent);
                break;
            case 1:
                chapters.add(new List_item("I BOB. DAVLAT SUVERENITETI                "));
                chapters.add(new List_item("II BOB. XALQ HOKIMIYATCHILIGI          "));
                chapters.add(new List_item("III BOB. KONSTITUTSIYA VA QONUNNING USTUVORLIGI"));
                chapters.add(new List_item("IV BOB. TASHQI SIYOSAT                       "));
                break;
            case 2:
                chapters.add(new List_item("V BOB. UMUMIY QOIDALAR                 "));
                chapters.add(new List_item("VI BOB. FUQAROLIK                              "));
                chapters.add(new List_item("VII BOB. SHAXSIY HUQUQ ERKINLIKLAR"));
                chapters.add(new List_item("VIII BOB. SIYOSIY HUQUQLAR             "));
                chapters.add(new List_item("IX BOB. IQTISODIY, IJTIMOIY, MADANIY VA EKOLOGIK HUQUQLAR"));
                chapters.add(new List_item("X BOB. INSON HAMDA FUQARONING HUQUQ VA ERKINLIKLARI KAFOLATLARI"));
                chapters.add(new List_item("XI BOB. FUQAROLARNING BURCHLARI        "));
                break;
            case 3:
                chapters.add(new List_item("XII BOB. JAMIYATNING IQTISODIY NEGIZLARI"));
                chapters.add(new List_item("XIII BOB. FUQAROLIK JAMIYATI INSTITUTLARI"));
                chapters.add(new List_item("XIV BOB. OILA, BOLALAR VA YOSHLAR"));
                chapters.add(new List_item("XV BOB. OMMAVIY AXBOROT VOSITALARI"));
                break;
            case 4:
                chapters.add(new List_item("XVI BOB. O'ZBEKISTON RESPUBLIKASINING MA'MURIY-HUDUDIY TUZILISHI"));
                chapters.add(new List_item("XVII BOB. QORAQALPOG'ISTON RESPUBLIKASI"));
                break;
            case 5:
                chapters.add(new List_item("XVIII BOB. O'ZBEKISTON RESPUBLIKASI OLIY MAJLISI"));
                chapters.add(new List_item("XIX BOB. O'ZBEKISTON RESPUBLIKASINING PREZIDENTI"));
                chapters.add(new List_item("XX BOB. O'ZBEKISTON RESPUBLIKASI VAZIRLAR MAHKAMASI"));
                chapters.add(new List_item("XXI BOB. MAHALLIY DAVLAT HOKIMIYATI ASOSLARI. " +
                        "FUQAROLARNING O'ZINI O'ZI BOSHQARISH ORGANLARI"));
                chapters.add(new List_item("XXII BOB. SAYLOV TIZIMI                     "));
                chapters.add(new List_item("XXIII BOB. SUD HOKIMIYATI                 "));
                chapters.add(new List_item("XXIV BOB. ADVOKATURA                      "));
                chapters.add(new List_item("XXV BOB. PROKURATURA                      "));
                chapters.add(new List_item("XXVI BOB. MOLIYA, PUL VA BANK TIZIMI"));
                chapters.add(new List_item("XXVII BOB. MUDOFAA VA XAVFSIZLIK"));
                break;
            case 6:
                Intent sub_intent = new Intent(this, SubstanceActivity.class);

                sub_intent.putExtra("department", finalDepartment.getInt("department"));
                sub_intent.putExtra("chapter_num", "XXVIII");
                sub_intent.putExtra("chapter_name", finalDepartment.getString("department_name"));

                startActivity(sub_intent);
                break;
        }
    }
}