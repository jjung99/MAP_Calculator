package com.example.map_calculator;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    MainActivity main;
    List<String> arr1;

    public void onCreate(Bundle savedInstanceState) {
        arr1 = new ArrayList<String>();
    }

    void push (String value){
        main = new MainActivity();
        arr1 = main.arr;
        arr1.add(value);
    }

    int calculate(){
        int total = 0;
        String op = "";
        for (int i = 0; i < arr1.size(); i++){
            if(i == 0){
                total = total + Integer.parseInt(arr1.get(0));
                continue;
            }

            if(i % 2 == 0) {
                switch (op) {
                    case "+":
                        total = total + Integer.parseInt(arr1.get(i));
                        break;
                    case "-":
                        total = total - Integer.parseInt(arr1.get(i));
                        break;
                    case "*":
                        total = total * Integer.parseInt(arr1.get(i));
                        break;
                    case "/":
                        total = total / Integer.parseInt(arr1.get(i));
                        break;
                    case "%":
                        total = total % Integer.parseInt(arr1.get(i));
                        break;
                    case "POW":
                        int powNum = total;
                        for(int j = 1; j < Integer.parseInt(arr1.get(i)); j++){
                            total = total * powNum;
                        }
                        break;
                    case "MAX":
                        if(total > Integer.parseInt(arr1.get(i))){
                            total = total;
                        }
                        else{
                            total = Integer.parseInt(arr1.get(i));
                        }
                        break;
                    case "MIN":
                        if(total < Integer.parseInt(arr1.get(i))){
                            total = total;
                        }
                        else{
                            total = Integer.parseInt(arr1.get(i));
                        }
                        break;
                }
            }
            else{
                op = arr1.get(i);
            }

        }

        return total;
    }
}
