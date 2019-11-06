package webapp.mvc.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import webapp.mvc.bean.DBLog;
import webapp.mvc.bean.User;

import java.util.List;

@Controller
public class JDBCController {

    @Autowired
    JDBCExample jdbcExample;

@RequestMapping(value = "/jdbcQueryAllUsers",method = RequestMethod.GET)
    public ModelAndView jdbcSelectAllUser(){
    System.out.println("JDBCController jdbcSelectAllUsers() id called");
    List<User> userList =jdbcExample.queryAllUsers();
    return new ModelAndView("/jdbc/jdbc","resultObject",userList);
}

@RequestMapping(value="/jdbcInsert/logstring/{logstring}")
    public ModelAndView jdbcInsert(@PathVariable(value = "logstring") String logstring){
System.out.println("JDBCController jdbcInsert is called");
    DBLog dbLog =new DBLog();
dbLog.setLOGSTRING(logstring);
boolean result =jdbcExample.insertLog(dbLog);
return  new ModelAndView("/jdbc/jdbc", "resultObject",result);
}

@RequestMapping(value = "/jdbcSelectLogs",method = RequestMethod.GET)
    public ModelAndView jdbcSelect(){
System.out.println("JDBCController jdbcSelect is called");
List<DBLog> dbLogList =jdbcExample.queryAllLogs();
return  new ModelAndView("/jdbc/jdbc","resultObject",dbLogList);
}


@RequestMapping(value = "/jdbcDelete/user/{iduser}",method = RequestMethod.GET)
    public ModelAndView jdbcDelete(@PathVariable(value = "iduser") int iduser){
System.out.println("JDBCController jdbcDelete is called");
boolean result =jdbcExample.deleteUser(iduser);
return new ModelAndView("/jdbc/jdbc","resultObject",result);
}

@RequestMapping(value = "/jdbcUpdate/user/username/{username}/enabled/{enabled}",method = RequestMethod.GET)
    public ModelAndView jdbcUpdate(@PathVariable(value = "username") String username, @PathVariable(value = "enabled") boolean enabled) {
System.out.println("JDBCController jdbcUpdate is called");
User user = new User();
user.setUserName(username);
boolean result =jdbcExample.updateUserEnable(user,enabled);
return new ModelAndView("jdbc/jdbc","resultObject",result);
}
}
