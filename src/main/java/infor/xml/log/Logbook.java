package infor.xml.log;

import infor.xml.enums.ActionState;

import java.util.ArrayList;

/**
 * 日志
 */
public class Logbook extends ArrayList<LogLine> {

    public void success(String action) {
        super.add(new LogLine(action,ActionState.SUCCESS,"成功"));
    }

    public void success(String action,String description) {
        super.add(new LogLine(action,ActionState.SUCCESS,description));
    }

    public void warning(String action,String description) {
        super.add(new LogLine(action,ActionState.WARNING,description));
    }

    public void generalError(String action,String description) {
        super.add(new LogLine(action,ActionState.GENERAL_ERROR,description));
    }

    public void seriousError(String action,String description) {
        super.add(new LogLine(action,ActionState.SERIOUS_ERROR,description));
    }

}
