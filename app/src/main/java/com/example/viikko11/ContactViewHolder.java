package com.example.viikko11;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    public TextView contactNameText;
    public TextView contactNumberText;
    public TextView contactGroupText;
    public ImageButton contactDetailsButton;
    public ImageButton contactDeleteButton;
    private boolean detailsVisible = false;

    public ContactViewHolder(View itemView) {
        super(itemView);
        contactNameText = itemView.findViewById(R.id.ContactNameText);
        contactNumberText = itemView.findViewById(R.id.ContactNumberText);
        contactGroupText = itemView.findViewById(R.id.ContactGroupText);
        contactDetailsButton = itemView.findViewById(R.id.ContactDetailsButton);
        contactDeleteButton = itemView.findViewById(R.id.ContactDeleteButton);

        // Initially hide details
        contactNumberText.setVisibility(View.GONE);
        contactGroupText.setVisibility(View.GONE);

        contactDetailsButton.setOnClickListener(v -> {
            detailsVisible = !detailsVisible;
            contactNumberText.setVisibility(detailsVisible ? View.VISIBLE : View.GONE);
            contactGroupText.setVisibility(detailsVisible ? View.VISIBLE : View.GONE);
        });
    }
}
