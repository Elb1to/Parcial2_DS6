package me.elb1to.parcial2_ds6.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import me.elb1to.parcial2_ds6.MainActivity;
import me.elb1to.parcial2_ds6.R;
import me.elb1to.parcial2_ds6.impl.User;

public class LoginActivity extends AppCompatActivity {

    EditText cedula, password;
    public static List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeControllers();
        checkFileExistence();
        convertFileToList();
    }

    private void checkFileExistence() {
        String string = "Victor?8-970-1354?Elb1to?TestPW$Jijija?1-234-5678?Professor?Troll";
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput("credentials.txt", Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeControllers() {
        cedula = findViewById(R.id.login_cedula_txt);
        password = findViewById(R.id.login_password_txt);
    }

    private List<User> convertFileToList() {
        try {
            String line = new BufferedReader(new InputStreamReader(openFileInput("credentials.txt"))).readLine();
            String[] usersArray = line.split("\\$");
            for (String currentUser : usersArray) {
                String[] userData = currentUser.split("\\?");
                User newUser = new User(userData[0], userData[1], userData[2], userData[3]);
                users.add(newUser);
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error converting file to list => " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        return users;
    }

    public void processLogin(View v) {
        try {
            List<User> users = convertFileToList();
            String ced = cedula.getText().toString();
            String pw = password.getText().toString();

            for (User user : users) {
                if (user.getCedula().equals(ced) && user.getPassword().equals(pw)) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("nombre", user.getName());
                    intent.putExtra("username", user.getUsername());
                    intent.putExtra("cedula", user.getCedula());
                    intent.putExtra("password", user.getPassword());
                    startActivity(intent);
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    // Get user by cedula
    public static User getUserByCedula(String ced) {
        for (User user : users) {
            if (user.getCedula().equals(ced)) {
                return user;
            }
        }

        return null;
    }
}