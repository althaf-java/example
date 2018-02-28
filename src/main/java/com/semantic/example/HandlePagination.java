package com.semantic.example;

import java.util.Collection;

import com.semantic.example.domain.Page;
import com.semantic.example.domain.Result;

public interface HandlePagination {

    int nextPage(int start, int pageSize, Collection<Result> results);
    int previousPage(int start, int pageSize, Collection<Result> results);
    boolean hasNext(int start, int pageSize, Collection<Result> results);
    Boolean hasPrevious(int start, int pageSize, Collection<Result> results);
    Page getPagination(int start, int pageSize, Collection<Result> results);
    
}
