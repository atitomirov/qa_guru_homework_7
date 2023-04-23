package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
public class RegistrationWithPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                        .removeBanner()
                        .setFirstName("Captain")
                        .setLastName("America")
                        .setUserEmail("example@mrak.gnu")
                        .setGender("Male")
                        .setNumber("8005577744")
                        .setBirthDate("01", "January", "2000")
                        .setSubjects("English")
                        .setHobbies("Sports")
                        .setHobbies("Reading")
                        .setHobbies("Music")
                        .setPicture("src/test/resources/1.jpg")
                        .setAddress("LasVegas")
                        .setState("Haryana")
                        .setCity("Karnal")
                        .setSubmit();

        registrationPage.verifyRegistrationResultsModalAppears()
                        .verifyResult("Student Name", "Captain America")
                        .verifyResult("Student Email", "example@mrak.gnu")
                        .verifyResult("Gender", "Male")
                        .verifyResult("Mobile", "8005577744")
                        .verifyResult("Date of Birth", "01 January,2000")
                        .verifyResult("Subjects", "English")
                        .verifyResult("Hobbies", "Sports, Reading, Music")
                        .verifyResult("Picture", "1.jpg")
                        .verifyResult("Address", "LasVegas")
                        .verifyResult("State and City", "Haryana Karnal");
    }
}
