/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Klinik;
import util.NewHibernateUtil;


public class KlinikHelper {

    public List<Klinik> bacaKlinik() {
        List<Klinik> list = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Klinik k");
        list = q.list();
        tx.commit();
        session.close();
        return list;
    }

    public static String toJson() {
        KlinikHelper helper = new KlinikHelper();
        List<Klinik> list = helper.bacaKlinik();
        String result = "[";
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) {
                result = result + list.get(i).toJson() +",\n";
            } else {
                result = result + list.get(i).toJson() + "\n";
            }
        }
        result = result + "]";
        return result;
    }
}