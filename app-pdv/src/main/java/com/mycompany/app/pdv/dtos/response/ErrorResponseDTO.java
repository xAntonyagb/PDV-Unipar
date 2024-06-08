package com.mycompany.app.pdv.dtos.response;

import java.util.List;

/**
 *
 * @author Antony
 */
public class ErrorResponseDTO {
    private List<String> errorList;

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }

    public String getErrors() {
        if (errorList == null || errorList.isEmpty()) {
            return "Nenhum erro";
        } else {
            return String.join(",\n", errorList);
        }
    }
}
