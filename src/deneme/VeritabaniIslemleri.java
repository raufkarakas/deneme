/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deneme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rkarakas
 */
public class VeritabaniIslemleri {
    private Connection con = null;
    String veritabaniURL;
    String kullaniciAdi;
    String sifre;
    
    public VeritabaniIslemleri() {
        this.veritabaniURL = "jdbc:derby://localhost:1527/Alivelikonya";
        this.kullaniciAdi = "";
        this.sifre = "";
    }
    
    public VeritabaniIslemleri(String url,String kullaniciAdi, String sifre) {
        this.veritabaniURL = url;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
    }
    
    public void baglan() throws Exception {
        //Eger baglanti varsa true gonder
        if ((con != null)) {
            if (con.isClosed() == false) {
                return;
            }
        }
        //Baglanti yoksa yeniden olustur
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = (Connection) DriverManager.getConnection(
                this.veritabaniURL, this.kullaniciAdi, this.sifre);
    }
    
    public void baglantiyiKes() throws SQLException {
        if (con != null) {
            if (!con.isClosed()) {
                con.close();
            }
        }
    }
    /**
     * 
     * @return
     * @throws SQLException 
     */
    public List<Personel> tumPersonelleriGetir() throws SQLException{

        String sorgu = "SELECT * FROM APP.PERSONEL";
        ResultSet rs;
        List <Personel> personelList;
        try (PreparedStatement pstmt = con.prepareStatement(sorgu)) {
            rs = pstmt.executeQuery();
            personelList = null;
            if(rs.next()){
                personelList = new ArrayList<>();
            }   rs.beforeFirst();
            while (rs.next()) {
                Personel p = new Personel();
                p.setId(rs.getInt("APP.ID"));
                p.setAd(rs.getString("APP.AD"));
                personelList.add(p);
            }
        }
        rs.close();
        return personelList;
    }
}
