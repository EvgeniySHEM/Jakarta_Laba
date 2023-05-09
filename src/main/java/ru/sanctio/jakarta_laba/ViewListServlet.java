package ru.sanctio.jakarta_laba;

import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "ViewListServlet", value = "/ViewListServlet")
public class ViewListServlet extends HttpServlet {
    @EJB
    private ClientService clientService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sendResponse(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sendResponse(request, response);
    }

    private void sendResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Set<Client> clients = clientService.getAllClient();
//        Set<Client> sortClients = new TreeSet<>(clients);
        Set<Address> addressSet = clientService.getAllInformation();
        String filterParam = request.getParameter("filter");
        List<Address> filteredList = getFilteredList(addressSet, filterParam);

        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<form action=\"ViewListServlet\" method=\"get\" align=\"center\">\n" +
                "    <p><input type=\"text\" name=\"filter\" placeholder=\"filter\">\n" +
                "    <input type=\"submit\" value=\"Filter\"></p>\n" +
                "</form>");
        out.println("<table align=\"center\" cellpadding=\"5\" border=\"5px double #000\" cellspacing=\"0\">");
        out.println("<tr>");
        out.println("<th>clientId</th>");
        out.println("<th>clientName</th>");
        out.println("<th>type</th>");
        out.println("<th>added</th>");
        out.println("<th>ip</th>");
        out.println("<th>mac</th>");
        out.println("<th>model</th>");
        out.println("<th>address</th>");
        out.println("</tr>");
//        for(Client client : sortClients) {
            for (Address address : filteredList) {
                out.println("<tr>");
                out.println("<td>" + address.getClient().getClientId() + "</td>");
                out.println("<td>" + address.getClient().getClientName() + "</td>");
                out.println("<td>" + address.getClient().getType() + "</td>");
                out.println("<td>" + address.getClient().getAdded() + "</td>");
                out.println("<td>" + address.getIp() + "</td>");
                out.println("<td>" + address.getMac() + "</td>");
                out.println("<td>" + address.getModel() + "</td>");
                out.println("<td>" + address.getAddress() + "</td>");
                out.println("</tr>");
            }
//        }
        out.println("</table>");
        out.println("</body></html>");
    }

    private List<Address> getFilteredList(Set<Address> addressSet, String filterParam) {
        List<Address> list = new ArrayList<>();
        if(filterParam != null && !filterParam.isEmpty()) {
            for (Address address : addressSet) {
                if (address.toString().contains(filterParam)) {
                    list.add(address);
                }
            }
        } else {
            list.addAll(addressSet);
        }
        return list;
    }
}