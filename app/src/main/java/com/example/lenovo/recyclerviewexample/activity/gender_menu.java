package com.example.lenovo.recyclerviewexample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lenovo.recyclerviewexample.R;

public class gender_menu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_menu);
        Button btnContactMenu = findViewById(R.id.btnContactGenderMenu);
        registerForContextMenu(btnContactMenu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contact_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.male:
                Toast.makeText(this,"Male", Toast.LENGTH_SHORT).show();
                break;
            case R.id.female:
                Toast.makeText(this,"Feale", Toast.LENGTH_SHORT).show();
                break;
            case R.id.other:
                Toast.makeText(this,"Other", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
