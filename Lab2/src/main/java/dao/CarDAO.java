package dao;

import entity.CarEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/car";
    private static final String USER = "postgres";
    private static final String PASSWORD = "5130";
    private static final String REGEX = "[5-6]+";

    public CarEntity getById(long id) {
        String SQL_SELECT = "SELECT * FROM car WHERE id=" + id;

        try (Connection conn = DriverManager.getConnection(
                URL, USER, PASSWORD);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new CarEntity(resultSet.getLong("id"),
                        resultSet.getString("number"),
                        resultSet.getString("mark"),
                        resultSet.getString("model"),
                        resultSet.getLong("year"),
                        resultSet.getString("owner"),
                        resultSet.getString("address"));
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<CarEntity> getAll() {
        List<CarEntity> result = new ArrayList<>();
        String SQL_SELECT = "SELECT * FROM car";

        try (Connection conn = DriverManager.getConnection(
                URL, USER, PASSWORD);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(new CarEntity(resultSet.getLong("id"),
                        resultSet.getString("number"),
                        resultSet.getString("mark"),
                        resultSet.getString("model"),
                        resultSet.getLong("year"),
                        resultSet.getString("owner"),
                        resultSet.getString("address")
                ));
            }

            Collections.sort(result);
            return result;

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<CarEntity> getMatchers() {
        List<CarEntity> result = new ArrayList<>();
        String SQL_SELECT = "SELECT * FROM car";

        try (Connection conn = DriverManager.getConnection(
                URL, USER, PASSWORD);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            Pattern p = Pattern.compile(REGEX);

            while (resultSet.next()) {
                String number = resultSet.getString("number");
                Matcher m = p.matcher(number);
                if (m.matches()) {
                    result.add(new CarEntity(resultSet.getLong("id"),
                            number,
                            resultSet.getString("mark"),
                            resultSet.getString("model"),
                            resultSet.getLong("year"),
                            resultSet.getString("owner"),
                            resultSet.getString("address")
                    ));
                }
            }

            Collections.sort(result);
            return result;

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void create(CarEntity car) {
        String SQL_INSERT = "INSERT INTO car(" +
                "number, mark, model, year, owner, address)" +
                "VALUES ( '" +
                car.getNumber() +
                "', '" +
                car.getMark() +
                "', '" +
                car.getModel() +
                "', '" +
                car.getYear() +
                "', '" +
                car.getOwner() +
                "', '" +
                car.getAddress() + "');";

        try (Connection conn = DriverManager.getConnection(
                URL, USER, PASSWORD);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

            preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
