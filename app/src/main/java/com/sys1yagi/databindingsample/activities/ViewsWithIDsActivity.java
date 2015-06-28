package com.sys1yagi.databindingsample.activities;

import com.sys1yagi.databindingsample.R;
import com.sys1yagi.databindingsample.databinding.ActivityViewsWithIdsBinding;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ViewsWithIDsActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, ViewsWithIDsActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityViewsWithIdsBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_views_with_ids);

        //Become a member of the binding object automatically.
        binding.name.setText("jiro");
        binding.description.setText("I'm the second son.");
        binding.okButton.setText("ok");
    }
}
