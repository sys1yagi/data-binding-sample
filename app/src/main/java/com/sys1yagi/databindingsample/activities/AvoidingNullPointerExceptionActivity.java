package com.sys1yagi.databindingsample.activities;

import com.sys1yagi.databindingsample.R;
import com.sys1yagi.databindingsample.databinding.ActivityAvoidingNpeBinding;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AvoidingNullPointerExceptionActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, AvoidingNullPointerExceptionActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityAvoidingNpeBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_avoiding_npe);

        //no crash!
        binding.setViewModel(null);
    }
}
