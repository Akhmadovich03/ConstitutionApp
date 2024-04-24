package com.example.constitution;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SubstanceActivity extends AppCompatActivity {

    TextView chapter_name;
    ListView substance_list;
    Drawable s_b_icon;
    Toolbar toolbar;
    int department;
    private final ArrayList<List_item> substances = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_substance);

        toolbar = findViewById(R.id.s_toolbar);
        chapter_name = findViewById(R.id.chapter_text);
        substance_list = findViewById(R.id.substances_list);
        s_b_icon = toolbar.getNavigationIcon();

        setSupportActionBar(toolbar);

        Bundle chapter = getIntent().getExtras();
        assert chapter != null;
        chapter_name.setText(chapter.getString("chapter_name"));
        department = chapter.getInt("department");

        setInitialData(chapter.getString("chapter_num"));

        List_item_Adapter ch_adapter = new List_item_Adapter(this, R.layout.list_item, substances);
        substance_list.setAdapter(ch_adapter);

        substance_list.setOnItemClickListener((parent, view, position, id) -> {
            Intent l_intent = new Intent(this, LastActivity.class);

            l_intent.putExtra("department", department);
            l_intent.putExtra("sub_name", substances.get(position).getText().trim());

            startActivity(l_intent);
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {

            if(department != 6)
                finish();
            else
                startActivity(new Intent(this, MainActivity.class));

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setInitialData(String roman){
        int chapter_num = romanToInt(roman), first_s = 0, last_s = 0;

        switch (chapter_num){
            case 1: first_s = 1; last_s = 6; break;
            case 2: first_s = 7; last_s = 14; break;
            case 3: first_s = 15; last_s = 16; break;
            case 4: first_s = 17; last_s = 18; break;
            case 5: first_s = 19; last_s = 21; break;
            case 6: first_s = 22; last_s = 24; break;
            case 7: first_s = 25; last_s = 35; break;
            case 8: first_s = 36; last_s = 40; break;
            case 9: first_s = 41; last_s = 53; break;
            case 10: first_s = 54; last_s = 58; break;
            case 11: first_s = 59; last_s = 64; break;
            case 12: first_s = 65; last_s = 68; break;
            case 13: first_s = 69; last_s = 75; break;
            case 14: first_s = 76; last_s = 80; break;
            case 15: first_s = 81; last_s = 82; break;
            case 16: first_s = 83; last_s = 84; break;
            case 17: first_s = 85; last_s = 90; break;
            case 18: first_s = 91; last_s = 104; break;
            case 19: first_s = 105; last_s = 113; break;
            case 20: first_s = 114; last_s = 119; break;
            case 21: first_s = 120; last_s = 127; break;
            case 22: first_s = 128; last_s = 129; break;
            case 23: first_s = 130; last_s = 140; break;
            case 24: first_s = 141; last_s = 142; break;
            case 25: first_s = 143; last_s = 146; break;
            case 26: first_s = 147; last_s = 151; break;
            case 27: first_s = 152; last_s = 153; break;
            case 28: first_s = 154; last_s = 155; break;
        }

        for(int i = first_s; i <= last_s; i++){
            substances.add(new List_item(i + " - modda    " +
                    "                                          "));
        }
    }

    private int romanToInt(String s)
    {
        int n = s.length(), num = 0;
        int[] strNum = new int[n + 1];
        strNum[n] = 0;

        for(int i = 0; i < n; i++)
        {
            switch(s.charAt(i))
            {
                case 'I': strNum[i] = 1; break;
                case 'V': strNum[i] = 5; break;
                case 'X': strNum[i] = 10; break;
            }
        }

        for(int i = 0; i < n; i++)
        {
            if(strNum[i] < strNum[i + 1])
            {
                num += strNum[i + 1] - strNum[i];
                i++;
                continue;
            }
            num += strNum[i];
        }

        return num;
    }
}