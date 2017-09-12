//package com.agit.crm.main.viewmodel.admin;
//
//import com.agit.crm.main.viewmodel.forumcontrol.AuthorBean;
//import com.agit.crm.main.viewmodel.forumcontrol.ContactGroupBean;
//import com.agit.crm.main.viewmodel.forumcontrol.FakeData;
//import com.agit.crm.main.viewmodel.forumcontrol.MenuGroupBean;
//import com.agit.crm.main.viewmodel.forumcontrol.PostBean;
//import java.util.List;
//import javax.servlet.ServletRequest;
//import org.zkoss.bind.annotation.Init;
//import org.zkoss.web.fn.ServletFns;
//import org.zkoss.zul.ListModel;
//import org.zkoss.zul.ListModelList;
//
///**
// *
// * @author Zaky
// */
//public class ForumPostVM {
//
//    private AuthorBean currentUser;
//    private MenuGroupBean[] menuGroups;
//    private ContactGroupBean[] contactGroups;
//    private PostBean currentPost = null;
//    private String currentComment = null;
//    private boolean modalShow = false;
//    private boolean menuOpen = false;
//    private boolean contactOpen = true;
//    private boolean hideContact = false;
//    private boolean likeStatus = false;
//    private ServletRequest request = ServletFns.getCurrentRequest();
//
//    public ListModel<String[]> getToolbarModel() {
//        return new ListModelList<String[]>(
//                new String[][]{
//                    {"Status", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAANFJREFUeNpiZEhrYSADTAPis0A8lwkqADLlPx78CkmzHBD7AfFMIDZjgQoWEbDxHZTuBWIDIHYD4nwgvgAzgBNKswPxLxyG9CJZBKJTQAwmNEW4NHchaX4ExPUwCSYiAgwUPqVQ9msgdgbijUC8DiTAQkAzyGsVUPZ3IPYB4jtAbAzEKsQYIA31FgjHAfEpdAX4DGCGOt0WiG8C8RdsivAZ8BeI0wkFEBMDhYDqBggRoUcUWxj8hQbaWxIs/4Xsgj5coYwngEF6GBjJzM5wABBgALS1KzDd2YvyAAAAAElFTkSuQmCC"},
//                    {"Photo", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAOtJREFUeNpiZEhrYaAEMAHxGSD+TwK+CsRCMANYgNgYiL8D8TUiLFQBYi0glgZiCSB+ygKVuAPEJkQYsAWIvaHsFUD8lwlNgRwQM6OJceIxUAjZAJCz7gFxL5rYdhya2UCWIRvwAoj7gHgN1H8gMA2I7YE4EIsBIJfxIBvwF4jroX58CLXZDyrXiMsPLGgmFkGjaAFUbBZaDOA0AOTXCQRioBSIdbEZ8B1qaxoJCfA7sgEOQGxAguZH0HQDN+AUFIO8UUeEAcbQWAG5+i8LmmQsgYSDDu4gG/AUiOWhqZFYcBndBa+hmGgAEGAAw0kvuVLIffoAAAAASUVORK5CYII="},
//                    {"Check In", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAO5JREFUeNpi/P//PwMIMKa3MpAK/s+sZmDCIccPxL1AfA+kDoifAPFMIBZFV4jNAHsgvgrERUCsCBWTBuI0qLgTPgNANqyAagCBLJDvgLgASX41EEvgMqAFSfIvEE+HsqdD+SAgBMTtuAzwRmIzA3EOEHNCaWYkOVcYgwXNACE0/mQoZsClDt0FZ4mMwbO4DJhFpAELcBmwEojvENAMkl+My4BfQJxCwIACqDqcCekgEC/DoXkrFONNiSBQBsTv0MTeQRMWAzEGPMXilUQgfkSsASCwHojnQtlTgHgTNkUsBAIsF4jZgLgYlwKAAAMAbegrRQ3UKeAAAAAASUVORK5CYII="}
//                }
//        );
//    }
//    
//    
//    @Init
//    public void init() {
//        
//        
//    }
//    
//    
//
//    /* is, getter, setter */
//    public AuthorBean getCurrentUser() {
//        return this.currentUser;
//    }
//
//    public MenuGroupBean[] getMenuGroups() {
//        return menuGroups;
//    }
//
//    public void setMenuGroups(MenuGroupBean[] menuGroups) {
//        this.menuGroups = menuGroups;
//    }
//
//    public ContactGroupBean[] getContactGroups() {
//        return contactGroups;
//    }
//
//    public PostBean getCurrentPost() {
//        return currentPost;
//    }
//
//    public void setCurrentPost(PostBean currentPost) {
//        this.currentPost = currentPost;
//    }
//
//    public String getCurrentComment() {
//        return currentComment;
//    }
//
//    public void setCurrentComment(String currentComment) {
//        this.currentComment = currentComment;
//    }
//
//    public boolean isModalShow() {
//        return modalShow;
//    }
//
//    public void setModalShow(boolean modalShow) {
//        this.modalShow = modalShow;
//    }
//
//    public boolean isMenuOpen() {
//        return menuOpen;
//    }
//
//    public void setMenuOpen(boolean menuOpen) {
//        this.menuOpen = menuOpen;
//    }
//
//    public boolean isContactOpen() {
//        return contactOpen;
//    }
//
//    public void setContactOpen(boolean contactOpen) {
//        this.contactOpen = contactOpen;
//    }
//
//    public boolean isLikeStatus() {
//        return (currentPost == null) ? false : currentPost.getLikeList().contains(currentUser);
//    }
//
//    public void setLikeStatus(boolean likeStatus) {
//        this.likeStatus = likeStatus;
//    }
//    
//    public List<PostBean> getPostModel() {
//        return FakeData.getPosts();
//    }
//}
