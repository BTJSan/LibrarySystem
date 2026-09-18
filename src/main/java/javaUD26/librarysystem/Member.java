package javaUD26.librarysystem;

public class Member {
    private String memberName;
    private String memberID;
    private String activeLoans;

    public Member(String memberName, String memberID) {
        this.memberName = memberName;
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public String getMemberID() {
        return memberID;
    }
    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }
    public String getActiveLoans() {
        return activeLoans;
    }
    public void setActiveLoans(String activeLoans) {
        this.activeLoans = activeLoans;
    }
}
