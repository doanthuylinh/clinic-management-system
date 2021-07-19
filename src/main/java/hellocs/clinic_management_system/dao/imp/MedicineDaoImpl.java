/////////////////////////////////////////////////////////////////////////////
//
// © 2020 VNEXT TRAINING
//
/////////////////////////////////////////////////////////////////////////////

package hellocs.clinic_management_system.dao.imp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hellocs.clinic_management_system.bean.MedicineEntity;
import hellocs.clinic_management_system.dao.MedicineDao;

/**
 * [OVERVIEW] Medicine Data Access Object Implementation.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/07/19      LinhDT             Create new
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

}
