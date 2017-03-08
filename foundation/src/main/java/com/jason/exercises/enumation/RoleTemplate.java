package com.jason.exercises.enumation;

/**
 * Created by shanshouchen@weibangong.com on 2017/3/8.
 */
public enum RoleTemplate {
    /**
     * <code>MEMBER = 0;</code>
     *
     * <pre>
     * 普通员工
     * </pre>
     */
    MEMBER(0, 0),
    /**
     * <code>ADMIN = 1;</code>
     *
     * <pre>
     * 系统管理员
     * </pre>
     */
    ADMIN(1, 1),
    /**
     * <code>TREASURER = 2;</code>
     *
     * <pre>
     * 财务管理员
     * </pre>
     */
    TREASURER(2, 2),
    /**
     * <code>OPERATOR = 3;</code>
     *
     * <pre>
     *人事行政管理员
     * </pre>
     */
    OPERATOR(3, 3),
    /**
     * <code>ANNOUNCER = 4;</code>
     *
     * <pre>
     *公告管理员
     * </pre>
     */
    ANNOUNCER(4, 4),
    /**
     * <code>OUTDOOR = 5;</code>
     *
     * <pre>
     *外勤管理员
     * </pre>
     */
    OUTDOOR(5, 5),
    /**
     * <code>CRM_ADMIN = 6;</code>
     *
     * <pre>
     * CRM管理员
     * </pre>
     */
    CRM_ADMIN(6, 6),
    /**
     * <code>STATISTICS = 7;</code>
     *
     * <pre>
     * 应用数据管理员
     * </pre>
     */
    STATISTICS(7, 7),
    /**
     * <code>FINANCE = 8;</code>
     *
     * <pre>
     * 新的财务管理员 以前的2表示审批管理员
     * </pre>
     */
    FINANCE(8, 8),
    /**
     * <code>ATTENDANCE = 9;</code>
     *
     * <pre>
     *考勤管理员
     * </pre>
     */
    ATTENDANCE(9, 9),
    /**
     * <code>EMAIL = 10;</code>
     *
     * <pre>
     *邮箱管理员
     * </pre>
     */
    EMAIL(10, 10),
    /**
     * <code>TASK = 11;</code>
     *
     * <pre>
     *任务管理员
     * </pre>
     */
    TASK(11, 11),
    /**
     * <code>HR = 12;</code>
     *
     * <pre>
     *人事管理员
     * </pre>
     */
    HR(12, 12),
    /**
     * <code>REPORT = 13;</code>
     *
     * <pre>
     * 汇报管理员
     * </pre>
     */
    REPORT(13, 13),
    /**
     * <code>CONFERENCE_ROOM = 14;</code>
     *
     * <pre>
     * 会议室管理员
     * </pre>
     */
    CONFERENCE_ROOM(14, 14),
    /**
     * <code>PROJECT = 15;</code>
     *
     * <pre>
     *项目管理员
     * </pre>
     */
    PROJECT(15, 15),
    /**
     * <code>AIREPORT = 16;</code>
     *
     * <pre>
     * 智能简报管理员
     * </pre>
     */
    AIREPORT(16, 16),
    /**
     * <code>SALARY = 17;</code>
     *
     * <pre>
     * 薪酬管理员
     * </pre>
     */
    SALARY(17, 17),
    /**
     * <code>ASSETS = 18;</code>
     *
     * <pre>
     *资产管理员
     * </pre>
     */
    ASSETS(18, 18),
    UNRECOGNIZED(-1, -1),
    ;

    /**
     * <code>MEMBER = 0;</code>
     *
     * <pre>
     * 普通员工
     * </pre>
     */
    public static final int MEMBER_VALUE = 0;
    /**
     * <code>ADMIN = 1;</code>
     *
     * <pre>
     * 系统管理员
     * </pre>
     */
    public static final int ADMIN_VALUE = 1;
    /**
     * <code>TREASURER = 2;</code>
     *
     * <pre>
     * 财务管理员
     * </pre>
     */
    public static final int TREASURER_VALUE = 2;
    /**
     * <code>OPERATOR = 3;</code>
     *
     * <pre>
     *人事行政管理员
     * </pre>
     */
    public static final int OPERATOR_VALUE = 3;
    /**
     * <code>ANNOUNCER = 4;</code>
     *
     * <pre>
     *公告管理员
     * </pre>
     */
    public static final int ANNOUNCER_VALUE = 4;
    /**
     * <code>OUTDOOR = 5;</code>
     *
     * <pre>
     *外勤管理员
     * </pre>
     */
    public static final int OUTDOOR_VALUE = 5;
    /**
     * <code>CRM_ADMIN = 6;</code>
     *
     * <pre>
     * CRM管理员
     * </pre>
     */
    public static final int CRM_ADMIN_VALUE = 6;
    /**
     * <code>STATISTICS = 7;</code>
     *
     * <pre>
     * 应用数据管理员
     * </pre>
     */
    public static final int STATISTICS_VALUE = 7;
    /**
     * <code>FINANCE = 8;</code>
     *
     * <pre>
     * 新的财务管理员 以前的2表示审批管理员
     * </pre>
     */
    public static final int FINANCE_VALUE = 8;
    /**
     * <code>ATTENDANCE = 9;</code>
     *
     * <pre>
     *考勤管理员
     * </pre>
     */
    public static final int ATTENDANCE_VALUE = 9;
    /**
     * <code>EMAIL = 10;</code>
     *
     * <pre>
     *邮箱管理员
     * </pre>
     */
    public static final int EMAIL_VALUE = 10;
    /**
     * <code>TASK = 11;</code>
     *
     * <pre>
     *任务管理员
     * </pre>
     */
    public static final int TASK_VALUE = 11;
    /**
     * <code>HR = 12;</code>
     *
     * <pre>
     *人事管理员
     * </pre>
     */
    public static final int HR_VALUE = 12;
    /**
     * <code>REPORT = 13;</code>
     *
     * <pre>
     * 汇报管理员
     * </pre>
     */
    public static final int REPORT_VALUE = 13;
    /**
     * <code>CONFERENCE_ROOM = 14;</code>
     *
     * <pre>
     * 会议室管理员
     * </pre>
     */
    public static final int CONFERENCE_ROOM_VALUE = 14;
    /**
     * <code>PROJECT = 15;</code>
     *
     * <pre>
     *项目管理员
     * </pre>
     */
    public static final int PROJECT_VALUE = 15;
    /**
     * <code>AIREPORT = 16;</code>
     *
     * <pre>
     * 智能简报管理员
     * </pre>
     */
    public static final int AIREPORT_VALUE = 16;
    /**
     * <code>SALARY = 17;</code>
     *
     * <pre>
     * 薪酬管理员
     * </pre>
     */
    public static final int SALARY_VALUE = 17;
    /**
     * <code>ASSETS = 18;</code>
     *
     * <pre>
     *资产管理员
     * </pre>
     */
    public static final int ASSETS_VALUE = 18;
    private final int index;
    private final int value;

    RoleTemplate(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
