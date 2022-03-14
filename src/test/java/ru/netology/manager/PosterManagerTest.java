package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MoviePoster;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {
    //экземпляры класса MoviePoster
    MoviePoster one = new MoviePoster("Brat", 1);
    MoviePoster two = new MoviePoster("Brat2", 2);
    MoviePoster three = new MoviePoster("Brat3", 3);
    MoviePoster four = new MoviePoster("Brat4", 4);
    MoviePoster fife = new MoviePoster("Brat5", 5);
    MoviePoster six = new MoviePoster("Brat6", 6);
    MoviePoster seven = new MoviePoster("Brat7", 7);
    MoviePoster eight = new MoviePoster("Brat8", 8);
    MoviePoster nine = new MoviePoster("Brat9", 9);
    MoviePoster ten = new MoviePoster("Brat10", 10);
    MoviePoster eleven = new MoviePoster("Brat11", 11);
    MoviePoster twelve = new MoviePoster("Brat12", 12);

    @Test
    void addMovieForThreeMovies() {
        PosterManager manager = new PosterManager();
        manager.addMovie(one);
        manager.addMovie(two);
        manager.addMovie(three);
        MoviePoster[] expected = {one, two, three};
        MoviePoster[] actual = manager.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    void addMovieForNullMovies() {
        PosterManager manager = new PosterManager();
        MoviePoster[] expected = {};
        MoviePoster[] actual = manager.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    void getAllForLimitsOneMovieWhenAddThreeMovie() {
        PosterManager manager = new PosterManager(1);
        manager.addMovie(one);
        manager.addMovie(two);
        manager.addMovie(three);
        MoviePoster[] expected = {three};
        MoviePoster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllForLimitsNullMovieWhenAddNullMovies() {
        PosterManager manager = new PosterManager(0);
        MoviePoster[] expected = {};
        MoviePoster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllForLimitsNullMovieWhenAddOneMovie() {
        PosterManager manager = new PosterManager(0);
        manager.addMovie(one);
        MoviePoster[] expected = {};
        MoviePoster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllForLimitsFourMovieWhenAddSixMovies() {
        PosterManager manager = new PosterManager(4);
        manager.addMovie(one);
        manager.addMovie(two);
        manager.addMovie(three);
        manager.addMovie(four);
        manager.addMovie(fife);
        manager.addMovie(six);
        MoviePoster[] expected = {six, fife, four, three};
        MoviePoster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllForLimitsDefaultConstructorWhenMovieTwelve() {                    // limits = 10
        PosterManager manager = new PosterManager();
        manager.addMovie(one);
        manager.addMovie(two);
        manager.addMovie(three);
        manager.addMovie(four);
        manager.addMovie(fife);
        manager.addMovie(six);
        manager.addMovie(seven);
        manager.addMovie(eight);
        manager.addMovie(nine);
        manager.addMovie(ten);
        manager.addMovie(eleven);
        manager.addMovie(twelve);
        MoviePoster[] expected = {twelve, eleven, ten, nine, eight, seven, six, fife, four, three};
        MoviePoster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllForLimitsDefaultConstructorWhenMovieTen() {                    // limits = 10
        PosterManager manager = new PosterManager();
        manager.addMovie(one);
        manager.addMovie(two);
        manager.addMovie(three);
        manager.addMovie(four);
        manager.addMovie(fife);
        manager.addMovie(six);
        manager.addMovie(seven);
        manager.addMovie(eight);
        manager.addMovie(nine);
        manager.addMovie(ten);
        MoviePoster[] expected = {ten, nine, eight, seven, six, fife, four, three, two, one};
        MoviePoster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllForLimitsDefaultConstructorWhenMovieEleven() {                    // limits = 10
        PosterManager manager = new PosterManager();
        manager.addMovie(one);
        manager.addMovie(two);
        manager.addMovie(three);
        manager.addMovie(four);
        manager.addMovie(fife);
        manager.addMovie(six);
        manager.addMovie(seven);
        manager.addMovie(eight);
        manager.addMovie(nine);
        manager.addMovie(ten);
        manager.addMovie(eleven);
        MoviePoster[] expected = {eleven, ten, nine, eight, seven, six, fife, four, three, two};
        MoviePoster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllForLimitsDefaultConstructorWhenMovieNine() {                    // limits = 10
        PosterManager manager = new PosterManager();
        manager.addMovie(one);
        manager.addMovie(two);
        manager.addMovie(three);
        manager.addMovie(four);
        manager.addMovie(fife);
        manager.addMovie(six);
        manager.addMovie(seven);
        manager.addMovie(eight);
        manager.addMovie(nine);
        MoviePoster[] expected = {nine, eight, seven, six, fife, four, three, two, one};
        MoviePoster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllForLimitsDefaultConstructorWhenMovieNull() {                    // limits = 10
        PosterManager manager = new PosterManager();
        MoviePoster[] expected = {};
        MoviePoster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }


}