package in.co.rays.proj4.model;

import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DatabaseException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC Implementation of College Model.
 */
public class CollegeModel {

    // Get next primary key
    public int nextPk() throws DatabaseException {
        int pk = 0;
        try (Connection conn = JDBCDataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT MAX(id) FROM st_college");
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                pk = rs.getInt(1);
            }
        } catch (Exception e) {
            throw new DatabaseException("Exception : Exception in getting PK " + e.getMessage());
        }
        return pk + 1;
    }

    // Add a College
    public long add(CollegeBean bean) throws ApplicationException, DuplicateRecordException, Exception {
        int pk = nextPk();

        // check duplicate college name
        CollegeBean exist = findByName(bean.getName());
        if (exist != null) {
            throw new DuplicateRecordException("College already exists with name : " + bean.getName());
        }

        try (Connection conn = JDBCDataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO st_college VALUES(?,?,?,?,?,?,?,?,?,?)")) {

            ps.setInt(1, pk);
            ps.setString(2, bean.getName());
            ps.setString(3, bean.getAddress());
            ps.setString(4, bean.getState());
            ps.setString(5, bean.getCity());
            ps.setString(6, bean.getPhoneNo());
            ps.setString(7, bean.getCreatedBy());
            ps.setString(8, bean.getModifiedBy());
            ps.setTimestamp(9, bean.getCreatedDatetime());
            ps.setTimestamp(10, bean.getModifiedDatetime());

            ps.executeUpdate();
        } catch (Exception e) {
            throw new ApplicationException("Exception : Exception in add College " + e.getMessage());
        }
        return pk;
    }

    // Delete a College (with child cleanup)
    public void delete(CollegeBean bean) throws ApplicationException {
        Connection conn = null;
        try {
            conn = JDBCDataSource.getConnection();
            conn.setAutoCommit(false);

            // delete child records from faculty
            try (PreparedStatement ps1 = conn.prepareStatement("DELETE FROM st_faculty WHERE college_id=?")) {
                ps1.setLong(1, bean.getId());
                ps1.executeUpdate();
            }

            // delete college
            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM st_college WHERE id=?")) {
                ps.setLong(1, bean.getId());
                int rows = ps.executeUpdate();
                if (rows == 0) {
                    throw new ApplicationException("College not found for id " + bean.getId());
                }
            }

            conn.commit();
        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            throw new ApplicationException("Exception : Exception in delete College " + e.getMessage());
        } finally {
            JDBCDataSource.closeConnection(conn);
        }
    }

    // Update a College
    public void update(CollegeBean bean) throws ApplicationException, DuplicateRecordException {
        CollegeBean exist = findByName(bean.getName());
        if (exist != null && exist.getId() != bean.getId()) {
            throw new DuplicateRecordException("College already exists with name : " + bean.getName());
        }

        try (Connection conn = JDBCDataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "UPDATE st_college SET name=?, address=?, state=?, city=?, phone_no=?, created_by=?, modified_by=?, created_datetime=?, modified_datetime=? WHERE id=?")) {

            ps.setString(1, bean.getName());
            ps.setString(2, bean.getAddress());
            ps.setString(3, bean.getState());
            ps.setString(4, bean.getCity());
            ps.setString(5, bean.getPhoneNo());
            ps.setString(6, bean.getCreatedBy());
            ps.setString(7, bean.getModifiedBy());
            ps.setTimestamp(8, bean.getCreatedDatetime());
            ps.setTimestamp(9, bean.getModifiedDatetime());
            ps.setLong(10, bean.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            throw new ApplicationException("Exception : Exception in update College " + e.getMessage());
        }
    }

    // Find by Name
    public CollegeBean findByName(String name) throws ApplicationException {
        CollegeBean bean = null;
        try (Connection conn = JDBCDataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM st_college WHERE name=?")) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    bean = populateBean(rs);
                }
            }
        } catch (Exception e) {
            throw new ApplicationException("Exception : Exception in findByName College " + e.getMessage());
        }
        return bean;
    }

    // Find by PK
    public CollegeBean findByPk(long pk) throws ApplicationException {
        CollegeBean bean = null;
        try (Connection conn = JDBCDataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM st_college WHERE id=?")) {
            ps.setLong(1, pk);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    bean = populateBean(rs);
                }
            }
        } catch (Exception e) {
            throw new ApplicationException("Exception : Exception in findByPk College " + e.getMessage());
        }
        return bean;
    }

    // Search
    public List search(CollegeBean bean, int pageNo, int pageSize) throws ApplicationException {
        StringBuffer sql = new StringBuffer("SELECT * FROM st_college WHERE 1=1");
        if (bean != null) {
            if (bean.getName() != null && bean.getName().length() > 0) {
                sql.append(" AND name like '" + bean.getName() + "%'");
            }
            if (bean.getCity() != null && bean.getCity().length() > 0) {
                sql.append(" AND city like '" + bean.getCity() + "%'");
            }
        }

        if (pageSize > 0) {
            pageNo = (pageNo - 1) * pageSize;
            sql.append(" limit " + pageNo + ", " + pageSize);
        }

        ArrayList list = new ArrayList();
        try (Connection conn = JDBCDataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString());
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(populateBean(rs));
            }
        } catch (Exception e) {
            throw new ApplicationException("Exception : Exception in search College " + e.getMessage());
        }
        return list;
    }

    // List
    public List list() throws ApplicationException {
        ArrayList list = new ArrayList();
        try (Connection conn = JDBCDataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM st_college");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(populateBean(rs));
            }
        } catch (Exception e) {
            throw new ApplicationException("Exception : Exception in list College " + e.getMessage());
        }
        return list;
    }

    // Populate Bean from ResultSet
    private CollegeBean populateBean(ResultSet rs) throws Exception {
        CollegeBean bean = new CollegeBean();
        bean.setId(rs.getLong(1));
        bean.setName(rs.getString(2));
        bean.setAddress(rs.getString(3));
        bean.setState(rs.getString(4));
        bean.setCity(rs.getString(5));
        bean.setPhoneNo(rs.getString(6));
        bean.setCreatedBy(rs.getString(7));
        bean.setModifiedBy(rs.getString(8));
        bean.setCreatedDatetime(rs.getTimestamp(9));
        bean.setModifiedDatetime(rs.getTimestamp(10));
        return bean;
    }
}
