package com.example.forgot_password;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure this layout exists

        // Set up immersive mode if needed
        setEdgeToEdge();

        // Check if the user is signed in
        checkUserAuthentication();
    }

    private void setEdgeToEdge() {
        View mainView = findViewById(R.id.main); // Ensure R.id.main exists in your layout
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                v.setPadding(insets.getInsets(WindowInsetsCompat.Type.systemBars()).left,
                        insets.getInsets(WindowInsetsCompat.Type.systemBars()).top,
                        insets.getInsets(WindowInsetsCompat.Type.systemBars()).right,
                        insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
                return insets;
            });

            WindowInsetsControllerCompat windowInsetsController =
                    ViewCompat.getWindowInsetsController(mainView);
            if (windowInsetsController != null) {
                windowInsetsController.setAppearanceLightStatusBars(true); // Adjusts for light/dark mode
            }
        }
    }

    private void checkUserAuthentication() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser == null) {
            // Redirect to login if no user is signed in
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish(); // Finish the current activity to prevent returning back to it
        } else {
            // Log the signed-in user's ID for debugging
            Log.d("MainActivity", "User ID: " + currentUser.getUid());
        }
    }

    // Launch the ProfileActivity when Button 1 is clicked
    public void onButton1Click(View view) {
        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
    }

    // Launch the ProductDetailsActivity when Button 2 is clicked
    public void onButton2Click(View view) {
        Log.d("MainActivity", "Button 2 clicked"); // Debug log
        startActivity(new Intent(MainActivity.this, ProductDetailsActivity.class));
    }

    // Launch the CartActivity when Button 3 is clicked
    public void onButton3Click(View view) {
        Log.d("MainActivity", "Button 3 clicked"); // Debug log
        startActivity(new Intent(MainActivity.this, CartActivity.class));
    }
}
