package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.model.CourseModel;

public class TestCourseModel {

	public static void main(String[] args) throws Exception {
//		 testAdd();
//		 testAdd1();
//		 testUpdate();
	 testDelete();
//		 testfindByPk();
//		 testfindByName();
		 testsearch();

	}

	public static void testAdd() throws Exception {
		CourseBean bean = new CourseBean();
		bean.setName("Java Adv");
		bean.setDuration("6 months");
		bean.setDescription("Java , MySQL");
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CourseModel model = new CourseModel();
		model.add(bean);
	}
	
	public static void testAdd1() throws Exception {
		CourseBean bean = new CourseBean();
		bean.setName("ML");
		bean.setDuration("3 months");
		bean.setDescription("DevOps");
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CourseModel model = new CourseModel();
		model.add(bean);
	}

	public static void testUpdate() throws Exception {
		CourseBean bean = new CourseBean();
		bean.setId(4);
		bean.setName("C, C++");
		bean.setDuration("6 months");
		bean.setDescription("Basic Coding");
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CourseModel model = new CourseModel();
		model.update(bean);

	}

	public static void testDelete() {
		try {
			CourseModel model = new CourseModel();
			model.delete(2);
			System.out.println("Course deleted successfully.");
		} catch (Exception e) {
			e.printStackTrace();  // This will show the real cause
		}
	}
	public static void testfindByPk() throws Exception {

		CourseModel model = new CourseModel();
		CourseBean bean = model.findByPk(4);
		if (bean != null) {
			System.out.println("\t" + bean.getId());
			System.out.println("\t" + bean.getName());
			System.out.println("\t" + bean.getDuration());
			System.out.println("\t" + bean.getDescription());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("id does not exist....!");

		}
	}

	public static void testfindByName() throws Exception {

		CourseModel model = new CourseModel();
		CourseBean bean = model.findByName("Corporate Java");
		if (bean != null) {
			System.out.println("\t" + bean.getId());
			System.out.println("\t" + bean.getName());
			System.out.println("\t" + bean.getDuration());
			System.out.println("\t" + bean.getDescription());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Name does not exist....!");

		}
	}

	public static void testsearch() throws Exception {

		CourseBean bean = new CourseBean();
		//bean.setId(1);
		// bean.setName("Corporate Java");
		// bean.setDuration("3 Months");
		// bean.setDescription("Tester");
		// bean.setCreatedBy("Admin");
		// bean.setModifiedBy("Admin");
		// bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		// bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CourseModel model = new CourseModel();
		List list = model.search(bean, 1, 5);
		Iterator<CourseBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println("\t" + bean.getId());
			System.out.println("\t" + bean.getName());
			System.out.println("\t" + bean.getDuration());
			System.out.println("\t" + bean.getDescription());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}

	}

}