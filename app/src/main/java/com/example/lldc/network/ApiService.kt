package com.example.lldc.network

import com.example.lldc.data.Song
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/search")
    suspend fun searchSongs(
        @Query("keyword") keyword: String,
        @Query("sources") sources: String? = null
    ): Response<List<Song>>

    @GET("api/get_lyrics_by_id")
    suspend fun getLyrics(
        @Query("song_info_json") songInfoJson: String,
        @Query("include_romaji") includeRomaji: Boolean = true
    ): Response<ResponseBody>

    @GET("api/match_lyrics")
    suspend fun matchLyrics(
        @Query("title") title: String,
        @Query("artist") artist: String,
        @Query("duration") duration: Long?,
        @Query("include_romaji") includeRomaji: Boolean = true
    ): ResponseBody

    @GET("api/match_lyrics")
    suspend fun matchLyricsByKeyword(
        @Query("keyword") keyword: String,
        @Query("duration") duration: Long?,
        @Query("include_romaji") includeRomaji: Boolean = true
    ): ResponseBody

} 
