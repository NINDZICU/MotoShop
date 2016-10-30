package ru.kpfu.repositories;

import ru.kpfu.models.DBWrapper;
import ru.kpfu.entites.Good;
import ru.kpfu.entites.User;
import ru.kpfu.interfaces.DataBaseInterface;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 21.09.2016.
 */
public class UserDataBase implements DataBaseInterface {
    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;

    public void addUser(User user) throws SQLException {
        conn = DBWrapper.getConection();
//         stmt = conn.createStatement();
        PreparedStatement st = conn.prepareStatement(
                "USE proga_database;" +
                        " INSERT INTO users (login, password, name, gender, country, aboutYourself, newsletter, favoriteSinger)" +
                        "VALUES (?, ?,?, ?, ?,?,?,?)");

        st.setString(1, user.getLogin());
        st.setString(2, user.getPassword());
        st.setString(3, user.getName());
        st.setString(4, user.getGender());
        st.setString(5, user.getCountry());
        st.setString(6, user.getAboutYourself());
        st.setString(7, user.getNewsletter());
        st.setString(8, user.getFavoriteSinger());
        st.execute();
    }




//    public void Writer(String[] message) throws IOException {
//
//        CSVWriter writer = new CSVWriter(new FileWriter("D:\\registration1.csv", true), ',');
//        writer.writeNext(message);
//        writer.flush();
//    }

    public boolean checkLogin(String login) throws IOException, SQLException {
        conn = DBWrapper.getConection();
        stmt = conn.createStatement();
        rs = stmt.executeQuery("USE proga_database " +
                "SELECT login FROM users WHERE login='" + login + "'");
        if (rs.next()) return true;
        else return false;

//        CSVReader reader = new CSVReader(new FileReader("D:\\registration1.csv"), ',');
//        String[] stringOfData;
//        while ((stringOfData = reader.readNext()) != null) {
//            if (stringOfData[0].equals(login)) return true;
//        }
//        return false;
    }

    public boolean checkLoginAndPassword(String login, String password) throws SQLException {
        conn = DBWrapper.getConection();
        stmt = conn.createStatement();
        rs = stmt.executeQuery("USE proga_database " +
                "SELECT login, password FROM users WHERE login='" + login + "' AND password='" + password + "'");
        if (rs.next()) return true;
        else return false;

    }

    public String getCity(HttpServletRequest req) throws IOException, SQLException {
        String login = (String) req.getSession().getAttribute("inputLogin");
        String city = "";

        conn = DBWrapper.getConection();
        stmt = conn.createStatement();
        rs = stmt.executeQuery("USE proga_database " +
                "SELECT * FROM users WHERE login='" + login + "'");
        while (rs.next()) {
            city = rs.getString("country");
        }
        return city;

//        String login = (String) req.getSession().getAttribute("inputLogin");
//        CSVReader reader = new CSVReader(new FileReader("D:\\registration1.csv"), ',');
//        String[] stringOfData;
//        while ((stringOfData = reader.readNext()) != null) {
//            if (stringOfData[0].equals(login)) {
//                return stringOfData[4];
//            }
//        }
//        return null;
    }

    public String getFavoriteSinger(HttpServletRequest req) throws IOException, SQLException {
        String login = (String) req.getSession().getAttribute("inputLogin");
        String favoriteSinger = "";
        conn = DBWrapper.getConection();
        stmt = conn.createStatement();
        rs = stmt.executeQuery("USE proga_database " +
                "SELECT * FROM users WHERE login='" + login + "'");
        while (rs.next()) {
            favoriteSinger = rs.getString("favoriteSinger");
        }
        return favoriteSinger;

//        CSVReader reader = new CSVReader(new FileReader("D:\\registration1.csv"), ',');
//        String[] stringOfData;
//        while ((stringOfData = reader.readNext()) != null) {
//            if (stringOfData[0].equals(login)) {
//                return stringOfData[7];
//            }
//        }
//        return null;
    }

}
