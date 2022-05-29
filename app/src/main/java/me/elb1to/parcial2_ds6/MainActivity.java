package me.elb1to.parcial2_ds6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import me.elb1to.parcial2_ds6.activities.GradesActivity;
import me.elb1to.parcial2_ds6.activities.LoginActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup mainButtons;
    String name, cedula, username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeControllers();
    }

    private void initializeControllers() {
        mainButtons = findViewById(R.id.main_rgroup);

        Intent intent = getIntent();
        name = intent.getStringExtra("nombre");
        username = intent.getStringExtra("username");
        cedula = intent.getStringExtra("cedula");
        password = intent.getStringExtra("password");
    }

    public void selectProfileOption(View view) {
        int checkedRadioButtonId = mainButtons.getCheckedRadioButtonId();
        switch (checkedRadioButtonId) {
            case R.id.main_siu_rbtn:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://utp.ac.pa")));
                break;
            case R.id.main_student_rbtn:
                if (cedula.equals("8-970-1354")) {
                    Intent intent = new Intent(getApplicationContext(), GradesActivity.class);
                    intent.putExtra("nombre", name);
                    intent.putExtra("username", username);
                    intent.putExtra("cedula", cedula);
                    intent.putExtra("password", password);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Usted no es un estudiante" + cedula, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.main_professor_rbtn:
                if (cedula.equals("1-234-5678")) {
                    Intent intent = new Intent(getApplicationContext(), GradesActivity.class);
                    intent.putExtra("nombre", name);
                    intent.putExtra("username", username);
                    intent.putExtra("cedula", cedula);
                    intent.putExtra("password", password);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Usted no es un profesor" + cedula, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                Toast.makeText(getApplicationContext(), "Debes escoger una opcion!", Toast.LENGTH_LONG).show();
                break;
        }
    }
}