package uz.pdp.advancedui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import uz.pdp.advancedui.model.Member;
import uz.pdp.advancedui.model.MemberSub;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));

        ArrayList<Member> members = loadData();
        refreshAdapter(members, context);
    }

    private void refreshAdapter(ArrayList<Member> members, Context context) {
        CustomAdapter customAdapter = new CustomAdapter(members, context);
        recyclerView.setAdapter(customAdapter);
    }

    private ArrayList<Member> loadData() {
        ArrayList<Member> members = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            if (i==1 || i == 10) {
                members.add(new Member(R.drawable.google, "Google", "top company", prepareMemberSubs()));
            } else {
                members.add(new Member(R.drawable.img, "Yandex", "top company", null));
            }
        }
        return members;
    }

    private List<MemberSub> prepareMemberSubs() {
        List<MemberSub> memberSubs = new ArrayList<>();
        for (int i = 0; i<5; i++){
            memberSubs.add(new MemberSub());
        }
        return memberSubs;
    }
}