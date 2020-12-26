package com.mastermoviles.persistencia.files;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button externalState;
    private EditText editText;
    private Button addToFile;
    private Button showFile;
    private Button moveExternal;
    private Button moveInternal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setUIContent();
    }

    private void setUIContent() {
        externalState = findViewById(R.id.externalState);
        editText = findViewById(R.id.editText);
        addToFile = findViewById(R.id.addToFile);
        showFile = findViewById(R.id.showFile);
        moveExternal = findViewById(R.id.moveExternal);
        moveInternal = findViewById(R.id.moveInternal);

        externalState.setOnClickListener(this);
        addToFile.setOnClickListener(this);
        showFile.setOnClickListener(this);
        moveExternal.setOnClickListener(this);
        moveInternal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.externalState:
                Intent intent = new Intent(this, ExternalActivity.class);
                startActivity(intent);
                break;
            case R.id.addToFile:
                Log.d("Main", "addToFile");
                break;
            case R.id.showFile:
                Log.d("Main", "showFile");
                break;
            case R.id.moveExternal:
                Log.d("Main", "moveExternal");
                break;
            case R.id.moveInternal:
                Log.d("Main", "moveInternal");
                break;
            default:
                Log.d("Main", "no existe el botón");
        }


    }
}