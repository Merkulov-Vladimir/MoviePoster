package ru.netology.manager;

import ru.netology.domain.MoviePoster;

public class PosterManager {
    private MoviePoster[] moviePosters = new MoviePoster[0];
    private int limitMovies = 10;

    public PosterManager() {                // конструктор без параметров, лимит показываемых фильмов 10
    }

    public PosterManager(int limitMovies) {  // конструктор, чтобы задать лимит
        this.limitMovies = limitMovies;
    }

    public void addMovie(MoviePoster moviePoster) {
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

    public MoviePoster[] getAll() {   // вывод последних фильмов
        MoviePoster[] moviePosters = findAll();
        int resultLength; // длина результирующего массива
        if (moviePosters.length >= limitMovies) {
            resultLength = limitMovies;
        } else {
            resultLength = moviePosters.length;
        }
        MoviePoster[] result = new MoviePoster[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = moviePosters.length - i - 1;
            result[i] = moviePosters[index]; // копируем в обратном порядке
        }
        return result;
    }
}
