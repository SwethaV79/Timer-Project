package com.example.labassignment03;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.auth.FirebaseUser;

public class AgeActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private TextView ageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        ageTextView = findViewById(R.id.ageTextView);

        fetchUserData();
    }

    private void fetchUserData() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            db.collection("users").document(currentUser.getUid())
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            String dob = task.getResult().getString("dob");
                            calculateAndDisplayAge(dob);
                        }
                    });
        }
    }

    private void calculateAndDisplayAge(String dob) {
        // Your logic to calculate age and display in ageTextView
    }
}
