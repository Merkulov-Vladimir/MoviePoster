package ru.netology.manager;

import ru.netology.domain.MoviePoster;
import ru.netology.repository.PosterRepository;

public class PosterManager {
    private MoviePoster[] moviePosters = new MoviePoster[0];
    private int limitMovies = 10;
    private PosterRepository repository;

    public PosterManager(PosterRepository repository) {
        this.repository = repository; // конструктор без параметра лимита, лимит показываемых фильмов равен 10
    }
    public PosterManager(int limitMovies, PosterRepository repository) {  // конструктор, чтобы задать лимит
        this.limitMovies = limitMovies;
        this.repository = repository;
    }

    public void addMovie(MoviePoster moviePoster) {
        repository.save(moviePoster);
    }

    public MoviePoster[] getAll() {   // вывод последних фильмов
        MoviePoster[] moviePosters = repository.findAll();
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
