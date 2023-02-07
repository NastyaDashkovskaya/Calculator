package ru.dashkovskajanastassia.myappcalculation;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import androidx.annotation.NonNull;

import com.google.android.material.radiobutton.MaterialRadioButton;


public class SettingsActivity extends Activity {
    // Имя настроек
    private static final String NameSharedPreference = "LOGIN";
    private static final int keyLight = 0;
    private static final int keyDark = 1;
    private static final String key_theme_name = "Theme";

    public  Switch theme_switch;
    private Button back;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.AppTheme));
        setContentView(R.layout.activity_settings);

        theme_switch = findViewById(R.id.switch_but);
        getCodeStyle(keyLight);
        if(getCodeStyle(keyLight) == 1)
        theme_switch.setChecked(true);
        else theme_switch.setChecked(false);
        theme_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int codeStyle = 0;
                if(!theme_switch.isChecked()){
                    MainActivity.theme = 0;
                }
                if(theme_switch.isChecked()){ codeStyle = 1;
                MainActivity.theme = 1;
                  }
                setAppTheme(codeStyle);
// пересоздадим активити, чтобы тема применилась
                recreate();

            }
        });

back = findViewById(R.id.back);
back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent(v.getContext(), MainActivity.class);
        startActivity(myIntent);
    }
});

    }

    public  int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }
    // Чтение настроек, параметр «тема»

    public int getCodeStyle(int codeStyle){
// Работаем через специальный класс сохранения и чтения настроек
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference,
                MODE_PRIVATE);
//Прочитать тему, если настройка не найдена - взять по умолчанию
        return sharedPref.getInt(key_theme_name, codeStyle);
    }
    // Сохранение настроек
    public void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference,
                MODE_PRIVATE);
// Настройки сохраняются посредством специального класса editor.

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(key_theme_name, codeStyle);
        editor.apply();
    }
    public static int codeStyleToStyleId(int codeStyle){
        if (codeStyle == keyDark) {
            return R.style.AppThemeDark;
        }
        return R.style.AppTheme;
    }

}
