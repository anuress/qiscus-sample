package com.astro.sample.code.di

import com.astro.sample.code.data.ChatRepository
import com.astro.sample.code.data.ChatRepositoryImpl
import com.astro.sample.code.data.network.service.ChatService
import com.astro.sample.code.presentation.ChatHistoryViewModel
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder().build()
    }

    factory<GsonConverterFactory> {
        val dateFormat = "yyyy-MM-dd'T'HH:mm:ssZ"
        val builder = GsonBuilder()
            .setDateFormat(dateFormat)
            .setPrettyPrinting()
            .serializeNulls()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
        GsonConverterFactory.create(builder)
    }

    single<Retrofit> {
        Retrofit.Builder()
            .addConverterFactory(get<GsonConverterFactory>())
            .baseUrl("https://multichannel.qiscus.com")
            .client(get())
            .build()
    }

    single<ChatService> {
        get<Retrofit>().create(ChatService::class.java)
    }

    single<ChatRepository> { ChatRepositoryImpl(get()) }

    viewModel<ChatHistoryViewModel> {
        ChatHistoryViewModel(get())
    }
}