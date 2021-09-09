package com.example.nytimes.ui.view.articles

import org.junit.Assert.*

import org.junit.Test

class ArticlesActivityTest {

    @Test
    fun getAdapter() {
        var output = {}
        var expected = {}

        var activity = ArticlesActivity();
        output = { activity.getMyData() };
        assertEquals(output, expected)
    }

    @Test
    fun setAdapter() {

    }

    @Test
    fun getLinearLayoutManager() {

    }

    @Test
    fun setLinearLayoutManager() {

    }

    @Test
    fun getRecyclerView() {
    }

    @Test
    fun setRecyclerView() {
    }

    @Test
    fun getSwipeView() {
    }

    @Test
    fun setSwipeView() {
    }

    @Test
    fun onCreate() {
    }

    @Test
    fun onCreateOptionsMenu() {
    }

    @Test
    fun onOptionsItemSelected() {
    }
}