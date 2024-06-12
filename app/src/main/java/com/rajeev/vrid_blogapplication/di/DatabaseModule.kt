package com.rajeev.vrid_blogapplication.di

import android.content.Context
import androidx.room.Room
import com.rajeev.vridblog.database.BlogDatabase
import com.rajeev.vridblog.database.BlogsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): BlogDatabase {
        return Room.databaseBuilder(
            appContext,
            BlogDatabase::class.java,
            "Blogs"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideChannelDao(blogDatabase: BlogDatabase): BlogsDao {
        return blogDatabase.blogsDao
    }

}