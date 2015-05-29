package com.sys1yagi.databindingsample.activities;

import com.sys1yagi.databindingsample.R;
import com.sys1yagi.databindingsample.databinding.ActivityMainBinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1);

        adapter.add("Simple Binding");
        adapter.add("Auto Update");
        adapter.add("View With IDs");

        binding.setListener(this);
        binding.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                startActivity(SimpleBindingActivity.createIntent(this));
                return;
            case 1:
                startActivity(AutoUpdateBindingActivity.createIntent(this));
                return;
            case 2:
                startActivity(ViewsWithIDsActivity.createIntent(this));
                return;
        }
    }
}
