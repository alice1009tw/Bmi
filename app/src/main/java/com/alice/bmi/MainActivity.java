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
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("BMI")
                    .setMessage("BMI原來的設計是一個用於公眾健康研究的統計工具。當需要知道肥胖是否為某一疾病的致病原因時，可以把病人的身高及體重換算成BMI，再找出其數值及病發率是否有線性關連。")
                    .setPositiveButton("OK" , null)
                    .show();
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
        int height = Integer.parseInt(edheight.getText().toString()) ;
        if(height>3){
            new AlertDialog.Builder(this)
                    .setMessage("身高單位應為公尺")
                    .setPositiveButton("OK", null)
                    .show();
        }
        float weight = Float.parseFloat(edWeight.getText().toString());
        float height1 = Float.parseFloat(edheight.getText().toString());
        float bmi = weight / (height1 * height1);
        Log.d("MainActivity", "Your BMI is:" + bmi);
        if(bmi<20){
            new AlertDialog.Builder(this)
                    .setMessage(getString(R.string.your_bmi_is)+bmi+" 請多吃點")
                    .setTitle(R.string.bmi_title)
                    .setPositiveButton(R.string.ok, null)
                    .show();
        }

       /*Toast.makeText(this,
                "Your BMI is " + bmi,
                Toast.LENGTH_SHORT)   //回傳Toast
                .show();*/
    }
}
