package validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;
import java.util.Set;

/**
 * Provides static validation utilities for the Personal Finance Manager (PFM)
 * application.
 * @author Selina Zhu
 * @author Tasfia Rahman
 * @author David Guanga
 */
public class Validation {

    private static final int MIN_USERNAME_LENGTH = 3;
    private static final int MAX_USERNAME_LENGTH = 20;
    private static final int MIN_PASSWORD_LENGTH = 8;

    private static final String REQUIRED_HEADER = "Date,Category,Amount";

    private static final Set<String> VALID_CATEGORIES = Set.of(
        "Compensation", "Allowance", "Investments",
        "Home", "Utilities", "Food", "Appearance", "Work",
        "Education", "Transportation", "Entertainment",
        "Professional Services", "Other"
    );

    /**
     * Validates a user's username.
     *
     * @param username the username entered by the user
     * @return true if the username satisfies all username requirements;
     *         otherwise false
     * @author Selina Zhu
     */
    public static boolean isValidUsername(String username) {
        if (username == null) {
            return false;
        }
        String trimmed = username.trim();
        if (trimmed.length() < MIN_USERNAME_LENGTH || trimmed.length() > MAX_USERNAME_LENGTH) {
            return false;
        }
        return trimmed.matches("[A-Za-z][A-Za-z0-9_]*");
    }

    /**
     * Validates a user's password.
     *
     * @param password the password entered by the user
     * @return true if the password satisfies all password requirements;
     *         otherwise false
     * @author Selina Zhu
     */
    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }
        boolean hasLetter = password.chars().anyMatch(Character::isLetter);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        return hasLetter && hasDigit;
    }

    /**
     * Validates the user's secret question.
     *
     * @param secretQuestion the secret question entered by the user
     * @return true if the secret question is valid; otherwise false
     * @author Selina Zhu
     */
    public static boolean isValidSecretQuestion(String secretQuestion) {
        return secretQuestion != null && !secretQuestion.trim().isEmpty();
    }

    /**
     * Validates the user's secret answer.
     *
     * @param secretAnswer the secret answer entered by the user
     * @return true if the secret answer is valid; otherwise false
     * @author Selina Zhu
     */
    public static boolean isValidSecretAnswer(String secretAnswer) {
        return secretAnswer != null && !secretAnswer.trim().isEmpty();
    }

    /**
     * Checks whether a file name follows the required YYYY.csv pattern.
     *
     * @param fileName the file name or fully qualified path to validate
     * @return true if the base file name matches YYYY.csv, false otherwise
     * @author Tasfia Rahman
     */
    public static boolean isValidFileName(String fileName) {
        if (fileName == null) {
            return false;
        }
        String baseName = Paths.get(fileName).getFileName().toString();
        return baseName.matches("\\d{4}\\.csv");
    }

    /**
     * Checks whether a CSV file exists, is readable, and begins with the
     * required header line.
     *
     * @param fileName the file name or fully qualified path of the CSV file
     * @return true if the file exists, can be read, and has a valid header,
     *         false otherwise
     * @author Tasfia Rahman
     */
    public static boolean isValidCsvFile(String fileName) {
        if (!isValidFileName(fileName)) {
            return false;
        }
        Path path = Paths.get(fileName);
        if (!Files.isReadable(path)) {
            return false;
        }
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String firstLine = reader.readLine();
            return firstLine != null && isValidHeader(firstLine);
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Checks whether a header line matches the required CSV header.
     *
     * @param headerLine the first line of a CSV file
     * @return true if the header is valid, false otherwise
     * @author Tasfia Rahman
     */
    public static boolean isValidHeader(String headerLine) {
        if (headerLine == null) {
            return false;
        }
        String cleaned = headerLine.replace("﻿", "").trim();
        return cleaned.equalsIgnoreCase(REQUIRED_HEADER);
    }

    /**
     * Checks whether a CSV data file already exists for the given year in the
     * given directory.
     *
     * @param directory the directory to search
     * @param year the four-digit year to look for
     * @return true if a file named YYYY.csv exists in the directory, false otherwise
     * @author Tasfia Rahman
     */
    public static boolean fileExistsForYear(String directory, int year) {
        if (directory == null) {
            return false;
        }
        Path candidate = Paths.get(directory, year + ".csv");
        return Files.exists(candidate);
    }

    /**
     * Checks to see if the date is in the proper format and represents a
     * valid month, date, and year.
     *
     * @param date the date as a String
     * @return true if date is in the correct format MM/DD/YYYY and represents
     *         a real calendar date
     * @author David Guanga
     */
    public static boolean isValidDateFormat(String date) {
        if (date == null || !date.matches("\\d{2}/\\d{2}/\\d{4}")) {
            return false;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
                .withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Checks that every date in a CSV file belongs to the same, expected year.
     *
     * @param dates the raw date strings read from the file (MM/DD/YYYY each)
     * @param expectedYear the year all dates must belong to, typically parsed
     *                     from the YYYY.csv file name
     * @return true if every date is valid and falls within expectedYear
     * @author David Guanga
     */
    public static boolean isSameYear(List<String> dates, int expectedYear) {
        if (dates == null || dates.isEmpty()) {
            return false;
        }
        for (String date : dates) {
            if (!isValidDateFormat(date)) {
                return false;
            }
            int year = Integer.parseInt(date.substring(6));
            if (year != expectedYear) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks to see if the category matches one of the accepted categories.
     *
     * @param categ the name of the category to validate
     * @return true if the input category is one of the accepted income or
     *         expense categories
     * @author David Guanga
     */
    public static boolean isValidCategory(String categ) {
        return categ != null && VALID_CATEGORIES.contains(categ.trim());
    }

    /**
     * Checks to see if the amount can be converted to a whole-dollar number.
     *
     * @param am the amount to process and validate
     * @return true if am is a valid whole-dollar integer amount
     * @author David Guanga
     */
    public static boolean isValidAmount(String am) {
        if (am == null || !am.trim().matches("-?\\d+")) {
            return false;
        }
        try {
            Integer.parseInt(am.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks to see if a single CSV row has a valid date, category, and amount.
     *
     * @param fields the raw row fields in order: {date, category, amount}
     * @return true if the row has a valid date format, category, and amount
     * @author David Guanga
     */
    public static boolean isValidRecord(String[] fields) {
        if (fields == null || fields.length != 3) {
            return false;
        }
        return isValidDateFormat(fields[0].trim())
                && isValidCategory(fields[1].trim())
                && isValidAmount(fields[2].trim());
    }

    /**
     * Checks to see if a raw CSV line has a valid date, category, and amount.
     * Splits the line on commas and delegates to {@link #isValidRecord(String[])}.
     *
     * @param line a single raw line from a CSV file, e.g. "07/06/2026,Food,-50"
     * @return true if the line splits into exactly 3 fields and each field is valid
     * @author David Guanga
     */
    public static boolean isValidRecord(String line) {
        if (line == null) {
            return false;
        }
        return isValidRecord(line.split(",", -1));
    }
}
