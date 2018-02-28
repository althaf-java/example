package com.semantic.example.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.semantic.example.domain.Page;
import com.semantic.example.domain.Result;

public class HandlePaginationImplTest {
    
    HandlePaginationImpl handlePaginationImpl = new HandlePaginationImpl();
    
    @Test
    public void testNextPageWhenHasNext() {
        Collection<Result> searchResults = new ArrayList<Result>();
        searchResults.add(new Result("https://link1", "title1", "summary1"));
        searchResults.add(new Result("https://link2", "title2", "summary2"));
        assertEquals(2,handlePaginationImpl.nextPage(1, 5, searchResults));
    }
    
    @Test
    public void testNextPageWhenNoNext() {
        Collection<Result> searchResults = new ArrayList<Result>();
        searchResults.add(new Result("https://link1", "title1", "summary1"));
        assertEquals(5,handlePaginationImpl.nextPage(5, 5, searchResults));
    }
    
    @Test
    public void testHasNext() {
        Collection<Result> searchResults = new ArrayList<Result>();
        searchResults.add(new Result("https://link1", "title1", "summary1"));
        searchResults.add(new Result("https://link2", "title2", "summary2"));
        assertEquals(true,handlePaginationImpl.hasNext(1, 5, searchResults));
    }
    
    @Test
    public void testHasNoNext() {
        Collection<Result> searchResults = new ArrayList<Result>();
        searchResults.add(new Result("https://link1", "title1", "summary1"));
        searchResults.add(new Result("https://link2", "title2", "summary2"));
        assertEquals(false,handlePaginationImpl.hasNext(5, 5, searchResults));
    }
    
    @Test
    public void testHasPrev() {
        Collection<Result> searchResults = new ArrayList<Result>();
        searchResults.add(new Result("https://link1", "title1", "summary1"));
        searchResults.add(new Result("https://link2", "title2", "summary2"));
        assertEquals(false,handlePaginationImpl.hasPrevious(5, 5, searchResults));
    }
    
    @Test
    public void testHasNoPrev() {
        Collection<Result> searchResults = new ArrayList<Result>();
        searchResults.add(new Result("https://link1", "title1", "summary1"));
        searchResults.add(new Result("https://link2", "title2", "summary2"));
        assertEquals(false,handlePaginationImpl.hasPrevious(1, 5, searchResults));
    }
    
    @Test
    public void testPrevPageWhenHasPrev() {
        Collection<Result> searchResults = new ArrayList<Result>();
        searchResults.add(new Result("https://link1", "title1", "summary1"));
        searchResults.add(new Result("https://link2", "title2", "summary2"));
        assertEquals(1,handlePaginationImpl.previousPage(2, 5, searchResults));
    }
    
    @Test
    public void testPrevPageWhenNoPrev() {
        Collection<Result> searchResults = new ArrayList<Result>();
        searchResults.add(new Result("https://link1", "title1", "summary1"));
        searchResults.add(new Result("https://link2", "title2", "summary2"));
        assertEquals(1,handlePaginationImpl.previousPage(1, 5, searchResults));
    }
    
    @Test
    public void testWhenPageSizeIs0() {
        Collection<Result> searchResults = new ArrayList<Result>();
        for(int i = 0; i < 20; i++) {
            searchResults.add(new Result("https://link"+i, "title1"+i, "summary1"+i));
        }
        Page page = handlePaginationImpl.getPagination(1, 0, searchResults);
        
        assertEquals(20, page.getResult().size());
    }

    @Test
    public void testPagination() {
        Collection<Result> searchResults = new ArrayList<Result>();
        searchResults.add(new Result("https://link1", "title1", "summary1"));
        searchResults.add(new Result("https://link2", "title2", "summary2"));
        searchResults.add(new Result("https://link3", "title3", "summary3"));
        searchResults.add(new Result("https://link4", "title4", "summary4"));
        searchResults.add(new Result("https://link5", "title5", "summary5"));        
        int startPage = 2;
        int pageSize = 1;
        
        Page page = handlePaginationImpl.getPagination(startPage, pageSize, searchResults);
        
        assertEquals(pageSize, page.getResult().size());
        assertEquals(searchResults.toArray()[startPage - 1], page.getResult().toArray()[0]);
        assertEquals(startPage + 1, page.getNextPage());
        assertEquals(startPage - 1, page.getPrevPage());
    }
    
}
