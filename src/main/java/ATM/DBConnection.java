package ATM;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component("DB")
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

    public void AddToDB(int id, String Name, String password, int sum){
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO person values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            System.out.println(id);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, Name);
            preparedStatement.setString(3, password);
            preparedStatement.setInt(4, sum);
            preparedStatement.execute();
            System.out.println("New account add!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void DeleteFromDB(int id){
        try {
            Statement statement = connection.createStatement();
            String SQL = "DELETE FROM person WHERE id ="+id;
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.execute();
            System.out.println("Well done!");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
