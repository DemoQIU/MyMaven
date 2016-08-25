package my.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wsights.common.dto.UserDTO;
import com.wsights.common.service.UserService;
import com.wsights.common.util.Constants;
import com.wsights.common.util.LoginUserUtils;
import com.wsights.common.util.RequestContextUtils;


	@Controller
	//jspµÿ÷∑
	@RequestMapping(value = "/my/my/myLR/")
	public class LoginController {

		@Resource
		UserService userService;
		
	    @RequestMapping(value = "/isExist.json",method = RequestMethod.POST)
	    @ResponseBody
	    boolean isExist(@Valid @RequestBody final UserDTO userDTO){
	    	boolean auth = userService.isExist(userDTO);
	    	if(auth){
	    		RequestContextUtils.setSessionAttribute(Constants.LOGIN_USER, userDTO);
	    		return true;
	    	}else{
	    		LoginUserUtils.clearSessionLoginUser();
	    		return false;
	    	}
		}
	    
	    
	}

