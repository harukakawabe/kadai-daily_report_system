package models.validators;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import models.Report;

public class ReportValidator {
    public static List<String> validate(Report r) {
        List<String> errors = new ArrayList<String>();

        String title_error = _validateTitle(r.getTitle());
        if (!title_error.equals("")) {
            errors.add(title_error);
        }

        String content_error = _validateContent(r.getContent());
        if (!content_error.equals("")) {
            errors.add(content_error);
        }
        String attendance_time_error = _validateAttendance_time(r.getAttendance_time());
        if (!attendance_time_error.equals("")) {
            errors.add(attendance_time_error);
        }

        String leave_time_error = _validateLeave_time(r.getLeave_time());
        if (!leave_time_error.equals("")) {
            errors.add(leave_time_error);
        }


        return errors;
    }

    private static String _validateTitle(String title) {
        if (title == null || title.equals("")) {
            return "タイトルを入力してください。";
        }

        return "";
    }

    private static String _validateContent(String content) {
        if (content == null || content.equals("")) {
            return "内容を入力してください。";
        }

        return "";
    }

    private static String _validateAttendance_time(Time attendance_time) {
        if (attendance_time == null || attendance_time.equals("") || attendance_time.toString().equals("00:00:00")) {
            return "出勤時間を入力してください。";
        }

        return "";
    }

    private static String _validateLeave_time(Time leave_time) {
        if (leave_time == null || leave_time.equals("") || leave_time.toString().equals("00:00:00")) {
            return "退勤時間を入力してください。";
        }
        return "";
    }
}