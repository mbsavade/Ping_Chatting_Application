package com.mahakuji.ping.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.mahakuji.ping.databinding.ActivityPhoneNumberAvctivityBinding;

public class PhoneNumberAvctivity extends AppCompatActivity {

    ActivityPhoneNumberAvctivityBinding binding;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneNumberAvctivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() != null){
            Intent intent = new Intent(PhoneNumberAvctivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        getSupportActionBar().hide();

        binding.phoneBox.requestFocus();

        binding.continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhoneNumberAvctivity.this, OTPActivity.class);
                intent.putExtra("phoneNumber", binding.phoneBox.getText().toString());
                startActivity(intent);
            }
        });
    }
}