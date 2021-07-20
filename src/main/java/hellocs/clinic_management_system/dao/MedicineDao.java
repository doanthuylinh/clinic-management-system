/////////////////////////////////////////////////////////////////////////////
//
// © 2020 VNEXT TRAINING
//
/////////////////////////////////////////////////////////////////////////////

package hellocs.clinic_management_system.dao;

import hellocs.clinic_management_system.bean.MedicineEntity;

/**
 * [OVERVIEW] Medicine Data Access Object.
 *
 * @author: LinhDT
 * @version: 1.1
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/07/19      LinhDT             Create new
 * 002       1.1       2021/07/20      LinhDT             getMedicineEntityById
*/
public interface MedicineDao {

    /**
     * addMedicine
     * @author: LinhDT
     * @param medicineEntity
     * @return
     */
    public MedicineEntity addMedicine(MedicineEntity medicineEntity);

    /**
     * getMedicineEntityById
     * @author: LinhDT
     * @param medicineId
     * @return
     */
    public MedicineEntity getMedicineEntityById(Integer medicineId);
}
