package com.example.lab3_intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(v -> {
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.setData(Uri.parse("https://www.google.com"));
//            startActivity(intent);
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "My ID: CB.EN.U4CYS21061");
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        });

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), Activity2.class);
            i.putExtra("Name", "Roshni Venkatesan");
            startActivity(i);
        });


    }
}

