package com.lumato.tools;

public enum AppMessages {

    EXIT_INFO("('p', 'enter' - poprzednie menu / 'q', 'enter' - wyjście z aplikacji)"),
    PREVIOUS("p - powrót do poprzedniego menu"),
    APP_EXIT("q - wyjście z aplikacji"),
    LOGOUT(">>Tutaj informacja jak się wylogować<<"),
    AFTER_EXIT_INFO("Dziękujemy za skorzystanie z aplikacji. Do zobaczenia!"),
    YES_NO_MSG("Wpisz 'tak' lub 'nie' i naciśnij enter: ");

    private String message;

    AppMessages(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
