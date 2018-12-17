package com.lumato.interfaces;

import java.io.IOException;

public interface InterfaceUserSelect {
    void PrintHeader();

    void PrintOptions();

    String ValidateUserInput();

    void SelectedOptions(String choice);

}
