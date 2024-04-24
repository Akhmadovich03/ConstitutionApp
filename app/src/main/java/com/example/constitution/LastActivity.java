package com.example.constitution;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class LastActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView t_text;
    ListView l_text;
    AppCompatButton button;
    int department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        toolbar = findViewById(R.id.l_toolbar);
        t_text = findViewById(R.id.lt_text);
        l_text = findViewById(R.id.l_text);
        button = findViewById(R.id.ch_button);

        setSupportActionBar(toolbar);

        Bundle sub_args = getIntent().getExtras();
        assert sub_args != null;
        String temp = sub_args.getString("sub_name");
        department = sub_args.getInt("department");
        t_text.setText(temp);

        String text = "";

        try{
            InputStream inputStream = getAssets().open(temp + ".txt");
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();

            text = new String(buffer);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

        ArrayList<List_item> tempList = new ArrayList<>();
        tempList.add(new List_item(text));

        List_item_Adapter l_adapter = new List_item_Adapter(this, R.layout.list_item, tempList);
        l_text.setAdapter(l_adapter);

        button.setOnClickListener(v -> startActivity(new Intent(LastActivity.this, OfferActivity.class)));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if(department != 0) finish();
            else startActivity(new Intent(this, MainActivity.class));

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}