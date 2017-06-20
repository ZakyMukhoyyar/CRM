package com.agit.crm.main.navigation;

public abstract class NavigationPage {
    private String title;
    private String includeUri;
    private String subTitle;
    private Object data;
    
    public abstract boolean isSelected();

    public NavigationPage(String title, String includeUri, String subTitle, Object data) {
        super();
        this.title = title;
        this.includeUri = includeUri;
        this.subTitle = subTitle;
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIncludeUri() {
        return includeUri;
    }

    public void setIncludeUri(String includeUri) {
        this.includeUri = includeUri;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
