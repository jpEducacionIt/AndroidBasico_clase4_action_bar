package com.example.androidbasico_clase4_action_bar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String nombres [] = {"Valentina","Matias","Macarena","Marcos","Tobias","Eduardo" ,"Paula","Maria Laura","Jose","Martin","Francisco", "Cecilia", "Martina", "Nicolas", "Juan Ignacio", "Lucia", "Sofia"};
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewNombres);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nombres);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem menuItem = menu.findItem(R.id.buscarNombre);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("buscar nombre");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }
}
