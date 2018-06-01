package by.intervale.exception;

import by.intervale.utils.Constants;

public class FileLineException extends IllegalArgumentException {
    
    private static final long serialVersionUID = 1L;
    private String csvLine;
    
    public FileLineException() {
        super();
    }
    
    public FileLineException(Exception exception) {
        super(exception);
    }
    
    public FileLineException(Exception exception, String csvLine) {
        super(exception);
        this.csvLine = csvLine;
    }

    public FileLineException(String cause, String csvLine) {
        super(cause);
        this.csvLine = csvLine;
    }

    public String toString() {
        return csvLine + Constants.ERROR_EXCEPTION_DELIMETER + getMessage();
    }
    
}


