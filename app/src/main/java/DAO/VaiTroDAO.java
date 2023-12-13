package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import DATABASE.DataBase;
import Model.VaiTro;

public class VaiTroDAO {
    DataBase dataBase;
    SQLiteDatabase db;

    public VaiTroDAO(Context context){
        dataBase = new DataBase(context);
        db = dataBase.getWritableDatabase();
    }

    public List<VaiTro>getAllVaiTro(String sql, String...select){
        List<VaiTro> list = new ArrayList<>();
        db = dataBase.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, select);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            VaiTro vaiTro = new VaiTro();
            vaiTro.setId(cursor.getInt(0));
            vaiTro.setNameVaiTro(cursor.getString(1));
            vaiTro.setDescriptionVaiTro(cursor.getString(2));
            vaiTro.setCreatedVaiTro(cursor.getString(3));
            vaiTro.setUpdatedVaiTro(cursor.getString(4));
            cursor.moveToNext();
            list.add(vaiTro);
        }
        cursor.close();
        return list;
    }

    public boolean insertVaiTro(VaiTro vaiTro){
        db = dataBase.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", vaiTro.getNameVaiTro());
        contentValues.put("Description", vaiTro.getDescriptionVaiTro());
        contentValues.put("Created", vaiTro.getDescriptionVaiTro());
        contentValues.put("Updated", vaiTro.getUpdatedVaiTro());
        long row = db.insert("VaiTro", null, contentValues);
        return row > 0;
    }
}
