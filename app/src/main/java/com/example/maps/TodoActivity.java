package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.maps.data.TodoNote;
import com.example.maps.data.datasource.local.TodoDao;
import com.example.maps.data.datasource.local.TodoDatabase;

import java.util.List;

public class TodoActivity extends AppCompatActivity {
EditText titleEditText, subtitleEditText;
ListView dataListView;

    TodoDatabase todoDatabase;
    private TodoDao todoDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        titleEditText = findViewById(R.id.titleEdittext);
        subtitleEditText = findViewById(R.id.subtitleEdittext);
        dataListView = findViewById(R.id.dblist);

        todoDatabase = TodoDatabase.getDatabase(this);
        todoDao = todoDatabase.todoDao();
    }

    public void handleClick(View view) {
        switch (view.getId()){
            case R.id.buttonsave:
                String title = titleEditText.getText().toString();
                String subtitle = subtitleEditText.getText().toString();
                TodoNote todoNote = new TodoNote(title,subtitle);
                insert(todoNote);
                break;
            case R.id.buttonget:
                getData();
                break;
        }
    }

    private void getData() {
        new GetAsyncTask().execute();

    }

    private void insert(TodoNote todoNote) {
        new InsertAsyncTask().execute(todoNote);

    }

    class InsertAsyncTask extends AsyncTask<TodoNote,Void,Void>{




        @Override
        protected Void doInBackground(TodoNote... todoNotes) {
            todoDao.insert(todoNotes[0]);
            return null;
        }
    }


    class  GetAsyncTask extends AsyncTask<Void,Void, List<TodoNote>>{

        @Override
        protected List<TodoNote> doInBackground(Void... voids) {
            return todoDao.getAllWords();
        }

        @Override
        protected void onPostExecute(List<TodoNote> todoNotes) {
            //super.onPostExecute(todoNotes);

            ArrayAdapter<TodoNote> adapter = new ArrayAdapter<TodoNote>(TodoActivity.
                    this,android.R.layout.simple_list_item_2,
                    android.R.id.text1,todoNotes);
            dataListView.setAdapter(adapter);

        }
    }
}
