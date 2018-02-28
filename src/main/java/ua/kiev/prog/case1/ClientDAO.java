package ua.kiev.prog.case1;

import ua.kiev.prog.shared.Client;

import java.util.List;

public interface ClientDAO {
    void init();
    void addClient(String name, int age);
    void deleteClient(int id);
    void update(int id, String name, int age);
    List<Client> getAll();
    long count();
}
