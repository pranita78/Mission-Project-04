 package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.TimetableBean;
import in.co.rays.proj4.model.TimetableModel;

public class TestTimetableModel {

	public static void main(String[] args) throws Exception {
//		 testAdd();
//		 testUpdate();
		 testDelete();
//		 testfindByPk();
     //    testsearch();

	}

	public static void testAdd() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		TimetableBean bean = new TimetableBean();
		bean.setSemester("1st Semester");
		bean.setDescription("Timetable for first M1");
		bean.setExamDate(sdf.parse("20-08-2025"));
		bean.setExamTime("8:00 AM - 11:00 AM");
		bean.setCourseId(1);
		bean.setSubjectId(1);
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		TimetableModel model = new TimetableModel();
		model.add(bean);
	}

	public static void testUpdate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		TimetableBean bean = new TimetableBean();
		bean.setId(1);
		bean.setSemester("First Semester");
		bean.setDescription("Timetable for first Computer Networking");
		bean.setExamDate(sdf.parse("23-08-2025"));
		bean.setExamTime("8:00 AM - 11:00 AM");
		bean.setCourseId(1);
		bean.setSubjectId(1);
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		TimetableModel model = new TimetableModel();
		model.update(bean);

	}

	public static void testDelete() throws Exception {

		TimetableModel model = new TimetableModel();
		TimetableBean bean = new TimetableBean();
		bean.setId(2);
		model.delete(bean);
	}

	public static void testfindByPk() throws Exception {

		TimetableModel model = new TimetableModel();
		TimetableBean bean = model.findByPk(4);
		if (bean != null) {
			System.out.println("\t" + bean.getId());
			System.out.println("\t" + bean.getSemester());
			System.out.println("\t" + bean.getDescription());
			System.out.println("\t" + bean.getExamDate());
			System.out.println("\t" + bean.getExamTime());
			System.out.println("\t" + bean.getCourseId());
			System.out.println("\t" + bean.getCourseName());
			System.out.println("\t" + bean.getSubjectId());
			System.out.println("\t" + bean.getSubjectName());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("id does not exist....!");

		}
	}

	public static void testsearch() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		TimetableBean bean = new TimetableBean();
		  bean.setId(5);
		  bean.setSemester("1st Semester");
		  bean.setDescription("Timetable for first M1");
		  bean.setExamDate(sdf.parse("2025-08-20"));
		  bean.setExamTime("Developer");
		  bean.setCourseId(1);
		  bean.setCourseName("Java");
		  bean.setSubjectId(1);
		  bean.setSubjectName("Java");

		TimetableModel model = new TimetableModel();
		List list = model.search(bean, 1, 5);
		Iterator<TimetableBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println("\t" + bean.getId());
			System.out.println("\t" + bean.getSemester());
			System.out.println("\t" + bean.getDescription());
			System.out.println("\t" + bean.getExamDate());
			System.out.println("\t" + bean.getExamTime());
			System.out.println("\t" + bean.getCourseId());
			System.out.println("\t" + bean.getCourseName());
			System.out.println("\t" + bean.getSubjectId());
			System.out.println("\t" + bean.getSubjectName());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}

	}

}