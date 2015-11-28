package com.sys1yagi.databindingsample.activities;

import com.cookpad.android.rxt4a.schedulers.AndroidSchedulers;
import com.sys1yagi.databindingsample.R;
import com.sys1yagi.databindingsample.api.ArticleApiClient;
import com.sys1yagi.databindingsample.databinding.ActivityMvvmBinding;
import com.sys1yagi.databindingsample.models.Article;
import com.sys1yagi.databindingsample.viewmodels.ArticleListViewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import rx.Subscription;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public class MVVMActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, MVVMActivity.class);
    }

    ActivityMvvmBinding binding;

    ArticleListViewModel model;

    ArticleApiClient articleApiClient = new ArticleApiClient();

    Subscription subscription = Subscriptions.empty();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        model = new ArticleListViewModel(this);
        binding.setModel(model);

        //ArticleApiClient returns an error in the random.
        subscription = articleApiClient.get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Action1<List<Article>>() {
                            @Override
                            public void call(List<Article> articles) {
                                model.setArticles(articles);
                            }
                        },
                        new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                model.setShowError(true);
                            }
                        }
                );
    }

    @Override
    protected void onPause() {
        super.onPause();
        subscription.unsubscribe();
    }
}
