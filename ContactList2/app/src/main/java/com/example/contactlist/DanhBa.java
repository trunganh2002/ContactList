package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.contactlist.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class DanhBa extends AppCompatActivity {

    private static final int REQUEST_CODE_ASK_PERMISSIONS = 1001;

    ListView lvDanhBa;
    ArrayList<Contact> dsDanhBa;
    ArrayAdapter<Contact> adapterDanhBa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_ba);
        
        addControl();
        showAllContact();
    }

    private void showAllContact() {

        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri, null,null,null,null);
        dsDanhBa.clear();
        while (cursor.moveToNext()){
            String TenCotName =     ContactsContract.Contacts.DISPLAY_NAME;
            String TenCotPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;

            int vitriCotName = cursor.getColumnIndex(TenCotName);
            int vtriCotPhone = cursor.getColumnIndex(TenCotPhone);

            String name  = cursor.getString(vitriCotName);
            String Phone = cursor.getString(vtriCotPhone);

            Contact contact = new Contact(name, Phone);
            dsDanhBa.add(contact);
            adapterDanhBa.notifyDataSetChanged();
        }
    }

    private void addControl() {
        lvDanhBa = findViewById(R.id.lvDanhBa);
        dsDanhBa = new ArrayList<>();
        adapterDanhBa = new ArrayAdapter<>(
                DanhBa.this, android.R.layout.simple_list_item_1,dsDanhBa
        );
        lvDanhBa.setAdapter(adapterDanhBa);
    }
}