package com.lumato.tools;

public enum AppMessages {

    APP_EXIT("Wpisz 'q', a nastêpnie naciœnij 'enter' by opuœciæ aplikacjê"),
    PREV_MENU("Wpisz 'p', a nastêpnie naciœnij 'enter' by wrócić do poprzedniego widoku");

    private String message;

    AppMessages(String message){
        this.message = message;
    }

    String getMessage() {
        return message;
    }
}
