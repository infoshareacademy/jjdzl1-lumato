package com.lumato.interfaces;

import com.lumato.appfunctions.appnavigation.menuchoice.MenuSelect;

public class ImplManualDataInput implements InterfaceUserSelect {
    @Override
    public void printHeader() {
        System.out.println("Wprowadz date w formacie DD-MM-YYYY");

    }

    @Override
    public void printOptions() {

    }

    @Override
    public String validateUserInput() {
        String dataRegex = "(^(((0[1-9]|1[0-9]|2[0-8])[-](0[1-9]|1[012]))|((29|30|31)[-](0[13578]|1[02]))|((29|30)[-](0[4,6,9]|11)))[-](19|[2-9][0-9])\\d\\d$)|(^29[-]02[-](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)\n";
        return  MenuSelect.validateInput(dataRegex,"","");

    }

    @Override
    public void selectedOptions(String choice) {

    }
}