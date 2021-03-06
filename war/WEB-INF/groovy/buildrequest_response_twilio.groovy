import com.google.appengine.api.xmpp.XMPPService
import com.google.appengine.api.xmpp.XMPPServiceFactory
import com.google.appengine.api.xmpp.MessageBuilder
import com.google.appengine.api.xmpp.Message
import com.google.appengine.api.xmpp.JID

log.info "build request response :" + request.getParameter("Digits");

String buildRequestResponse = request.getParameter("Digits");
String projectName = request.getParameter("projectName");

def buildRequestResponseMap = ["1": "Approved", "2": "Rejected"]

XMPPService xmppService = XMPPServiceFactory.getXMPPService();

String recipient = "imran.iansari@gmail.com"

Message replyMessage = new MessageBuilder().withRecipientJids(new JID(recipient)).withBody("your build request for " + projectName + " was " + buildRequestResponseMap[buildRequestResponse]).build();

xmppService.sendMessage(replyMessage);


String HUDSON_JOB_URL = ServiceConstants.HUDSON_BASE_URL + "/job/";
String HUDSON_BUILD_CMD = "/build";

URL url = new URL(HUDSON_JOB_URL + projectName + HUDSON_BUILD_CMD)

def response = url.get()

String xmlResponse = "<?xml version='1.0' encoding='utf-8' ?>\n";
xmlResponse += "<Response>\n";
xmlResponse += "<Say voice='woman'>Thank you.</Say>\n";
xmlResponse += "</Response>";

out.write xmlResponse
