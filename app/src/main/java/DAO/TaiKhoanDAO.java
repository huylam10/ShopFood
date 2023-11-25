package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import DATABASE.DataBase;
import Model.TaiKhoan;

public class TaiKhoanDAO {
    SQLiteDatabase db;
    DataBase dataBase;
    SharedPreferences sharedPreferences;

    public TaiKhoanDAO(Context context){
        dataBase = new DataBase(context);
        db = dataBase.getWritableDatabase();
        sharedPreferences = context.getSharedPreferences("OKOK", Context.MODE_PRIVATE);
    }

    public ArrayList<TaiKhoan> getDSNV(){
        ArrayList<TaiKhoan> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dataBase.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT *FROM TaiKhoan Where Roled=2", null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new TaiKhoan(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3)));
            } while (cursor.moveToNext());
        }
        return list;
    }

    public List<TaiKhoan> getAllTaiKhoan(String sql, String... select){
        List<TaiKhoan> list = new ArrayList<>();
        db = dataBase.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, select);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            TaiKhoan taiKhoan = new TaiKhoan();
            taiKhoan.setId(cursor.getInt(0));
            taiKhoan.setUsername(cursor.getString(1));
            taiKhoan.setPassword(cursor.getString(2));
            taiKhoan.setRole(cursor.getInt(3));
            cursor.moveToNext();
            list.add(taiKhoan);
        }
        cursor.close();
        return list;
    }

    public  boolean insertTaiKhoan(TaiKhoan taiKhoan){
        db = dataBase.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("UserName", taiKhoan.getUsername());
        values.put("PassWord", taiKhoan.getPassword());
        values.put("Role", taiKhoan.getRole());
        Long row =db.insert("TaiKhoan",null, values);
        return row > 0;
    }
}
