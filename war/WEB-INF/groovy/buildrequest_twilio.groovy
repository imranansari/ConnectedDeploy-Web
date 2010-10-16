
/**
 * Created by IntelliJ IDEA.
 * User: imranansari
 * Date: Oct 15, 2010
 * Time: 5:40:32 PM
 * To change this template use File | Settings | File Templates.
 */

response.contentType = "text/xml"

String xmlResponse = "<?xml version='1.0' encoding='utf-8' ?>\n";
xmlResponse += "<Response>\n";
xmlResponse += "<Say voice='woman'>You have a urgent build request for "+request.getParameter("projectName")+".</Say>\n";
xmlResponse += "</Response>";

out.write xmlResponse