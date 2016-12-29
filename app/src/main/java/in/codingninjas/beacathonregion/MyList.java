package in.codingninjas.beacathonregion;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class MyList extends AppCompatActivity {
    EditText e_cat,e_task;
    Button button;
    Set<String> mySet;
    String m_category,m_task;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        e_cat=(EditText)findViewById(R.id.category);
        e_task=(EditText)findViewById(R.id.task);
        button=(Button)findViewById(R.id.button2);
        sharedpreferences = getSharedPreferences("TaskDetails", Context.MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m_category=e_cat.getText().toString().toUpperCase();
                m_task=e_task.getText().toString().toUpperCase();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                mySet=sharedpreferences.getStringSet(m_category,null);
                if(mySet==null){
                    mySet=new HashSet<String>();
                    mySet.add(m_task);
                    editor.putStringSet(m_category,mySet);
                    Toast.makeText(getApplicationContext(),"Added"+m_task,Toast.LENGTH_LONG).show();
                    editor.commit();
                    mySet=sharedpreferences.getStringSet(m_category,null);
                    String s=new String();
                    for(String x : mySet){
                        s=s+x;
                    }
                    Log.d("deepak",s);
                }
                else {
                    mySet.add(m_task);
                    editor.putStringSet(m_category,mySet);
                    Toast.makeText(getApplicationContext(),"Added"+m_task,Toast.LENGTH_LONG).show();
                    editor.commit();
                    mySet=sharedpreferences.getStringSet(m_category,null);
                    String s=new String();
                    for(String x : mySet){
                        s=s+x;
                    }
                    Log.d("deepak",s);
                }
            }
        });



    }
}
