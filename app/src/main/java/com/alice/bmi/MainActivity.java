package com.alice.bmi;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String s = new String("abc");
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bHelp = (Button) findViewById(R.id.b_help);
        bHelp.setOnClickListener(listener);
//        getResources().getString(R.string.app_name);
    }
    public void bmi(View view){
//        System.out.println();
        Log.d("MainActivity", "testing bmi method");
        Log.e("MainActivity", "testing bmi method");
        Log.w("MainActivity", "testing bmi method");
        EditText edWeight = (EditText) findViewById(R.id.ed_weight);
        EditText edheight = (EditText) findViewById(R.id.ed_height);
        float weight = Float.parseFloat(edWeight.getText().toString());
        float height = Float.parseFloat(edheight.getText().toString());
        float bmi = weight / (height * height);
        Log.d("MainActivity", "Your BMI is:" + bmi);
        new AlertDialog.Builder(this)
                .setMessage(getString(R.string.your_bmi_is)+bmi)  //多國語言 抽取資料 對話框 button做事
                .setTitle(R.string.bmi_title)
                .setPositiveButton(R.string.ok, null)
                .show();

       /*Toast.makeText(this,
                "Your BMI is " + bmi,
                Toast.LENGTH_SHORT)   //回傳Toast
                .show();*/
    }
}
