package name.juhasz.judit.udacity.reportcard;

import java.util.ArrayList;

public class ReportCard {

    public static final int GRADE_FAIL = 1;
    public static final int GRADE_PASS = 2;
    public static final int GRADE_SATISFACTORY = 3;
    public static final int GRADE_GOOD = 4;
    public static final int GRADE_EXCELLENT = 5;

    private ArrayList<String> mCourseTitle;
    private ArrayList<Integer> mCourseGrade;

    public ReportCard() {
        mCourseTitle = new ArrayList<>();
        mCourseGrade = new ArrayList<>();
    }

    public boolean addCourse(String title, int grade) {
        if (!isCourseTitleValid(title) || !isCourseGradeValid(grade) ||
                mCourseTitle.contains(title)) {
            return false;
        }
        mCourseTitle.add(title);
        mCourseGrade.add(grade);
        return true;
    }

    private boolean isCourseTitleValid(String title) {
        return title != null && !title.isEmpty();
    }

    private boolean isCourseGradeValid(int grade){
        return GRADE_FAIL == grade || GRADE_PASS == grade || GRADE_SATISFACTORY == grade ||
                GRADE_GOOD == grade || GRADE_EXCELLENT == grade;
    }
}
