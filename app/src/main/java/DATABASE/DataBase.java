package DATABASE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {

    static final String dbName ="FOODSTORE";
    static final int dbVersion = 1;

    public DataBase(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createTableTaiKhoan = "CREATE TABLE TaiKhoan(" +
                "Id INTEGER PRIMARY KEY," +
                "UserName TEXT NOT NULL," +
                "PassWord TEXT NOT NULL," +
                "Roled INTEGER REFERENCES VaiTro(Id))";
        sqLiteDatabase.execSQL(createTableTaiKhoan);

        String createTableVaiTro = "CREATE TABLE VaiTro(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name TEXT NOT NULL," +
                "Description TEXT NOT NULL," +
                "Created TEXT NOT NULL," +
                "Updated TEXT NOT NULL)";
        sqLiteDatabase.execSQL(createTableVaiTro);

        String createTableThongTinNguoiDung = "CREATE TABLE ThongTinNguoiDung(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "AccountId INTEGER REFERENCES TaiKhoan(Id)," +
                "FullName TEXT NOT NULL," +
                "Email TEXT NOT NULL," +
                "SDT TEST NOT NULL," +
                "Adress TEXT NOT NULL," +
                "Avatar TEXT NOT NULL," +
                "Birthday DATE NOT NULL," +
                "Gender INT NOT NULL," +
                "Created TEXT NOT NULL," +
                "Updated TEXT NOT NULL)";
        sqLiteDatabase.execSQL(createTableThongTinNguoiDung);

        String createTableDatHang = "CREATE TABLE DatHang(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "AccountId INTEGER REFERENCES TaiKhoan(Id)," +
                "TotalPrice FLOAT NOT NULL," +
                "Created TEXT NOT NULL," +
                "Updated TEXT NOT NULL," +
                "Status INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(createTableDatHang);

        String createTableChiTietDatHang = "CREATE TABLE ChiTietDatHang(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "OderId INTEGER REFERENCES DatHang(Id)," +
                "ProductId INTEGER NOT NULL," +
                "UnitPrice FLOAT NOT NULL," +
                "Amount INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(createTableChiTietDatHang);

        String createTableCuaHang = "CREATE TABLE CuaHang(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name TEXT NOT NULL," +
                "Image TEXT NOT NULL," +
                "Phone TEXT NOT NULL," +
                "Email TEXT NOT NULL," +
                "Adress TEXT NOT NULL," +
                "Created TEXT NOT NULL," +
                "Updated TEXT NOT NULL," +
                "Status TEXT NOT NULL)";
        sqLiteDatabase.execSQL(createTableCuaHang);

        String createTablLoaiSanPham = "CREATE TABLE LoaiSanPham(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "IdCuaHang INTEGER REFERENCES CuaHang(Id)," +
                "Name TEXT NOT NULL," +
                "Image TEXT NOT NULL," +
                "Created TEXT NOT NULL," +
                "Updated TEXT," +
                "Status INTEGER)";
        sqLiteDatabase.execSQL(createTablLoaiSanPham);

        String cteateTableSanPham = "CREATE TABLE SanPham(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name TEXT NOT NULL," +
                "Image TEXT NOT NULL," +
                "Price FLOAT NOT NULL," +
                "TypeproDuct INTEGER REFERENCES LoaiSanPham(Id)," +
                "Created TEXT NOT NULL," +
                "Updated TEXT," +
                "Status INTEGER)";
        sqLiteDatabase.execSQL(cteateTableSanPham);

        sqLiteDatabase.execSQL("INSERT INTO VaiTro VALUES(1, 'ADMIN', 'ADMIN', '24/11/2023', '24/11/2023'),(2, 'NHANVIEN', 'NHANVIEN', '24/11/2023', '24/11/2023'),(3, 'KHACHHANG', 'KHACHHANG', '24/11/2023', '24/11/2023')");
        sqLiteDatabase.execSQL("INSERT INTO TaiKhoan VALUES(1, 'ADMIN', '1', 1), (2, 'KH1', 'KH1', 3), (3, 'NV1', 'NV1', 2)");
        sqLiteDatabase.execSQL("INSERT INTO ThongTinNguoiDung VALUES(0,2,'huylam', 'null', '012345678', 'ThaiBinh', '700042', '15/10/2003', 'Name', '01/12/2023', '01/12/2023'), (1,4,'huylam', 'null', '012345678', 'HaNoi', '700042', '15/10/2003', 'Nu', '01/12/2023', '01/12/2023') ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String dropTableTaiKhoan = "DROP TABLE IF EXISTS TaiKhoan";
        sqLiteDatabase.execSQL(dropTableTaiKhoan);

        String dropTableVaiTro = "DROP TABLE IF EXISTS VaiTro";
        sqLiteDatabase.execSQL(dropTableVaiTro);

        String dropTableThongTinNguoiDung = "DROP TABLE IF EXISTS ThongTinNguoiDung";
        sqLiteDatabase.execSQL(dropTableThongTinNguoiDung);

        String dropTableCuaHang = "DROP TABLE IF EXISTS CuaHang";
        sqLiteDatabase.execSQL(dropTableCuaHang);

        String dropTableDatHang = "DROP TABLE IF EXISTS DatHang";
        sqLiteDatabase.execSQL(dropTableDatHang);

        String dropTableChiTietDatHang = "DROP TABLE IF EXISTS ChiTietDatHang";
        sqLiteDatabase.execSQL(dropTableChiTietDatHang);

        String dropTableLoaiSanPham = "DROP TABLE IF EXISTS LoaiSanPham";
        sqLiteDatabase.execSQL(dropTableLoaiSanPham);

        String dropTableSanPham = "DROP TABLE IF EXISTS SanPham";
        sqLiteDatabase.execSQL(dropTableSanPham);
        onCreate(sqLiteDatabase);
    }
}
