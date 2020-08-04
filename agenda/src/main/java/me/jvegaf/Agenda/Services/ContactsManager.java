package me.jvegaf.Agenda.Services;

import me.jvegaf.Agenda.Model.Contact;
import me.jvegaf.Agenda.Storage.StorageRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class ContactsManager {

    // solo uso con docker
    private final String URL = "jdbc:mysql://db:3306/agenda_db";
    // private final String URL = "jdbc:mysql://localhost:3306/agenda_db";
    private final String USER = "usuario";
    private final String PASS = "usuario";

    private StorageRepository repository;

    public ContactsManager() {
        try {
            this.repository = StorageRepository.create(this.URL, this.USER, this.PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Contact> getAll() {
        GetAllContacstUseCase getAllUC = new GetAllContacstUseCase(this.repository);
        return getAllUC.execute();
    }

    public void add(String name, int phone, String address) {
        AddContactUseCase addUC = new AddContactUseCase(this.repository);
        addUC.execute(new Contact(null, name, phone, address));
    }

    public void update(Integer id, String name, int phone, String address){
        UpdateContactUseCase updateUseCase = new UpdateContactUseCase(this.repository);
        updateUseCase.execute(new Contact(id, name, phone, address));
    }

    public Contact find(Integer id) {
        FindContactUseCase findUseCase = new FindContactUseCase(this.repository);
        return findUseCase.execute(id);
    }

    public void remove(Integer id) {
        RemoveContactUseCase removeUseCase = new RemoveContactUseCase(this.repository);
        removeUseCase.execute(id);
    }
}
