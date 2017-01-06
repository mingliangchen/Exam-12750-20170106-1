package com.hand.dto;

import java.util.List;

public class PageRerult<T> {
    private int nowPage;
    private int pageSize;
    private int tatolPage;
    private List<T> t;
    public int getNowPage() {
        return nowPage;
    }
    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getTatolPage() {
        return tatolPage;
    }
    public void setTatolPage(int tatolPage) {
        this.tatolPage = tatolPage;
    }
    public List<T> getT() {
        return t;
    }
    public void setT(List<T> t) {
        this.t = t;
    }
    
}
