package uz.pdp.advancedui.model;

import java.util.List;

public class Member {
    public int img_rv;
    public String title;
    public String description;
    private List<MemberSub> memberSubs;

    public Member(int img_rv, String title, String description, List<MemberSub> memberSubs){
        this.img_rv = img_rv;
        this.title = title;
        this.description = description;
        this.memberSubs = memberSubs;
    }
    public List<MemberSub> getMemberSubs() {return memberSubs;}

    public void setMemberSubs(List<MemberSub> memberSubs) {
        this.memberSubs = memberSubs;
    }
}
