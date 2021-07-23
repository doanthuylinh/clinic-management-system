/////////////////////////////////////////////////////////////////////////////
//
// © 2020 VNEXT TRAINING
//
/////////////////////////////////////////////////////////////////////////////

package hellocs.clinic_management_system.dao;

import java.util.List;

import hellocs.clinic_management_system.bean.MedicineEntity;

/**
 * [OVERVIEW] Medicine Data Access Object.
 *
 * @author: LinhDT
 * @version: 1.3
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/07/19      LinhDT             Create new
 * 002       1.1       2021/07/20      LinhDT             getMedicineEntityById, getListMedicine
 * 003       1.2       2021/07/22      LinhDT             updateMedicine
 * 004       1.3       2021/07/23      LinhDT             deleteMedicine
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

    /**
     * getListMedicine
     * @author: LinhDT
     * @return
     */
    public List<MedicineEntity> getListMedicine();

    /**
     * updateMedicine
     * @author: LinhDT
     * @param medicineEntity
     * @return
     */
    public MedicineEntity updateMedicine(MedicineEntity medicineEntity);

    /**
     * deleteMedicine
     * @author: LinhDT
     * @param medicineId
     */
    public void deleteMedicine(Integer medicineId);
}
