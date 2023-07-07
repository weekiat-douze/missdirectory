package org.missdirectory.parser;

import org.junit.jupiter.api.Test;
import org.missdirectory.commands.ChangeDirectoryCommand;
import org.missdirectory.commands.Command;
import org.missdirectory.exceptions.ParseException;
import org.missdirectory.model.Directory;

import static org.junit.jupiter.api.Assertions.*;

class ChangeDirectoryCommandParserTest {

    @Test
    void parseChangeDirectoryCommand() {
        assertDoesNotThrow(() -> {
            Command test = ChangeDirectoryCommandParser.parse("");
            assertEquals(ChangeDirectoryCommand.class, test.getClass());
        });
        assertDoesNotThrow(() -> {
            Command test = ChangeDirectoryCommandParser.parse(null);
            assertEquals(ChangeDirectoryCommand.class, test.getClass());
        });
        assertDoesNotThrow(() -> {
            Command test = ChangeDirectoryCommandParser.parse("..");
            assertEquals(ChangeDirectoryCommand.class, test.getClass());
        });
        assertDoesNotThrow(() -> {
            Command test = ChangeDirectoryCommandParser.parse("abcABC0123@_-");
            assertEquals(ChangeDirectoryCommand.class, test.getClass());
        });
    }

    @Test
    void parseChangeDirectoryCommand_throwsParseException() {
        String[] illegalCharactersList = {"/", "\\", "<", ">", "|", "\"", "\0", "*", "?"};
        for(String character: illegalCharactersList) {
            assertThrows(ParseException.class, () -> {
                ChangeDirectoryCommandParser.parse(character);
            });
        }
        for(String character: illegalCharactersList) {
            assertThrows(ParseException.class, () -> {
                ChangeDirectoryCommandParser.parse("abcABC0123@_-" + character);
            });
        }
    }
}
