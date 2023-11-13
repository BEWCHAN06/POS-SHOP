package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import ConnectDB.KetNoiSQL;
import entity.MauSac;
import entity.TaiKhoan;

public class loginDAO {
	
	public int getTaiKhoan(String tk,String mk){
        KetNoiSQL.getInstance();
        Connection conn = KetNoiSQL.getConnection();
        
        try {
            String sql = "select loaiTaiKhoan from TaiKhoan where tenTaiKhoan =(?) and matKhau = (?)";
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setString(1, tk);
            stmt.setString(2, mk);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
//                MauSac mauSac = new MauSac();
//                mauSac.setMaMauSac(rs.getString(1));
//                mauSac.setMauSac(rs.getString(2));
//                return mauSac;
            	return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MauSacDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
