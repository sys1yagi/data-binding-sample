package com.sys1yagi.databindingsample.activities;

import com.sys1yagi.databindingsample.R;
import com.sys1yagi.databindingsample.databinding.ActivityBindingAdapterBinding;
import com.sys1yagi.databindingsample.models.User;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BindingAdapterActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, BindingAdapterActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityBindingAdapterBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_binding_adapter);
        User user = new User();
        user.setIcon(
                "https://pbs.twimg.com/profile_images/562623123518787584/st_WXQ8e_400x400.png");
        binding.setUser(user);

        //see more ImageLoadAdapter
    }
}
