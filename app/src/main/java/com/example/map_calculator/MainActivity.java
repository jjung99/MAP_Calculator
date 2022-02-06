package com.example.map_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    List<String> arr;
    String tempNum;
    String temOp;
    Boolean isCalculate;
    Button btnType;
    Boolean toggle;
    LinearLayout layout;
    Calculator myCal = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Assignment1");
        tv = findViewById(R.id.Cal_TV);
        arr = new ArrayList<String>();
        tempNum = "";
        temOp = "";
        isCalculate = true;
        btnType = findViewById(R.id.btn_type);
        toggle = true;
        layout = findViewById(R.id.layout_advanced);
        layout.setVisibility(View.GONE);
    }

    public void onClick(View view) {
        String current = tv.getText().toString();
        switch (view.getId()) {
            case R.id.btn_0:
                tv.setText(current + "0");
                tempNum = tempNum + "0";
                break;
            case R.id.btn_1:
                tv.setText(current + "1");
                tempNum = tempNum + "1";
                break;
            case R.id.btn_2:
                tv.setText(current + "2");
                tempNum = tempNum + "2";
                break;
            case R.id.btn_3:
                tv.setText(current + "3");
                tempNum = tempNum + "3";
                break;
            case R.id.btn_4:
                tv.setText(current + "4");
                tempNum = tempNum + "4";
                break;
            case R.id.btn_5:
                tv.setText(current + "5");
                tempNum = tempNum + "5";
                break;
            case R.id.btn_6:
                tv.setText(current + "6");
                tempNum = tempNum + "6";
                break;
            case R.id.btn_7:
                tv.setText(current + "7");
                tempNum = tempNum + "7";
                break;
            case R.id.btn_8:
                tv.setText(current + "8");
                tempNum = tempNum + "8";
                break;
            case R.id.btn_9:
                tv.setText(current + "9");
                tempNum = tempNum + "9";
                break;
            case R.id.btn_Add:
                tv.setText(current + " + ");
                temOp = "+";
                myCal.push(tempNum);
                myCal.push(temOp);
                tempNum = "";
                temOp = "";
                break;
            case R.id.btn_Sub:
                tv.setText(current + " - ");
                temOp = "-";
                myCal.push(tempNum);
                myCal.push(temOp);
                tempNum = "";
                temOp = "";
                break;
            case R.id.btn_Multi:
                tv.setText(current + " * ");
                temOp = "*";
                myCal.push(tempNum);
                myCal.push(temOp);
                tempNum = "";
                temOp = "";
                break;
            case R.id.btn_Div:
                tv.setText(current + " / ");
                temOp = "/";
                myCal.push(tempNum);
                myCal.push(temOp);
                tempNum = "";
                temOp = "";
                break;
            case R.id.btn_Mod:
                tv.setText(current + " % ");
                temOp = "%";
                myCal.push(tempNum);
                myCal.push(temOp);
                tempNum = "";
                temOp = "";
                break;
            case R.id.btn_POW:
                tv.setText(current + " POW ");
                temOp = "POW";
                myCal.push(tempNum);
                myCal.push(temOp);
                tempNum = "";
                temOp = "";
                break;
            case R.id.btn_MAX:
                tv.setText(current + " MAX ");
                temOp = "MAX";
                myCal.push(tempNum);
                myCal.push(temOp);
                tempNum = "";
                temOp = "";
                break;
            case R.id.btn_MIN:
                tv.setText(current + " MIN ");
                temOp = "MIN";
                myCal.push(tempNum);
                myCal.push(temOp);
                tempNum = "";
                temOp = "";
                break;
            case R.id.btn_Equal:
                myCal.push(tempNum);
                tempNum = "";
                for(int i = 0; i < arr.size(); i++){
                    if(arr.get(i) == ""){
                        isCalculate = false;
                    }

                }
                if(isCalculate){
                    int result = myCal.calculate();
                    String totalString = String.valueOf(result);
                    tv.setText(current + " = " +totalString);
                }
                else{
                    tv.setText(current + " = Not an Operator");
                }

                break;
            case R.id.btn_C:
                tv.setText("");
                tempNum = "";
                arr.clear();
                break;
        }
    }

    public void onTypeClick(View view) {
        if(toggle){
            btnType.setText("ADVANCE - SCIENTIFIC");
            layout.setVisibility(View.VISIBLE);
            toggle = false;
        }
        else{
            btnType.setText("STANDARD");
            layout.setVisibility(View.GONE);
            toggle = true;
        }
    }
}
