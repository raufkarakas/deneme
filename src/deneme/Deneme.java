/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deneme;

/**
 *
 * @author rkarakas
 */
public class Deneme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        VeritabaniIslemleri vi = new VeritabaniIslemleri();
        vi.baglan();
        vi.tumPersonelleriGetir();
        vi.baglantiyiKes();
    }
    
}
