package com.cappielloantonio.play.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.cappielloantonio.play.model.RecentSearch;

import java.util.List;

@Dao
public interface RecentSearchDao {
    @Query("SELECT * FROM recent_search GROUP BY search ORDER BY search DESC LIMIT :limit")
    List<String> getRecent(int limit);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(RecentSearch search);

    @Delete
    void delete(RecentSearch search);

    @Query("DELETE FROM recent_search")
    void deleteAll();
}