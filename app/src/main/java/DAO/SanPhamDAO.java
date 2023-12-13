package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import DATABASE.DataBase;
import Model.SanPham;

public class SanPhamDAO {
    DataBase dataBase;

    public SanPhamDAO(Context context){
        dataBase = new DataBase(context);
    }

    public ArrayList<SanPham> getDSSanPham(){
        ArrayList<SanPham> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dataBase.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM SanPham", null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new SanPham(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getInt(7)));
            } while (cursor.moveToNext());
        }
        return list;
    }

    public boolean themSanPham(SanPham sanPham){
        SQLiteDatabase sqLiteDatabase = dataBase.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", sanPham.getNameSanPham());
        contentValues.put("Image", sanPham.getImageSanPham());
        contentValues.put("Price", sanPham.getPriceSanPham());
        contentValues.put("TypeproDuct", sanPham.getLoaiSanPham());
        contentValues.put("Created", sanPham.getCreatedSanPham());
        contentValues.put("Updated", sanPham.getUpdatedSanPham());
        contentValues.put("Status", sanPham.getStatusSanPham());
        long check = sqLiteDatabase.insert("SanPham", null, contentValues);
        if (check == -1)
            return false;
        return true;
    }

    public boolean xoaSanPham(String Id){
        SQLiteDatabase sqLiteDatabase = dataBase.getWritableDatabase();
        long check = sqLiteDatabase.delete("SanPham", "Id=?", new String[]{String.valueOf(Id)});
        if (check > 0){
            return true;
        }
        return false;
    }

    public SanPham getID(int id){
        SQLiteDatabase sqLiteDatabase = dataBase.getWritableDatabase();
        String sql = "SELECT * FROM SanPham WHERE id=?";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, new String[]{String.valueOf(id)});

        cursor.moveToFirst();

        return new SanPham(cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getInt(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getInt(7));
    }

    public List<SanPham> getSpTT(int LoaiSP, int idSP){
        List<SanPham> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dataBase.getReadableDatabase();
        String sql = "SELECT * FROM SanPham WHERE TypeproDuct =? AND Id!=? ";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, new String[]{String.valueOf(LoaiSP), String.valueOf(idSP)});

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            list.add(new SanPham(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getInt(7)));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<SanPham> getListLoaiSP(int loaiSP){
        List<SanPham> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dataBase.getReadableDatabase();
        String sql = "SELECT * FROM SanPham WHERE TypeproDuct =?";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, new String[]{String.valueOf(loaiSP)});

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(new SanPham(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getInt(7)));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<SanPham> getListName(String name){
        List<SanPham> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dataBase.getReadableDatabase();
        String sql = "SELECT * FROM SanPham WHERE Name LIKE '%'||?||'%'";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, new String[]{String.valueOf(name)});

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            list.add(new SanPham(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getInt(7)));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<SanPham> getListMoney(int type){
        List<SanPham> list = new ArrayList<>();
        String text = "asc";
        if (type == 1){
            text="desc";
        }
        SQLiteDatabase sqLiteDatabase = dataBase.getReadableDatabase();
        String sql = "SELECT * FROM SanPham ORDER BY Price" + text;
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            list.add(new SanPham(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getInt(7)));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
