package generalassembly.yuliyakaleda.relationships_lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import generalassembly.yuliyakaleda.relationships_lab.recyclerview.JoinsRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";
    private RecyclerView mRecyclerView;
    private JoinsRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addDataToDb();

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mAdapter = new JoinsRecyclerViewAdapter(new ArrayList<String>());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        Button sameWorkplace = (Button) findViewById(R.id.same_workplace);
        Button bostonLocation = (Button) findViewById(R.id.boston_location);
        Button bestPaidCity = (Button) findViewById(R.id.best_paid_employee);

        sameWorkplace.setOnClickListener(this);
        bostonLocation.setOnClickListener(this);
        bestPaidCity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.same_workplace:
                sameWorkPlace();
                break;

            case R.id.boston_location:
                bostonLocation();
                break;

            case R.id.best_paid_employee:
                highestSalary();
                break;
        }
    }

    private void addDataToDb() {
        Helper helper = Helper.getInstance(MainActivity.this);
        Employee employee1 = new Employee("123-04-5678", "John", "Smith", 1973, "NY");
        Employee employee2 = new Employee("123-04-5679", "David", "McWill", 1982, "Seattle");
        Employee employee3 = new Employee("123-04-5680", "Katerina", "Wise", 1973, "Boston");
        Employee employee4 = new Employee("123-04-5681", "Donald", "Lee", 1992, "London");
        Employee employee5 = new Employee("123-04-5682", "Gary", "Henwood", 1987, "Las Vegas");
        Employee employee6 = new Employee("123-04-5683", "Anthony", "Bright", 1963, "Seattle");
        Employee employee7 = new Employee("123-04-5684", "William", "Newey", 1995, "Boston");
        Employee employee8 = new Employee("123-04-5685", "Melony", "Smith", 1970, "Chicago");

        helper.insertRow(employee1);
        helper.insertRow(employee2);
        helper.insertRow(employee3);
        helper.insertRow(employee4);
        helper.insertRow(employee5);
        helper.insertRow(employee6);
        helper.insertRow(employee7);
        helper.insertRow(employee8);

        Job job1 = new Job("123-04-5678", "Fuzz",60, 1);
        Job job2 = new Job("123-04-5679", "GA", 70, 2);
        Job job3 = new Job("123-04-5680", "Little Place", 120, 5);
        Job job4 = new Job("123-04-5681", "Macys", 78, 3);
        Job job5 = new Job("123-04-5682", "New Life", 65, 1);
        Job job6 = new Job("123-04-5683", "Believe", 158, 6);
        Job job7 = new Job("123-04-5684", "Macys", 200, 8);
        Job job8 = new Job("123-04-5685", "Stop", 299, 12);

        helper.insertRowJob(job1);
        helper.insertRowJob(job2);
        helper.insertRowJob(job3);
        helper.insertRowJob(job4);
        helper.insertRowJob(job5);
        helper.insertRowJob(job6);
        helper.insertRowJob(job7);
        helper.insertRowJob(job8);
    }

    private void sameWorkPlace(){
        Helper helper = Helper.getInstance(MainActivity.this);
        List<String> employees = helper.getEmployeesWorkingAtTheSameCompany();
        mAdapter.replaceData(employees);
    }

    private void bostonLocation(){
        Helper helper = Helper.getInstance(MainActivity.this);
        List<String> companies = helper.getCompaniesLocatedInBoston();
        mAdapter.replaceData(companies);
    }

    private void highestSalary(){
        Helper helper = Helper.getInstance(MainActivity.this);
        List<String> employees = helper.getCompanyWithHighestSalary();
        mAdapter.replaceData(employees);
    }
}
