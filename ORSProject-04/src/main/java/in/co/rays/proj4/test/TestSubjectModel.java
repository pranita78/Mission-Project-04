package in.co.rays.proj4.test;

import java.sql.Timestamp;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.SubjectBean;
import in.co.rays.proj4.model.SubjectModel;

public class TestSubjectModel {

	public static void main(String[] args) throws Exception {
		// testAdd();
		// testUpdate();
		testDelete();
//		 testfindByPk();
//		 testfindByName();
		// testsearch();

	}

	public static void testAdd() throws Exception {
		SubjectBean bean = new SubjectBean();
		bean.setName("Python");
		bean.setCourseId(9);
		bean.setDescription("Full Python");
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		SubjectModel model = new SubjectModel();
		model.add(bean);
	}

	public static void testUpdate() throws Exception {
		SubjectBean bean = new SubjectBean();
		bean.setId(5);
		bean.setName("Basic DevOps");
		bean.setCourseId(5);
		bean.setDescription("Flow");
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		SubjectModel model = new SubjectModel();
		model.update(bean);

	}

	public static void testDelete() throws Exception {

		SubjectModel model = new SubjectModel();

		SubjectBean bean = new SubjectBean();
		bean.setId(2);

		model.delete(bean);

	}

	public static void testfindByPk() throws Exception {

		SubjectModel model = new SubjectModel();
		SubjectBean bean = model.findByPk(1);
		if (bean != null) {
			System.out.println("\t" + bean.getId());
			System.out.println("\t" + bean.getName());
			System.out.println("\t" + bean.getCourseId());
			System.out.println("\t" + bean.getCourseName());
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

		SubjectModel model = new SubjectModel();
		SubjectBean bean = model.findByName("Python DS");
		if (bean != null) {
			System.out.println("\t" + bean.getId());
			System.out.println("\t" + bean.getName());
			System.out.println("\t" + bean.getCourseId());
			System.out.println("\t" + bean.getCourseName());
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

		SubjectBean bean = new SubjectBean();
//		bean.setId(1);
		bean.setName("Python");
//		bean.setCourseId(101L);
//		bean.setCourseName("Java");
//		bean.setDescription("Description");
//		bean.setCreatedBy("Admin");
//		bean.setModifiedBy("Admin");
//		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
//		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		SubjectModel model = new SubjectModel();
		List list = model.search(bean, 1, 5);
		Iterator<SubjectBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println("\t" + bean.getId());
			System.out.println("\t" + bean.getName());
			System.out.println("\t" + bean.getCourseId());
			System.out.println("\t" + bean.getCourseName());
			System.out.println("\t" + bean.getDescription());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}

	}

}