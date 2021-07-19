/////////////////////////////////////////////////////////////////////////////
//
// © 2020 VNEXT TRAINING
//
/////////////////////////////////////////////////////////////////////////////

package hellocs.clinic_management_system.utils;

import org.springframework.http.HttpStatus;

import hellocs.clinic_management_system.bean.ResultBean;

/**
 * [OVERVIEW] Response Utils.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/07/19      LinhDT       Create new
*/
public class ResponseUtils {

    /**
     * getResponseStatus
     * @author: LinhDT
     * @param result
     * @return
     */
    public static HttpStatus getResponseStatus(ResultBean result) {
        String code = result.getMeta().getCode();

        return HttpStatus.OK;
    }

    /**
     * handleError
     * @author: LinhDT
     * @param e
     * @return
     */
    public static ResultBean handleError(Exception e) {
        ResultBean resultBean = null;
        if (e instanceof ApiValidateException) {
            return new ResultBean(((ApiValidateException) e).getCode(), e.getMessage());
        }

        e.printStackTrace();
        return new ResultBean("500", e.getMessage());
    }
}
