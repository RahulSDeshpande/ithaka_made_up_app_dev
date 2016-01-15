package in.jigyasacodes.ithakamadeupapp.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import in.jigyasacodes.ithakamadeupapp.R;
import in.jigyasacodes.ithakamadeupapp.ui.frag.QuerySearchFragment;

public class QuerySearchActivity extends AppCompatActivity implements QuerySearchFragment.QuerySearchGoClickedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_query_search);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.frag_container, new QuerySearchFragment(), "FRAG_TAG_QUERY_SEARCH");

        ft.commit();
    }

    @Override
    public void querySearchGoClicked(String WHAT, String WHERE) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.addToBackStack("");
        ft.add(R.id.frag_container, new QuerySearchFragment());
        ft.commit();
    }

    @Override
    public void onBackPressed() {

        //  super.onBackPressed();


    }
}