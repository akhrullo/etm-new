package uz.iDev.repository;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import uz.iDev.container.UNIContainer;
import uz.iDev.exception.CustomerSQLException;
import uz.iDev.property.DatabaseProperties;

import java.io.Serializable;
import java.sql.*;
import java.util.Objects;

public class AbstractRepository {
    protected Connection connection = UNIContainer.getBean(Connection.class);
    Object[] args;
    protected DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);
    protected Gson gson = UNIContainer.getBean(Gson.class);


    protected Serializable callProcedure(String query, int outType) {
        try {
            CallableStatement statement = connection.prepareCall(query);
            prepareToExecute(statement);
            ResultSet resultSet = statement.executeQuery();
            return prepareResultSet(resultSet, outType);

        } catch (SQLException e) {
            throw new CustomerSQLException(e.getMessage(), e.getCause());
        }
    }

    protected <T> T callProcedure(String query, int outType, Class<T>  clazz) {
        return (T) callProcedure(query, outType);
    }

    @SneakyThrows
    protected Serializable prepareResultSet(ResultSet resultSet, int outType) {
        if (Objects.nonNull(resultSet) && resultSet.next()) {
            return switch (outType) {
                case Types.VARCHAR -> resultSet.getString(1);
                case Types.BIGINT -> resultSet.getLong(1);
                case Types.BOOLEAN -> resultSet.getBoolean(1);
//                case Types.VOID -> -1;
                default -> {
                    throw new IllegalStateException("Unexpected Value: " + outType);
                }
            };
        }
        return null;
    }

    @SneakyThrows
    protected void prepareToExecute(CallableStatement statement) {
        for (int i = 0; i < this.args.length; i++) {
            statement.setObject(i + 1, args[i]);
        }
    }

    protected void prepareArguments(Object... args) {
        this.args = args;
    }
}
