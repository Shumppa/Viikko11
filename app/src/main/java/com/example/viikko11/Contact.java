package com.example.viikko11;

public class Contact {
    private String firstName;
    private String lastName;
    private String number;
    private String contactGroup;

    public Contact(String firstName, String lastName, String number, String contactGroup) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.contactGroup = contactGroup;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getNumber() {
        return number;
    }

    public String getContactGroup() {
        return contactGroup;
    }
}
