package com.lumato.interfaces;

import java.io.IOException;

public interface InterfaceUserSelect {
    void printHeader();

    void printOptions();

    String validateUserInput();

    void selectedOptions(String choice);

}
