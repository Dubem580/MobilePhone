package com.lesson;

import java.util.ArrayList;

public class MobilePhone {
    private static ArrayList<Contacts> contacts;

    public MobilePhone() {
        this.contacts = new ArrayList<Contacts>();
    }

    public boolean addName(Contacts contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("contact is already on file");
            return false;
        }

        contacts.add(contact);
        return true;
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + " was not found");
            return false;
        }
        this.contacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " , was replaced with" + newContact.getName());
        return true;
    }

    public boolean removeContact(Contacts contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            System.out.println(contact.getName() + " was not found");
            return false;
        }
        this.contacts.remove(foundPosition);
        System.out.println(contact.getName() + " , was deleted");
        return true;
    }

    private int findContact(Contacts contact) {
        return this.contacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < this.contacts.size(); i++) {
            Contacts contact = this.contacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String findContactRecord(Contacts contacts) {
        if (findContact(contacts) >= 0) {
            return contacts.getName();
        }
        return null;
    }

    public Contacts queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.contacts.get(position);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("contact list");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + " . " + this.contacts.get(i).getName() + " -> " + this.contacts.get(i).getNumber());
        }
    }

}
