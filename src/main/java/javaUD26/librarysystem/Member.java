package javaUD26.librarysystem;

public class Member {
    private String memberName;
    private String memberID;
    private int activeLoans;

    public Member(String memberName, String memberID) {
        this.memberName = memberName;
        this.memberID = memberID;
        if (memberID.length() != 10) {
            throw new IllegalArgumentException("Felaktig inmatning, 10 siffror krävs.");
        }
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
    public int getActiveLoans() {
        return activeLoans;
    }
    public void setActiveLoans(int activeLoans) {
        this.activeLoans = activeLoans;
    }

    public boolean canBorrowMore() {
        return activeLoans < 5;
    }
}
