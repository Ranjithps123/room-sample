package com.ranjithps.persistence.dao;


import android.content.Context;
import android.os.AsyncTask;

import com.ranjithps.persistence.database.RmDatabase;
import com.ranjithps.persistence.entity.Config;

import java.util.List;

/**
 * Abstracted Repository as promoted by the Architecture Guide.
 * https://developer.android.com/topic/libraries/architecture/guide.html
 */

public class ConfigRepository {

    private ConfigDao mConfigDao;

    public ConfigRepository(Context context) {
        RmDatabase db = RmDatabase.getDatabase(context);
        mConfigDao =  db.configDao();
    }

    // Room executes all queries on a separate thread.
//    public List<Config> getAllTheConfigurations() {
//        return mAllCountriesList;
//    }

    // You must call this on a non-UI thread or your app will crash.
    // Like this, Room ensures that you're not doing any long running operations on the main
    // thread, blocking the UI.
    public void insertOnlySingleRecord(Config config) {
        new insertAsyncTask(mConfigDao).execute(config);
    }

    private static class insertAsyncTask extends AsyncTask<Config, Void, Void> {

        private ConfigDao mAsyncTaskDao;

        insertAsyncTask(ConfigDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Config... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
