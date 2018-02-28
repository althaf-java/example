package com.semantic.example.service;

import java.util.Collection;

import com.semantic.example.modal.Page;
import com.semantic.example.modal.Result;

public interface HandlePagination {

    int nextPage(int start, int pageSize, Collection<Result> results);
    int previousPage(int start, int pageSize, Collection<Result> results);
    boolean hasNext(int start, int pageSize, Collection<Result> results);
    Boolean hasPrevious(int start, int pageSize, Collection<Result> results);
    Page getPagination(int start, int pageSize, Collection<Result> results);
    
}
