package com.chefmic.leetcode.string;

/**
 * Created by cyuan on 1/17/17.
 */
public class Q468ValidateIPAddress {

    private static final String ERROR = "Neither";

    public static void main(String[] args) {
        Q468ValidateIPAddress validator = new Q468ValidateIPAddress();
        System.out.println(validator.validIPAddress("172.16.254.1"));
    }

    public String validIPAddress(String IP) {
        if (IP.contains(".")) {
            return validateIPv4Address(IP);
        } else {
            return validateIPV6Address(IP);
        }
    }

    private String validateIPV6Address(String IP) {
        String[] parts = IP.split(":");
        if (parts == null || parts.length != 8) {
            return ERROR;
        }

        for (String part : parts) {
            if (!validateIPv6Part(part)) {
                return ERROR;
            }
        }

        return "IPv6";
    }

    private boolean validateIPv6Part(String part) {
        try {
            if (part.length() != 4 && part.length() != 1) return false;
            Integer.parseInt(part, 16);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String validateIPv4Address(String IP) {
        String[] fragments = IP.split("\\.");
        if (fragments == null || fragments.length != 4) {
            return ERROR;
        }

        for (String fragment : fragments) {
            if (!validateIPv4Part(fragment)) {
                return ERROR;
            }
        }
        return "IPv4";
    }

    private boolean validateIPv4Part(String part) {
        if (part.startsWith("0+")) {
            return false;
        }
        try {
            int num = Integer.parseInt(part);
            return num >= 0 && num < 256;
        } catch (Exception e) {
            return false;
        }
    }


}
