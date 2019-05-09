package com.ranjithps.persistence.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.ranjithps.persistence.entity.Config;
import com.ranjithps.persistence.entity.User;

import java.util.List;

@Dao
public interface ConfigDao {

    @Query("SELECT * FROM configuration")
    List<Config> getAll();

    @Query("SELECT COUNT(*) from configuration")
    int countConfigurationItems();

    @Insert
    void insert(Config config);
}
