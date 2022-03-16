package ru.netology.repository;

import ru.netology.domain.MoviePoster;

public class PosterRepository {
    private MoviePoster[] moviePosters = new MoviePoster[0];

    public void save(MoviePoster moviePoster) {
        int length = moviePosters.length + 1; // длина нового массива
        MoviePoster[] tmp = new MoviePoster[length];     // создание нового массива типа MP с нужной длиной
        System.arraycopy(moviePosters, 0, tmp, 0, moviePosters.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = moviePoster;
        moviePosters = tmp;
    }

    public MoviePoster[] findAll() {
        return moviePosters;
    }

    public void removeById(int id) {
        int resultLength = moviePosters.length - 1; // длина нового массива
        MoviePoster[] tmp = new MoviePoster[resultLength]; // создание нового массива дляной resultLength
        int index = 0;
        for (MoviePoster moviePoster : moviePosters) {
            if (moviePoster.getId() != id) {
                tmp[index] = moviePoster;
                index++;
            }
        }
        moviePosters = tmp;

    }

    public void removeAll() {
        moviePosters = new MoviePoster[0]; // обнуляем
    }

    public MoviePoster findById(int id) {
        MoviePoster tmp = new MoviePoster();
        for (MoviePoster moviePoster : moviePosters) {
            if (moviePoster.getId() == id) {
                tmp = moviePoster;
            }
        }
        return tmp;
    }
}
