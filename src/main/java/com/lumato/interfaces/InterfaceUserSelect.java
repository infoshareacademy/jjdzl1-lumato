package com.lumato.interfaces;

import java.io.IOException;

public interface UserSelect {
    void PrintHeader();

    void PrintOptions();

    char ValidateUserInput();

    void SelectedOptions(char choice);




}
