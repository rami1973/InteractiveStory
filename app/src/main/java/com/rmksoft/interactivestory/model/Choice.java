package com.rmksoft.interactivestory.model;

/**
 * Created by Administrator on 26/02/2015.
 */
public class Choice {
    private  int mNextPage;
    private  String mText;

    public Choice( String text, int nextPage) {
        mNextPage = nextPage;
        mText = text;
    }

    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int nextPage) {
        mNextPage = nextPage;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }
}
