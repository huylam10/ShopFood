package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import DATABASE.DataBase;
import Model.ThongTinNguoiDung;

public class ThongTinNguoiDungDAO {

    DataBase dataBase;
    SQLiteDatabase db;
    SharedPreferences sharedPreferences;

    public ThongTinNguoiDungDAO(Context context){
        dataBase = new DataBase(context);
        db = dataBase.getReadableDatabase();
        sharedPreferences = context.getSharedPreferences("OKOK", Context.MODE_PRIVATE)
    }

    public List<ThongTinNguoiDung> getThongTinNguoDungs(){
        String sql = "SELECT * FROM ThongTinNguoiDung";
        return getData(sql);
    }

    public boolean themThongTinNguoiDung(ThongTinNguoiDung info){
        ContentValues contentValues = new ContentValues();
        contentValues.put("AccountId", info.getIdTaiKhoan());
        contentValues.put("FullName" , info.getFullName());
        contentValues.put("Email", info.getEmailNguoiDung());
        contentValues.put("SDT", info.getSDTNguoiDung());
        contentValues.put("Adress", info.getAdressNguoiDung());
        contentValues.put("Avatar", info.getAvatarNguoiDung());
        contentValues.put("Birthday", info.getBirthdayNguoiDung());
        contentValues.put("Gender", info.getGender());
        contentValues.put("Created", info.getCreatedNguoiDung());
        contentValues.put("Updated", info.getUpdatedNguoiDung());
        long check = db.insert("ThongTinNguoiDung", null, contentValues);
        if (check == -1)
            return false;
        return true;
    }

    public boolean capNhatThongTinNguoiDung(ThongTinNguoiDung info){
        ContentValues contentValues = new ContentValues();
        contentValues.put("AccountId", info.getIdTaiKhoan());
        contentValues.put("FullName", info.getFullName());
        contentValues.put("Email", info.getEmailNguoiDung());
        contentValues.put("SDT", info.getSDTNguoiDung());
        contentValues.put("Address", info.getAdressNguoiDung());
        contentValues.put("Birthday", info.getBirthdayNguoiDung());
        contentValues.put("Gender", info.getGender());
        contentValues.put("Created", info.getCreatedNguoiDung());
        contentValues.put("Updated", info.getUpdatedNguoiDung());
        long check = db.update("ThongTinNguoiDung", contentValues,"id=?", new String[]{String.valueOf(info.getId())});
        if (check == -1)
            return false;
        return true;
    }

    public boolean capNhatAnh(ThongTinNguoiDung info){
        ContentValues contentValues = new ContentValues();
        contentValues.put("Avatar", info.getAvatarNguoiDung());
        long check = db.update("ThongTinNguoiDung", contentValues, "Id=?", new String[]{String.valueOf(info.getId())});
        if (check == -1)
            return false;
        return true;
    }

    public int XoaThongTinNguoiDung(int id){
        Cursor cursor = db.rawQuery("SELECT * FROM ThongTinNguoiDung WHERE Id=?", new String[]{String.valueOf(id)});
        if (cursor.getCount() !=0){
            return -1;
        }
        long check = db.delete("ThongTinNguoiDung", "id=?", new String[]{String.valueOf(id)});
        if (check == -1)
            return 0;
        return 1;
    }

    public List<ThongTinNguoiDung> getData(){
        List<ThongTinNguoiDung> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM ThongTinNguoiDung", null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new ThongTinNguoiDung(cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getInt(8),
                        cursor.getString(9),
                        cursor.getString(10)));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public List<ThongTinNguoiDung> getData(String sql, String... selectionArgs){
        List<ThongTinNguoiDung> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new ThongTinNguoiDung(cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getInt(8),
                        cursor.getString(9),
                        cursor.getString(10)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public ThongTinNguoiDung getInfo(int id){
        String  sql = "SELECT * FROM ThongTinNguoiDung AccountId=?";
        return getData(sql, new String[]{String.valueOf(id)}).get(0);
    }
}
