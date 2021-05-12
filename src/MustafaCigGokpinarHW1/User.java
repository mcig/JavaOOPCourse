package MustafaCigGokpinarHW1;

public class User {
    protected static int id = 0;
    protected String name;
    protected String surname;
    protected String birthDate;
    protected String gender;
    protected String mobilePhone;
    protected String email;
    protected String password;

    public User(String name, String surname, String birthDate, String gender, String mobilePhone, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.password = password;
        this.id++;
    }

    public User() {
        String[] datas = MyUtilities.createRandomUserDatas();
        this.name = datas[0];
        this.surname = datas[1];
        this.birthDate = datas[2];
        this.gender = datas[3];
        this.mobilePhone = datas[4];
        this.email = datas[5];
        this.password = datas[6];
        this.id++;
    }
}
