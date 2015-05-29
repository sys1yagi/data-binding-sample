package com.sys1yagi.databindingsample.activities;

import com.sys1yagi.databindingsample.R;
import com.sys1yagi.databindingsample.databinding.ActivityAutoUpdateBinding;
import com.sys1yagi.databindingsample.models.User;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;

public class AutoUpdateBindingActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, AutoUpdateBindingActivity.class);
    }

    ActivityAutoUpdateBinding binding;

    User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auto_update);

        user.setName("Saburo");
        user.setDescription("hehehe");
        binding.setUser(user);

        binding.textInput.setText(user.getName());
        binding.textInput.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                user.setName(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //no op
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //no op
            }

        });
    }
}
