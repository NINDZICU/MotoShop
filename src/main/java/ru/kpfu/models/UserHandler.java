package ru.kpfu.models;

import ru.kpfu.entites.User;
import ru.kpfu.repositories.UserDataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Admin on 30.09.2016.
 */
public class UserHandler {
    private UserDataBase db = new UserDataBase();
    private String name = "";
    private String login = "";
    private String password;
    private String repassword;
    private String gender = "-1";
    private String country;
    private String aboutYourself = "";
    private String newsletter;
    private String favoriteSinger;
    private String inputLogin;
    boolean check;


    public boolean checkError(HttpServletRequest req) throws IOException, SQLException {
        check = false;
        String[] data = new String[8];
        name = req.getParameter("fullname");
        login = req.getParameter("login");
        password = req.getParameter("password");
        repassword = req.getParameter("repassword");
        gender = req.getParameter("gender");
        country = req.getParameter("country");
        aboutYourself = req.getParameter("aboutYourself");
        newsletter = req.getParameter("newsletter");
        favoriteSinger = req.getParameter("loveSinger");

        req.setAttribute("name", this.name);
        req.setAttribute("about", aboutYourself);
        req.setAttribute("login", login);
        req.setAttribute("gender", gender);
        req.setAttribute("loveSinger", favoriteSinger);


        if (name.equals("")) {
            check = true;
            req.setAttribute("errorMessageName", " Enter the name <br>");
        }
        if (!name.matches("^[a-zA-Z\\s{,2}]{0,50}$")) {
            check = true;
            req.setAttribute("errorMessageName", " Name must contain valid characters<br>");
        }
        if (!login.matches("^[a-zA-Z0-9_.-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,8}$")) {
            check = true;
            req.setAttribute("errorMessageLogin", " Login must contain valid characters and have a length from 11 to 30<br>");
        }
        else if (db.checkLogin(login)) {
            check = true;
            req.setAttribute("errorMessageLogin", " This login already taken <br>");
        }

        if (password.length() < 6) {
            check = true;
            req.setAttribute("errorMessagePassword", " The password must be at least 6 characters <br>");
        }
        if (!password.equals(repassword)) {
            check = true;
            req.setAttribute("errorMessagePassword", " Passwords don't match");
        }
        try {
            if (!(req.getAttribute("gender").equals("0") || req.getAttribute("gender").equals("1"))) {
                check = true;
                req.setAttribute("errorMessageGender", "              Select gender");
            }
        } catch (NullPointerException e) {
            check = true;
            req.setAttribute("errorMessageGender", "              Select gender");
        }

        if (!check) {
            User user = new User(login, password, name, gender, country, aboutYourself, newsletter, favoriteSinger);
            db.addUser(user);
            HttpSession session = req.getSession();
            session.setAttribute("inputLogin", login);
            session.setMaxInactiveInterval(20 * 60);

//            data[0] = login;
//            data[1] = password;
//            data[2] = name;
//            data[3] = gender;
//            data[4] = country;
//            data[5] = aboutYourself;
//            data[6] = newsletter;
//            data[7] = favoriteSinger;
//
//            db.Writer(data);
            return check;
        } else {
            return check;
        }
    }

    public void updatePage(HttpServletResponse resp) throws IOException {

    }

    public boolean checkDataForAutentification(HttpServletRequest req) throws IOException {
        login = req.getParameter("inputLogin");
        password = req.getParameter("inputPassword");
        req.setAttribute("login", login);
        try {
            if (db.checkLoginAndPassword(login, password)) {
                HttpSession session = req.getSession();
                session.setAttribute("inputLogin", login);
                session.setMaxInactiveInterval(20 * 60);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        CSVReader reader = new CSVReader(new FileReader("D:\\registration1.csv"), ',');
//
//        String[] stringOfData;
//        while ((stringOfData = reader.readNext()) != null) {
//            if (stringOfData[0].equals(login) && stringOfData[1].equals(password)) {
//                HttpSession session = req.getSession();
//                session.setAttribute("inputLogin", login);
//                session.setMaxInactiveInterval(20 * 60);
//
//                return true;
//            }
//        }
        req.setAttribute("inputErrorMessage", "Incorrect login or password!");
        return false;
    }

    public boolean checkSession(HttpServletRequest req) throws IOException {
        if (req.getSession().getAttribute("inputLogin") != null) return true;
        else return false;
    }

    public String getLogin() {
        return login;
    }

    //    public String getCity(HttpServletRequest req) throws IOException {
//        String login = (String) req.getSession().getAttribute("inputLogin");
//
//        CSVReader reader = new CSVReader(new FileReader("D:\\registration1.csv"), ',');
//        String[] stringOfData;
//        while ((stringOfData = reader.readNext()) != null) {
//            if (stringOfData[0].equals(login)) {
//                return stringOfData[4];
//            }
//        }
//        return null;
//    }
//
//    public String getFavoriteSinger(HttpServletRequest req) throws IOException {
//        String login = (String) req.getSession().getAttribute("inputLogin");
//
//        CSVReader reader = new CSVReader(new FileReader("D:\\registration1.csv"), ',');
//        String[] stringOfData;
//        while ((stringOfData = reader.readNext()) != null) {
//            if (stringOfData[0].equals(login)) {
//                return stringOfData[7];
//            }
//        }
//        return null;
//    }
}
