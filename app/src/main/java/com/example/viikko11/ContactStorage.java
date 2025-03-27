package com.example.viikko11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ContactStorage {
    private static ContactStorage instance;
    private ArrayList<Contact> contacts;

    private ContactStorage() {
        contacts = new ArrayList<>();
    }

    public static ContactStorage getInstance() {
        if (instance == null) {
            instance = new ContactStorage();
        }
        return instance;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
        }
    }

    public void sortAlphabetically() {
        Collections.sort(contacts, new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.getFullName().compareToIgnoreCase(c2.getFullName());
            }
        });
    }

    public void sortByGroup() {
        Iterator<Contact> iterator = contacts.iterator();
        ArrayList<Contact> workContacts = new ArrayList<>();
        ArrayList<Contact> personalContacts = new ArrayList<>();

        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getContactGroup().equals("Työ")) {
                workContacts.add(contact);
            } else {
                personalContacts.add(contact);
            }
        }

        contacts.clear();
        contacts.addAll(workContacts);
        contacts.addAll(personalContacts);
    }
}
