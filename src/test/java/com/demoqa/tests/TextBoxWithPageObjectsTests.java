package com.demoqa.tests;

import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxWithPageObjectsTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfulFillTextBoxTest() {

        textBoxPage.openPage()
                .setUserName("Mr Smith")
                .setUserEmail("aa@aaa.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .setSubmit();

        textBoxPage.verifyInputData("Mr Smith")
                .verifyInputData("aa@aaa.com")
                .verifyInputData("Some street 1")
                .verifyInputData("Another street 1");

    }
}
