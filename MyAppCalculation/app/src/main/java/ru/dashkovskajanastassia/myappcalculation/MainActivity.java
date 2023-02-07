package ru.dashkovskajanastassia.myappcalculation;

import static java.lang.Double.NaN;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity {

    public static int theme;
    public static int safetheme;
    private AppCompatButton but1;
    private AppCompatButton but2;
    private AppCompatButton but3;
    private AppCompatButton but4;
    private AppCompatButton but5;
    private AppCompatButton but6;
    private AppCompatButton but7;
    private AppCompatButton but8;
    private AppCompatButton but9;
    private AppCompatButton but0;
    private AppCompatButton butplus;
    private AppCompatButton butminus;
    private AppCompatButton buttimes;
    private AppCompatButton butdivision;
    private AppCompatButton butdot;
    private AppCompatButton delite;
    private AppCompatButton ac;
    private  AppCompatButton butequals;


    private TextView text;

    private ImageButton setting;

    private double valueOne;
    private double valueTwo;
    private double valueResalt;
    private String window_text;

    private static final char plus = '+';
    private static final char minus = '-';
    private static final char times = '*';
    private static final char division = '/';
    private char action = '0';

    private String key_valueOne = "valueOne";
    private String key_valueTwo = "valueTwo";
    private String key_valueResalt = "valueResalt";
    private String key_action = "action";
    private String key_text = "text";




    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        ChengeTheme();
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView);

        but1 = findViewById(R.id.button1);
        but1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "1");
            }
        });

        but2 = findViewById(R.id.button2);
        but2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "2");
            }
        });
        but3 = findViewById(R.id.button3);
        but3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "3");
            }
        });

        but4 = findViewById(R.id.button4);
        but4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "4");
            }
        });

        but5 = findViewById(R.id.button5);
        but5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "5");
            }
        });

        but6 = findViewById(R.id.button6);
        but6.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "6");
            }
        });

        but7 = findViewById(R.id.button7);
        but7.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "7");
            }
        });

        but8 = findViewById(R.id.button8);
        but8.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "8");
            }
        });

        but9 = findViewById(R.id.button9);
        but9.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "9");
            }
        });

        but0 = findViewById(R.id.button0);
        but0.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + "0");
            }
        });

        butdot = findViewById(R.id.button_dot);
        butdot.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                text.setText(text.getText() + ".");
            }
        });

        butplus = findViewById(R.id.button_plus);
        butplus.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Calculation();
                action = plus;
                text.setText(text.getText() + "+");
                text.setText(null);
            }
        });

        butminus = findViewById(R.id.button_minus);
        butminus.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Calculation();
                action = minus;
                text.setText(text.getText() + "-");
                text.setText(null);
            }
        });

        buttimes = findViewById(R.id.button_times);
        buttimes.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Calculation();
                action = times;
                text.setText(text.getText() + "*");
                text.setText(null);
            }
        });

        butdivision = findViewById(R.id.button_division);
        butdivision.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Calculation();
                action = division;
                text.setText(text.getText() + "/");
                text.setText(null);
            }
        });

        delite = findViewById(R.id.button_delite);
        delite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText().subSequence(0, text.length() - 1));
            }
        });

        ac = findViewById(R.id.button_AC);
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("");
            }
        });


         butequals = findViewById(R.id.button_equals);
        butequals.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Calculation();
                text.setText(Double.toString(valueResalt));
                valueOne = NaN;
                action = '0';

            }
        });

        setting = findViewById(R.id.settings);
        setting.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), SettingsActivity.class);
                startActivity(myIntent);
            }
        });
    }
    private void Calculation(){
        if(!Double.isNaN(valueOne) && action != '0') {
            valueTwo = Double.parseDouble(text.getText().toString());
            text.setText(null);
            if(action == plus){
                valueResalt = valueOne + valueTwo;
                valueOne = valueResalt;}
            else if(action == minus){
                valueResalt = valueOne - valueTwo;
                valueOne = valueResalt;}
            else if(action == times){
                valueResalt = valueOne * valueTwo;
                valueOne = valueResalt;}
            else if(action == division){
                valueResalt = valueOne / valueTwo;
                valueOne = valueResalt;}
        }
        else {
            valueOne = Double.parseDouble(text.getText().toString());
        }
}


    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putDouble(key_valueOne, valueOne);
        instanceState.putDouble(key_valueTwo, valueTwo);
        instanceState.putDouble(key_valueResalt, valueResalt);
        instanceState.putChar(key_action, action);
        window_text = (String) text.getText();
        instanceState.putString(key_text, window_text);

    }
    @SuppressLint("SetTextI18n")
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        valueOne = instanceState.getDouble(key_valueOne);
        valueTwo = instanceState.getDouble(key_valueTwo);
        valueResalt = instanceState.getDouble(key_valueResalt);
        action = instanceState.getChar(key_action);
        window_text = instanceState.getString(key_text);
        text.setText(window_text);

    }
public void ChengeTheme(){
    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
    sp.getInt("mytheme", safetheme);
    int theme_app;
    if(theme == 1){
        theme_app = sp.getInt("THEME", R.style.AppThemeDark);
    }
    else {
        theme_app = sp.getInt("THEME", R.style.AppTheme);
    }
    setTheme(theme_app);
    SharedPreferences.Editor editor = sp.edit();
    editor.putInt("mytheme", theme);
    editor.apply();

}

}