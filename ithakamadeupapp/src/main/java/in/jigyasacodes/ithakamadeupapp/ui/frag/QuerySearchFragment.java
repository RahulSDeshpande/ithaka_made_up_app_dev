package in.jigyasacodes.ithakamadeupapp.ui.frag;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import in.jigyasacodes.ithakamadeupapp.R;
import in.jigyasacodes.ithakamadeupapp.data.Consts;
import in.jigyasacodes.ithakamadeupapp.ui.dialog.Dialogs;
import in.jigyasacodes.ithakamadeupapp.util.Net;

public class QuerySearchFragment extends Fragment {

    private Context ctx;

    private Dialogs dialog;

    private QuerySearchGoClickedListener querySearchGoClickedListener;

    private EditText etWhat, etWhere;
    private Button btnSearchGo;

    public QuerySearchFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //  if (this.isNetConnected()) {

        this.initUI(container);
        //  }

        return inflater.inflate(R.layout.frag_query_search, container, false);
    }

    private void initUI(ViewGroup container) {

        etWhat = (EditText) container.findViewById(R.id.etWhat);
        etWhere = (EditText) container.findViewById(R.id.etWhere);

        btnSearchGo = (Button) container.findViewById(R.id.btnSearchGo);

        btnSearchGo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (new QuerySearchFragment().isNetConnected()) {

                    Toast.makeText(ctx,
                            "WHAT:\n"+ etWhat.getText().toString().trim()+
                            "\n\nWHERE:\n"+etWhere.getText().toString().trim(),
                            Toast.LENGTH_LONG).show();

                    querySearchGoClickedListener.querySearchGoClicked(
                            etWhat.getText().toString().trim(),
                            etWhere.getText().toString().trim());
                }
            }
        });
    }

    private boolean isNetConnected() {

        if (!Net.isNetworkAvailable(ctx)) {

            dialog = new Dialogs(ctx);
            dialog.showNetworkIssueAD(Consts.NET_ISSUE_AD_TITLE,
                    Consts.NET_ISSUE_AD_MESSAGE);

            return false;
        }

        return true;
    }

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);

        ctx = activity;
        querySearchGoClickedListener = (QuerySearchGoClickedListener) ctx;

    }

    public interface QuerySearchGoClickedListener {

        public void querySearchGoClicked(final String WHAT, final String WHERE);
    }
}