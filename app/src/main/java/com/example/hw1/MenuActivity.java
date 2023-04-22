package com.example.hw1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MenuActivity extends AppCompatActivity {
    private Button[] menu_screen_BTN_options;
    private final int SLOW_MOVE_FREQUENCY = 800;
    private final int SLOW_CREATE_FREQUENCY = 1600;
    private final int FAST_MOVE_FREQUENCY = 200;
    private final int FAST_CREATE_FREQUENCY = 400;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_screen);
        findViews();
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        for (Button button : menu_screen_BTN_options) {
            button.setOnClickListener(v -> checkButtonType(v.getId()));
        }
    }

    private void checkButtonType(int buttonId) {
        switch (buttonId) {
            case R.id.menu_screen_slow_button:
                openMainActivity(SLOW_MOVE_FREQUENCY, SLOW_CREATE_FREQUENCY);
                break;
            case R.id.menu_screen_fast_button:
                openMainActivity(FAST_MOVE_FREQUENCY, FAST_CREATE_FREQUENCY);
                break;
            default:
                break;
        }
    }


    private void findViews() {
        menu_screen_BTN_options = new MaterialButton[]{
                findViewById(R.id.menu_screen_slow_button),
                findViewById(R.id.menu_screen_fast_button),
                findViewById(R.id.menu_screen_sensor_button),
                findViewById(R.id.menu_screen_records_button)};
    }


    private void openMainActivity(int moveFrequency, int CreateFrequency) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra((MainActivity.KEY_MOVE_FREQUENCY), moveFrequency);
        intent.putExtra((MainActivity.KEY_CREATE_FREQUENCY), CreateFrequency);
        startActivity(intent);
    }
}
