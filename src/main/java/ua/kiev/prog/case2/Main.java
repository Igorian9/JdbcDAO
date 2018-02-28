package ua.kiev.prog.case2;

import ua.kiev.prog.shared.Client;
import ua.kiev.prog.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/mydb";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "111";

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        ConnectionFactory factory = new ConnectionFactory(
                DB_CONNECTION, DB_USER, DB_PASSWORD
        );

        Connection conn = factory.getConnection();
        try {
            ClientDAOEx dao = new ClientDAOEx(conn, "Clients");

            Client c = new Client("test", 1);
//            dao.add(c);
            Client b = new Client ("update", 2);

            List<Client> list = dao.getAll(Client.class);
            for (Client cli : list)
                System.out.println(cli);

            list.get(0).setAge(20);
            dao.update(list.get(0));

            System.out.println();


            for (Client cli :dao.getAll(Client.class))
                System.out.println(cli);

//           dao.delete(list.get(0));
//           dao.delete(list.get(1));

        } finally {
            sc.close();
            if (conn != null) conn.close();
        }
    }
}
