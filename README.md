### CÔNG NGHỆ
LOADING
### CONNECT DATABASE
```java
package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KetNoiSQL {
    private static Connection conn = null;
    private static KetNoiSQL instance = new KetNoiSQL();
    
    public static KetNoiSQL getInstance(){  
        return instance;
    }
    
     public void connect(){
        String url = "jdbc:sqlserver://localhost:1433;database=Postshop";
        String username = "sa";
        String password = "sapassword";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection(){
        return conn;
    }

}

```
### GD MANG HINH
- GD LOGIN 
<img src="POS SHOP/GD/HAGD/login.png" alt="">

- GD CHÍNH
<img src="POS SHOP/GD/HAGD/giaodienchinh.png" alt="">
</br>

- GD BÁN HÀNG
<img src="POS SHOP/GD/HAGD/Bán Hàng .png" alt="">

- GD ĐỔI TRẢ
<img src="POS SHOP/GD/HAGD/TraHang.png" alt="">

- GD SẢN PHẨM
<img src="POS SHOP/GD/HAGD/SanPham.png" alt="">

- GD THUỘC TÍNH 
<img src="POS SHOP/GD/HAGD/Thêm Thuộc Tính.png" alt="">

- GD HÓA ĐƠN  
<img src="POS SHOP/GD/HAGD/HoaDon.png" alt="">

- GD KHUYẾN MÃI
<img src="POS SHOP/GD/HAGD/khuyenMai.png" alt="">

- GD Nhân Viên
<img src="POS SHOP/GD/HAGD/NhanVien.png" alt="">

- GD Tài Khoản
<img src="POS SHOP/GD/HAGD/Tài Khoản.png" alt="">

- GD Khách Hàng
<img src="POS SHOP/GD/HAGD/KhachHang.png" alt="">

- GD Thống Kê
<img src="POS SHOP/GD/HAGD/ThongKe.png" alt="">

- GD Thống Kê
<img src="POS SHOP/GD/HAGD/TKDOITRA.png" alt="">