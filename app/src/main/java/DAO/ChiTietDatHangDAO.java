package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import DATABASE.DataBase;
import Model.ChiTietDatHang;

public class ChiTietDatHangDAO {
    private SQLiteDatabase db;

    DataBase dataBase;

    public ChiTietDatHangDAO(Context context) {
        dataBase = new DataBase(context);
        db = dataBase.getReadableDatabase();
    }

    public ArrayList<ChiTietDatHang> getDSChiTietDatHang() {
        ArrayList<ChiTietDatHang> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM ChiTietDatHang", null);

        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new ChiTietDatHang(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4)));
            } while (cursor.moveToNext());
        }
        return list;
    }

    public boolean ThemChiTietDatHang(ChiTietDatHang chiTietDatHang) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("OderId", chiTietDatHang.getIdDatHang());
        contentValues.put("ProductId", chiTietDatHang.getProductid());
        contentValues.put("UnitPrice", chiTietDatHang.getUnitprice());
        contentValues.put("Amount", chiTietDatHang.getAmount());
        long check = db.insert("ChiTietDatHang", null, contentValues);
        if (check == -1)
            return false;
        return true;
    }

    public boolean CapNhapChiTietDatHang(ChiTietDatHang chiTietDatHang) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("OderId", chiTietDatHang.getIdDatHang());
        contentValues.put("ProductId", chiTietDatHang.getProductid());
        contentValues.put("UnitPrice", chiTietDatHang.getUnitprice());
        contentValues.put("Amount", chiTietDatHang.getAmount());
        long check = db.update("ChiTietDatHang", contentValues, "Id =?", new String[]{String.valueOf(chiTietDatHang.getId())});
        if (check == -1)
            return false;
        return true;
    }

    public int XoaChiTietDatHang(ChiTietDatHang chiTietDatHang) {
        long check = db.delete("ChiTietDatHang", "Id = ?", new String[]{String.valueOf(chiTietDatHang.getId())});
        if (check == -1)
            return 0;
        return 1;
    }

    public List<ChiTietDatHang> getListCT(int idDatHang) {
        List<ChiTietDatHang> list = new ArrayList<>();
        String sql = "select * from ChiTietDatHang where OderId =?";
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(idDatHang)});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            int id = cursor.getInt(0);
            int idDathang = cursor.getInt(1);
            int productid = cursor.getInt(2);
            float unitprice = cursor.getFloat(3);
            float amount = cursor.getFloat(4);

            ChiTietDatHang chiTietDatHang = new ChiTietDatHang(id, idDathang, productid, unitprice, amount);
            list.add(chiTietDatHang);

            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<ChiTietDatHang> checkCart(int idDatHang, int IdSP) {
        List<ChiTietDatHang> list = new ArrayList<>();
        String sql = "select * from ChiTietDatHang where OderId =? and ProductId =?";
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(idDatHang), String.valueOf(IdSP)});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            int id = cursor.getInt(0);
            int idDathang = cursor.getInt(1);
            int productid = cursor.getInt(2);
            float unitprice = cursor.getFloat(3);
            float amount = cursor.getFloat(4);

            ChiTietDatHang chiTietDatHang = new ChiTietDatHang(id, idDathang, productid, unitprice, amount);
            list.add(chiTietDatHang);

            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public int getSum(int idDatHang) {
        String sql = "SELECT SUM(Amount) AS sum from ChiTietDatHang WHERE OderId =?";
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(idDatHang)});
        cursor.moveToFirst();
        Log.e("IDdatHang", "getSum: " + idDatHang);
        Log.e("Sum", "getSum: " + cursor.getInt(cursor.getColumnIndex("sum")));
        return cursor.getInt(0);
    }
}
