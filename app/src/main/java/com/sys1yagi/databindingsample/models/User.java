package com.sys1yagi.databindingsample.models;

import com.sys1yagi.databindingsample.BR;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class User extends BaseObservable {

    private long id;

    private String name;

    private String description;

    private String icon;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
