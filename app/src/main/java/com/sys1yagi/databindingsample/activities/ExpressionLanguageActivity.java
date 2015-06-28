package com.sys1yagi.databindingsample.activities;

import com.sys1yagi.databindingsample.R;
import com.sys1yagi.databindingsample.databinding.ActivityExpressionBinding;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

public class ExpressionLanguageActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, ExpressionLanguageActivity.class);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //see layout/activity_expression.xml
        final ActivityExpressionBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_expression);
        binding.setLeft(3);
        binding.setRight(1);
        binding.leftHandSide.setText(binding.getLeft().toString());
        binding.rightHandSide.setText(binding.getRight().toString());

        binding.leftHandSide.addTextChangedListener(new PartialTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)) {
                    return;
                }
                binding.setLeft(Integer.parseInt(s.toString()));
            }
        });
        binding.rightHandSide.addTextChangedListener(new PartialTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)) {
                    return;
                }
                binding.setRight(Integer.parseInt(s.toString()));
            }
        });

    }

    //Utils
    abstract public static class PartialTextWatcher implements TextWatcher {

        @Override
        public void afterTextChanged(Editable s) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
    }
}
