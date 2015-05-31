package com.sys1yagi.databindingsample.viewmodels;

import com.sys1yagi.databindingsample.BR;
import com.sys1yagi.databindingsample.models.Article;
import com.sys1yagi.databindingsample.views.ArticleAdapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;

import java.util.List;


public class ArticleListViewModel extends BaseObservable implements
        AdapterView.OnItemClickListener {

    Context context;

    private List<Article> articles;

    private ArticleAdapter adapter;

    private boolean showContent;

    private boolean showError;

    public ArticleListViewModel(Context context) {
        this.context = context;
        this.adapter = new ArticleAdapter(context);
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
        adapter.clear();
        adapter.addAll(this.articles);
        setAdapter(adapter);
    }

    @Bindable
    public boolean isShowContent() {
        return showContent;
    }

    public void setShowContent(boolean showContent) {
        this.showContent = showContent;
        notifyPropertyChanged(BR.showContent);
    }

    @Bindable
    public boolean isShowError() {
        return showError;
    }

    public void setShowError(boolean showError) {
        this.showError = showError;
        notifyPropertyChanged(BR.showError);
        setShowContent(false);
    }

    @Bindable
    public ArticleAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(ArticleAdapter adapter) {
        this.adapter = adapter;
        notifyPropertyChanged(BR.adapter);
        setShowContent(adapter.getCount() > 0);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String url = getArticles().get(position).getUrl();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(intent);
    }
}
