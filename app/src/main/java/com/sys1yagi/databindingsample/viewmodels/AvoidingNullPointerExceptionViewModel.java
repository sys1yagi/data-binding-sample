package com.sys1yagi.databindingsample.viewmodels;

import com.sys1yagi.databindingsample.models.Article;
import com.sys1yagi.databindingsample.models.User;

public class AvoidingNullPointerExceptionViewModel {

    private User user;

    private Article article;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
