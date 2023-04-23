package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModal;
import java.io.File;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModal resultsModal = new ResultsModal();
    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            gender = $("#genterWrapper"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            userNumber = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitData = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setNumber(String value) {
        userNumber.setValue(value);
        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setBirthDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setPicture(String value) {
        uploadPicture.uploadFile(new File(value));
        return this;
    }
    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }
    public RegistrationPage setState(String value) {
        stateInput.click();
        $(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity(String value) {
        cityInput.click();
        $(byText(value)).click();
        return this;
    }
    public RegistrationPage setSubmit() {
        submitData.click();
        return this;
    }
    public RegistrationPage verifyRegistrationResultsModalAppears() {
        resultsModal.verifyModalAppears();
        return this;
    }
    public RegistrationPage verifyResult(String key, String value) {
        resultsModal.verifyResult(key, value);
        return this;
    }
}

