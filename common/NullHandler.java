package shoeseholic.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		return "/common/null.jsp";
	}

}
