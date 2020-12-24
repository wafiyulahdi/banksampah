package id.banksampah;

abstract class UserModels {
    public String[] arrayUserId = new String[]{}; 
    private int maxUser;

    abstract public void setUserLevel(String level);
    abstract public String getUserLevel();

    public void printUserLevel() {
        System.out.println(getUserLevel());
    }

    public void setMaxUser(int maximum) {
        this.maxUser = maximum;
    }

    public int getMaxUser() {
        return this.maxUser;
    }

    public String[] genUserId() {
        char prefix ='A';
        int suffix;
        int maxValue =3;
        String userId;

        for (int index =1; index <= maxValue; index++) {
            suffix = index;
            userId = String.valueOf(suffix) + Integer.toString(suffix);
            this.arrayUserId[index] = userId;
        }
        return this.arrayUserId;
    }
}