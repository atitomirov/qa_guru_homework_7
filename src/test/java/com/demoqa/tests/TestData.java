package com.demoqa.tests;

import com.github.javafaker.Faker;

public class TestData {

    static Faker faker = new Faker();
    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            currentAddress = faker.address().fullAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            day = String.format("%02d", faker.number().numberBetween(1, 28)),
            year = String.valueOf(faker.number().numberBetween(1990, 2010)),
            month = faker.options().option("January", "February", "March", "April",
                    "May", "June", "July", "August", "September", "October", "November", "December"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            subject = faker.options().option("English", "Maths"),
            mobile = faker.phoneNumber().subscriberNumber(10),
            uploadPath = "src/test/resources/1.jpg",
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = city();

    public static String city() {
        String city;
        switch (state) {
            case ("NCR") -> {
                city = faker.options().option("Delhi", "Gurgaon", "Noida");
                return city;
            }
            case ("Uttar Pradesh") -> {
                city = faker.options().option("Agra", "Lucknow", "Merrut");
                return city;
            }
            case ("Haryana") -> {
                city = faker.options().option("Karnal", "Panipat");
                return city;
            }
            case ("Rajasthan") -> {
                city = faker.options().option("Jaipur", "Jaiselmer");
                return city;
            }
            default -> {
                return "";
            }
        }
    }

}
