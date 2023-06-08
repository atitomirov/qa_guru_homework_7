package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;
import static io.qameta.allure.Allure.step;

public class RegistrationRemoteTests extends RemoteTestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("remote")
    @DisplayName("Successful registration")
    void successfulRegistrationTest() {

        step("Open form", () -> {
            registrationPage.openPage()
                    .removeBanner();
        });

        step("Fill form", () -> {
            registrationPage.setFirstName(firstName)
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
        });
        step("Verify results", () -> {
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
        });
    }
}
