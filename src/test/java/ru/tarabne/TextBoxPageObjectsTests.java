package ru.tarabne;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;


public class TextBoxPageObjectsTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFullFormTest() {
        textBoxPage.openPage()
                .setFullName("TestFullName")
                .setEmailInput("Test@Email.com")
                .setCurrentAddressInput("TestCurrentAddress")
                .setPermanentAddressInput("TestPermanentAddress")
                .submit();

        textBoxPage.nameCheck("TestFullName")
                .emailCheck("Test@Email.com")
                .currentAddressCheck("TestCurrentAddress")
                .permanentAddressCheck("TestPermanentAddress");
    }
}
