package raildrawer.com.sqllitecrud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ved-pc on 10/2/2017.
 */

public class EmployeeDBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "employees.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_EMPLOYEES = "employees";
    public static final String COLUMN_ID = "empId";
    public static final String COLUMN_FIRST_NAME = "firstname";
    public static final String COLUMN_LAST_NAME = "lastname";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_HIRE_DATE= "hiredata";
    public static final String COLUMN_DEPT= "dept";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_EMPLOYEES + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FIRST_NAME + " TEXT, " +
                    COLUMN_LAST_NAME + " TEXT, " +
                    COLUMN_GENDER + " TEXT, " +
                    COLUMN_HIRE_DATE + " NUMERIC, " +
                    COLUMN_DEPT + " TEXT " +
                    ")";


    public EmployeeDBHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_EMPLOYEES);
        db.execSQL(TABLE_CREATE);
    }
}
