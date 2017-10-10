package com.lesson;

import java.awt.event.ContainerAdapter;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static MobilePhone phone = new MobilePhone();

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("\nEnter action: (press 6 to show available actions)");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down");
                    quit = true;
                    break;
                case 1:
                    phone.printContacts();
                    ;
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateNewContact();
                    break;
                case 4:
                    removeExisitingContact();
                    break;
                case 5:
                    queryExistingContact();
                    break;
                case 6:
                    printActions();
                    break;

            }

        }
    }


    private static void startPhone() {
        System.out.println("phone is starting...");
    }

    private static void addNewContact() {
        System.out.println("Enter new name: ");
        String name = sc.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        Contacts newContact = Contacts.createContact(name, phoneNumber);
        if (phone.addName(newContact)) {
            System.out.println("new contact added: " + name + " , phone: " + phoneNumber);
        } else {
            System.out.println("cannot add, " + name + ". " + " already exists.");
        }
    }

    private static void updateNewContact() {
        System.out.println("enter existing contact name: ");
        String name = sc.nextLine();
        Contacts exisiting = phone.queryContact(name);
        if (exisiting == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = sc.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newNumber = sc.nextLine();
        Contacts newContact = Contacts.createContact(newName, newNumber);
        if (phone.updateContact(exisiting, newContact)) {
            System.out.println("Successfully updated");
        } else {
            System.out.println("Error updating record");
        }
    }

    private static void removeExisitingContact() {
        System.out.println("enter existing contact name: ");
        String name = sc.nextLine();
        Contacts exisiting = phone.queryContact(name);
        if (exisiting == null) {
            System.out.println("Contact not found");
            return;
        }

        if (phone.removeContact(exisiting)) {
            System.out.println("successfully deleted");
        } else {
            System.out.println("error deleting record. does not exist");
        }
    }

    private static void queryExistingContact() {
        System.out.println("enter existing contact name: ");
        String name = sc.nextLine();
        Contacts exisiting = phone.queryContact(name);
        if (exisiting == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name " + exisiting.getName() + " phone number is " + exisiting.getNumber());
    }

    private static void printActions() {
        System.out.println("\nAvailable actions: \npress");
        System.out.println("0 - Shutdown\n");
        System.out.println("1 - Print contact list\n");
        System.out.println("2 - Add a new contact\n");
        System.out.println("3 - Update an existing contact\n");
        System.out.println("4 - Remove a contact\n");
        System.out.println("5 - Query to find exisitng contact\n");
        System.out.println("6 - Print list of available actions\n");
        System.out.println("choose your action: ");



    }
}
