package infor.xml.log;

import infor.xml.enums.ActionState;

import java.util.Date;

/**
 * 日志中的一行
 */
public class LogLine {

    /**
     * 动作
     */
    private String action;

    /**
     * 状态
     */
    private ActionState state;

    /**
     * 描述
     */
    private String description;

    /**
     * 时间
     */
    private final Date date=new Date();

    public LogLine() {
    }

    public LogLine(String action, ActionState state, String description) {
        this.action = action;
        this.state = state;
        this.description = description;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public ActionState getState() {
        return state;
    }

    public void setState(ActionState state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "LogLine{" +
                "action='" + action + '\'' +
                ", state=" + state +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
