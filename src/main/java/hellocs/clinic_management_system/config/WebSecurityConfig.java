/////////////////////////////////////////////////////////////////////////////
//
// © 2020 VNEXT TRAINING
//
/////////////////////////////////////////////////////////////////////////////

package hellocs.clinic_management_system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * [OVERVIEW] Web Security Configuration.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/07/19      LinhDT             Create new
*/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // Prevent request from another domain.
                .authorizeRequests()
                // User
                .antMatchers(HttpMethod.POST, "/api/medicine").permitAll().antMatchers(HttpMethod.GET, "/api/medicine/{medicineId}", "/api/list-medicine")
                .permitAll().antMatchers(HttpMethod.PUT, "/api/medicine").permitAll().antMatchers(HttpMethod.DELETE, "/api/medicine").permitAll();

        // Except for the API(s) above, all other requests must be verified before access.
    }

}
