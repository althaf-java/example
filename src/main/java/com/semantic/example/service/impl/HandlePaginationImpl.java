package com.semantic.example.service.impl;

import java.util.Collection;

import com.semantic.example.modal.Page;
import com.semantic.example.modal.Result;
import com.semantic.example.service.HandlePagination;

public class HandlePaginationImpl implements HandlePagination {

    private static final int DEFAULT_PAGE_SIZE = 20;
    
    @Override
    public int nextPage(int start, int pageSize, Collection<Result> results) {
        int next = hasNext(start, pageSize, results) ? start + 1: start;
        return next;
    }

    @Override
    public int previousPage(int start, int pageSize, Collection<Result> results) {
        return hasPrevious(start, pageSize, results) ? start - 1: start;
    }

    @Override
    public boolean hasNext(int start, int pageSize, Collection<Result> results) {
        return results.size() > start && start >= 1; 
    }

    @Override
    public Boolean hasPrevious(int start, int pageSize, Collection<Result> results) {
        return start <= results.size() && start > 1;
    }

    @Override
    public Page getPagination(int start, int pageSize, Collection<Result> results) {
        pageSize = pageSize == 0 ? DEFAULT_PAGE_SIZE: pageSize;
        Page page = new Page();
        //TODO: Refactor this for loop later
        for (int i = start - 1; i < start + pageSize - 1; i++) {
            page.getResult().add((Result) results.toArray()[i]);
        }
        page.setNextPage(this.nextPage(start, pageSize, results));
        page.setPrevPage(this.previousPage(start, pageSize, results));
        return page;
    }

}
