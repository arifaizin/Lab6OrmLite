package id.co.imastudio.lab6ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by idn on 1/24/2018.
 */

public class DbHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "anggota.db";
    private static final int DATABASE_VERSION = 1;
    private Context context;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, ModelAnggota.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, ModelAnggota.class, true);
            onCreate(database);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Dao<ModelAnggota, Integer> anggotaDao;
    //crud
    public Dao<ModelAnggota, Integer> getAnggotaDao(){
        if (anggotaDao == null){
            try {
                anggotaDao = getDao(ModelAnggota.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return anggotaDao;
    }

    public int tambahData(ModelAnggota anggota){
        try {
            return getAnggotaDao().create(anggota);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<ModelAnggota> ambilData(){
        try {
            return getAnggotaDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int editData(ModelAnggota anggota) {
        try {
            return getAnggotaDao().update(anggota);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int hapusData(int dataId) {
        try {
            return getAnggotaDao().deleteById(dataId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
