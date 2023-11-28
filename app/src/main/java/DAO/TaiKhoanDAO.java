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
        values.put("Roled", taiKhoan.getRole());
        Long row =db.insert("TaiKhoan",null, values);
        return row > 0;
    }

    public int deleteTaiKhoan(String id){
        db = dataBase.getWritableDatabase();
        int row = db.delete("TaiKhoan", "Id=?", new String[]{id});
        return row;
    }

//    public List<TaiKhoan> getAll{
//        String sql ="SELECT * FROM TaiKhoan";
//        return getAllTaiKhoan(sql);
//    }

    public TaiKhoan getName(String name){
        String sql = "SELECT * FROM TaiKhoan WHERE UserName=?";
        List<TaiKhoan> list = getAllTaiKhoan(sql, new String[]{name});
        if (list.size() == 0)
            return null;
        return list.get(0);
    }

    public boolean checkDangNhapkh(String UserName, String PassWord){
        SQLiteDatabase sqLiteDatabase = dataBase.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT tk.Id, tk.UserName, tk.PassWord, tk.Roled, tt.FullName, tt.Avatar FROM TaiKhoan tk, ThongTinNguoiDung tt WHERE tk.Id = tt.AccountId AND UserName = ? AND PassWord = ? AND Roled = 3", new String[]{UserName, PassWord});
        if (cursor.getCount() != 0){
            cursor.moveToFirst();

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Id", cursor.getString(0));
            editor.putString("UserName", cursor.getString(1));
            editor.putString("PassWord", cursor.getString(2));
            editor.putString("Roled", cursor.getString(3));
            editor.putString("FullName", cursor.getString(4));
            editor.putString("Avatar", cursor.getString(5));
            editor.commit();
            return true;
        }else {
            return false;
        }
    }

    public  boolean checkDangNhapkhNVAD(String UserName, String PassWord){
        SQLiteDatabase sqLiteDatabase = dataBase.getReadableDatabase();
        TaiKhoan taiKhoan;
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM TaiKhoan WHERE UserName = ? AND PassWord = ? AND Roled != 3", new String[]{UserName, PassWord});
        if (cursor.getCount() != 0){
            return true;
        } else {
            return false;
        }
    }

    public int capnhatMatKhau(String username, String oldPass, String newPass){
        db = dataBase.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM TaiKhoan WHERE Id =?  AND PassWord", new String[]{username, oldPass});
        if (cursor.getCount() > 0){
            ContentValues values = new ContentValues();
            values.put("PassWord", newPass);
            long check = db.update("TaiKhoan", values, "Id = ?", new String[]{username});

            if (check == -1)
                return -1;
            return 1;
        }
        return 0;
    }
}


