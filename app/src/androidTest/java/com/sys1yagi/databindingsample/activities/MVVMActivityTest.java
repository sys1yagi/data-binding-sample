package com.sys1yagi.databindingsample.activities;


import com.sys1yagi.databindingsample.databinding.ActivityMvvmBinding;

import org.junit.Test;

import android.support.test.InstrumentationRegistry;
import android.view.LayoutInflater;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MVVMActivityTest {

    @Test
    public void test() {

        //OMG...
        //I faced the error below...
        //
        //java.lang.IllegalAccessError: Class ref in pre-verified class resolved to unexpected implementation
        //
        //Because the source code for data binding is also generated in the test side, maybe.

        //SOLVE: You should run on Android 5.0 or upper and run on Ui thread.
        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                ActivityMvvmBinding binding = ActivityMvvmBinding.inflate(LayoutInflater.from(
                        InstrumentationRegistry.getTargetContext()
                ));
                assertThat(binding, is(notNullValue()));
            }
        });
    }
}
