package com.core.application.collection.utils;

import com.core.application.collection.utils.dom.Movie;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
// comparing itself with another object. The class itself must implements
// the java.lang.Comparable interface to compare its instances.
public class ComparableUtilsTest {

    @Test
    public void verify_sortalistofMoviesbasedonyearofrelease() {

        ArrayList<Movie> list = new ArrayList<>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));

        Collections.sort(list);

        System.out.println("Movies after sorting : ");
        for (Movie movie: list) {
            System.out.println(movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());
        }
    }
}
