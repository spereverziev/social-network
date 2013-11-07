package com.stanislav.pereverziev.socialnetwork.dao;

import com.stanislav.pereverziev.socialnetwork.ConnectionFactory;
import com.stanislav.pereverziev.socialnetwork.entity.Account;
import com.stanislav.pereverziev.socialnetwork.entity.User;
import com.stanislav.pereverziev.socialnetwork.idao.IAccountDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/3/13
 */
public class AccountDao implements IAccountDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    EntityManager entityManager;
    EntityManagerFactory factory;

    public AccountDao() {
        factory = Persistence.createEntityManagerFactory("sn-pu");
        entityManager = factory.createEntityManager();
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    @Override
    public void addAccount(Account account) throws SQLException {
        String query = "INSERT INTO accounts(first_name, last_name, email, age, user_id) VALUES(?,?)";
        connection = getConnection();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, account.getFirstName());
        preparedStatement.setString(2, account.getLastName());
        preparedStatement.setString(3, account.getEmail());
        preparedStatement.setInt(4, account.getAge());
        preparedStatement.executeUpdate();
        try {
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account findAccountByUser(User user) throws SQLException {
        System.out.println("1");
        Query query = entityManager.createNamedQuery("findByUser").setParameter("user", user);
        System.out.println("2");
        Object result = query.getSingleResult();
        System.out.println("3");
        return (Account) result;
    }

    @Override
    public List findAccountsByName(String name) throws SQLException {
        List<Account> accounts = new ArrayList<Account>();
        Account account;
        String query = "SELECT * FROM accounts WHERE CONCAT(first_name,' ',last_name) = '" + name + "'";
        connection = getConnection();
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            account = new Account();
            account.setId(resultSet.getInt(1));
            account.setFirstName(resultSet.getString(2));
            account.setLastName(resultSet.getString(3));
            account.setEmail(resultSet.getString(4));
            account.setAge(resultSet.getInt(5));
//            account.setUserId(resultSet.getInt(6));

            accounts.add(account);
        }

        try {
            preparedStatement.close();
            connection.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    @Override
    public List findAll() {
        return null;
    }
}
