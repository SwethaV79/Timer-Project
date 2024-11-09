package com.example.labassignment03;
public class ProfileActivity extends AppCompatActivity {
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private EditText nameEditText, dobEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        nameEditText = findViewById(R.id.name);
        dobEditText = findViewById(R.id.dob);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(v -> saveUserData());
    }

    private void saveUserData() {
        String name = nameEditText.getText().toString();
        String dob = dobEditText.getText().toString();

        if (!name.isEmpty() && !dob.isEmpty()) {
            Map<String, Object> user = new HashMap<>();
            user.put("name", name);
            user.put("dob", dob);

            db.collection("users").document(mAuth.getCurrentUser().getUid())
                    .set(user)
                    .addOnSuccessListener(aVoid -> {
                        Toast.makeText(ProfileActivity.this, "Data saved!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ProfileActivity.this, AgeActivity.class));
                        finish();
                    })
                    .addOnFailureListener(e -> Toast.makeText(ProfileActivity.this, "Error saving data", Toast.LENGTH_SHORT).show());
        }
    }
}

