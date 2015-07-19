package com.sys1yagi.databindingsample.activities;

import com.sys1yagi.databindingsample.R;
import com.sys1yagi.databindingsample.databinding.ActivityMainBinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import rx.functions.Action0;

public class MainActivity extends AppCompatActivity {

    class Title {

        String title;

        Action0 action;

        public Title(String title, Action0 action) {
            this.title = title;
            this.action = action;
        }
    }

    class TitleAdapter extends ArrayAdapter<Title> {

        public TitleAdapter(Context context) {
            super(context, android.R.layout.simple_list_item_1);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = (TextView) super.getView(position, convertView, parent);
            textView.setText(getItem(position).title);
            return textView;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        final TitleAdapter adapter = new TitleAdapter(this);
        adapter.add(new Title("Simple Binding", new Action0() {
            @Override
            public void call() {
                startActivity(SimpleBindingActivity.createIntent(MainActivity.this));
            }
        }));
        adapter.add(new Title("Auto Update", new Action0() {
            @Override
            public void call() {
                startActivity(AutoUpdateBindingActivity.createIntent(MainActivity.this));
            }
        }));
        adapter.add(new Title("View With IDs", new Action0() {
            @Override
            public void call() {
                startActivity(ViewsWithIDsActivity.createIntent(MainActivity.this));
            }
        }));
        adapter.add(new Title("MVVM Pattern", new Action0() {
            @Override
            public void call() {
                startActivity(MVVMActivity.createIntent(MainActivity.this));
            }
        }));
        adapter.add(new Title("Avoiding NullPointerException", new Action0() {
            @Override
            public void call() {
                startActivity(AvoidingNullPointerExceptionActivity.createIntent(MainActivity.this));
            }
        }));

        adapter.add(new Title("Include Data Binding Layout", new Action0() {
            @Override
            public void call() {
                startActivity(IncludeDataBindingLayoutActivity.createIntent(MainActivity.this));
            }
        }));
        adapter.add(new Title("Include Data Binding Layout (fix bug on rc1)", new Action0() {
            @Override
            public void call() {
                startActivity(IncludeLayoutActivity.createIntent(MainActivity.this));
            }
        }));

        adapter.add(new Title("Expression Language", new Action0() {
            @Override
            public void call() {
                startActivity(ExpressionLanguageActivity.createIntent(MainActivity.this));
            }
        }));
        adapter.add(new Title("Binding Adapter", new Action0() {
            @Override
            public void call() {
                startActivity(BindingAdapterActivity.createIntent(MainActivity.this));
            }
        }));

        //ListView landscape portrait

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                    View view, int position, long id) {
                adapter.getItem(position).action.call();
            }
        });
        binding.listView.setAdapter(adapter);
    }
}
