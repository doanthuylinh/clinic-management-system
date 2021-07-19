/////////////////////////////////////////////////////////////////////////////
//
// © 2020 VNEXT TRAINING
//
/////////////////////////////////////////////////////////////////////////////

package hellocs.clinic_management_system.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hellocs.clinic_management_system.bean.ResultBean;
import hellocs.clinic_management_system.service.MedicineService;
import hellocs.clinic_management_system.utils.ApiValidateException;
import hellocs.clinic_management_system.utils.ResponseUtils;

/**
 * [OVERVIEW] Medicine Controller.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/07/19      LinhDT             Create new
*/
@RestController
@RequestMapping(value = "/api")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    private static final Logger LOGGER = LogManager.getLogger(MedicineController.class);

    /**
     * addMedicine
     * @author: LinhDT
     * @param data
     * @return
     */
    @RequestMapping(value = "/medicine", method = RequestMethod.POST)
    public ResponseEntity<ResultBean> addMedicine(@RequestBody String data) {

        LOGGER.info("----------addMedicine START----------");
        ResultBean resultBean = null;

        try {
            resultBean = medicineService.addMedicine(data);
        } catch (ApiValidateException e) {
            resultBean = new ResultBean(e.getCode(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean("500", "Internal server error");
        }

        LOGGER.info("----------addMedicine END----------");

        return new ResponseEntity<ResultBean>(resultBean, ResponseUtils.getResponseStatus(resultBean));

    }
}
