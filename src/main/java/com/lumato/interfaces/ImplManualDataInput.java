package com.lumato.interfaces;

import com.lumato.appfunctions.appnavigation.Shortcuts;
import com.lumato.appfunctions.appnavigation.menuchoice.MenuSelect;
import com.lumato.tools.CLS;
import com.lumato.tools.DataReader;

public class ImplManualDataInput implements InterfaceUserSelect {
    @Override
    public void printHeader() {
        System.out.println("\nPlease enter the date in DD-MM-YYYY format: ");

    }

    @Override
    public void printOptions() {

    }

    @Override
    public String validateUserInput() {
        String dataRegex = "(^(((0[1-9]|1[0-9]|2[0-8])[-](0[1-9]|1[012]))|((29|30|31)[-](0[13578]|1[02]))|((29|30)[-](0[4,6,9]|11)))[-](19|[2-9][0-9])\\d\\d$)|(^29[-]02[-](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)\n";
        String infoWhenWrong = "\nIncorrect input. Please enter the date in DD-MM-YYYY format: ";
        return  MenuSelect.validateInput(dataRegex,"",infoWhenWrong);

    }

    @Override
    public void selectedOptions(String choice) {

    }
}