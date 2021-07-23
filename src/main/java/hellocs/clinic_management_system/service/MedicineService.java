/////////////////////////////////////////////////////////////////////////////
//
// © 2020 VNEXT TRAINING
//
/////////////////////////////////////////////////////////////////////////////

package hellocs.clinic_management_system.service;

import hellocs.clinic_management_system.bean.ResultBean;
import hellocs.clinic_management_system.utils.ApiValidateException;

/**
 * [OVERVIEW] Medicine Service.
 *
 * @author: LinhDT
 * @version: 1.3
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/07/19      LinhDT             Create new
 * 002       1.1       2021/07/20      LinhDT             getMedicineById, getListMedicine
 * 003       1.2       2021/07/22      LinhDT             updateMedicine
 * 004       1.3       2021/07/23      LinhDT             deleteMedicine
*/
public interface MedicineService {

    /**
     * addMedicine
     * @author: LinhDT
     * @param data
     * @return
     * @throws ApiValidateException
     */
    public ResultBean addMedicine(String data) throws ApiValidateException;

    /**
     * getMedicineById
     * @author: LinhDT
     * @param medicineId
     * @return
     * @throws ApiValidateException
     */
    public ResultBean getMedicineById(Integer medicineId) throws ApiValidateException;

    /**
     * getListMedicine
     * @author: LinhDT
     * @return
     * @throws ApiValidateException
     */
    public ResultBean getListMedicine() throws ApiValidateException;

    /**
     * updateMedicine
     * @author: LinhDT
     * @param data
     * @return
     * @throws ApiValidateException
     */
    public ResultBean updateMedicine(String data) throws ApiValidateException;

    /**
     * deleteMedicine
     * @author: LinhDT
     * @param data
     * @return
     * @throws ApiValidateException
     */
    public ResultBean deleteMedicine(String data) throws ApiValidateException;

}
