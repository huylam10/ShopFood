package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import DATABASE.DataBase;
import Model.LoaiSanPham;

public class LoaiSanPhamDAO {
    DataBase dataBase;

    public LoaiSanPhamDAO(Context context){
        dataBase = new DataBase(context);
    }

    public ArrayList<LoaiSanPham> getDSLoaiSanPham(){
        ArrayList<LoaiSanPham> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dataBase.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM  LoaiSanPham", null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new LoaiSanPham(
                        cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getInt(6)));
            } while (cursor.moveToNext());
        }
        return list;
    }

    public ArrayList<LoaiSanPham> getDSLoaiSanPham(String sql, String...select){
        ArrayList<LoaiSanPham> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dataBase.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, select);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new LoaiSanPham(
                        cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getInt(6)));
            } while (cursor.moveToNext());
        }
        return list;
    }

    public boolean themLoaiSanPham(LoaiSanPham loaiSanPham){
        SQLiteDatabase sqLiteDatabase = dataBase.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Idcuahang", loaiSanPham.getIdCuahang());
        contentValues.put("Name", loaiSanPham.getNameLoaiSanPham());
        contentValues.put("Image", loaiSanPham.getImageLoaiSanPham());
        contentValues.put("Created", loaiSanPham.getCreatedLoaiSanPham());
        contentValues.put("Updated", loaiSanPham.getUpdatedLoaiSanPham());
        contentValues.put("Status", loaiSanPham.getStatusLoaiSanPham());
        long check = sqLiteDatabase.update("LoaiSanPham", contentValues, "Id=?", new String[]{String.valueOf(loaiSanPham.getId())});
        if (check == -1)
            return false;
        return true;
    }

    public boolean deleteLoaiSanPham(String id){
        SQLiteDatabase sqLiteDatabase = dataBase.getWritableDatabase();
        int row =sqLiteDatabase.delete("LoaiSanPham", "id=?", new String[]{id});
        if (row > 0){
            return true;
        }
        return false;
    }

    public LoaiSanPham getID(String id){
        String sql = "SELECT * FROM LoaiSanPham WHERE id=?";
        ArrayList<LoaiSanPham> list = getDSLoaiSanPham(sql,id);
        return list.get(0);
    }

    public ArrayList<LoaiSanPham> getAll(){
        String sql ="SELECT * FROM LoaiSanPham";
        return getDSLoaiSanPham(sql);
    }
}
