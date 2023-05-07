package com.example.demo.extensions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DirectionDAOImpl  implements DirectionDAO {

    private Connection connection;

    public DirectionDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Direction direction) throws DirectionExistsException {
        if (exists(direction))
            throw new DirectionExistsException(direction, direction.toString());

        String sql = "INSERT INTO directions (street, postal_code, province, country) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, direction.getStreet());
            statement.setString(2, direction.getPostalCode());
            statement.setString(3, direction.getProvince());
            statement.setString(4, direction.getCountry());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean exists(Direction direction) {
        return direction != null &&
               direction.getId() != null &&
               this.getById(direction.getId()) != null;
    }


    @Override
    public void delete(Direction direction) {
        String sql = "DELETE FROM directions WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, direction.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Direction getById(Long id) {
        String sql = "SELECT * FROM directions WHERE ID = ?";
        Direction direction = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Long idDirection = resultSet.getLong("id");
                String street = resultSet.getString("street");
                String postalCode = resultSet.getString("postal_code");
                String province = resultSet.getString("province");
                String country = resultSet.getString("country");
                direction = new Direction(idDirection, street, postalCode, province, country);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return direction;
    }
}