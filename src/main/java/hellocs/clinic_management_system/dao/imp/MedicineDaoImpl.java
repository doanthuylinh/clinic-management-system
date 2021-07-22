/////////////////////////////////////////////////////////////////////////////
//
// © 2020 VNEXT TRAINING
//
/////////////////////////////////////////////////////////////////////////////

package hellocs.clinic_management_system.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hellocs.clinic_management_system.bean.MedicineEntity;
import hellocs.clinic_management_system.dao.MedicineDao;

/**
 * [OVERVIEW] Medicine Data Access Object Implementation.
 *
 * @author: LinhDT
 * @version: 1.2
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/07/19      LinhDT             Create new
 * 002       1.1       2021/07/20      LinhDT             getMedicineEntityById, getListMedicine
 * 003       1.2       2021/07/22      LinhDT             updateMedicine
*/
@Repository
@Transactional
public class MedicineDaoImpl implements MedicineDao {

    @PersistenceContext
    @Autowired
    private EntityManager entityManager;

    /**
     * addMedicine
     * @author: LinhDT
     * @param medicineEntity
     * @return
     */
    @Override
    public MedicineEntity addMedicine(MedicineEntity medicineEntity) {
        this.entityManager.persist(medicineEntity);
        return medicineEntity;
    }

    /**
     * getMedicineEntityById
     * @author: LinhDT
     * @param medicineId
     * @return
     */
    @Override
    public MedicineEntity getMedicineEntityById(Integer medicineId) {
        StringBuilder sql = new StringBuilder();
        sql.append(" FROM ");
        sql.append("    MedicineEntity me ");
        sql.append(" WHERE ");
        sql.append("    me.medicineId = :medicineId ");

        Query query = this.entityManager.createQuery(sql.toString());
        query.setParameter("medicineId", medicineId);
        MedicineEntity medicineEntity = null;
        try {
            medicineEntity = (MedicineEntity) query.getSingleResult();
        } catch (NoResultException e) {

        }
        return medicineEntity;
    }

    /**
     * getListMedicine
     * @author: LinhDT
     * @return
     */
    @Override
    public List<MedicineEntity> getListMedicine() {
        StringBuilder sql = new StringBuilder();
        sql.append(" FROM ");
        sql.append("    MedicineEntity me ");
        sql.append(" ORDER BY ");
        sql.append("    me.acquiredDate desc, ");
        sql.append("    me.medicineId desc ");

        Query query = this.entityManager.createQuery(sql.toString());
        List<MedicineEntity> listMedicine = null;
        listMedicine = query.getResultList();
        return listMedicine;
    }

    /**
     * updateMedicine
     * @author: LinhDT
     * @param medicineEntity
     * @return
     */
    @Override
    public MedicineEntity updateMedicine(MedicineEntity medicineEntity) {
        this.entityManager.merge(medicineEntity);
        return medicineEntity;
    }

}
