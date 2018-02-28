package com.semantic.example.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import com.semantic.example.modal.Page;
import com.semantic.example.modal.Result;
import com.semantic.example.service.HandlePagination;
import org.junit.Test;

import com.semantic.example.service.impl.HandlePaginationImpl;

public class HandlPaginationIntegrationTest {

    private HandlePagination handlPagination = new HandlePaginationImpl();
    private Collection<Result> searchResults;
    private Page page;
    private int startPage = 2;
    private int pageSize = 1;

    @Test
    public void testPaginationFeature() {
        givenIHaveSearchResult();
        whenIRequestAGivenPageWithPageSizeOfResult(startPage, pageSize);
        iShouldSeeUpToPageSizeResult(pageSize);
        resultShouldStartFromStartPage(startPage);
        iShouldBeGiveNumberOfNextPage(startPage + 1);
        iShouldBeGiveNumberOfPreviousPage(startPage - 1);

    }

    private void givenIHaveSearchResult() {
        searchResults = new ArrayList<Result>();
        searchResults.add(new Result("https://link1", "title1", "summary1"));
        searchResults.add(new Result("https://link2", "title2", "summary2"));
        searchResults.add(new Result("https://link3", "title3", "summary3"));
        searchResults.add(new Result("https://link4", "title4", "summary4"));
        searchResults.add(new Result("https://link5", "title5", "summary5"));
    }

    private void whenIRequestAGivenPageWithPageSizeOfResult(int startPage, int pageSize) {
        page = handlPagination.getPagination(startPage, pageSize, searchResults);
    }

    private void iShouldSeeUpToPageSizeResult(int pageSize) {
        assertEquals(pageSize, page.getResult().size());

    }

    private void resultShouldStartFromStartPage(int startPage) {
        assertEquals(searchResults.toArray()[startPage - 1], page.getResult().toArray()[0]);
    }

    private void iShouldBeGiveNumberOfNextPage(int nextPage) {
        assertEquals(nextPage, page.getNextPage());
    }

    private void iShouldBeGiveNumberOfPreviousPage(int prevPage) {
        assertEquals(prevPage, page.getPrevPage());
    }

}
