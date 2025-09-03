package in.co.rays.proj4.test;

import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.model.CollegeModel;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestCollegeModel {

    public static void main(String[] args) throws Exception {

        // Run whichever test you want
        // testAdd();
        // testUpdate();
       // testDelete();
        // testFindByPk();
        // testFindByName();
         testSearch();
        //
   //testList();
    }

    private static void testAdd() throws Exception {
        CollegeBean bean = new CollegeBean();
        CollegeModel model = new CollegeModel();

        bean.setName("IIM");
        bean.setAddress("ByPass Road");
        bean.setState("Madhya Pradesh");
        bean.setCity("Indore");
        bean.setPhoneNo("1234567890");
        bean.setCreatedBy("admin");
        bean.setModifiedBy("admin");
        bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
        bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

        long pk = model.add(bean);
        System.out.println("College added successfully with PK = " + pk);
    }

    private static void testUpdate() throws Exception {
        CollegeModel model = new CollegeModel();
        CollegeBean bean = model.findByPk(1);

        if (bean != null) {
            bean.setName("LNCT Indore");
            bean.setAddress("Behind Aurobindo Hospital");
            bean.setCity("Indore");
            bean.setState("Madhya Pradesh");
            bean.setPhoneNo("9876543210");
            bean.setModifiedBy("admin");
            bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

            model.update(bean);
            System.out.println("College updated successfully");
        } else {
            System.out.println("College not found for update");
        }
    }

    private static void testDelete() throws Exception {
        CollegeModel model = new CollegeModel();
        CollegeBean bean = new CollegeBean();
        bean.setId(1);

        model.delete(bean);
        System.out.println("College deleted successfully");
    }

    private static void testFindByPk() throws Exception {
        CollegeModel model = new CollegeModel();
        CollegeBean bean = model.findByPk(1);
        if (bean != null) {
            System.out.println("Found: " + bean.getName() + " | " + bean.getCity());
        } else {
            System.out.println("College not found");
        }
    }

    private static void testFindByName() throws Exception {
        CollegeModel model = new CollegeModel();
        CollegeBean bean = model.findByName("IIM");
        if (bean != null) {
            System.out.println("Found: " + bean.getName() + " | " + bean.getCity());
        } else {
            System.out.println("College not found");
        }
    }

    private static void testSearch() throws Exception {
        CollegeModel model = new CollegeModel();
        CollegeBean searchBean = new CollegeBean();
        searchBean.setCity("Indore");

        List list = model.search(searchBean, 1, 10);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CollegeBean bean = (CollegeBean) it.next();
            System.out.println(bean.getId() + " | " + bean.getName() + " | " + bean.getCity());
        }
    }

    private static void testList() throws Exception {
        CollegeModel model = new CollegeModel();
        List list = model.list();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CollegeBean bean = (CollegeBean) it.next();
            System.out.println(bean.getId() + " | " + bean.getName() + " | " + bean.getCity());
        }
    }
}
