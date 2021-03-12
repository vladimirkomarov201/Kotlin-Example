package ru.skillbranch.skillarticles.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.skillbranch.skillarticles.App
import ru.skillbranch.skillarticles.BuildConfig
import ru.skillbranch.skillarticles.data.local.dao.ArticlesDao
import ru.skillbranch.skillarticles.data.local.entities.Article
import ru.skillbranch.skillarticles.data.local.entities.ArticleFull
import ru.skillbranch.skillarticles.data.local.entities.ArticleItem

object DbManager {

    val db = Room.databaseBuilder(
        App.applicationContext(),
        AppDb::class.java,
        AppDb.DATABASE_NAME
    ).build()

}

@Database(
    entities = [
        Article::class
    ],
    version = AppDb.DATABASE_VERSION,
    exportSchema = true,
    views = [ArticleItem::class, ArticleFull::class]
)
@TypeConverters(DateConverter::class)
abstract class AppDb: RoomDatabase(){

    companion object{
        const val DATABASE_NAME = BuildConfig.APPLICATION_ID + ".db"
        const val DATABASE_VERSION = 1
    }

    abstract fun articlesDao(): ArticlesDao

}