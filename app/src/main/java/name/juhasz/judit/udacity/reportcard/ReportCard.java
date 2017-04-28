package name.juhasz.judit.udacity.reportcard;

import java.util.ArrayList;
import java.util.List;

public class ReportCard {

    public static final int GRADE_FAIL = 1;
    public static final int GRADE_PASS = 2;
    public static final int GRADE_SATISFACTORY = 3;
    public static final int GRADE_GOOD = 4;
    public static final int GRADE_EXCELLENT = 5;

    private ArrayList<String> mCourseTitles;
    private ArrayList<Integer> mCourseGrades;

    public ReportCard() {
        mCourseTitles = new ArrayList<>();
        mCourseGrades = new ArrayList<>();
    }

    public boolean addCourse(String title, int grade) {
        if (!isCourseTitleValid(title) || !isCourseGradeValid(grade) ||
                mCourseTitles.contains(title)) {
            return false;
        }
        mCourseTitles.add(title);
        mCourseGrades.add(grade);
        return true;
    }

    public List<String> getCourseTitles() {
        return mCourseTitles;
    }

    public int getGrade(String courseTitle) {
        int index = mCourseTitles.indexOf(courseTitle);
        return mCourseGrades.get(index);
    }

    public boolean updateGrade(String courseTitle, int newGrade) {
        int index = mCourseTitles.indexOf(courseTitle);

        if (-1 == index || !isCourseGradeValid(newGrade)) {
            return false;
        }

        mCourseGrades.set(index, newGrade);
        return true;
    }

    public boolean removeCourse(String title) {
        int index = mCourseTitles.indexOf(title);

        if (-1 == index) {
            return false;
        }

        mCourseTitles.remove(index);
        mCourseGrades.remove(index);
        return true;
    }

    public double getAverageGrade() {
        if (mCourseGrades.isEmpty()) {
            return 0;
        }

        int sumOfGrades = 0;
        for (int grade : mCourseGrades) {
            sumOfGrades = sumOfGrades + grade;
        }
        return sumOfGrades / (double) mCourseGrades.size();
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < mCourseTitles.size(); ++i) {
            result = result + mCourseTitles.get(i) + ": " + mCourseGrades.get(i) + "\n";
        }
        return result;
    }

    private boolean isCourseTitleValid(String title) {
        return title != null && !title.isEmpty();
    }

    private boolean isCourseGradeValid(int grade) {
        return GRADE_FAIL == grade || GRADE_PASS == grade || GRADE_SATISFACTORY == grade ||
                GRADE_GOOD == grade || GRADE_EXCELLENT == grade;
    }
}
