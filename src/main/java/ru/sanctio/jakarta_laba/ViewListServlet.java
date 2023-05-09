package ru.sanctio.jakarta_laba;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        List<Address> addressList = clientService.getAllInformation();
        String filterName = request.getParameter("filter");
        String filterType = request.getParameter("select");


        List<Address> filteredList = getFilteredList(addressList, filterName, filterType);
        filteredList.sort((a, b) -> a.getClient().getClientId() - b.getClient().getClientId());

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<form action=\"ViewListServlet\" method=\"get\" align=\"center\">");
        out.println("<p><input type=\"text\" name=\"filter\" placeholder=\"filter\">");
        out.println("<select name=\"select\">\n");
        out.println("<option value=\"\"></option>");
        out.println("<option value=\"" + Type.TYPE1.getClientType() + "\">" + Type.TYPE1.getClientType() + "</option>");
        out.println("<option value=\"" + Type.TYPE2.getClientType() + "\">" + Type.TYPE2.getClientType() + "</option>");
        out.println("</select>");
        out.println("<input type=\"submit\" value=\"Filter\"></p>");
        out.println("</form>");
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
        out.println("</table>");
        out.println("</body></html>");
    }

    private List<Address> getFilteredList(List<Address> addressList, String filterName, String filterType) {
        List<Address> list = new ArrayList<>();
        if (filterName != null && !filterName.isEmpty()) {
            for (Address address : addressList) {
                if(filterType != null && !filterType.isEmpty()) {
                    if ((address.getClient().getClientName().contains(filterName)
                            || address.getAddress().contains(filterName))
                            && address.getClient().getType().equals(filterType)) {
                        list.add(address);
                    }
                } else if (address.getClient().getClientName().contains(filterName)
                        || address.getAddress().contains(filterName)){
                    list.add(address);
                }
            }
        } else if (filterType != null && !filterType.isEmpty()) {
            for (Address address : addressList) {
                if (address.getClient().getType().equals(filterType)) {
                    list.add(address);
                }
            }
        } else {
            return addressList;
        }
        return list;
    }
}