package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;

public class RegistrationWithTestDataTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setNumber(mobile)
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobbies)
                .setPicture(imageUploadPath)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .setSubmit();

        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", mobile)
                .verifyResult("Date of Birth", String.format("%s %s,%s", day, month, year))
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", imageName)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);
    }
}
