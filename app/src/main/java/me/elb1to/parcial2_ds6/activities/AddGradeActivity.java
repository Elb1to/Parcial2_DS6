package me.elb1to.parcial2_ds6.activities;

import static me.elb1to.parcial2_ds6.activities.LoginActivity.getUserByCedula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

import me.elb1to.parcial2_ds6.R;
import me.elb1to.parcial2_ds6.impl.Grade;
import me.elb1to.parcial2_ds6.impl.GradeGrid;
import me.elb1to.parcial2_ds6.impl.User;

public class AddGradeActivity extends AppCompatActivity {

    GridView gridView;
    TextView title;

    User user = getUserByCedula("8-970-1354");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);
        initializeControllers();
    }

    private void initializeControllers() {
        gridView = findViewById(R.id.grid);
        title = findViewById(R.id.grades_title);
        title.setText(MessageFormat.format("Historial de Notas de ", getIntent().getStringExtra("nombre")));

        List<String> courses = user.getGrades().stream().map(Grade::getCourse).collect(Collectors.toList());
        List<Integer> icons = user.getGrades().stream().map(Grade::getCourseIcon).collect(Collectors.toList());

        GradeGrid adapter = new GradeGrid(this, courses, icons);
        gridView = findViewById(R.id.grid);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(getApplicationContext(), "Clicked == " + courses.get(+i), Toast.LENGTH_SHORT).show();
        });
    }
}