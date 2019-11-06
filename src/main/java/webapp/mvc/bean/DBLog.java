package webapp.mvc.bean;

import java.io.Serializable;

public class DBLog implements Serializable {

    private static final long serialVersionUID = 1L;
    private int IDLOG;
    private String LOGSTRING;

    public DBLog() {
    }

    public DBLog(int idLog, String logString) {
        this.IDLOG = idLog;
        this.LOGSTRING = logString;
    }

    public int getIDLOG() {
        return IDLOG;
    }

    public void setIDLOG(int IDLOG) {
        this.IDLOG = IDLOG;
    }

    public String getLOGSTRING() {
        return LOGSTRING;
    }

    public void setLOGSTRING(String LOGSTRING) {
        this.LOGSTRING = LOGSTRING;
    }



}
