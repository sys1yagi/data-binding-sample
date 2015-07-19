package com.sys1yagi.databindingsample.activities;

import com.sys1yagi.databindingsample.R;
import com.sys1yagi.databindingsample.databinding.ActivityIncludeWithoutDatabindingBinding;
import com.sys1yagi.databindingsample.models.User;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class IncludeLayoutActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, IncludeLayoutActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        User user = new User();
        user.setId(100);
        user.setName("MNC");
        user.setDescription("Andoid M is Macadamia Nut Cookie?");

        //fixed issue on rc1
        //see more : https://code.google.com/p/android/issues/detail?id=176649&can=1&q=Data%20Binding&colspec=ID%20Type%20Status%20Owner%20Summary%20Stars
        ActivityIncludeWithoutDatabindingBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_include_without_databinding);
        binding.setUser(user);

        binding.botomDivider.setVisibility(View.GONE);
    }
}
