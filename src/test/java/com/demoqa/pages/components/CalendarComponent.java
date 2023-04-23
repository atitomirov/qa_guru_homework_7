package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setBirthDate(String day, String month, String year) {

        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        //$(".react-datepicker__day--0" + day).click();

        String dayPickerLocator = (".react-datepicker__day--0" + day);
        $(dayPickerLocator).click();

    }
}
