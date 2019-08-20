package ua.kiev.prog;

public class UserStatistic {

    private int userCount; // number of interviews
    private String userFirstName = "<none>"; // name of the last interviewer
    private String userLastName = "<none>"; // surname of the last interviewer
    private int statAge; // average age of the interviewers
    private int statSport; // sportsmen number
    private int statBooks0; // non-reader number
    private int statBooks1; // more then 1 and less then 10
    private int statBooks11; // more then 10

    public UserStatistic() {

    }

    public UserStatistic(int userCount, String userFirstName, String userLastName, int statAge, int statSport, int statBooks0, int statBooks1, int statBooks11) {
        this.userCount = userCount;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.statAge = statAge;
        this.statSport = statSport;
        this.statBooks0 = statBooks0;
        this.statBooks1 = statBooks1;
        this.statBooks11 = statBooks11;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public int getStatAge() {
        return statAge;
    }

    public void setStatAge(int statAge) {
        this.statAge = statAge;
    }

    public int getStatSport() {
        return statSport;
    }

    public void setStatSport(int statSport) {
        this.statSport = statSport;
    }

    public int getStatBooks0() {
        return statBooks0;
    }

    public void setStatBooks0(int statBooks0) {
        this.statBooks0 = statBooks0;
    }

    public int getStatBooks1() {
        return statBooks1;
    }

    public void setStatBooks1(int statBook1) {
        this.statBooks1 = statBook1;
    }

    public int getStatBooks11() {
        return statBooks11;
    }

    public void setStatBooks11(int statBooks11) {
        this.statBooks11 = statBooks11;
    }

    @Override
    public String toString() {
        return "Statistic : " +
                "interview number = " + userCount +
                ", average age = " + statAge +
                ", sportsmen = " + statSport +
                ", Books 0 = " + statBooks0 +
                ", Books 1..10 = " + statBooks1 +
                ", Books 11... = " + statBooks11;
    }

    public synchronized void updateStatistic(String userFirstName, String userLastName, int statAge, boolean statSport, int statBooks) {
        int age = this.userCount*this.statAge;
        this.userCount++;
        setUserFirstName(userFirstName);
        setUserLastName(userLastName);
        setStatAge((age+statAge)/this.userCount);
        if (statSport) {
           this.statSport++;
        }
        switch (statBooks){
            case 0: this.statBooks0++; break;
            case 1: this.statBooks1++; break;
            case 11: this.statBooks11++; break;
        }
    }
}
