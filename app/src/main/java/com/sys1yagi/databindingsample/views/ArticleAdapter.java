package com.sys1yagi.databindingsample.views;

import com.sys1yagi.databindingsample.ArticleBinding;
import com.sys1yagi.databindingsample.models.Article;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ArticleAdapter extends ArrayAdapter<Article> {

    public ArticleAdapter(Context context) {
        super(context, -1);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            ArticleBinding binding = ArticleBinding.inflate(LayoutInflater.from(getContext()));
            convertView = binding.getRoot();
            convertView.setTag(binding);
        }
        ((ArticleBinding) convertView.getTag()).setArticle(getItem(position));
        return convertView;
    }
}


