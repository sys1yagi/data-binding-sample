package com.sys1yagi.databindingsample.api;


import com.sys1yagi.databindingsample.models.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

public class ArticleApiClient {

    public Observable<List<Article>> get() {
        return Observable.create(new Observable.OnSubscribe<List<Article>>() {
            @Override
            public void call(Subscriber<? super List<Article>> subscriber) {
                //random error
                Random random = new Random();
                if (random.nextInt(100) < 10) {
                    subscriber.onError(new Exception());
                    return;
                }

                //dummy
                final List<Article> articles = new ArrayList<>();
                Observable.range(0, 20).subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Article article = new Article();
                        article.setId(integer);
                        article.setTitle("title" + integer);
                        article.setDescription("description:" + integer);
                        article.setUrl(
                                "http://developer.android.com/tools/data-binding/guide.html");
                        articles.add(article);
                    }
                });

                subscriber.onNext(articles);
                subscriber.onCompleted();
            }
        }).delay(2, TimeUnit.SECONDS);
    }
}
