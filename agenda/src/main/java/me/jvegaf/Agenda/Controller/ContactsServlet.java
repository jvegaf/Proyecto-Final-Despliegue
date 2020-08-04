package me.jvegaf.Agenda.Controller;

import me.jvegaf.Agenda.Model.Contact;
import me.jvegaf.Agenda.Services.ContactsManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet({ "/Contactos", "/view/Contactos" })
public class ContactsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ContactsManager cm = new ContactsManager();

		String action = request.getParameter("action");
		String url = null;

		switch (action) {
		
		case "list":
			List<Contact> contacts = cm.getAll();
			if (contacts != null) {
                request.setAttribute("lista", contacts);
            }
            url = "contactos.jsp";
			break;
			
		case "add":
			cm.add(
					request.getParameter("nombre"),
					Integer.parseInt(request.getParameter("telefono")),
					request.getParameter("correo")
			);

			url = "Contactos?action=list";
			break;
		
		case "find":
			Contact contact = cm.find(
					Integer.parseInt(request.getParameter("id"))
			);

			if (contact != null){
				request.setAttribute("contacto", contact);
				url = "contactosUpd.jsp";
			}
			break;
			
		case "update":
			cm.update(
					Integer.parseInt(request.getParameter("id")),
					request.getParameter("nombre"),
					Integer.parseInt(request.getParameter("telefono")),
					request.getParameter("correo")
			);
			url = "Contactos?action=list";
			break;
			
		case "remove":
			cm.remove(
					Integer.parseInt(request.getParameter("id"))
			);
            url = "Contactos?action=list";
			break;
			
		default:
			url = "Contactos?action=list";
		}

		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
				
	}
}