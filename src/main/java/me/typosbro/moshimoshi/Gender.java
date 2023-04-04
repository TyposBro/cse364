package me.typosbro.moshimoshi;

public enum Gender {
    MALE("M"),
    FEMALE("F");

    public final String gender;

    private Gender(String gender) {
        this.gender = gender;
    }

    // getter method
    public String getGender()
    {
        return this.gender;
    }
}
