package repository;

import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    static private Statement statement;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/user_data";
            String user = "root";
            String pas = "cdtk825oxl63Q";

            Connection connection = DriverManager.getConnection(url, user, pas);
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> findAll() {
        List<User> result = new ArrayList<>();
         try {
             ResultSet rs = statement.executeQuery("SELECT * FROM first_web.user_data");

             while (rs.next()) {
                 User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
                 result.add(user);
             }
             return result;
         }
         catch (SQLException e) {
             /*e.printStackTrace(); todo - что оно делает? - этот метод показывает, где в коде произошла ошибка */
             String message = e.getMessage();
             throw new RuntimeException("Can't get all users. Reason - " + message);
         }
    }

    public int findMaxId() {
        Integer maxId = 0;
        try {
            ResultSet rs = statement.executeQuery("SELECT MAX(id) FROM first_web.user_data");
            while (rs.next()) {
                int id = rs.getInt(1);
                maxId = id;
                return maxId;
            }
        } catch (SQLException e) {
            String message = e.getMessage();
            throw new RuntimeException("Can't get maxId. Reason - " + message);
        }
        return maxId;
    }

    public User findById(Integer id) {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM first_web.user_data WHERE id = " + id);
            User user;
            if (rs.next()) {
                String email = rs.getString(2);
                String password = rs.getString(3);
                user = new User(id, email, password);
            } else {
                user = null;
            }
            return user;
        } catch (SQLException e) {
            String message = e.getMessage();
            throw new RuntimeException("Can't find such user. Reason - " + message);
        }
    }

    public User findByEmail(String email) {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM first_web.user_data WHERE e_mail = " + email);
            User user;
            if (rs.next()) {
                int id = rs.getInt(1);
                String password = rs.getString(3);
                user = new User(id, email, password);
            } else {
                user = null;
            }
            return user;
        } catch (SQLException e) {
            String message = e.getMessage();
            throw new RuntimeException("Can't find such user. Reason - " + message);
        }
    }

    public User save(User user) {
        Integer insertId = findMaxId() + 1;
        String query = String.format("insert into first_web.user_data (id, e_mail, password) values (%d, '%s', '%s')", insertId, user.getEmail(), user.getPassword());
        try {
            statement.executeUpdate(query);
            return findById(insertId);
        } catch (SQLException e) {
            String message = e.getMessage();
            throw new RuntimeException("Can't save this user. Reason - " + message);
        }
    }

    public User update(User user) {
        String query = String.format("update first_web.user_data set e_mail = '%s', password = '%s' where  id = '%d'", user.getEmail(), user.getPassword(), user.getId());
        try {
            int updateCount = statement.executeUpdate(query);
            if (updateCount == 0) {
                throw new RuntimeException("User with such id " + user.getId() + " doesn't exist");
            }
            return findById(user.getId());
        } catch (SQLException e) {
            String message = e.getMessage();
            throw new RuntimeException("Can't update such user. Reason - " + message);
        }
    }


}
