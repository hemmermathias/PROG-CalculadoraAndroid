package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtNumA, txtNumB;
    ListView lstEntries;
    ArrayAdapter adapter;
    ArrayList<String> results = new ArrayList<String>();

    int numberA, numberB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumA = findViewById(R.id.txtNumA);
        txtNumB = findViewById(R.id.txtNumB);

        lstEntries = findViewById(R.id.lstEntries);
        adapter = new ArrayAdapter<String>(this,R.layout.list_item, results);
        lstEntries.setAdapter(adapter);
    }

    public void Add(View v){
        if(!GetNumbers()) return;

        String res = String.valueOf(numberA + numberB);
        results.add(0, res);
        adapter.notifyDataSetChanged();

    }
    public void Sub(View v){
        if(!GetNumbers()) return;

        String res = String.valueOf(numberA - numberB);
        results.add(0, res);
        adapter.notifyDataSetChanged();
    }
    public void Div(View v){
        if(!GetNumbers()) return;
        if(numberB == 0){
            Toast.makeText(this, "Divisão por 0", Toast.LENGTH_LONG).show();
            return;
        }

        String res = String.valueOf(numberA / numberB);
        results.add(0, res);
        adapter.notifyDataSetChanged();
    }
    public void Mul(View v){
        if(!GetNumbers()) return;

        String res = String.valueOf(numberA * numberB);
        results.add(0, res);
        adapter.notifyDataSetChanged();
    }

    private boolean GetNumbers(){
        String numA = txtNumA.getText().toString().trim();
        String numB = txtNumB.getText().toString().trim();

        if(numA.equals("") || numB.equals("")){
            Toast.makeText(this, "Informe os dois números para operação", Toast.LENGTH_LONG).show();
            return false;
        }else{
            numberA = Integer.parseInt(numA);
            numberB = Integer.parseInt(numB);
            return true;
        }
    }
}
