package org.missdirectory.parser;

import org.junit.jupiter.api.Test;
import org.missdirectory.commands.Command;
import org.missdirectory.commands.ListCommand;
import org.missdirectory.exceptions.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class ListCommandParserTest {

    @Test
    void parseListCommand() {
        assertDoesNotThrow(() -> {
            Command testCommand = ListCommandParser.parse("");
            assertEquals(ListCommand.class, testCommand.getClass());
        });
        assertDoesNotThrow(() -> {
            Command testCommand = ListCommandParser.parse(null);
            assertEquals(ListCommand.class, testCommand.getClass());
        });
    }

    @Test
    void parseListCommand_throwsParseException() {
        assertThrows(ParseException.class, () -> ListCommandParser.parse("test"));
        assertThrows(ParseException.class, () -> ListCommandParser.parse("test test2"));
        assertThrows(ParseException.class, () -> ListCommandParser.parse("\0"));
    }
}
