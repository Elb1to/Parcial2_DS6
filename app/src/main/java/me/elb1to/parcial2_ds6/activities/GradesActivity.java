package me.elb1to.parcial2_ds6.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;

import me.elb1to.parcial2_ds6.R;
import me.elb1to.parcial2_ds6.impl.GradeGrid;

public class GradesActivity extends AppCompatActivity {

    GridView gridView;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);
        initializeControllers();
    }

    private void initializeControllers() {
        gridView = findViewById(R.id.grid);
        title = findViewById(R.id.grades_title);

        Intent intent = getIntent();
        String name = intent.getStringExtra("nombre");
        title.setText(MessageFormat.format("Bienvenido {0} \n\n Su Historial de Notas es ", name));

        String[] web = {
                "Arte\nII Semestre",
                "Astronomia\nII Semestre",
                "Ciencia\nII Semestre",
                "Biologia\nII Semestre",
                "Quimica\nII Semestre",
                "Geografia\nII Semestre",
                "Matematicas\nII Semestre",
                "Calculo\nII Semestre",
                "Ed. Fisica\nII Semestre",
                "Literatura\nII Semestre"
        };

        int[] imageId = {
                R.drawable.arts,
                R.drawable.astronomy,
                R.drawable.atom,
                R.drawable.biology,
                R.drawable.chemistry,
                R.drawable.geology,
                R.drawable.math,
                R.drawable.geometric,
                R.drawable.sport,
                R.drawable.language,
        };

        GradeGrid adapter = new GradeGrid(this, web, imageId);
        gridView = findViewById(R.id.grid);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener((adapterView, view, i, l) -> Toast.makeText(getApplicationContext(), "You Clicked at " + web[+i], Toast.LENGTH_SHORT).show());
    }
}