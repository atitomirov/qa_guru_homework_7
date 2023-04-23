package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    SelenideElement userNameInput = $("#userName"),
            userEmail = $("#userEmail"),
            userCurrentAddress = $("#currentAddress"),
            userPermanentAddress = $("#permanentAddress"),
            submitData = $("#submit");


    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        userCurrentAddress.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        userPermanentAddress.setValue(value);
        return this;
    }

    public TextBoxPage setSubmit() {
        submitData.click();
        return this;
    }

    public TextBoxPage verifyInputData(String value) {
        $("#output").shouldHave(text(value));
        return this;
    }
}
