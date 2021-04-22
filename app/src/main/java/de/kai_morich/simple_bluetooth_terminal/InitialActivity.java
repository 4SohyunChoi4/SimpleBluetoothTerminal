package de.kai_morich.simple_bluetooth_terminal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InitialActivity extends AppCompatActivity {

    EditText name, addr, phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_info);

        name = (EditText) findViewById(R.id.name);
        addr = (EditText) findViewById(R.id.addr);
        phone = (EditText) findViewById(R.id.phone);

        SharedPreferences pref = getSharedPreferences("info", MODE_PRIVATE);

        SharedPreferences.Editor editor = pref.edit();

        String Name = name.getText().toString();
        String Addr = addr.getText().toString();
        String Phone = phone.getText().toString();

        editor.putString("name", Name);
        editor.putString("addr", Addr);
        editor.putString("phone", Phone);

        editor.commit();

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);
            }
        });
    }
}
