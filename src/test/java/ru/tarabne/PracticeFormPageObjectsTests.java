package ru.tarabne;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFullFormTest() {
        registrationPage.openPage()
                .setFirstName("FirstName")
                .setLastName("LastName")
                .setEmail("useremail@value.com")
                .setGender("Female")
                .setUserNumber("9183214567")
                .setDateOfBirth("30", "July", "2008")
                .setSubjects("mat")
                .setHobbies("Music")
                .setHobbies("Sports")
                .uploadPicture("1.jpeg")
                .setCurrentAddress("CurrentAddressValue")
                .setState("Rajasthan")
                .setCity("Jaipur")
                .submit();

        registrationPage.checkResult("Student Name", "FirstName LastName")
                .checkResult("Student Email", "useremail@value.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9183214567")
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Music, Sports")
                .checkResult("Picture", "1.jpeg")
                .checkResult("Address", "CurrentAddressValue")
                .checkResult("State and City", "Rajasthan Jaipur");

        //sleep(5000);
    }

    @Test
    void fillOnlyRequiredFieldsFormTest() {
        registrationPage.openPage()
                .setFirstName("FirstName")
                .setLastName("LastName")
                .setGender("Female")
                .setUserNumber("9183214567")
                .setDateOfBirth("30", "July", "2008")
                .submit();

        registrationPage.checkResult("Student Name", "FirstName LastName")
                .checkResult("Student Email", "\t")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9183214567")
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Subjects", "\t")
                .checkResult("Hobbies", "\t")
                .checkResult("Picture", "\t")
                .checkResult("Address", "\t")
                .checkResult("State and City", "\t")
                .registrationSuccessCheck();

        //sleep(5000);
    }

    @Test
    void allFieldsAreEmptyTest() {
        registrationPage.openPage()
                .submit();

        registrationPage.registrationFailureCheck();

    }

    @Test
    void phone9DigitsTest() {
        registrationPage.openPage()
                .setFirstName("FirstName")
                .setLastName("LastName")
                .setGender("Female")
                .setUserNumber("123456789")
                .submit();

        registrationPage.registrationFailureCheck();

    }
}
