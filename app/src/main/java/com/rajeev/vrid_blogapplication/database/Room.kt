package com.rajeev.vridblog.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomDatabase
import com.rajeev.vrid_blogapplication.database.DatabaseBlogListItem

@Dao
interface BlogsDao {

    @Query("select * from DatabaseBlogListItem")
    fun getAll(): LiveData<List<DatabaseBlogListItem>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<DatabaseBlogListItem>)
}

@Database(entities = [DatabaseBlogListItem::class], version = 1, exportSchema = false)
abstract class BlogDatabase : RoomDatabase() {
    abstract val blogsDao: BlogsDao
}