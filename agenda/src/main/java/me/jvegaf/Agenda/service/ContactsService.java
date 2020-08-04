package me.jvegaf.Agenda.service;


import me.jvegaf.Agenda.Model.Contact;

import java.util.List;

public interface ContactsService {
	
	public List<Contact> getAll();
	
	public void addContact(Contact contact);
	
	public Contact getContact(int id);
	
	public void updateContact(Contact contactos);
	
	public void removeContact(Integer id);
	
	public String getMessage();

}
