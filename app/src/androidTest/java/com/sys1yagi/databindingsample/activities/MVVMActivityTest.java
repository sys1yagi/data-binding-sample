package com.sys1yagi.databindingsample.activities;


import com.sys1yagi.databindingsample.databinding.ActivityMvvmBinding;

import org.junit.Test;

import android.support.test.InstrumentationRegistry;
import android.view.LayoutInflater;

public class MVVMActivityTest {

    @Test
    public void test() {

        //OMG...
        //I faced the error below...
        //
        //java.lang.IllegalAccessError: Class ref in pre-verified class resolved to unexpected implementation
        //
        //Because the source code for data binding is also generated in the test side, maybe.

        ActivityMvvmBinding binding = ActivityMvvmBinding.inflate(LayoutInflater.from(
                InstrumentationRegistry.getContext()
        ));
    }
}
