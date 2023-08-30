package com.example.sigma;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.content.Context;
import android.media.SigmaManager;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        SigmaManager sigmaManager = (SigmaManager) getSystemService(Context.SIGMA_SERVICE);

        // Check if the service is available
        if (sigmaManager != null) {
            // Call the method to perform a task using the SigmaService
            performSigmaTask(sigmaManager);
        } else {
            // Handle the case when the SigmaService is not available
            Log.e("MainActivity", "SigmaService is not available.");
        }
    }

    private void performSigmaTask(@NonNull SigmaManager sigmaManager) {
       // try {
            // Call a method provided by the SigmaService
        int result = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            result = sigmaManager.write("HELLO");
        }
        // Replace SigmaService with sigmaManager
            // Process the result
            Log.d("MainActivity", "Result from SigmaService: " + result);
        }


}