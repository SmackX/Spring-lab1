package ATM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {private static final String URL = "jdbc:postgresql://localhost:5432/ATM";
    private static final String Username = "postgres";
    private static final String Password = "postgres";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL,Username,Password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public List<Users> getBD(){
        List<Users> people = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                Users user = new Users();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setSum(resultSet.getInt("sum"));
                people.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;
    }
    public void DoMyInit(){
        System.out.println("Database connect!");
    }
    public void DoMyDestroy(){
        System.out.println("Database disconnect!");
    }
}
