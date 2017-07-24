package com.agit.crm.main.crm;

import com.agit.crm.common.dto.usermanagement.UserDTO;
import com.agit.crm.user.management.application.UserService;
import com.agit.crm.user.management.domain.user.UserRepository;
import java.util.List;
import static org.activiti.engine.impl.scripting.JuelScriptEngine.print;
import org.apache.commons.lang.Validate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author 3AD
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/crm-context-application.xml",
    "classpath:/crm-context-infrastructure.xml"})
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testEnd2EndMahasiswa() {
        Validate.notNull(userRepository);
        /* Header*/
        print("Data Mahasiswa Processing");

        /* Incident Record*/
        UserDTO m = userService.getDummy();

        System.out.println("Incident Record : " + m.toString());

        userService.saveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        UserDTO b = userService.findByID(m.getUserName());
        System.out.println("Mahasiswa :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<UserDTO> listMahasiswa = (List<UserDTO>) userService.findAllUser();
        for (UserDTO bt : listMahasiswa) {
            System.out.println("Mahasiswa :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
}
