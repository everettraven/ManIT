package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Orgs.class, WAPS.class, Lists.class, Items.class}, version=3, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract OrgsDao orgsDao();
    public abstract WAPDao wapsDao();
    public abstract ListsDao listsDao();
    public abstract ItemsDao itemsDao();

    //Create the actual database
    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getDatabase(final Context context){
        if(INSTANCE == null)
        {
            synchronized (AppDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "manit_db").fallbackToDestructiveMigration().addCallback(sCallback).build();
                }
            }
        }

        return INSTANCE;
    }

    // Currently fill the database with this information so we can test the views
    private static RoomDatabase.Callback sCallback =  new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            databaseExecutor.execute(()->{
                OrgsDao dao = INSTANCE.orgsDao();
                dao.deleteAll();

                Orgs org= new Orgs("Microsoft");
                dao.insert(org);
                org = new Orgs("Facebook");
                dao.insert(org);
            });
        }
    };

}
