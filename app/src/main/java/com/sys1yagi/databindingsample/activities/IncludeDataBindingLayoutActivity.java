package com.sys1yagi.databindingsample.activities;

import com.sys1yagi.databindingsample.R;
import com.sys1yagi.databindingsample.databinding.ActivityIncludeBinding;
import com.sys1yagi.databindingsample.models.User;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class IncludeDataBindingLayoutActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, IncludeDataBindingLayoutActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        User user = new User();
        user.setId(100);
        user.setName("MNC");
        user.setDescription("Andoid M is Macadamia Nut Cookie?");

        ActivityIncludeBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_include);
        binding.setUser(user);
    }
}
