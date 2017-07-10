package com.agit.crm.infrastructure.component.xls;

import com.agit.crm.infrastructure.component.commons.FileIOCommons;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author bayutridewanto
 */
public class XlsWriterTest {

    private static final String SHEET_NAME = "student_sheet";

    public XlsWriterTest() {
    }

    @Test
    public void testSomeMethod() throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        XlsWriter<Student> jxl = new XlsWriter<>(Student.class);
        jxl.writeThisObjectToFile(createStudent(), FileIOCommons.ABS_FILE_LOC_XLS, SHEET_NAME);
    }

    private static List<Student> createStudent() {
        List<Student> l = new ArrayList();
        Student student = new Student();
        student.setEnglish("89.0");
        student.setName("System");
        student.setScience("56");
        student.setMaths("80");
        for (int i = 1; i < 100; i++) {
            l.add(student);
        }
        return l;
    }

}
