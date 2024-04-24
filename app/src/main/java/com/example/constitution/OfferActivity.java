package com.example.constitution;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class OfferActivity extends AppCompatActivity {

    AppCompatButton offer_button;
    EditText offer_text;
    Toolbar offer_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);

        offer_button = findViewById(R.id.offer_button);
        offer_text = findViewById(R.id.offer_text);
        offer_toolbar = findViewById(R.id.offer_toolbar);

        setSupportActionBar(offer_toolbar);

        offer_button.setOnClickListener(v -> {
            if(offer_text.getText().toString().equals("")) re_entering();
            else sending_offer();
        });
    }

    private void re_entering() {
        AlertDialog.Builder builder = new AlertDialog.Builder(OfferActivity.this);

        builder.setTitle("TAKLIF KIRITILMAGAN");
        builder.setMessage("Jo'natishdan avval taklif kiriting!");
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();

        dialog.show();
    }

    private void sending_offer(){
        AlertDialog.Builder builder = new AlertDialog.Builder(OfferActivity.this);

        builder.setTitle("QAYTA TEKSHIRING");
        builder.setMessage("Taklifingizni jo'natishga ishochingiz komilmi?");
        builder.setPositiveButton("HA", (dialog, which) -> {
            Toast.makeText(
                    getApplicationContext(),
                    "Taklif muvaffaqqiyatli jo'natildi",
                    Toast.LENGTH_LONG).show();
            finish();
        });
        builder.setNegativeButton("YO'Q", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();

        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}