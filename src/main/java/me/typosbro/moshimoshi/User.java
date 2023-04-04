package me.typosbro.moshimoshi;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Document
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Indexed(unique = true)
    private long id;
    private Gender gender;
    private Number age;
    private String occupation;
    private String zip_code;

    public User(Gender gender, Number age, String  occupation, String zip_code){
        this.gender = gender;
        this.age = age;
        this.occupation = occupation;
        this.zip_code = zip_code;
    }
    
}
