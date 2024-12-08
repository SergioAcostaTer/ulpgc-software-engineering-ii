package software.ulpgc.kata4.architecture.io;

import software.ulpgc.kata4.architecture.Title;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TitleLoaderDb implements TitleRepository{
    private final String databasePath;

    public TitleLoaderDb(String databasePath) {
        this.databasePath = databasePath;
    }

    @Override
    public List<Title> load() {
        List<Title> titles = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:"+databasePath)){
            Statement statement = connection.createStatement();
            String query = "SELECT primaryTitle, startYear, runtimeMinutes FROM titles";

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String title = resultSet.getString("primaryTitle");
                int year = resultSet.getInt("startYear");
                int duration = resultSet.getInt("runtimeMinutes");

                titles.add(new Title(title, year, duration));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return titles;
    }
}
