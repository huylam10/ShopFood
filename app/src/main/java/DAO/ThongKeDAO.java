package DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import DATABASE.DataBase;
import Model.SanPham;
import Model.Top;

public class ThongKeDAO {
    DataBase dataBase;
    SQLiteDatabase db;

    String ProductId = "ProductId";
    String table_ChiTietDH = "ChiTietDatHang";
    String table_DatHang = "DatHang";
    String Created = "Created";
    String toTalPrice = "TotalPrice";

    public ThongKeDAO(Context context){
        dataBase = new DataBase(context);
        db = dataBase.getReadableDatabase();
    }

    public List<SanPham> getTop(){
        List<SanPham> list = new ArrayList<>();
        String sql = " SELECT SanPham.*,SUM(amount) AS SUM FROM ChiTietDatHang " +
                "JOIN DatHang ON DatHang.Id = ChiTietDatHang.OderId " +
                "JOIN SanPham ON ChiTietDatHang.ProductID = SanPham.Id " +
                "WHERE DatHang.status = 5 GROUP BY productid ORDER BY SUM DESC LIMIT 10";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            list.add(new SanPham(cursor.getInt(0),
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

    public List<Top> getTopSP(String  tuNgay,String denNgay) {
        List<Top> list = new ArrayList<>();
        String sql = "SELECT ChiTietDatHang.ProductId, SUM(ChiTietDatHang.Amount) AS SUM FROM ChiTietDatHang " +
                "JOIN DatHang ON ChiTietDatHang.OderId = DatHang.Id " +
                "JOIN SanPham ON SanPham.Id = ChiTietDatHang.ProductId " +
                "WHERE DatHang.Status = 5 AND (DATE(DatHang.Updated) BETWEEN ? AND ?) " +
                "GROUP BY productid ORDER BY SUM DESC";
        Cursor cursor = db.rawQuery(sql, new String[]{tuNgay, denNgay});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            list.add(new Top(cursor.getInt(0),
                    cursor.getInt(1)));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public int getDoanhThu(String tuNgay, String denNgay){
        String sql = "SELECT SUM(TotalPrice) AS doanhthu FROM DatHang WHERE (DATE(Created) BETWEEN ? AND ?) AND Status = 5";
        List<Integer> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, new String[]{tuNgay, denNgay});
        cursor.moveToFirst();
        if (cursor.getCount() != 0){
            cursor.moveToNext();
            return cursor.getInt(0);
        }
        cursor.close();
        return 0;
    }
}
