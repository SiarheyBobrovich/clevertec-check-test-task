package ru.clevertec.check.dto;

public interface CommandLineArgumentContainer {

    String[] getAppArguments();

    String getReadFromFilePath();
    String getSaveToFilePath();
}
