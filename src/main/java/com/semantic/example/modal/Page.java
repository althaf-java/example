package com.semantic.example.modal;

import java.util.ArrayList;
import java.util.Collection;

public class Page {
    
    private Collection<Result> result = new ArrayList<Result>();
    private int nextPage;
    private int prevPage;
    
    public Collection<Result> getResult() {
        return result;
    }
    public void setResult(Collection<Result> result) {
        this.result = result;
    }
    public int getNextPage() {
        return nextPage;
    }
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
    public int getPrevPage() {
        return prevPage;
    }
    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }
    
    

}
