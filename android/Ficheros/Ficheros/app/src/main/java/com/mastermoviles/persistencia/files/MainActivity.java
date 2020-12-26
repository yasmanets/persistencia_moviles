package com.mastermoviles.persistencia.files;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button internalState;
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
        internalState = findViewById(R.id.internalState);
        editText = findViewById(R.id.editText);
        addToFile = findViewById(R.id.addToFile);
        showFile = findViewById(R.id.showFile);
        moveExternal = findViewById(R.id.moveExternal);
        moveInternal = findViewById(R.id.moveInternal);

        internalState.setOnClickListener(this);
        addToFile.setOnClickListener(this);
        showFile.setOnClickListener(this);
        moveExternal.setOnClickListener(this);
        moveInternal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.internalState:
                Log.d("Main", "internalState");
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