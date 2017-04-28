package name.juhasz.judit.udacity.reportcard;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent a report card for education systems similar to the Hungarian one.
 * Additional information: https://en.wikipedia.org/wiki/Academic_grading_in_Hungary
 */
public class ReportCard {

    public static final int GRADE_FAIL = 1;
    public static final int GRADE_PASS = 2;
    public static final int GRADE_SATISFACTORY = 3;
    public static final int GRADE_GOOD = 4;
    public static final int GRADE_EXCELLENT = 5;

    /**
     * You need to keep them in sync. The indexes connect the title with the grade.
     */
    private ArrayList<String> mCourseTitles;
    private ArrayList<Integer> mCourseGrades;

    public ReportCard() {
        mCourseTitles = new ArrayList<>();
        mCourseGrades = new ArrayList<>();
    }

    /**
     * Add a course to the report card.
     *
     * @param title The title of the course in the report card. It must not be null or empty string,
     *              and it must not have already present in the report card.
     * @param grade The grade of the course in the report card. It must be one of the valid grades
     *              in the system.
     * @return If the addition was successful. Nothing is modified if it is false.
     */
    public boolean addCourse(String title, int grade) {
        if (!isCourseTitleValid(title) || !isCourseGradeValid(grade) ||
                mCourseTitles.contains(title)) {
            return false;
        }
        mCourseTitles.add(title);
        mCourseGrades.add(grade);
        return true;
    }

    /**
     * Get the titles of the courses added.
     *
     * @return The list of the titles.
     */
    public List<String> getCourseTitles() {
        return mCourseTitles;
    }

    /**
     * Get the grade of the given course title.
     *
     * @param courseTitle The course title of the grade. It must be an existing title.
     * @return The grade of the given title.
     */
    public int getGrade(String courseTitle) {
        int index = mCourseTitles.indexOf(courseTitle);
        return mCourseGrades.get(index);
    }

    /**
     * Update the grade of the given course title.
     *
     * @param courseTitle The title of the course that you want to update. The title must have been
     *                    added earlier.
     * @param newGrade The new grade.
     * @return Indicates whether the title was updated or not. Nothing is modified if it is false.
     */
    public boolean updateGrade(String courseTitle, int newGrade) {
        int index = mCourseTitles.indexOf(courseTitle);

        if (-1 == index || !isCourseGradeValid(newGrade)) {
            return false;
        }

        mCourseGrades.set(index, newGrade);
        return true;
    }

    /**
     * Remove course with the given title.
     *
     * @param title The title of the row you want to remove. It must have added earlier.
     * @return Indicates whether the removal was succeed or not. Nothing will be modified if it is
     * false.
     */
    public boolean removeCourse(String title) {
        int index = mCourseTitles.indexOf(title);

        if (-1 == index) {
            return false;
        }

        mCourseTitles.remove(index);
        mCourseGrades.remove(index);
        return true;
    }

    /**
     * Get the average grade of the added grades.
     *
     * @return The average grade of the added grades. It returns 0 if no grade added so far.
     */
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

    /**
     * Returns the string representation of the report card.
     *
     * @return The string representation of the report card.
     */
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
