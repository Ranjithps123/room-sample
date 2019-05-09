package com.ranjithps.persistence.database;

/**
 * Created by Ranjith on 02-05-2019.
 */

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.ranjithps.persistence.dao.ConfigDao;
import com.ranjithps.persistence.entity.Config;

/**
 * This is the backend. The database. This used to be done by the OpenHelper.
 * The fact that this has very few comments emphasizes its coolness.
 */

@Database(entities = {Config.class}, version = 1)
public abstract class RmDatabase extends RoomDatabase {

    public abstract ConfigDao configDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile RmDatabase INSTANCE;

    public static RmDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RmDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RmDatabase.class, "confi_database")
                            // allow queries on the main thread.
                            // Don't do this on a real app!
                            .allowMainThreadQueries() //TODO: Only for testing purpose.
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
