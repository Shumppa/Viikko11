package com.example.viikko11;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_contact);

        EditText firstNameEdit = findViewById(R.id.FirstNameEdit);
        EditText lastNameEdit = findViewById(R.id.LastNameEdit);
        EditText phoneNumberEdit = findViewById(R.id.PhoneNumberEdit);
        RadioGroup contactTypeRadioGroup = findViewById(R.id.ContactTypeRadioGroup);
        Button addContactButton = findViewById(R.id.AddContactButton);

        addContactButton.setOnClickListener(v -> {
            String firstName = firstNameEdit.getText().toString();
            String lastName = lastNameEdit.getText().toString();
            String phoneNumber = phoneNumberEdit.getText().toString();

            int selectedId = contactTypeRadioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = findViewById(selectedId);
            String contactGroup = radioButton.getText().toString();

            Contact contact = new Contact(firstName, lastName, phoneNumber, contactGroup);
            ContactStorage.getInstance().addContact(contact);

            finish();
        });
    }
}