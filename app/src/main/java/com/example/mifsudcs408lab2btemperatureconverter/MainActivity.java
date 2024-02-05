package com.example.mifsudcs408lab2btemperatureconverter;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mifsudcs408lab2btemperatureconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        String fahrenheitText = binding.fahrenheitEditText.getText().toString().trim();
        String celsiusText = binding.celsiusEditText.getText().toString().trim();

        if (!fahrenheitText.isEmpty() && isNumeric(fahrenheitText) &&
                !celsiusText.isEmpty() && isNumeric(celsiusText)) {

            double fahrenheitValue = Double.parseDouble(fahrenheitText);
            double celsiusValue = (fahrenheitValue - 32) * 5/9;
            binding.celsiusEditText.setText(String.valueOf(celsiusValue));

        } else if (!fahrenheitText.isEmpty() && isNumeric(fahrenheitText)) {
            double fahrenheitValue = Double.parseDouble(fahrenheitText);
            double celsiusValue = (fahrenheitValue - 32) * 5/9;
            binding.celsiusEditText.setText(String.valueOf(celsiusValue));

        } else if (!celsiusText.isEmpty() && isNumeric(celsiusText)) {
            double celsiusValue = Double.parseDouble(celsiusText);
            double fahrenheitValue = (celsiusValue * 9/5) + 32;
            binding.fahrenheitEditText.setText(String.valueOf(fahrenheitValue));
        }
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
