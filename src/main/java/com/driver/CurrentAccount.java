package com.driver;
import java.util.Arrays;
import java.util.Random;

public class CurrentAccount extends BankAccount {
    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    private String tradeLicenseId; //consists of Uppercase English characters only

    private static final double MIN_BALANCE = 5000;

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, MIN_BALANCE);
        this.tradeLicenseId = tradeLicenseId;
        validateLicenseId();
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if (isValidLicenseId(tradeLicenseId)) {
            return;
        }
        char[] licenseId = tradeLicenseId.toCharArray();
        for (int i = 1; i < licenseId.length; i++) {
            if (licenseId[i] == licenseId[i - 1]) {
                licenseId[i] = (char) (licenseId[i] + 1);
            }
        }
        tradeLicenseId = new String(licenseId);
        if (isValidLicenseId(tradeLicenseId)) {
            return;
        }
        throw new Exception("Valid License can not be generated");
    }

    private boolean isValidLicenseId(String tradeLicenseId) {
        for (int i = 1; i < tradeLicenseId.length(); i++) {
            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}

