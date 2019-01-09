package com.example.user.bcompanion3;



public class Room {
    private String mGatherPoint, mStartAge, mEndAge, mStayStatus, mGatherDate,mGatherTime, mAdmin ;

    public Room(String mGatherPoint, String mStartAge, String mEndAge, String mStayStatus, String mGatherDate, String mGatherTime, String mAdmin) {
        this.mGatherPoint = mGatherPoint;
        this.mStartAge = mStartAge;
        this.mEndAge = mEndAge;
        this.mStayStatus = mStayStatus;
        this.mGatherDate = mGatherDate;
        this.mGatherTime = mGatherTime;
        this.mAdmin= mAdmin;
    }

    public String getGatherPoint() {
        return mGatherPoint;
    }

    public void setGatherPoint(String mGatherPoint) {
        this.mGatherPoint = mGatherPoint;
    }

    public String getStartAge() {
        return mStartAge;
    }

    public void setStartAge(String mStartAge) {
        this.mStartAge = mStartAge;
    }

    public String getEndAge() {
        return mEndAge;
    }

    public void setEndAge(String mEndAge) {
        this.mEndAge = mEndAge;
    }

    public String getStayStatus() {
        return mStayStatus;
    }

    public void setStayStatus(String mStayStatus) {
        this.mStayStatus = mStayStatus;
    }

    public String getGatherDate() {
        return mGatherDate;
    }

    public void setGatherDate(String mGatherDate) {
        this.mGatherDate = mGatherDate;
    }

    public String getGatherTime() {
        return mGatherTime;
    }

    public void setGatherTime(String mGatherTime) {
        this.mGatherTime = mGatherTime;
    }

    public String getAdmin() {
        return mAdmin;
    }

    public void setAdmin(String mAdmin) {
        this.mAdmin = mAdmin;
    }
}
