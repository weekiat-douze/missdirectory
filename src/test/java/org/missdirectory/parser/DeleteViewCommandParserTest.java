package org.missdirectory.parser;

import org.junit.jupiter.api.Test;
import org.missdirectory.exceptions.ParseException;
import org.missdirectory.viewcommands.DeleteViewCommand;
import org.missdirectory.viewcommands.ShowViewCommand;
import org.missdirectory.viewcommands.ViewCommand;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeleteViewCommandParserTest {

    @Test
    void parseShowViewCommand() {
        ArrayList<String> templateListString = new ArrayList<>();
        templateListString.add("Some_template");
        assertDoesNotThrow(() -> {
            ViewCommand test = DeleteViewCommandParser.parse("1", templateListString);
            assertEquals(DeleteViewCommand.class, test.getClass());
        });
    }

    @Test
    void nonIntegerArgument_throwsParseException() {
        ArrayList<String> templateListString = new ArrayList<>();
        templateListString.add("Some_template");
        assertThrows(ParseException.class, () -> DeleteViewCommandParser.parse("abc", templateListString));
    }
    @Test
    void indexOutOfBounds_throwsParseException() {
        ArrayList<String> templateListString = new ArrayList<>();
        templateListString.add("Some_template");
        assertThrows(ParseException.class, () -> DeleteViewCommandParser.parse("2", templateListString));
        assertThrows(ParseException.class, () -> DeleteViewCommandParser.parse("-1", templateListString));
        assertThrows(ParseException.class, () -> DeleteViewCommandParser.parse("0", templateListString));
        assertThrows(ParseException.class, () -> DeleteViewCommandParser.parse("20", templateListString));
    }

}
