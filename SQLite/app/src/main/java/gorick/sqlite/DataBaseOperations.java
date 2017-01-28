package gorick.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by sg-0036936 on 25/01/2017.
 */

public class DataBaseOperations extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public String CREATE_QUERY = "CREATE TABLE " + TableData.TableInfo.TABLE_NAME + " (" +
            TableData.TableInfo.USER_NAME + " TEXT," + TableData.TableInfo.USER_PASS + " TEXT);";

    UserModel userModel;
    DataBaseOperations dataBaseOperations;


    public DataBaseOperations(Context context) {
        super(context, TableData.TableInfo.DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database operations", "Database created");
    }

    public DataBaseOperations(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addUser(UserModel userModel) {
        SQLiteDatabase SQ = dataBaseOperations.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.USER_NAME, userModel.getUsername());
        cv.put(TableData.TableInfo.USER_PASS, userModel.getPassword());
        long k = SQ.insert(TableData.TableInfo.TABLE_NAME, null, cv);
        Log.d("Database operations", "One row inserted");
    }

    public int checkUser(UserModel user) {
        int id = -1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id FROM user WHERE name=? AND password=?", new String[]{user.getUsername(), user.getPassword()});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            id = cursor.getInt(0);
            cursor.close();
        }
        return id;
    }
}



