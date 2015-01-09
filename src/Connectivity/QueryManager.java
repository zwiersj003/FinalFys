package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Baggage;
import model.CreateAccount;
import model.Customerinfo;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.jdbc.JDBCPieDataset;

public class QueryManager {

    private final Dbmanager dbmanager;

    public QueryManager(Dbmanager dbmanager) {
        this.dbmanager = dbmanager;
    }

    public CreateAccount Login(String _username, String _password) {
        String Accounttype = "";
        String password = "";
        String name = "";
        String adress = "";
        String city = "";
        String postal = "";
        String country = "";
        String email = "";

        CreateAccount createaccount = new CreateAccount("", false, "", "", "", "", "", "", "", "", "");

        try {
            String sql = "SELECT passwordd, accounttype FROM createaccount WHERE username ='" + _username + "'";
            ResultSet result = dbmanager.doQuery(sql);

            while (result.next()) {
                password = result.getString("passwordd");
                Accounttype = result.getString("accounttype");
//                name = result.getString("name");
//                adress = result.getString("adress");
//                city = result.getString("city");
//                postal = result.getString("postal");
//                country = result.getString("country");
//                email = result.getString("email");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            if (password.equals(_password)) {
                createaccount.succes = true;
                createaccount.accounttype = Accounttype;
                createaccount.username = _username;
            }
        }
        return createaccount;
    }

    public void insertBaggage(Baggage baggage) {
        String sql = "INSERT INTO baggage(baggageId, collor,  weight, brand,  description,  materials, department, status, flightnr, CustomerName, Adress, ShippingAdress, City, Postal, Country, Email)"
                + "VALUES('" + baggage.baggageId + "','" + baggage.color + "','" + baggage.weight + "','" + baggage.brand + "','" + baggage.description + "','" + baggage.materials + "','" + baggage.department + "','" + baggage.status + "','" + baggage.flightnr + "','" + baggage.CustomerName + "','" + baggage.Adress + "','" + baggage.ShippingAdress + "','" + baggage.City + "','" + baggage.Postal + "','" + baggage.Country + "','" + baggage.Email + "')";
        System.out.println(sql);
        int luggage_id = 0;
        try {
            ResultSet result = dbmanager.insertQuery(sql);
            result.next();
            luggage_id = result.getInt(1);
            System.out.println(luggage_id);
//            System.out.println(result);
        } catch (SQLException e) {
            System.out.println("FOUT" + e.getMessage());
        }

    }

    public void insertcutomerinfo(Customerinfo customerinfo) {
        String sql = "INSERT INTO customerinfo(CustomerName, Adress, shippingAdress,City,Postal,Country, Email)"
                + "VALUES('" + customerinfo.Name + "','" + customerinfo.Adress + "','" + customerinfo.shippingAdress + "','" + customerinfo.City + "','" + customerinfo.Postal + "','" + customerinfo.Country + "','" + customerinfo.Email + "')";
        System.out.println(sql);
        int luggage_id = 0;
        try {
            ResultSet result = dbmanager.insertQuery(sql);
            result.next();
            luggage_id = result.getInt(1);
            System.out.println(luggage_id);

        } catch (SQLException e) {

            System.out.println("FOUT" + e.getMessage());
        }

    }

    public void insertcreateaccount(CreateAccount createaccount) {
        String sql = "INSERT INTO createaccount(username,passwordd,accounttype,name,adress,city,postal,country,email)"
                + "VALUES('" + createaccount.username + "','" + createaccount.passwordd + "','" + createaccount.accounttype + "','" + createaccount.name + "','" + createaccount.adress + "','" + createaccount.city + "','" + createaccount.postal + "','" + createaccount.country + "','" + createaccount.email + "')";
        System.out.println(sql);
        int luggage_id = 0;
        try {
            ResultSet result = dbmanager.insertQuery(sql);
            result.next();
            luggage_id = result.getInt(1);
            System.out.println(luggage_id);

        } catch (SQLException e) {

            System.out.println("FOUT" + e.getMessage());
        }
    }

    public void GetAccountinfo(CreateAccount account) {
        String sql = "SELECT username, adress country FROM createaccount";
        System.out.println(sql);
        int luggage_id = 0;
        try {
            ResultSet result = dbmanager.insertQuery(sql);
            result.next();
            luggage_id = result.getInt(1);
            System.out.println(luggage_id);

        } catch (SQLException e) {

            System.out.println("FOUT" + e.getMessage());
        }

    }

    public ArrayList<Customerinfo> getCustomersinfoo(String sql) {
        ArrayList<Customerinfo> cil = new ArrayList();
        Customerinfo ci;

        try {
            System.out.println(sql);
            ResultSet result = dbmanager.doQuery(sql);

            while (result.next()) {
                cil.add(ci = new Customerinfo(result.getString("CustomerName"), result.getString("Adress"), result.getString("shippingAdress"), result.getString("City"), result.getString("Postal"), result.getString("Country"), result.getString("Email")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }

        return cil;
    }

    public ArrayList<Baggage> getBaggage(String sql) {
        ArrayList<Baggage> ld = new ArrayList();
        Baggage lg;

        try {
            System.out.println(sql);
            ResultSet result = dbmanager.doQuery(sql);

            while (result.next()) {
                ld.add(lg = new Baggage(result.getString("baggageId"), result.getString("department"), result.getString("collor"), result.getString("weight"), result.getString("brand"), result.getString("materials"), result.getString("description"), result.getString("status"), result.getString("flightnr"), result.getString("CustomerName"),result.getString("Adress"),result.getString("ShippingAdres"),result.getString("City"),result.getString("Postal"),result.getString("Country"),result.getString("Email")));
            }
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e);
        }

        return ld;
    }

    public ArrayList<CreateAccount> getUsers(String query) {
        ArrayList<CreateAccount> udl = new ArrayList();
        CreateAccount ud;
        String sql = query;
        System.out.println(sql);
        ResultSet result = dbmanager.doQuery(sql);
        try {

            while (result.next()) {
                udl.add(ud = new CreateAccount("Onzin", false, result.getString("username"), result.getString("passwordd"), result.getString("accounttype"), result.getString("name"), result.getString("adress"), result.getString("city"), result.getString("postal"), result.getString("country"), result.getString("Email")));

            }
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e);

            System.out.println("connectivity.QueryManager.msdfn,smdfn,dsmfnsd,mfn() Exception:" + e.getMessage());
        }
        return udl;
    }

    public void deleteUser(int id) {
        String sql = "DELETE FROM createaccount WHERE id = " + id + "";
        System.out.println(sql);
        int order_id = 1;

        try {
            ResultSet result = dbmanager.insertQuery(sql);
            result.next();
            order_id = result.getInt(1);
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e);

            System.out.println("connectivity.QueryManager.setOrder() Exception:" + e.getMessage());
        }
    }

    public void updateUser(String username, String password) {
        String sql = "UPDATE createaccount SET username = '" + username + "', password = '" + password + " where username = " + username + "";
        System.out.println(sql);
        int order_id = 0;

        try {
            ResultSet result = dbmanager.insertQuery(sql);
            result.next();
            order_id = result.getInt(1);
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e);

            System.out.println("connectivity.QueryManager.updateUser() Exception:" + e.getMessage());
        }
    }

    public CreateAccount getCustomer(String id) {
        CreateAccount customerInfo = new CreateAccount("", false, "", "", "", "", "", "", "", "", "");

        try {
            String sql = "SELECT *FROM createaccount WHERE userid ='" + id + "'";
            ResultSet result = dbmanager.doQuery(sql);

            while (result.next()) {

                customerInfo.userid = id;
                customerInfo.name = result.getString("name");
                customerInfo.adress = result.getString("adress");
                customerInfo.city = result.getString("city");
                customerInfo.postal = result.getString("postal");
                customerInfo.country = result.getString("country");
                customerInfo.email = result.getString("email");

            }
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e);
        }
        return customerInfo;
    }

    public JDBCPieDataset pieChart() {
        Dbmanager dbm = new Dbmanager();
        QueryManager qm = new QueryManager(dbm);
        //Open database connection

        Connection conn = dbm.openConnection();

        String query = "SELECT status, count(*) FROM baggage GROUP BY status";

        JDBCPieDataset pieDataset = null;
        try {
            pieDataset = new JDBCPieDataset(conn, query);
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pieDataset;
    }

    public void monthGraphic() {
        try {
            int[] aantalLost = new int[11];

            String query = "SELECT status, count(*) FROM bagage GROUP BY status";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
