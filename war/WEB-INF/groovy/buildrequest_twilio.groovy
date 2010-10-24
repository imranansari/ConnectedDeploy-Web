
/**
 * Created by IntelliJ IDEA.
 * User: imranansari
 * Date: Oct 15, 2010
 * Time: 5:40:32 PM
 * To change this template use File | Settings | File Templates.
 */

String baseUrl = "http://connecteddeploy.appspot.com"

String projectName = request.getParameter("projectName");
String buildRequestResponse = baseUrl+"/buildrequestresponse?projectName="+projectName

response.contentType = "text/xml"

String xmlResponse = "<?xml version='1.0' encoding='utf-8' ?>\n";
xmlResponse += "<Response>\n";
xmlResponse += "<Say voice='woman'>You have a urgent build request for "+projectName+".</Say>\n";

xmlResponse += "<Gather action=\""+buildRequestResponse+"\" method=\"GET\">"
xmlResponse += "<Say voice='woman'>"
xmlResponse += "Please press 1 to approve this request, Press 2 to reject."
xmlResponse += "</Say>"
xmlResponse += "</Gather>"
xmlResponse += "<Say voice='woman'>We didn't receive any input. Goodbye!</Say>"
xmlResponse += "</Response>";

out.write xmlResponse