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
    public String CREATE_QUERY = "CREATE TABLE " + TableData.TableInfo.TABLE_NAME+" ("+
            TableData.TableInfo.USER_NAME+" TEXT,"+ TableData.TableInfo.USER_PASS+" TEXT);";


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

    public void putInformation(DataBaseOperations dop, String username, String password){
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.USER_NAME, username);
        cv.put(TableData.TableInfo.USER_PASS, password);
        long k = SQ.insert(TableData.TableInfo.TABLE_NAME, null, cv);
        Log.d("Database operations", "One row inserted");

    }

    public Cursor getInformation(DataBaseOperations dop){
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] columns = {TableData.TableInfo.USER_NAME, TableData.TableInfo.USER_PASS};
        Cursor cursor = SQ.query(TableData.TableInfo.TABLE_NAME, columns, null, null, null, null, null);
        return cursor;
    }



}
