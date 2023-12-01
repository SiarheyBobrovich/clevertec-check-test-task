package main.java.ru.clevertec.check.config;

import main.java.ru.clevertec.check.dto.ArgsWrapper;
import main.java.ru.clevertec.check.dto.CommandLineArgumentContainer;

import java.util.Arrays;

public class CommandLineArgumentResolver {

    public static CommandLineArgumentContainer splitArgs(String[] args) {
        ArgsWrapper argsWrapper = new ArgsWrapper();

        Arrays.stream(args)
                .forEach(arg -> {
                    if (arg.startsWith("pathToFile")) {
                        argsWrapper.putProperty(ArgsWrapper.READ_FROM_FILE_PATH, arg.split("=")[1]);

                    } else if (arg.startsWith("saveToFile")) {
                        argsWrapper.putProperty(ArgsWrapper.SAVE_TO_FILE_PATH, arg.split("=")[1]);

                    } else {
                        argsWrapper.addAppArg(arg);
                    }
                });

        return argsWrapper;
    }
}
