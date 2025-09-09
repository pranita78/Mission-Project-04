package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.CollegeModel;
import in.co.rays.proj4.model.StudentModel;
import in.co.rays.proj4.model.UserModel;

public class TestStudentModel {

	public static void main(String[] args) throws Exception {

//		   testAdd();
//		   testUpdate();
		   testDelete();
//		   testfindByPk();
//		   testfindByEmail();
//		   testsearch();
//		   testlist();
	}
	
private static void testlist() throws Exception {
		
		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();

		List list = new ArrayList();
		
		list = model.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (StudentBean) it.next();

			System.out.println("\t" + bean.getId());
			System.out.println("\t" + bean.getFirstName());
			System.out.println("\t" + bean.getLastName());
			System.out.println("\t" + bean.getDob());
			System.out.println("\t" + bean.getGender());
			System.out.println("\t" + bean.getMobileNo());
			System.out.println("\t" + bean.getEmail());
			System.out.println("\t" + bean.getCollegeId());
			System.out.println("\t" + bean.getCollegeName());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}
		
	}

	public static void testAdd() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		StudentBean bean = new StudentBean();

		bean.setFirstName("Pari");
		bean.setLastName("Sonone");
		bean.setDob(sdf.parse("28-2-2004"));
		bean.setGender("Female");
		bean.setMobileNo("8269650503");
		bean.setEmail("pari@gmail.com");
		bean.setCollegeId(1L);
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		StudentModel model = new StudentModel();
		model.add(bean);
	}

	public static void testUpdate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		StudentBean bean = new StudentBean();
		bean.setId(7);
		bean.setFirstName("Muskan");
		bean.setLastName("Parmar");
		bean.setDob(sdf.parse("15-05-1998"));
		bean.setGender("female");
		bean.setMobileNo("8269650503");
		bean.setEmail("muskan@gmail.com");
		bean.setCollegeId(7L);
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("Admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		StudentModel model = new StudentModel();
		model.update(bean);

	}

	public static void testDelete() throws Exception {
	    StudentBean bean = new StudentBean();
	    bean.setId(5L); // ✅ ID set karo yahan
	    StudentModel model = new StudentModel();
	    model.delete(bean); // ✅ Bean pass karo, int nahi
	}

	public static void testfindByPk() throws Exception {

		StudentModel model = new StudentModel();
		StudentBean bean = model.findByPk(11);
		if (bean != null) {
			System.out.println("\t" + bean.getId());
			System.out.println("\t" + bean.getFirstName());
			System.out.println("\t" + bean.getLastName());
			System.out.println("\t" + bean.getDob());
			System.out.println("\t" + bean.getGender());
			System.out.println("\t" + bean.getMobileNo());
			System.out.println("\t" + bean.getEmail());
			System.out.println("\t" + bean.getCollegeId());
			System.out.println("\t" + bean.getCollegeName());
            System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("id does not exist....!");

		}
	}

	public static void testfindByEmail() throws Exception {

		StudentModel model = new StudentModel();
		StudentBean bean = model.findByEmailId("shashank@gmail.com");
		if (bean != null) {
			System.out.println("\t" + bean.getId());
			System.out.println("\t" + bean.getFirstName());
			System.out.println("\t" + bean.getLastName());
			System.out.println("\t" + bean.getDob());
			System.out.println("\t" + bean.getGender());
			System.out.println("\t" + bean.getMobileNo());
			System.out.println("\t" + bean.getEmail());
			System.out.println("\t" + bean.getCollegeId());
			System.out.println("\t" + bean.getCollegeName());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("LoginId does not exist....!");

		}
	}

	public static void testsearch() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		StudentBean bean = new StudentBean();
//	    bean.setId(1);
//		bean.setFirstName("Riya");
//		bean.setLastName("Thakur");
//		bean.setDob(sdf.parse("07-03-2001"));
//		bean.setGender("Female");
//		bean.setMobileNo("8269650503");
//		bean.setEmail("riya@gmail.com");
//		bean.setCollegeId(7L);
//		bean.setCollegeName("MIT");

		StudentModel model = new StudentModel();
		List list = model.search(bean, 1, 5);
		Iterator<StudentBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println("\t" + bean.getId());
			System.out.println("\t" + bean.getFirstName());
			System.out.println("\t" + bean.getLastName());
			System.out.println("\t" + bean.getDob());
			System.out.println("\t" + bean.getGender());
			System.out.println("\t" + bean.getMobileNo());
			System.out.println("\t" + bean.getEmail());
			System.out.println("\t" + bean.getCollegeId());
			System.out.println("\t" + bean.getCollegeName());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}

	}

}