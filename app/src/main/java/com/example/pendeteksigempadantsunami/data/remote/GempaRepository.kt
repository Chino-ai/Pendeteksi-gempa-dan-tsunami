package com.example.pendeteksigempadantsunami.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

import com.example.submissionarchitecturecomponent.utils.AppExecutors


class GempaRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val appExecutors: AppExecutors
) : GempaDataSource {



    companion object {
        @Volatile
        private var instance: GempaRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,

            appExecutors: AppExecutors
        ): GempaRepository =
            instance ?: synchronized(this) {
                GempaRepository(remoteData,  appExecutors).apply {
                    instance = this
                }
            }
    }

   /* override fun getAllMovies(): LiveData<List<MoviesEntity>> {
        val movieResult = MutableLiveData<List<MoviesEntity>>()

        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movies: List<Movie>?) {
                val movieList = ArrayList<MoviesEntity>()
                if (movies != null) {
                    for (response in movies) {
                        with(response) {
                            val movie = MoviesEntity(
                                id,
                                title,
                                overview,
                                posterPath,


                                )
                            movieList.add(movie)
                        }
                    }
                    movieResult.postValue(movieList)
                }
            }


        })
        return movieResult
    }


    override fun getAllTvShows(): LiveData<List<TvShowsEntity>> {
        val tvResult = MutableLiveData<List<TvShowsEntity>>()

        remoteDataSource.getAllTvShows(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onAllTvShowsReceived(tvShows: List<TvShow>?) {
                val tvList = ArrayList<TvShowsEntity>()
                if (tvShows != null) {
                    for (response in tvShows) {
                        with(response) {
                            val tvShow = TvShowsEntity(
                                id,
                                name,
                                overview,
                                posterPath,

                            )
                            tvList.add(tvShow)
                        }
                    }
                    tvResult.postValue(tvList)
                }
            }


        })
        return tvResult
    }*/





}